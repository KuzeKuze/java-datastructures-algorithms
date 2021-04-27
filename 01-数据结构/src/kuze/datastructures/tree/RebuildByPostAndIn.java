package kuze.datastructures.tree;

import java.util.Arrays;
import java.util.List;

public class RebuildByPostAndIn {
    public static BinaryTreeNode rebuild(List<Integer> post, List<Integer> in){
        if(post.size() != in.size()){
            return null;
        }
        if(post.size() == 1){
            return new BinaryTreeNode(post.get(0));
        }
        if(post.size() == 0){
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(post.get(post.size()-1));

        // 构造左右子树
        int indexRootIn = in.indexOf(post.get(post.size()-1));

        // 左子树中序遍历，右子树中序遍历
        List<Integer> leftIn = in.subList(0, indexRootIn);
        List<Integer> rightIn = in.subList(indexRootIn+1, in.size());

        // 左子树后序遍历，右子树后序遍历
        List<Integer> leftPost = post.subList(0, leftIn.size());
        List<Integer> rightPost = post.subList(leftIn.size(), post.size()-1);

        root.left = rebuild(leftPost, leftIn);
        root.right = rebuild(rightPost, rightIn);
        return root;


    }

    public static void main(String[] args) {
        int[] post = {5, 4, 3, 7, 2, 1};
        int[] in = {5, 3, 4, 1, 2, 7};

    }
}
