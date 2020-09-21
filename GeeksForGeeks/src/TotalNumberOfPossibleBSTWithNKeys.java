/*Total number of bst with n keys
 * CountBST(n)= Cataln number = (2n!/(n+1)!*n!)
 *Total number of binary trees with n keys
 *  CountBT(n) = countBST(n)*n!
 * */
public class TotalNumberOfPossibleBSTWithNKeys {
    public static void main(String[] args) {
        int count1, count2, n = 2;
        count1 = countBST(n);
        count2 = countBT(n, count1);

        System.out.println("No. of BST with n =" + n + " keys are : " + count1);
        System.out.println("No. of BT with n =" + n + " keys are : " + count2);
    }

    private static int countBT(int n, int count) {
        int countBT = count * factorial(n);
        return countBT;
    }

    private static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; ++i)
            res *= i;
        return res;
    }

    private static int countBST(int n) {
        int count = cataln(n);
        return count;
    }

    private static int cataln(int n) {
        int coeff = binomialCoeff(2 * n, n);
        return coeff / (n + 1);
    }

    private static int binomialCoeff(int n, int k) {
        int res = 1;
        if (k > n - k)
            k = n - k;
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}
