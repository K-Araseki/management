import database.Pass;
import database.LoginDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangePass {

    public static void change() {
        System.out.println("パスワードの変更を行います。");
        System.out.println("ログインIDを入力");
        Scanner scan = new Scanner(System.in);
        int id = Integer.valueOf(scan.nextLine());

        LoginDAO dao = new LoginDAO();
        List<Pass> passList = new ArrayList<Pass>();
        try {
            passList = dao.selectPassword(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        while (true){
            System.out.println("昔のパスワードを入力");
            String oldPassword = scan.nextLine();
            if (oldPassword.equals(passList.get(0).getPassword())){
                break;
            }
            else {
                System.out.println("パスワードが間違っています。もう一度入力");
            }
        }

        System.out.println("新しいのパスワードを入力");
        String newPassword1 = scan.nextLine();
        System.out.println("新しいパスワードをもう一度入力してください。");
        String newPassword2 = scan.nextLine();
        int flag = 0;
        while (true){
            if (flag==0) {
                if (newPassword1.equals(newPassword2)) {
                    System.out.println("新しいパスワードの確認ができました。");
                    break;
                } else if (newPassword1.equals(newPassword2) == false) {
                    System.out.println("もう一度パスワードを入力しますか？");
                    System.out.println("する場合は１、しない場合は２を押してください。");
                    flag = Integer.valueOf(scan.nextLine());
                    if (flag==2){
                        break;
                    }
                    flag = 1;
                }
            }else if (flag==1){
                System.out.println("新しいのパスワードを入力");
                 newPassword1 = scan.nextLine();
                System.out.println("新しいパスワードをもう一度入力してください。");
                 newPassword2 = scan.nextLine();
                 flag=0;
            }
        }

        try {
          //  LoginDAO dao = new LoginDAO();
            int logins = dao.updatePassword(id,newPassword1);
            System.out.println(logins);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return;
    }

}
