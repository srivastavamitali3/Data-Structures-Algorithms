

public class Test2 {
    static class A {

    }

    static class B {
        A a = new A();
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        Test2 obj = new Test2();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            zigZagArray(arr);
        }*/

        try {
            int a = 1 + 2;
            System.out.println(a);
            throw new ArithmeticException("testing");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }

        int b = 5;
        System.out.println(b);
    }

    private static void zigZagArray(int[] arr) {
        boolean flag = true;

        for (int i = 0; i < arr.length - 2; i++) {
            if (flag) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag;
        }

        System.out.println("Zig Zag array :: a<b>c<d>e");
        for (int j : arr)
            System.out.print(j + " ");
    }
}
