package lesson10;

import org.testng.annotations.Test;

public class ExceptionExample {
    @Test
    public void testEx(){
        int a = 4;
        try {
            System.out.println(a / 0);
        }catch (ArithmeticException e){
            System.out.println("Caught / 0");
            throw new AssertionError(e);
        }
    }
}
