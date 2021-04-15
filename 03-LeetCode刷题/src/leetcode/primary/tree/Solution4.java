package leetcode.primary.tree;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

// https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/

public class Solution4 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        levelOrder(root, 1, map);
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        List<List<Integer>> list = new ArrayList<>();
        for(Object key :keys){
            list.add(map.get((Integer)key));
        }
        return list;

    }

    public void levelOrder(TreeNode root, int level, Map<Integer, List<Integer>> map){

        if(root == null ) return;;

        if( map.get(level) == null ){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(level, list);
        } else {
            List<Integer> list = map.get(level);
            list.add(root.val);
        }

        levelOrder(root.left, level+1, map);
        levelOrder(root.right, level+1, map);
    }
}
