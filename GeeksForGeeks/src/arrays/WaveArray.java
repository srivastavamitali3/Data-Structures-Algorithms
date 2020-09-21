package arrays;

public class WaveArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 7, 8, 9, 10};
        int[] arr1 = new int[]/*{2, 3, 4, 7, 8, 9, 10}*/{4, 3, 7, 8, 6, 2, 1};
        zigZagArray(new int[]{2, 1}, 2);// a<b>c<d>e<f>g
        //   printWaveArray2(arr, arr.length);//a1>a2<a3>a4
    }

    private static void printWaveArray2(int[] arr, int length) {
        int i = 0;
        while (i < length - 1) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
            i = i + 2;
        }
        System.out.print("\nprintWaveArray2 :: ");
        for (int j : arr)
            System.out.print(j + " ");
    }

    private static void zigZagArray(int[] arr, int length) {
        boolean flag = true;

        for (int i = 0; i < length - 1; i++) {
            if (flag) {
                if (arr[i] > arr[i + 1])
                    swap(arr, i);
            } else {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i);
                }
            }
            flag = !flag;
        }

        System.out.println("Zig Zag array :: a<b>c<d>e");
        for (int j : arr)
            System.out.print(j + " ");
    }

    private static void swap(int[] nums, int index) {
        int temp = nums[index];
        nums[index] = nums[index + 1];
        nums[index + 1] = temp;
    }
}
