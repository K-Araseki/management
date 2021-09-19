import database.SubjectDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class ChangeReport {
    public static void update(){
        Scanner scan = new Scanner(System.in);
        System.out.println("授業内容の修正");

        System.out.println("ログインIDを入力");
        int logId = Integer.valueOf(scan.nextLine());
        System.out.println("生徒IDを入力");
        int studentId = Integer.valueOf(scan.nextLine());
        System.out.println("日にちを入力");
        String date = scan.nextLine();
        System.out.println("科目を入力");
        String subject = scan.nextLine();
        System.out.println("内容は入力");
        String detail = scan.nextLine();
        System.out.println("宿題を入力");
        String homework = scan.nextLine();
        System.out.println("次回授業日を入力");
        String nextDate = scan.nextLine();
        System.out.println("備考を入力");
        String remarks = scan.nextLine();
        System.out.println("コメントを入力");
        String comment = scan.nextLine();

        try {
            SubjectDAO dao = new SubjectDAO();
            int n = dao.updateReport(logId,studentId,date,subject,detail,homework,nextDate,remarks,comment);
            if (n == 1){
                System.out.println("修正完了！");
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
