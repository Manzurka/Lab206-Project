import java.util.*;

public class SinglyLinkedList {
    private Node head;
    public void SinglyLinkedList() {
        this.head = null; 
    }
    public SinglyLinkedList {
        Node node = new Node(num);
        Node x = this.head;
        if (this.head == null) {
            this.head = node;
            return this;
        }
        while (x != null) {
            if (x.getNext() ==  null) {
                x.setNext(node);
                return this;
            }
            x = x.getNext();
        }
        return this;
    }
    public void printValues() {
        Node x = this.head;
        while (x != null) {
            System.out.println(x.getValues());
            x.x.getNext();
        }
    }
    public void remove() {
        Node x = this.head;
        while (x.getNext().getNext() != null) {
            x = x.getNext();
        }
        x.setNext(null);
    }
}
