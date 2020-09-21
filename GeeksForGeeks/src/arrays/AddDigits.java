package arrays;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        // return num == 0 ? 0 : 1 + (num - 1) % 9;
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
            if (num == 0 && sum / 10 != 0) {
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }

}
