package DataStructure.NodeBasedDS.TreeDS;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private final List<Integer> arr = new ArrayList<>();


    public Integer rootNode() {
        return arr.get(0);
    }

    public Integer lastNode() {
        return arr.get(arr.size() - 1);
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private int parentNodeIndex(int index) {
        return (index - 1) / 2;
    }

    public void insert(Integer value) {
        /*Add the value to the list*/
        arr.add(value);

        /*Save the index value of the last node*/
        int newNodeIndex = arr.size() - 1;

        /*Swap the lastNode with it's parent node if the value is greater than it's parent's node*/
        while (newNodeIndex > 0 && arr.get(newNodeIndex) > arr.get(parentNodeIndex(newNodeIndex))) {
            int temp = arr.get(parentNodeIndex(newNodeIndex));
            arr.set(parentNodeIndex(newNodeIndex), arr.get(newNodeIndex));
            arr.set(newNodeIndex, temp);
            newNodeIndex = parentNodeIndex(newNodeIndex);
        }

    }


    public void delete() {
        //overwriting rootNode's value by lastNode value;
        int value = arr.remove(arr.size() - 1);
        arr.set(0, value);
        int trickleNodeIndex = 0;
        while (hasGreaterChild(trickleNodeIndex)) {
            int largerChildIndex = calculateLargerChildIndex(trickleNodeIndex);
            int temp = arr.get(trickleNodeIndex);
            arr.set(trickleNodeIndex, arr.get(largerChildIndex));
            arr.set(largerChildIndex, temp);
            trickleNodeIndex = largerChildIndex;
        }

    }

    private boolean hasGreaterChild(int index) {
        return (leftChildIndex(index) < arr.size() && arr.get(leftChildIndex(index)) > arr.get(index)) || (rightChildIndex(index) < arr.size() && arr.get(rightChildIndex(index)) > arr.get(index));
    }

    private int calculateLargerChildIndex(int index) {
        if (rightChildIndex(index) >= arr.size()) {
            return leftChildIndex(index);
        }
        if (arr.get(rightChildIndex(index)) > arr.get(index)) {
            return rightChildIndex(index);
        } else {
            return leftChildIndex(index);
        }
    }

    public String toString() {
        return arr + "";
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(100);
        heap.insert(200);
        heap.insert(50);
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
        heap.insert(300);
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);

    }
}
