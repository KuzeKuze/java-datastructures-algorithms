package kuze.datastructures.tree;

import java.util.Arrays;
import java.util.List;

public class RebuildByPostAndIn {
    public static Node rebuild(List<String> post, List<String> in){
        if(post.size() != in.size()){
            return null;
        }
        if(post.size() == 1){
            return new Node(post.get(0));
        }
        if(post.size() == 0){
            return null;
        }

        Node root = new Node(post.get(post.size()-1));

        // 构造左右子树
        int indexRootIn = in.indexOf(post.get(post.size()-1));

        // 左子树中序遍历，右子树中序遍历
        List<String> leftIn = in.subList(0, indexRootIn);
        List<String> rightIn = in.subList(indexRootIn+1, in.size());

        // 左子树后序遍历，右子树后序遍历
        List<String> leftPost = post.subList(0, leftIn.size());
        List<String> rightPost = post.subList(leftIn.size(), post.size()-1);

        root.setLeft(rebuild(leftPost, leftIn));
        root.setRight(rebuild(rightPost, rightIn));
        return root;


    }

    public static void main(String[] args) {
        String[] post = {"5", "4", "3", "7", "2", "1"};
        String[] in = {"5", "3", "4", "1", "2", "7"};
        Node root = rebuild(Arrays.asList(post), Arrays.asList(in));
        BinaryTreeAlgorithms.preorderByRecursion(root);
        System.out.println();
        BinaryTreeAlgorithms.preorderByStack(root);
    }
}
