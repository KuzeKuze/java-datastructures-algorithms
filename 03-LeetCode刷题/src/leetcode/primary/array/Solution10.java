package leetcode.primary.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 */
public class Solution10 {
    public boolean isValidSudoku(String[][] board) {
        // 验证行
        Set<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            set.clear();
            for(int j = 0; j < 9; j++){
                if(set.contains(board[i][j])){
                    return false;
                }else{
                    if(".".equals(board[i][j])){
                        continue;
                    }
                    set.add(board[i][j]);
                }
            }
        }

        set.clear();
        // 验证列
        for(int i = 0; i < 9; i++){
            set.clear();
            for(int j = 0; j < 9; j++){
                if(set.contains(board[j][i])){
                    return false;
                }else{
                    if(".".equals(board[j][i])){
                        continue;
                    }
                    set.add(board[j][i]);
                }
            }
        }

        // 验证9宫格
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                set.clear();
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l++){
                        if(set.contains(board[i*3+k][j*3+l])){
                            return  false;
                        }else {
                            if(".".equals(board[i*3+k][j*3+l])){
                                continue;
                            }
                            set.add(board[i*3+k][j*3+l]);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] board = {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
            };
        Solution10 solution10 = new Solution10();
        System.out.println((solution10.isValidSudoku(board)));


    }
}
