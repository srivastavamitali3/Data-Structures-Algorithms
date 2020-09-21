public class BillPughSingleton {
    private BillPughSingleton() {
    }

    private static class StaticHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return StaticHelper.INSTANCE;
    }
}

