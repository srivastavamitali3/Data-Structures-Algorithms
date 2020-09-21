package arrays;

import java.util.Scanner;

public class CountNumberOfWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountNumberOfWords obj = new CountNumberOfWords();
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next().trim();
            System.out.println(obj.calcNoOfWords(str));
        }
    }

    private int calcNoOfWords(String str) {
        String[] s = str.split("\\D");
        int count = 0;
        for (int i = 0; i < s.length; i++)
            if (s[i].isEmpty())
                count++;
        return count;
    }
}
