package arrays;

public class FirstOccurence {
    public static void main(String[] args) {
        System.out.println(firstOccurence("tabctnyx", "ab*q"));
    }

    static int firstOccurence(String s, String t) {
        char[] t1 = t.toCharArray();
        String str = "";
        for (char c : t1) {
            if (c != '*')
                str += c;
            else
                break;
        }
        int index = s.indexOf(str);
        if (index != -1) {
            String s1 = s.substring(index, index + t.length());
            int count = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == t.charAt(i))
                    count++;
                else if (t.charAt(i) == '*') {
                    t.replace('*', s1.charAt(i));
                    count++;
                } else
                    count--;
            }
            if (count == s1.length())
                return index;
        }
        return -1;
    }
}
