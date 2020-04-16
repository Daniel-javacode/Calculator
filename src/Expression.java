public class Expression {
    static int firstDigit = 1;
    static int secondDigit = 1;
    static char sign = '0';
    static boolean isRomanian = false;

    public static void decoder(String s) {
        s = s.toLowerCase();
        String roma = "ivx";
        for (int i = 0; i < s.length(); i++) {
            if (roma.contains(String.valueOf(s.charAt(i)))) {
                isRomanian = true;
                break;
            }
        }
        digitDecoder(s);
    }

    private static void digitDecoder(String s) {
        if (s.charAt(0) == '-') {
            System.out.println("Первое число меньше ноля!");
            System.exit(0);
        }
        String tempString = "";
        String signAll = "-+*/";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' && sign != '0') {
                System.out.println("Второе число меньше ноля!");
                System.exit(0);
            }
            if (signAll.contains(String.valueOf(s.charAt(i)))) {
                firstDigit *= isRomanian ? romanianDigitChoose(tempString) : Integer.parseInt(tempString);
                sign = s.charAt(i);
                tempString = "";
                continue;
            }
            if (s.charAt(i)==','||s.charAt(i)=='.'){
                System.out.println("Вещественные числа недопустимы");
                System.exit(0);
            }
            tempString += s.charAt(i);
        }
        secondDigit *= isRomanian ? romanianDigitChoose(tempString) : Integer.parseInt(tempString);
        if (sign=='/' && secondDigit == 0){
            System.out.println("Делить на ноль нельзя!");
            System.exit(0);
        }
    }

    private static int romanianDigitChoose(String temp) {
        String[] romanDigits = {"i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix", "x"};
        for (int i = 0; i < romanDigits.length; i++) {
            if (romanDigits[i].equals(temp)) {
                return i + 1;
            }
        }
        System.out.println("Не знаю таких римских");
        System.exit(0);
        return -1;
    }

    public static String coder(int digit) {
        if (digit == 0) {
            System.out.println("Ноля у римлян не было!");
            System.exit(0);
        }
        String end = "";
        if (digit < 0) {
            end += '-';
            digit *= -1;
        }
        if (digit / 100 == 1) {
            end += 'C';
            digit -= 100;
        }
        while (digit > 9) {
            if (digit - 90 >= 0) {
                end += "XC";
                digit -= 90;
            }
            if (digit - 50 >= 0) {
                end += "L";
                digit -= 50;
            }
            if (digit - 40 >= 0) {
                end += "XL";
                digit -= 40;
            }
            if (digit - 10 >= 0) {
                end += "X";
                digit -= 10;
            }
        }
        while (digit > 0) {
            if (digit == 9) {
                end += "IX";
                break;
            }
            if (digit >= 5) {
                end += "V";
                digit -= 5;
                continue;
            }
            if (digit == 4) {
                end += "IV";
                break;
            }
            end += "I";
            digit--;
        }
        return end;
    }
}