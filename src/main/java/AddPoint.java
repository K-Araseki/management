import database.LoginDAO;
import database.Point;
import database.PointDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class AddPoint {
    public static void add(){
        Scanner scan = new Scanner(System.in);
        System.out.println("得点の登録");

        System.out.println("生徒IDを入力");
        int studentId = Integer.valueOf(scan.nextLine());
        System.out.println("学年を入力");
        int grade = Integer.valueOf(scan.nextLine());
        System.out.println("時期を入力");
        String season = scan.nextLine();
        System.out.println("科目は入力");
        String subject = scan.nextLine();
        System.out.println("得点を入力");
        int point = Integer.valueOf(scan.nextLine());

        try {
            PointDAO dao = new PointDAO();
            int n = dao.insertPoint(studentId,grade,season,subject,point);
            if (n == 1){
                System.out.println("登録完了！");
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
