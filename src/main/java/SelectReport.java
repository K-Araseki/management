import database.Point;
import database.PointDAO;
import database.Report;
import database.SubjectDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SelectReport {
    public static void select(){
        System.out.println("ログインIDを入力");
        Scanner scan = new Scanner(System.in);
        int logId = Integer.valueOf(scan.nextLine());
        System.out.println("生徒IDを入力");
        int studentId = Integer.valueOf(scan.nextLine());
        System.out.println("日にちを入力");
        String date = scan.nextLine();
        System.out.println("科目を入力");
        String subject = scan.nextLine();

        try {
            SubjectDAO dao = new SubjectDAO();
            List<Report> reports = dao.selectPreExams(logId,studentId,date,subject);
            for (Report report  : reports){
                report.print();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
