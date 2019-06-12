package lesson10;

import lesson7.Box;

public class ThrowExceptionn {
    static Box box;
    public static void makeSomeMagic() {
        if(box == null){
            throw new NullPointerException("BOX не инициализирован!");
        }
    }

    public static void main(String[] args) {
        //makeSomeMagic();
        //divideByZero(0);
        getSurname("test second");
    }

    public static void divideByZero(int number) {
        try {
            System.out.println(5/number);
        } catch (ArithmeticException e){
            e.printStackTrace();
        } finally {
            System.out.println(5/1);
        }
    }

    public static String getSurname(String nameAndSurname){
        String surname = nameAndSurname.split(" ")[1];
        try {
            return surname;
        } finally {
            System.out.println(surname);
        }
    }



}
