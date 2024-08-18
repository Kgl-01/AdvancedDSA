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

        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index value exceeds og list size.");
        }

        Node currentNode = headNode;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.nextNode;
        }

        return currentNode.data;
    }

    public void replace(int index, int data) {
        if (headNode == null) {
            throw new NullPointerException();
        }
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index value exceeds og list size.");
        }

        Node currentNode = headNode;

        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.nextNode;
        }
        currentNode.data = data;
    }


    public void insertAtIndex(int index, int data) {
        if (headNode == null) {
            throw new NullPointerException();
        }
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index value exceeds og list size.");
        }
        Node newNode = new Node(data);
        Node currentNode = headNode;

        int i = 0;
        while (i < index - 1) {
            currentNode = currentNode.nextNode;
            i++;
        }

        newNode.nextNode = currentNode.nextNode;
        currentNode.nextNode = newNode;
        size++;
    }

    public int indexOf(int value) {
        if (headNode == null) {
            throw new NullPointerException();
        }
        if (headNode.data == value) {
            return 0;
        }
        Node currentNode = headNode;

        for (int i = 0; i < size; i++) {
            if (currentNode.data == value) {
                return i;
            }
            currentNode = currentNode.nextNode;
        }
        return -1;
    }

    public int removeAtIndex(int index) {
        if (headNode == null) {
            throw new NullPointerException("The List is empty.");
        }

        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index value exceeds og list size.");
        }

        Node currentNode = headNode;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.nextNode;
        }
        int data = currentNode.nextNode.data;
        currentNode.nextNode = currentNode.nextNode.nextNode;
        size--;
        return data;
    }

    public void reverse() {
        if (headNode == null) {
            throw new NullPointerException("Empty List");
        }
        Node previousNode = null;
        Node nextNode = null;
        Node currentNode = headNode;

        while (currentNode != null) {
            nextNode = currentNode.nextNode;
            currentNode.nextNode = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        headNode = previousNode;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
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
        System.out.printf("Initial List %s \n", list);
        System.out.println(list.get(2));
        System.out.println(list.size());
        list.replace(0, 18);
        System.out.printf("Replaced List %s \n", list);
        list.insertAtIndex(2, 7);
        list.reverse();
        System.out.printf("Insertion List List %s \n", list);
        System.out.println(list.size());
        System.out.println(list.indexOf(3));
        list.removeAtIndex(3);
        System.out.printf("Deletion List List %s \n", list);

    }
}
