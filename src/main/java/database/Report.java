package database;

public class Report {
    private String detail;
    private String homework;
    private String nextDate;
    private String remarks;
    private String comment;

    public Report(String detail, String homework, String nextDate, String remarks, String comment) {
        this.detail = detail;
        this.homework = homework;
        this.nextDate = nextDate;
        this.remarks = remarks;
        this.comment = comment;
    }

    public void print(){
        System.out.println("内容:" + detail + "\n宿題:" + homework
                + "\n次回の授業日:" + nextDate + "\n備考:" + remarks + "\nコメント:" + comment);
    }

    public String getDetail() {
        return detail;
    }

    public String getHomework() {
        return homework;
    }

    public String getNextDate() {
        return nextDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getComment() {
        return comment;
    }

}
