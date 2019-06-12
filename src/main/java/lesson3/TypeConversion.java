package lesson3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TypeConversion {

    public static void main(String[] args) {
        System.out.println("Hello! Please type natural number");
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        int sum =0;
        if (q > 0) {
            while(q > 0){
                sum += q%10;
                q /= 10;
            }
            System.out.println(sum);
        } else System.out.println("Please check that you've entered three-digit number. Try again");
    }


}

