package leetcode.primary.sortandsearch;

public class Solution2 extends VersionControl{
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        do{
            long mid = (left + right) / 2;
            if(isBadVersion((int)mid)){ // 落在右边
                if(mid == 1) return (int)mid;
                if(!isBadVersion((int)(mid-1))) return (int)mid;
                // mid不是最早一个
                right = mid - 1;

            } else { // 落在左边
                if(isBadVersion((int)(mid+1))) return (int)(mid+1);
                // mid +1 不是最早的badVersion
                left = mid + 1;

            }

        } while (left < right);

        return (int)left;

    }

    public int firstBadVersion2(int n) {
        int start = 1;
        int end = n;
        while(start < end){
            int mid = (end - start) / 2 + start;
            if(!isBadVersion(mid)){
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return start;

    }

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.firstBadVersion(2126753390));
    }
}
