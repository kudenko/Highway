package lesson7;

public class MyBox extends Box {
    int color; // цвет коробки
    public void printInfo() {
        System.out.println("Объем коробки: " + getVolume());
        System.out.println("Цвет коробки: " + color);
    }

    public static void main(String[] args) {
        MyBox myBox = new MyBox();
        myBox.setBox(10, 11, 12);

        System.out.println(myBox.getVolume());
    }
    @Override
    public void getInfo(){
        System.out.println("second box");
    }
}
