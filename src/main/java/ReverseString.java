
public class ReverseString {
    public static void main(String[] args) {

        String input = "man has dog";
        System.out.println(reverse(input));
    }

    public static String reverse (String s){

        StringBuilder stringBuilder = new StringBuilder();
        String[] words = s.split(" ");

        for (int i = 1; i <= words.length; i++) {

            stringBuilder.append(words[words.length-i]);
            stringBuilder.append(" ");

        }
        return stringBuilder.toString().trim();
    }
}

  // String rev += words[words.length-i]; ==> doghasman

/*

 Написать метод `String reverse(String s) {...}`.

Входящий параметр: s - строка которая состоит из слов через пробел

Метод должен вернуть слова в обратном порядке

Пример:

"man has dog" => "dog has man"


 */

























