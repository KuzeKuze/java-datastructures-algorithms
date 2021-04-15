package kuze.datastructures.tree;

public class Test {

    public static void main(String[] args) {
        Node root = new Node("1");
        root.setLeft(new Node("3"));
        root.setRight(new Node("2"));
        root.getLeft().setLeft(new Node("5"));
        root.getRight().setRight(new Node("7"));
        root.getLeft().setRight(new Node("4"));

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
