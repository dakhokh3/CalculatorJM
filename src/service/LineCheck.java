package service;

public class LineCheck {
    public Object checkAndCalc(String ln) throws Exception {
        String line = ln.replaceAll("\\s+", "");
        String[] array = line.split("");
        String operation = line.replaceAll("([0-9])|([IVX])", "");
        if (array.length < 3) {
            throw new Exception("строка не является математической операцией");
        }

        if (operation.length() > 1) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - " +
                    "два операнда(числа от 1 до 10 включительно) и один оператор (+, -, /, *)");
        }
        array[0] = line.substring(0, line.indexOf((operation)));
        array[1] = line.substring(line.indexOf(operation) + 1);
        String c = array[0];
        String b = array[1];
        if (Character.isDigit(c.charAt(0)) & Character.isDigit(b.charAt(0))) {
            int num1 = Integer.parseInt(array[0]);
            int num2 = Integer.parseInt(array[1]);
            char opr = operation.charAt(0);
            if ((num1 >= 1) & (num1 <= 10) & (num2 >= 1 & (num2 <= 10))) {
                Calc res = new Calc();
                return res.calc(num1, num2, opr);
            } else if (((num1 < 1) || (num1 > 10) || (num2 < 1) || (num2 > 10))) {
                throw new Exception("Формат математической операции не удовлетворяет заданию - " +
                        "два операнда(числа от 1 до 10 включительно) и один оператор (+, -, /, *)");
            }
        } else if (Character.isLetter(c.charAt(0)) & Character.isLetter(b.charAt(0))) {
            String num1 = array[0];
            String num2 = array[1];
            int number1 = RomanNumerals.Roman.valueOf(num1).toInt();
            int number2 = RomanNumerals.Roman.valueOf(num2).toInt();
            char opr = operation.charAt(0);
            if ((opr == '-') & (number2 > number1)) {
                throw new Exception("В римской системе нет отрицательных чисел");
            } else {
                Calc res = new Calc();
                int result;
                result = res.calc(number1, number2, opr);
                return ResToRoman.toRoman(result);
            }
        } else if ((Character.isDigit(c.charAt(0)) & Character.isLetter(b.charAt(0))) |
                ((Character.isLetter(c.charAt(0)) & Character.isDigit(b.charAt(0))))) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        return null;
    }
}
