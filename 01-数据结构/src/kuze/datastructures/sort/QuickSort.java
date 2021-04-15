package kuze.datastructures.sort;

/**
 * 时间复杂度：
 *      枢纽结点的定位时间(partion)需要：O(n)
 *      快速排序最坏情况发生在序列已经有序的情况，这时的时间复杂度为O(n^2)
 *      平均情况下，快速排序的时间复杂度为O(nlogn)
 *
 * 空间复杂度：
 *      由于快速排序是递归执行的，最大递归调用也发生在有序的情况，为O(n)
 *      最好情况下是每次枢纽节点的定位都在中间的位置，为O(logn)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {7,1};
        sort(array);
        for(int ele : array){
            System.out.print(ele + " ");
        }
    }
    public static void sort(int[] array){
        sort(array, 0, array.length-1);
    }

    public static void sort(int[] array, int left, int right){
        if( left >= right ) return;
        int mid = partion(array, left, right);
        sort(array, left, mid-1);
        sort(array, mid+1, right);
    }

    private static int partion(int[] array, int left, int right){
        int tmp = array[left];
        while( left < right ){
            while(array[right] >= tmp && left < right){
                right--;
            }
            if(left < right){
                array[left] = array[right];
            }

            while (array[left] <= tmp && left < right){
                left++;
            }
            if(left < right){
                array[right] = array[left];
            }
        }
        array[left] = tmp;
        return left;
    }
}
