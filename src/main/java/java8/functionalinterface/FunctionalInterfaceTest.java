package java8.functionalinterface;

public class FunctionalInterfaceTest {
    public static void main(String[] args) {


        ArithmeticOp arithmeticOp = new ArithmeticOp() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println(arithmeticOp.add(4, 6));

        arithmeticOp = (a, b) -> {

            return a + b;
        };
        System.out.println(arithmeticOp.add(5, 6));

        arithmeticOp = (a, b) -> a + b;
        System.out.println(arithmeticOp.add(5, 7));
    }
}
