

public class LinkedListCycle {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    Node head;


    private boolean detectCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node findStartNode() {

        Node slow = head;
        Node fast = head;
        boolean cycleExists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycleExists = true;
                break;
            }
        }
        if (!cycleExists) return null;
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void removeCycle() {
        Node startNode = findStartNode();
        if (startNode == null) return;

        Node temp = startNode;
        while (temp.next != startNode) {
            temp = temp.next;
        }
        temp.next = null;
        System.out.println("Cycle removed.");
    }


    public void displayList() {
        if (detectCycle()) {
            System.out.println("Cannot Display,Cycle detected");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListCycle list = new LinkedListCycle();

        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
//creating cycle
        list.head.next.next.next.next.next.next = list.head.next;


        System.out.println(list.detectCycle());
        list.removeCycle();
        System.out.println(list.detectCycle());
        list.displayList();


    }

}

