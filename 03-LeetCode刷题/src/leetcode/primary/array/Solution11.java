package leetcode.primary.array;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2i30g/
 */

/**
 * 注意矩阵转置的操作步骤，不要搞错了
 */
public class Solution11 {
    public void rotate(int[][] matrix) {
        // 先转置，再对称
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){

                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < matrix.length / 2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length - 1 -j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Solution11 solution11 = new Solution11();
        solution11.rotate(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
