public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "       ";
        // System.out.println(firstNonRepeating(str));
        if (!(str.trim().length() > 0))
            System.out.println(0);
        String[] arr = str.split("\\s+");
        int lengthOfArray = arr.length;
        int lengthOfLastWord = arr[lengthOfArray - 1].length();
        System.out.println(lengthOfLastWord);
    }

    private static char firstNonRepeating(String str) {
        char count[] = new char[256];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;

        int index = -1;
        int j;
        for (j = 0; j < str.length(); j++) {
            if (count[str.charAt(j)] == 1) {
                index = j;
                break;
            }
        }
        return str.charAt(index);
    }
}
