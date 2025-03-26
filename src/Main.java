import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // массив строк и чисел для проверки
        ArrayList<Object> list = new ArrayList<>(Arrays.asList("а роза упала на лапу Азора", "1991", "Don't nod",
                "No lemon, no melon", "Do it, Tido", 12512, 112121, "привет", "ЁЁЁ"));
        for (Object text: list) {
            if (isPalindrome(String.valueOf(text))) {
                System.out.println(text + " - palindrome");
            }
            else {
                System.out.println(text + " - not palindrome");
            }
        }
    }

    public static boolean isPalindrome(String text) {
        /*
           удаление не буквенно-числовых значений
           приведение строки к нижнему регистру
        */
        text = text.replaceAll("[^a-zA-Zа-яА-Я0-9ёЁ]", "").toLowerCase();
        // посимвольное сравнение левой и правой части строки
        for (int i = 0; i < text.length() / 2; i++) {
            // если пара символов не совпадает, строка не является палиндромом
            if (text.charAt(i) != text.charAt(text.length()-1-i)) {
                return false;
            }
        }
        // если цикл пройден полностью, строка является палиндромом
        return true;
    }
}