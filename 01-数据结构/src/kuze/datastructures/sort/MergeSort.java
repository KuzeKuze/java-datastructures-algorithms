package kuze.datastructures.sort;


/**
 * 归并排序：
 *      时间复杂度：O(nlogn)
 *      空间复杂度：O(n)
 */
public class MergeSort {
    private static int[] auxiliryArray;


    public static void main(String[] args) {
        int[] array = {7,1,3,5,-5,1,8,15,23};
        sort(array);
        for(int ele : array){
            System.out.print(ele + " ");
        }
    }

    public static void sort(int[] array){
        auxiliryArray = new int[array.length];
        sort(array, 0, array.length-1);
    }

    private static void sort(int[] array, int left, int right){
        if( left >= right ) return;
        int mid = (right + left) / 2;
        sort(array, left, mid);
        sort(array, mid+1, right);
        merge(array, left, mid, right);
    }



    private static void merge(int[] array, int left, int mid, int right){
        for(int i = left; i <= right; i++){
            auxiliryArray[i] = array[i];
        }

        int p = left;
        int p1 = left;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= right){
            if( auxiliryArray[p1] < auxiliryArray[p2] ){
                array[p] = auxiliryArray[p1];
                p1++;
                p++;
            }else {
                array[p] = auxiliryArray[p2];
                p2++;
                p++;
            }
        }
        while(p1 <= mid){
            array[p] = auxiliryArray[p1];
            p++;
            p1++;
        }
        while(p2 <= right){
            array[p] = auxiliryArray[p2];
            p++;
            p2++;
        }
    }
}
