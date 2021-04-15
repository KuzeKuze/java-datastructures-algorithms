package kuze.datastructures.sort;


/**
 * 插入排序
 * 最好时间复杂度：O(n^2)
 * 最差时间复杂度：O(n^2)
 * 平均时间复杂度：O(n^2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {7,1,3,5,-5,1,8,15,23};
        SelectionSort.sort(array);
        for(int ele : array){
            System.out.print(ele + " ");
        }
    }


    public static void sort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int minValue = array[i];
            int minIndex = i;
            for(int j = i+1; j < array.length; j++){
                if( array[j] < minValue){
                    minValue = array[j];
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
