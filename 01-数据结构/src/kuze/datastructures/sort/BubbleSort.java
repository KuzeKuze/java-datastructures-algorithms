package kuze.datastructures.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {7,1,3,5,-5,1,8,15,23};
        sort(array);
        for(int ele : array){
            System.out.print(ele + " ");
        }
    }

    public static void sort(int[] array){
        boolean sorted;
        do{
            sorted = true;   // 假设有序
            for(int i = 0 ; i < array.length-1; i++){
                if(array[i] >array[i+1]){
                    swap(array, i, i+1);
                    sorted = false;
                }
            }
        } while (!sorted); // 若发生过交换，则表示上一轮依然无序，再执行一次
    }

    public static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
