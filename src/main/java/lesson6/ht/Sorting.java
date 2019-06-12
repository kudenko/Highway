package lesson6.ht;

public class Sorting {
    public static void main(String[] args) {
        int array[] = {54,26,93,17,77,31,44,55,20};
        //selection sort
        for(int i = 0; i<array.length; i++){
            int n = i;
            for(int k = i; k<array.length; k++){
                if(array[n] > array[k]){
                    n = k;

                }
            }

            int buff = array[i];
            array[i] = array[n];
            array[n] = buff;
        }
        for (int ar:array
             ) {
            System.out.println(ar);
        }
    }
}
