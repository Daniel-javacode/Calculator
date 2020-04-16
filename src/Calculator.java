import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input expression");
        Expression.codedString = in.nextLine();
        Expression.decoder(Expression.codedString);
        int result = 0;
        switch (Expression.sign) {
            case '+': {
                result = Expression.firstDigit + Expression.secondDigit;
                break;
            }
            case '-': {
                result = Expression.firstDigit - Expression.secondDigit;
                break;
            }
            case '*': {
                result = Expression.firstDigit * Expression.secondDigit;
                break;
            }
            case '/': {
                result = Expression.firstDigit / Expression.secondDigit;
                break;
            }
            default: {
                System.out.println("Что-то пошло не так");
                System.exit(0);
            }
        }
        if (Expression.isRomanian) {
            System.out.println("Результат = " + Expression.coder(result));
        } else {
            System.out.println("Результат = " + result);
        }
    }
}
