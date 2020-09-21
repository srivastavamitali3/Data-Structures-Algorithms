package arrays;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(versionCompare("0.1", "1.1"));
    }

    private static int versionCompare(String version1, String version2) {
        int result = 0;
        result = version1.compareTo(version2) > 0 ? 1 : -1;

        return result;
    }
}
