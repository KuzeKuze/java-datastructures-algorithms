package kuze.datastructures.tree;

public class ThreadNode {
    private String id;
    private ThreadNode left;
    private ThreadNode right;

    private boolean leftTag;
    private boolean rightTag;

    public ThreadNode() {
    }

    public ThreadNode(String id) {
        this.id = id;
    }

    public ThreadNode(String id, ThreadNode left, ThreadNode right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ThreadNode getLeft() {
        return left;
    }

    public void setLeft(ThreadNode left) {
        this.left = left;
    }

    public ThreadNode getRight() {
        return right;
    }

    public void setRight(ThreadNode right) {
        this.right = right;
    }

    public boolean isLeftTag() {
        return leftTag;
    }

    public void setLeftTag(boolean leftTag) {
        this.leftTag = leftTag;
    }

    public boolean isRightTag() {
        return rightTag;
    }

    public void setRightTag(boolean rightTag) {
        this.rightTag = rightTag;
    }


    @Override
    public String toString() {
        return "ThreadNode{" +
                "id='" + id + '\'' +
                ", left=" + (left == null ? left : left.getId()) +
                ", right=" + (right == null ? right : right.getId())+
                ", leftTag=" + leftTag +
                ", rightTag=" + rightTag +
                '}';
    }
}
