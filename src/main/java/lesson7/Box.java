package lesson7;

public class Box {
    public double width;
    public double height;
    public double depth;

    public double getVolume(){
        return  width*height*depth;
    }

    public void setBox(double width, double height, double depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public void getInfo(){
        System.out.println("First box");
    }


}
