package amazonQuestions;

public class UglyNumbers {
    public static void main(String[] args) {
        int n = 10;
        UglyNumbers obj = new UglyNumbers();
        System.out.println(obj.getNthUglyNo(n));
    }

    private int getNthUglyNo(int n) {
        int[] uglyNo = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        uglyNo[0] = 1;
        int nextMultipleOf2 = uglyNo[0] * 2;
        int nextMultipleOf3 = uglyNo[0] * 3;
        int nextMultipleOf5 = uglyNo[0] * 5;
        int next_Ugly_No = 1;
        for (int i = 1; i < n; i++) {
            next_Ugly_No = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNo[i] = next_Ugly_No;
            if (next_Ugly_No == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = uglyNo[i2] * 2;
            }
            if (next_Ugly_No == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = uglyNo[i3] * 3;
            }
            if (next_Ugly_No == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = uglyNo[i5] * 5;
            }
        }
        return next_Ugly_No;
    }
}
