import java.util.Scanner;

class DoublyLinkedListDemo {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) {
            this.data = data;
        }
    }

    static class DoublyLinkedList {
        Node head;

        void insertAtBegin(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            if (head != null) head.prev = newNode;
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
            newNode.prev = temp;
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
            if (temp.next != null)
                temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }

        void deleteAtBegin() {
            if (head == null) return;
            head = head.next;
            if (head != null)
                head.prev = null;
        }

        void deleteAtEnd() {
            if (head == null) return;
            if (head.next == null) {
                head = null;
                return;
            }
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.prev.next = null;
        }

        void deleteAtPosition(int pos) {
            if (head == null) return;
            if (pos == 1) {
                deleteAtBegin();
                return;
            }
            Node temp = head;
            for (int i = 1; temp != null && i < pos; i++)
                temp = temp.next;
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            if (temp.prev != null)
                temp.prev.next = temp.next;
            if (temp.next != null)
                temp.next.prev = temp.prev;
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtBegin(100);
        list.insertAtEnd(300);
        list.insertAtPosition(2, 200);
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
