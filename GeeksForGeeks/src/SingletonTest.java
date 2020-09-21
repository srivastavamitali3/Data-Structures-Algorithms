public class SingletonTest {
    public static void main(String[] args) {
        SingletonTest obj = new SingletonTest();
        System.out.println(obj.m1());
        System.out.println(obj.m2());
    }

    private BillPughSingleton m2() {
        return BillPughSingleton.getInstance();
    }

    private BillPughSingleton m1() {
        return BillPughSingleton.getInstance();
    }
}
