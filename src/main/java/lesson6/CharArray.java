package lesson6;

import java.util.Arrays;

public class CharArray {
    public static void main(String[] args) {
        char [] cc = new char[255];
        for(int i=0; i < 255; i++){
            cc[i] = (char)i;
    }
            System.out.println(Arrays.toString(cc));

    }
}
