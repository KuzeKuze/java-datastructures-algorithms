package kuze.datastructures.tree;

import java.util.Arrays;
import java.util.List;

/**
 * 通过先序和中序遍历复原二叉树
 */
public class RebuildByPreAndIn {

    public static BinaryTreeNode rebuild(List<Integer> pre, List<Integer> in){
        if(pre.size() != in.size()){
            return null;
        }
        if(pre.size() == 1){
            return new BinaryTreeNode(pre.get(0));
        }
        if(pre.size() == 0){
            return null;
        }

        // 构造根节点
        BinaryTreeNode root = new BinaryTreeNode(pre.get(0));

        // 构造左右子树
        int indexRootIn = in.indexOf(pre.get(0));

        // 左子树中序遍历，右子树中序遍历
        List<Integer> leftIn = in.subList(0, indexRootIn);
        List<Integer> rightIn = in.subList(indexRootIn+1, in.size());

        // 左子树前序遍历，右子树前序遍历
        List<Integer> leftPre = pre.subList(1, leftIn.size()+1);
        List<Integer> rightPre = pre.subList(1+leftIn.size(), pre.size());

        root.right = rebuild(rightPre, rightIn);
        root.left=rebuild(leftPre, leftIn);

        return root;

    }

    public static void main(String[] args) {
//        List<String> test = new ArrayList<>();
//        test.add("1");
//        test.add("2");
//        test.add("3");
//
//        System.out.println(test.subList(0, 1));

        Integer[] pre = {1, 3, 5, 4, 2, 7};
        Integer[] in = {5, 3, 4, 1, 2, 7};
        BinaryTreeNode root = rebuild(Arrays.asList(pre), Arrays.asList(in));
        BinaryTreePostOrderTraverse.traverse(root);
        System.out.println();
        BinaryTreeInOrderTraverse.traverse(root);

    }
}
