import java.util.Scanner;

public class Control {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("得点　or　報告内容　を入力");
        String key = scan.nextLine();
        if (key.equals("得点")){
            SelectPoint.select();
        }
        else if (key.equals("報告内容")){
            SelectReport.select();
        }
    }
}
