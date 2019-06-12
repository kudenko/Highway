package lesson6;

public class ArrayMinMax {
    public static void main(String[] args) {
        int ar[] = {2,3,-1,6,6,6,7,8,9,0,1111};
        int max = ar[0] , min = ar[0];
        for(int arr:ar){
            if(arr>max){
                max = arr;
            }
            if(arr<min){
                min = arr;
            }
        }
        System.out.println("max " + max);
        System.out.println("min " + min);

    }
}
