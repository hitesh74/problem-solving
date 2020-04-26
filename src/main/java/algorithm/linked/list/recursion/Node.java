package algorithm.linked.list.recursion;

public class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public static void printList(Node node) {

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public Node addFirst(int carry) {
        Node node = new Node(carry);
        node.next = this;
        return node;
    }

    public int getSize() {
        int count = 0;
        Node node = this;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}