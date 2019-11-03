package HelloWorld;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world");
        System.out.println("Hello from Andrew");
        System.out.println("Hello again@");
        System.out.println("Hello again");
        while(true) {
            System.out.println("["+LocalDateTime.now() +"] :"+"I'm alive!");
            Thread.sleep(1000);
        }
	System.out.println("Hello world");
    }
}
