package kuze.datastructures.other;

import java.util.List;

/**
 * 还没写完
 */
public class FullPermutation {

    public static void main(String[] args) {
        int[] array = {0,1,2,3};
        getFullPermutation(array);
    }

    public static void getFullPermutation(int[] array){
        getFullPermutation(array, 0);
    }

    public static void getFullPermutation(int[] array, int index){
        if( index >= array.length ){
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
            return ;
        }

        for(int i = index; i < array.length; i++){
            swap(array, index, i);
            getFullPermutation(array, i+1);
            swap(array, index, i);
        }
    }

    public static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

}
