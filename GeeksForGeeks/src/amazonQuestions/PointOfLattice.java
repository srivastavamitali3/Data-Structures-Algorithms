package amazonQuestions;
/*
1. The formula to rotate any pair of points (x,y) clockwise about the origin is (y, -x), and counter-clockwise is (-y, x) .
Here We try to rotate the points relative to the origin (i.e 0, 0), so we get the dx (Bx - Ax) and dy (By - Ay) first , then use above formula to rotate it
2. The reason we take the GCD of the (dx, dy) is because we are interested in finding the minimum vector ( from Bx, By) which is still an integer(for it to be on a lattice point). GCD is that
property we are looking for . If we just take the rotated vector , it might be too long spanning multiple lattice points, so we take GCD of (dx, dy) first, and then divide with rx , ry
(rotated vector) to get the new vector that hits the first lattice point (a.k.a minimum length)
3. Since we start walking clockwise from B, we add the values obtained above to Bx, By to get the new co-ordinates
 */
public class PointOfLattice {
    public static void main(String[] args) {
        PointOfLattice pol = new PointOfLattice();
        System.out.println(pol.solution(-1,3,3,1));
    }

    public String solution(int AX, int AY, int BX, int BY) {
        int dx = BX - AX, dy = BY - AY;
        int rx = dy, ry = -dx;

        int gcd = Math.abs(gcd(rx, ry));
        rx = rx / gcd;
        ry = ry / gcd;
        int x1 = rx + BX;
        int y1 = ry + BY;
        return new String(x1 + "," + y1);
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

}
