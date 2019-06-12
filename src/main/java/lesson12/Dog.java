package lesson12;

public class Dog extends Pet {
    @Override
    public void voice() {
        System.out.println("Gav gav");
    }

    @Override
    public void move() {
        System.out.println("Dog running");
    }
}
