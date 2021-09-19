package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {
    private static final String URL = "jdbc:h2:~/h2db/management;AUTO_SERVER=TRUE;MODE=PostgreSQL";
    private static final String USER_NAME = "b2190080";
    private static final String USER_PASS = "b2190080";

    //　授業内容テーブルへの追加（＝授業報告）
    public int insertGrade(int logId, int studentId, String date, String subject, String detail, String homework,
                           String nextDate, String remarks, String comment) throws SQLException{
        String sql = "insert into 授業内容 values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, logId);
            stmt.setInt(2, studentId);
            stmt.setString(3, date);
            stmt.setString(4, subject);
            stmt.setString(5, detail);
            stmt.setString(6, homework);
            stmt.setString(7, nextDate);
            stmt.setString(8, remarks);
            stmt.setString(9, comment);
            n = stmt.executeUpdate();
        }
        return n;
    }

    //授業内容テーブルの削除（＝授業報告の削除）
    public int deletePreExam(int logId, int studentId, String date, String subject) throws SQLException {
        String sql = "delete from 授業内容 where ログインID = ? and 生徒ID = ? and 日にち = ? and 科目 = ?";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, logId);
            stmt.setInt(2, studentId);
            stmt.setString(3, date);
            stmt.setString(4, subject);
            n = stmt.executeUpdate();
        }
        return n;
    }

    //授業内容テーブルの更新（=授業報告の修正）
    public int updateGrade(int logId, int studentId, String date, String subject, String detail, String homework, String nextDate, String remarks, String comment) throws SQLException{
        String sql = "update 授業内容 set 内容 = ?, 宿題 = ?, 次回授業日 = ?, 備考 = ?, コメント欄 = ? where ログインID = ? and 生徒ID = ? and 日にち = ? and 科目 = ?";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, detail);
            stmt.setString(2, homework);
            stmt.setString(3, nextDate);
            stmt.setString(4, remarks);
            stmt.setString(5, comment);
            stmt.setInt(6, logId);
            stmt.setInt(7, studentId);
            stmt.setString(8, date);
            stmt.setString(9, subject);
            n = stmt.executeUpdate();
        }
        return n;
    }

    //授業内容テーブルの検索（＝授業報告の表示）
    public List<Report> selectPreExams(int logId, int studentId, String date, String subject) throws SQLException{
        List<Report> returning = new ArrayList<Report>();
        String sql = "select 内容,宿題,次回授業日,備考,コメント欄 from 授業内容 where ログインID = ? and 生徒ID = ? and 日にち = ? and 科目 = ?";

        try(Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, logId);
            stmt.setInt(2, studentId);
            stmt.setString(3,date);
            stmt.setString(4, subject);
            ResultSet results = stmt.executeQuery();
            while(results.next()){
                String col1 = results.getString("内容");
                String col2 = results.getString("宿題");
                String col3 = results.getString("次回授業日");
                String col4 = results.getString("備考");
                String col5 = results.getString("コメント欄");
                Report report = new Report(col1, col2, col3, col4, col5);
                returning.add(report);
            }
        }
        return returning;
    }
}
