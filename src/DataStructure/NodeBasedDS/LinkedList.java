package DataStructure.NodeBasedDS;

public class LinkedList {

    private class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    private Node headNode;
    private int size;

    public LinkedList() {
        headNode = null;
        size = 0;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node currentNode = headNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
        size++;
    }

    public int get(int index) {
        if (headNode == null) {
            return -1;
        }

        Node currentNode = headNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode;
        }

        return currentNode.data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (headNode == null) {
            sb.append("}");
            return sb.toString();
        }
        Node currentNode = headNode;
        while (currentNode != null) {
            sb.append(currentNode.data).append(currentNode.nextNode != null ? "," : "");
            currentNode = currentNode.nextNode;
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(2);
        list.add(6);
        System.out.println(list);
        System.out.println(list.get(2));
    }
}
