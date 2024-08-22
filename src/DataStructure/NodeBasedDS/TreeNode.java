package DataStructure.NodeBasedDS;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        leftChild = left;
        rightChild = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
