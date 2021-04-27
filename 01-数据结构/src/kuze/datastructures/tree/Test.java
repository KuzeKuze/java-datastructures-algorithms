package kuze.datastructures.tree;

public class Test {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode("1");
        root.setLeft(new BinaryTreeNode("3"));
        root.setRight(new BinaryTreeNode("2"));
        root.getLeft().setLeft(new BinaryTreeNode("5"));
        root.getRight().setRight(new BinaryTreeNode("7"));
        root.getLeft().setRight(new BinaryTreeNode("4"));

        BinaryTreeAlgorithms.preorderByRecursion(root);
        System.out.println();
        BinaryTreeAlgorithms.preorderByStack(root);

        System.out.println();
        System.out.println();

        BinaryTreeAlgorithms.inorderByRecursion(root);
        System.out.println();
        BinaryTreeAlgorithms.inorderByStack(root);

        System.out.println();
        System.out.println();


        BinaryTreeAlgorithms.postorderByRecursion(root);
        System.out.println();
        BinaryTreeAlgorithms.postorderByStack(root);
    }
}
