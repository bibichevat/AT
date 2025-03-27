import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // массив строк и чисел для проверки
        // ввод с консоли
        /*
        ArrayList<String> list = new ArrayList<>();
        System.out.print("Enter number of strings for check = ");
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            list.add(in.nextLine());
        }
        */

        // массив строк и чисел для проверки
        ArrayList<String> list = new ArrayList<>(Arrays.asList("а роза упала на лапу Азора", "1991", "Don't nod",
                "No lemon, no melon", "Do it, Tido", "12512", "112121", "123.321", "привет", "ЁЁ"));

        // проход по строкам, проверка, является ли вся строка палиндромом
        for (String text: list) {
            if (isAllStringPalindrome(text)) {
                System.out.println(text + " - palindrome");
            }
            else {
                System.out.println(text + " - not palindrome");
            }
        }

        // проход по строкам, вывод подстроки-палиндрома, если есть
        for (String text: list) {
            String s = findPalindromeAsPartOfString(text);
            if (s != null){
                System.out.println(text + " | first palindrome: " + s);
            }
            else {
                System.out.println(text + " | - no palindromes in text");
            }
        }

    }

    // проверяет, является ли строка палиндромом
    public static boolean isAllStringPalindrome(String text) {
        /*
           удаление не буквенно-числовых значений
           приведение строки к нижнему регистру
        */
        text = text.replaceAll("[^a-zA-Zа-яА-Я0-9ёЁ]", "").toLowerCase();
        if (text.isEmpty()) {
            return false;
        }
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

    // возвращает первую подстроку-палиндром, иначе null
    public static String findPalindromeAsPartOfString(String text) {
        // приведение строки к нижнему регистру
        String textInLowCase = text.toLowerCase();
        // метод двух указателей
        // l - для прохода от начала строки, r - от конца строки
        for (int l = 0; l < textInLowCase.length(); l++)
        {
            for (int r = textInLowCase.length()-1; r > l; r--)
            {
                // проверка подстроки text[l:r+1] на палиндром
                // для прохода создаются переменные lb, rb
                int lb = l, rb = r;
                boolean f = true;
                while (lb <= rb) {
                    // если символ под индексом lb не буква или цифра, пропустить
                    if (!Character.isLetterOrDigit(textInLowCase.charAt(lb))) {
                        lb++;
                    }
                    // если символ под индексом rb не буква или цифра, пропустить
                    else if (!Character.isLetterOrDigit(textInLowCase.charAt(rb))) {
                        rb--;
                    }
                    // если не совпадают символы слева и справа, палиндрома нет
                    else if (textInLowCase.charAt(lb) != textInLowCase.charAt(rb)) {
                        f = false;
                        break;
                    }
                    // иначе проверка продолжается, указатели сдвигаются
                    else {
                        lb++;
                        rb--;
                    }
                }
                // проверка флага, проверка левой и правой границы, чтобы исключить не буквенно-числовые символы
                if (f && Character.isLetterOrDigit(textInLowCase.charAt(r)) && Character.isLetterOrDigit(textInLowCase.charAt(l))) {
                    return text.substring(l, r+1);
                }
            }
        }
        // если палиндром не найден, null
        return null;
    }
}