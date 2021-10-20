import service.LineCheck;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String ln = sc.nextLine();
        LineCheck check = new LineCheck();
        System.out.println(check.checkAndCalc(ln));
    }
}