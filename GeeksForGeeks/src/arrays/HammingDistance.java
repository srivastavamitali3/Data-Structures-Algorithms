package arrays;

public class HammingDistance {
    public static void main(String[] args) {
        HammingDistance obj = new HammingDistance();
        int x = 1, y = 4;
        System.out.println(obj.hammingDistance(x, y));
    }

    public int hammingDistance(int x, int y) {
        int distance = 0;

        int n = x ^ y;
        while (n > 0) {
            n &= (n - 1);
            distance++;
        }

        return distance;
    }
}
