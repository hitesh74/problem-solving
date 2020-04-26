package algorithm.linked.list.recursion;

/**
 * Suppose we want to represent 2 big numbers (which can't be refresented using any in build data type)
 * using linked list.
 * Now we can perform addition of these 2 numbers.
 *
 * <pre>
 * Example:
 *           1 => 2
 *           9 => 9
 *          =============
 *           1 => 1 => 1
 *          =============
 * </pre>
 *
 * <pre>
 * Constraints:
 *   1. You can't modify the existing input lists. (Can't reverse it)
 *   2. You can't use any external data structure except for resultant list.
 *           (Can't use additional Stack, can't make a copy of input lists, Hint: Use recursion)
 *
 *
 * </pre>
 */
public class SumOfTwoLinkedLists {

    private static Node head;

    public static void main(String[] args) {
        Node list1 = createList(1, 2);
        Node list2 = createList(9, 9, 9, 9);
        Node list = doSum(list1, list2);

        Node.printList(list1);
        Node.printList(list2);
        System.out.println("======================================");
        Node.printList(list);
        System.out.println("======================================");
    }

    private static Node doSum(Node first, Node second) {

        // First list is empty
        if (first == null) {
            return second;
        }

        // Second list is empty
        if (second == null) {
            return first;
        }

        Node[] firstSecond = makeSizeEqual(first, second);
        first = firstSecond[0];
        second = firstSecond[1];

        int carry = doSumRecursively(first, second);
        return head.addFirst(carry);
    }

    private static Node[] makeSizeEqual(Node first, Node second) {
        int size1 = first.getSize();
        int size2 = second.getSize();

        boolean firstIsShorter = size2 > size1;

        // Append the padding 0s to shorter list
        if (size1 != size2) {
            if (firstIsShorter) {
                first = appendZero(first, Math.abs(size1 - size2));
            } else {
                second = appendZero(second, Math.abs(size1 - size2));
            }
        }

        return new Node[]{first, second};
    }

    private static Node appendZero(Node node, int count) {
        while (count-- > 0) {
            node = node.addFirst(0);
        }
        return node;
    }

    private static int doSumRecursively(Node first, Node second) {
        if (first == null) {
            return 0;
        }

        int carry = doSumRecursively(first.next, second.next);

        int sum = first.data + second.data + carry;
        carry = sum / 10;
        sum = sum % 10;

        Node node = new Node(sum);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }

        return carry;
    }

    private static Node createList(int... list) {

        Node head = null;
        Node current = null;
        for (int val : list) {
            Node next = new Node(val);
            if (head == null) {
                head = next;
                current = head;
            } else {
                current.next = next;
                current = next;
            }
        }
        return head;
    }
}
