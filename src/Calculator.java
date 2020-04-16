import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input expression");
        Expression.decoder(in.nextLine());
        System.out.print("Результат = ");
        switch (Expression.sign) {
            case '+': {
                System.out.println(Expression.isRomanian ?
                        Expression.coder(Expression.firstDigit + Expression.secondDigit) :
                            Expression.firstDigit + Expression.secondDigit);
                break;
            }
            case '-': {
                System.out.println(Expression.isRomanian ?
                        Expression.coder(Expression.firstDigit - Expression.secondDigit) :
                            Expression.firstDigit - Expression.secondDigit);
                break;
            }
            case '*': {
                System.out.println(Expression.isRomanian ?
                        Expression.coder(Expression.firstDigit * Expression.secondDigit) :
                            Expression.firstDigit * Expression.secondDigit);
                break;
            }
            case '/': {
                System.out.println(Expression.isRomanian ?
                        Expression.coder(Expression.firstDigit / Expression.secondDigit) :
                            Expression.firstDigit / Expression.secondDigit);
                break;
            }
            default: {
                System.out.println("Что-то пошло не так");
                System.exit(0);
            }
        }
    }
}