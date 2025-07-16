import java.util.Scanner;

class SinglyLinkedListDemo {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        Node head;

        void insertAtBegin(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }

        void insertAtPosition(int pos, int data) {
            if (pos <= 1) {
                insertAtBegin(data);
                return;
            }
            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 1; temp != null && i < pos - 1; i++)
                temp = temp.next;
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

        void deleteAtBegin() {
            if (head == null) return;
            head = head.next;
        }

        void deleteAtEnd() {
            if (head == null) return;
            if (head.next == null) {
                head = null;
                return;
            }
            Node temp = head;
            while (temp.next.next != null)
                temp = temp.next;
            temp.next = null;
        }

        void deleteAtPosition(int pos) {
            if (head == null) return;
            if (pos == 1) {
                head = head.next;
                return;
            }
            Node temp = head;
            for (int i = 1; temp.next != null && i < pos - 1; i++)
                temp = temp.next;
            if (temp.next == null) {
                System.out.println("Invalid position");
                return;
            }
            temp.next = temp.next.next;
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBegin(10);
        list.insertAtEnd(30);
        list.insertAtPosition(2, 20);
        list.display();

        list.deleteAtBegin();
        list.display();

        list.deleteAtEnd();
        list.display();

        list.deleteAtPosition(1);
        list.display();

        sc.close();
    }
}
