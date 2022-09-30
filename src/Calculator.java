import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Converter converter = new Converter();

        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};

        Scanner scn = new Scanner(System.in);

        System.out.print("Введите выражение без пробелов от 1 до 10: ");
        String exp = scn.nextLine();

        int actionIndex=-1;

        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        if(actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);

        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){

            int a,b;
            boolean isRoman = converter.isRoman(data[0]);

            if(isRoman){
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            }
            else{
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            if(intOutside(a,b)) return;

            int result;

            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }

            if(isRoman){
                if(result >= 0){
                System.out.println("Ваш результат: " + converter.intToRoman(result));
            }
                else {
                    System.out.println("Мудрые римляне не оперировали значениями 0 и меньше");
                    System.out.println("Попробуйте посчитать арабскими цифрами");
                }
            }
            else{
                System.out.println("Ваш результат: " + result);
            }

        }
        else{
            System.out.println("Числа должны быть в одном формате");
        }
    }

    private static Boolean intOutside(int a, int b){
        if (a>10||a<1){
            System.out.println("Некорректное первое число");
            return true;
        }
        else if (b>10||b<1) {
            System.out.println("Некорректное второе число");
            return true;
        }
        else return false;
    }
}
