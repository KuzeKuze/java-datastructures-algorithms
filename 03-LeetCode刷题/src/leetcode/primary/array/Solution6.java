package leetcode.primary.array;

import java.util.*;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 */
public class Solution6 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            if(map1.containsKey(nums1[i])){
                int num = map1.get(nums1[i]);
                num++;
                map1.put(nums1[i], num);
            }else{
                map1.put(nums1[i], 1);
            }
        }
        for(int i = 0; i < nums2.length; i++){
            if(map2.containsKey(nums2[i])){
                int num = map2.get(nums2[i]);
                num++;
                map2.put(nums2[i], num);
            }else{
                map2.put(nums2[i], 1);
            }
        }

        Set<Integer> unionSet = map1.keySet();
        unionSet.retainAll(map2.keySet());
        List<Integer> list = new ArrayList<>();
        for(int i:unionSet){
            int minTime = map1.get(i) < map2.get(i) ? map1.get(i) : map2.get(i);
            for(int t=0; t < minTime; t++){
                list.add(i);
            }
        }

        int[] results = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            results[i] = list.get(i);
        }

        return results;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList();
        for(int i=0, j=0; i<nums1.length && j < nums2.length; ){
            if( nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else {
                if(nums1[i] < nums2[j]){
                    i++;
                }else {
                    j++;
                }
            }
        }
        int[] resutls = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            resutls[i]  = list.get(i);
        }
        return resutls;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] results = new Solution6().intersect2(nums1, nums2);
        for(int i:results){
            System.out.println(i);
        }
    }
}
