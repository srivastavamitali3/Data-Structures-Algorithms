import java.util.ArrayList;
import java.util.List;

abstract class A {
    public abstract void a();

    public void b() {
        System.out.println("b");
    }
}

abstract class C extends A {
    public void b() {
        System.out.println("AB");
    }
}

class B {
    public static void main(String[] args) {
//        int a =123451234512345;
//        for(int x =3;x<=3;x++)
//        System.out.println("apple".compareTo("banana"));
//        try{
//            System.out.println("Hello world");
//        }catch (Exception e){
//            System.out.println("e");
//        }catch (ArithmeticException e)
//        System.out.println("e");
//        finally{
//
//        }

//        List list = new ArrayList();
//        list.add("helo");
//        list.add(2);
//        System.out.println(list.get(0) instanceof Object);
//        System.out.println(list.get(1) instanceof Integer);

//        int[] array = {1,2,3,4};
//        for(int i =0;i<array.size())
//        String fruit ="strawberries";
//        System.out.println(fruit.substring(2,5));


        try {
            System.out.println("A");
            badMethod();
            System.out.println("B");
        } catch (Error ex) {
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
    }

    private static void badMethod() {
        throw new Error();
    }
}