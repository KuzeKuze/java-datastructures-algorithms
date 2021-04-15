package kuze.datastructures.sort;

/**
 * 大顶堆实现升序排序
 * 最好时间复杂度：O(nlogn)
 * 最差时间复杂度：O(nlogn)
 * 平均时间复杂度：O(nlogn)
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {7,1,3,5,-5,1,8,15,23};
        sort(array);
        for(int ele : array){
            System.out.print(ele + " ");
        }
    }


    public static void sort(int[] array){
        buildHeap(array);
        for(int len = array.length; len > 0; len--){
            swap(array, 0, len - 1);
            adjust(array, len-1, 0);
        }
    }

    public static void buildHeap(int[] array){
        if( array == null || array.length == 1) return;

        int len = array.length;
        int rootIndex = len / 2 - 1;  // 第一个非叶子节点
        for(; rootIndex >= 0; rootIndex--){ // 遍历所有非叶子节点
            adjust(array, len, rootIndex);
        }
    }

    public static void adjust(int[] array, int len, int rootIndex){
        while( (rootIndex < len) && (2*rootIndex+1 < len)){ // index没有超出树的范围且不是叶子节点
            int leftIndex = rootIndex * 2+1;
            int rightIndex = leftIndex +1;
            int maxIndex = leftIndex;
            if( (rightIndex < len)
                    && (array[rightIndex] > array[leftIndex])){
                maxIndex = rightIndex;
            }

            if( array[maxIndex] > array[rootIndex] ){ // 若子结点小于父节点则交换
                swap(array, maxIndex, rootIndex);
            } else {
                break;
            }
            rootIndex = maxIndex;
        }
    }

    public static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
