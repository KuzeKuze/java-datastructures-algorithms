package kuze.datastructures.sort;

public class ShellSort {

    public static void main(String[] args) {
        int[] array = {};
        sort(array);
        for(int ele : array){
            System.out.print(ele + " ");
        }
    }
    public static void sort(int[] array){
        int step = 1;
        while( step < array.length / 3){
            step = step * 3 + 1;  // 1, 4, 13, 40, 121, 364
        }

        while(step != 0){
            for(int i = step; i < array.length; i++){
                for(int j = i; j >= step; j -= step){
                    if( array[j] > array[j-step] ){
                        break;
                    }
                    swap(array, j-step, j);
                }
            }
            step /= 3;
        }
    }

    public static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
