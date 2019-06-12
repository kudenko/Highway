package lesson6;

public class BubbleSort {
    public static void main(String[] args) {
        int array[] = {54,26,93,17,77,31,44,55,20};
//        int array[] = {1,2,2,3};
        boolean isSorted = true;
        for(int i = 1; i < array.length; i++){
            if(array[i] <= array[i-i]){
                isSorted = false;
                System.out.println("Not sorted");
            }
        }
        if(isSorted){
            System.out.println("It's sorted");
            return;
        }
        for(int i =0; i< array.length; i++ ){
            for(int k = 1; k<array.length-i; k++){
                if(array[k]<array[k-1]){
                    int buff = array[k];
                    array[k] = array[k-1];
                    array[k-1] = buff;
                }
            }
        }

        for(int arr:array){
            System.out.println(arr);
        }
    }
}
