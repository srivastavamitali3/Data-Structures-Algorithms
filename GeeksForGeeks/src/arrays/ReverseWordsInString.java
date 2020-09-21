package arrays;

public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString obj = new ReverseWordsInString();
        System.out.println(obj.reverseWords("the sky is blue"));
        System.out.println(obj.reverseWords("  hello world!  "));
        System.out.println(obj.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {

        String[] str = s.trim().split("\\s+");
        StringBuffer res = new StringBuffer();
        for (int i = str.length - 1; i >= 0; i--)
            res.append(str[i] + " ");

        return res.toString().trim();
    }
}
