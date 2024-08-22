import DataStructure.NodeBasedDS.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode leftChild = new TreeNode(25);
        TreeNode rightChild = new TreeNode(75);
        TreeNode rootNode = new TreeNode(50, leftChild, rightChild);
        insert(45, rootNode);
        TreeNode foundNode = search(45, rootNode);

//        System.out.println(foundNode.getData());

        traverse(rootNode);

    }

    public static TreeNode search(int value, TreeNode node) {
        if (node == null || node.getData() == value) {
            return node;
        }
        if (value < node.getData()) {
            return search(value, node.getLeftChild());
        }
        return search(value, node.getRightChild());
    }

    public static void insert(int value, TreeNode node) {
        if (value < node.getData()) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(new TreeNode(value));
            } else {
                insert(value, node.getLeftChild());
            }
        } else if (value > node.getData()) {
            if (node.getRightChild() == null) {
                node.setRightChild(new TreeNode(value));
            } else {
                insert(value, node.getRightChild());
            }
        }
    }

    public static TreeNode delete(int valueToDelete, TreeNode node) {
        if (node == null) {
            return node;
        } else if (valueToDelete < node.getData()) {
            node.setLeftChild(delete(valueToDelete, node.getLeftChild()));
            return node;
        } else if (valueToDelete > node.getData()) {
            node.setRightChild(delete(valueToDelete, node.getRightChild()));
            return node;
        } else {
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            } else {
                node.setRightChild(liftUp(node.getRightChild(), node));
                return node;
            }
        }

    }

    public static TreeNode liftUp(TreeNode node, TreeNode nodeToDelete) {
        if (node.getLeftChild() != null) {
            node.setLeftChild(liftUp(node.getLeftChild(), nodeToDelete));
            return node;
        }
        nodeToDelete.setData(node.getData());
        return node.getRightChild();
    }

    public static void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.getLeftChild());
        System.out.println(node.getData());
        traverse(node.getRightChild());
    }

}