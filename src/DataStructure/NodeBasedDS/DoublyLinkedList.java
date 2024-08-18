package DataStructure.NodeBasedDS;

public class DoublyLinkedList {
    private class Node {
        int data;
        Node previousNode;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            previousNode = null;
            nextNode = null;
        }
    }

    private Node headNode;
    private int size;

    public DoublyLinkedList() {
        headNode = null;
        size = 0;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node currNode = headNode;
            while (currNode.nextNode != null) {
                currNode = currNode.nextNode;
            }
            currNode.nextNode = newNode;
        }
        size++;
    }

    public void reverse() {
        if (headNode == null) {
            throw new NullPointerException("Empty List");
        }
        Node previousNode = null;
        Node currentNode = headNode;
        Node next = null;

        while (currentNode != null) {
            next = currentNode.nextNode;
            currentNode.nextNode = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }

        headNode = previousNode;
    }

  
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (size == 0) {
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
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(10);
        list.add(2);
        list.add(18);
        list.add(32);
        System.out.printf("Before: %s\n", list);
        list.reverse();
        System.out.printf("After %s\n", list);
    }
}
