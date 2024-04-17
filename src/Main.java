import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String inputString = in.nextLine();

        StringBuilder str = new StringBuilder();
        Pattern pattern;
        Matcher matcher;
        boolean res = true;
        for (int a = 0; a < 8; a++){

            str = str.append(a).append(a+1).append(a+2);
            pattern = Pattern.compile(str.toString());
            matcher = pattern.matcher(inputString);
            str.delete(0,str.length()+1);
            if (matcher.find()) {
                res = false;
                break;
            }
        }
        for ( int a = 97; a < 121; a++ ){

            str = str.append((char)a).append((char)(a+1)).append((char)(a+2));
            pattern = Pattern.compile(str.toString());
            matcher = pattern.matcher(inputString);
            str.delete(0,str.length()+1);
            if (matcher.find()) {
                res = false;
                break;
            }
        }
        for ( int a = 65; a < 89; a++ ){

            str = str.append((char)a).append((char)(a+1)).append((char)(a+2));
            pattern = Pattern.compile(str.toString());
            matcher = pattern.matcher(inputString);
            str.delete(0,str.length()+1);
            if (matcher.find()) {
                res = false;
                break;
            }
        }

        pattern = Pattern.compile("^(?!.*(\\S)\\1).{8,}$");
        matcher = pattern.matcher(inputString);
        if (matcher.find() && res) System.out.println("Пароль верный");
        else System.out.println("Пароль неверный");

    }
}