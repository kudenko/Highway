package lesson7;

public class MyBox2 extends Box {
    int color; // цвет коробки
    public void printInfo() {
        System.out.println("Объем коробки: " + getVolume());
        System.out.println("Цвет коробки: " + color);
    }

    public static void main(String[] args) {
        Throwable th;
        MyBox2 myBox = new MyBox2();
        myBox.setBox(10, 11, 12);

        System.out.println(myBox.getVolume());
        myBox.getInfo();
    }
    @Override
    public void getInfo(){
        System.out.println("third box");
    }
}
