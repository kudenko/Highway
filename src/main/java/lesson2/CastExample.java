package lesson2;

public class CastExample {


    public static void main(String[] args) {
        int a = 101;
        float b = 1001.0f;
        char ch = (char)a;
        System.out.println(ch + " i->ch");
        char ch2 =  (char)b;
        System.out.println(ch2 + " f->ch");
        int i3 = (int)(char)(b);
        System.out.println(i3 + " f->ch->int");
    }
}
