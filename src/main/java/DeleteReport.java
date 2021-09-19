import database.SubjectDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteReport {
    public static void delete(){
        Scanner scan = new Scanner(System.in);
        System.out.println("授業内容を削除");

        System.out.println("ログインIDを入力");
        int logId = Integer.valueOf(scan.nextLine());
        System.out.println("生徒IDを入力");
        int studentId = Integer.valueOf(scan.nextLine());
        System.out.println("日にちを入力");
        String date = scan.nextLine();
        System.out.println("科目を入力");
        String subject = scan.nextLine();

        try {
            SubjectDAO dao = new SubjectDAO();
            int n = dao.deleteReport(logId,studentId,date,subject);
            if (n == 1){
                System.out.println("削除完了！");
            }
            else {
                System.out.println("もう一度始めから入力");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return;
    }
}
