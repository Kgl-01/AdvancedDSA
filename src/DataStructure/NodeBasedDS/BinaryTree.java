package DataStructure.NodeBasedDS;

public class BinaryTree {
    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(50);

        insert(25, rootNode);
        insert(75, rootNode);
        insert(10, rootNode);
        insert(33, rootNode);
        insert(56, rootNode);
        insert(89, rootNode);
        insert(4, rootNode);
        insert(11, rootNode);
        insert(30, rootNode);
        insert(40, rootNode);
        insert(52, rootNode);
        insert(61, rootNode);
        insert(82, rootNode);
        insert(95, rootNode);

        traverseAndPrint(rootNode);
    }

    public static void traverseAndPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        traverseAndPrint(node.getLeftChild());
        System.out.println(node.getData());
        traverseAndPrint(node.getRightChild());
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


    public static TreeNode search(int value, TreeNode node) {
        if (node == null || node.getData() == value) {
            return node;
        }
        if (value < node.getData()) {
            return search(value, node.getLeftChild());
        }
        return search(value, node.getRightChild());
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
                node.setRightChild(lift(node.getRightChild(), node));
                return node;
            }
        }
    }


    public static TreeNode lift(TreeNode node, TreeNode nodeToDelete) {
        if (node.getLeftChild() != null) {
            node.setLeftChild(lift(node.getLeftChild(), nodeToDelete));
            return node;
        }
        nodeToDelete.setData(node.getData());
        return node.getRightChild();
    }

}
