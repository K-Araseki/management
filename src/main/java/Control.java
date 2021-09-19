import java.util.Scanner;

public class Control {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("ログインIDの追加　or　パスワードの変更　or　得点の入力　or　得点の修正　or" + "　得点確認　" +
                    "or　得点の削除　or　授業内容の登録　or　授業内容の修正　or　授業内容の確認　or　授業内容の削除 or　生徒情報の登録　を入力\nやめる場合は　終了　を入力");
            String key = scan.nextLine();
            if (key.equals("ログインIDの追加")){
                AddID.add();
            }
            else if (key.equals("パスワードの変更")){
                ChangePass.change();
            }
            else if (key.equals("得点の入力")){
                AddPoint.add();
            }
            else if (key.equals("得点の修正")){
                ChangePoint.update();
            }
            else if (key.equals("得点確認")){
                SelectPoint.select();
            }
            else if (key.equals("得点の削除")){
                DeletePoint.delete();
            }
            else if (key.equals("授業内容の登録")){
                AddReport.add();
            }
            else if (key.equals("授業内容の修正")){
                ChangeReport.update();
            }
            else if (key.equals("授業内容の確認")){
                SelectReport.select();
            }
            else if (key.equals("授業内容の削除")){
                DeleteReport.delete();
            }
            else if (key.equals("生徒情報の登録")){
                AddStudent.add();
            }
            else if (key.equals("終了")){
                break;
            }
            else {
                continue;
            }
        }
    }

}
