package lesson8;

import org.testng.annotations.Test;

public class TestParallel {

    @Test()
    public void go() throws InterruptedException {
        System.out.println("first");
        Thread.sleep(10000);
        System.out.println("first");

    }

    @Test()
    public void go2() throws InterruptedException {
        System.out.println("second");
        Thread.sleep(10000);
        System.out.println("second");

    }

}
