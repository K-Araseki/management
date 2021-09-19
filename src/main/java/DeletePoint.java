import database.Point;
import database.PointDAO;
import database.SubjectDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class DeletePoint {
    public static void delete(){
        Scanner scan = new Scanner(System.in);
        System.out.println("得点情報を削除");

        System.out.println("生徒IDを入力");
        int studentId = Integer.valueOf(scan.nextLine());
        System.out.println("学年を入力");
        int grade = Integer.valueOf(scan.nextLine());
        System.out.println("時期を入力");
        String season = scan.nextLine();
        System.out.println("科目は入力");
        String subject = scan.nextLine();

        try {
            PointDAO dao = new PointDAO();
            int n = dao.deletePoint(studentId,grade,season,subject);
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
