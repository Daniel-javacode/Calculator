public class Expression {
    static String codedString;
    static int firstDigit = 1;
    static int secondDigit = 1;
    private static String signAll = "-+*/";
    static char sign = '0';
    static boolean isRomanian = false;

    public static void decoder(String s) {
        s = s.toLowerCase();
        String roma = "ivx";
        String arab = "123456789";
        int arabic = 0, romanian = 0;
        for (int i = 0; i < s.length(); i++) {
            if (roma.contains(String.valueOf(s.charAt(i)))) {
                romanian = 1;
            }
            if (arab.contains(String.valueOf(s.charAt(i)))) {
                arabic = 1;
            }
        }
        switch (arabic + romanian) {
            case 0: {
                System.out.println("Где цифры?");
                System.exit(0);
            }
            case 1: {
                if (arabic == 1) {
                    arabicDecoder(s);
                } else {
                    isRomanian = true;
                    romanianDecoder(s);
                }
                break;
            }
            case 2: {
                System.out.println("Либо римские, либо арабские!");
                System.exit(0);
            }
            default:
                System.out.println("Что-то пошло не так");
                System.exit(0);
        }

    }

    private static void arabicDecoder(String s) {
        if (s.charAt(0) == '-') {
            firstDigit *= -1;
            s = s.substring(1);
        }
        String tempDigit = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' && sign != '0') {
                secondDigit *= -1;
                continue;
            }
            if (signAll.contains(String.valueOf(s.charAt(i)))) {
                firstDigit *= Integer.parseInt(tempDigit);
                sign = s.charAt(i);
                tempDigit = "";
                continue;
            }
            tempDigit += s.charAt(i);
        }
        secondDigit *= Integer.parseInt(tempDigit);
    }

    private static void romanianDecoder(String s) {
        if (s.charAt(0) == '-') {
            firstDigit *= -1;
            s = s.substring(1);
        }
        String tempDigit = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' && sign != '0') {
                secondDigit *= -1;
                continue;
            }
            if (signAll.contains(String.valueOf(s.charAt(i)))) {
                firstDigit *= romanianDigitChoose(tempDigit);
                sign = s.charAt(i);
                tempDigit = "";
                continue;
            }
            tempDigit += s.charAt(i);
        }
        secondDigit *= romanianDigitChoose(tempDigit);
    }

    private static int romanianDigitChoose(String temp) {
        switch (temp) {
            case "i": {
                return 1;
            }
            case "ii": {
                return 2;
            }
            case "iii": {
                return 3;
            }
            case "iv": {
                return 4;
            }
            case "v": {
                return 5;
            }
            case "vi": {
                return 6;
            }
            case "vii": {
                return 7;
            }
            case "viii": {
                return 8;
            }
            case "ix": {
                return 9;
            }
            case "x": {
                return 10;
            }
            default: {
                return 11;
            }
        }
    }

    public static String coder(int digit) {
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
