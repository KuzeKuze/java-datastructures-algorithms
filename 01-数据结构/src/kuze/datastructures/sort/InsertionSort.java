package kuze.datastructures.sort;

/**
 * 插入排序：
 * 最好时间复杂度：O(n)
 * 最坏时间复杂度：O(n^2)
 * 平均时间复杂度：
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {7,1,3,5,-5,1,8,15,23};
        sort(array);
        for(int ele : array){
            System.out.print(ele + " ");
        }
    }

    public static void sort(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0; j--){
                if(array[j] > array[j-1]){
                    break;
                }
                swap(array, j-1, j);
            }
        }
    }

    public static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
