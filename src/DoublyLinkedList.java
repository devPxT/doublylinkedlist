

public class DoublyLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public class Node {
        T data;
        Node next;
        Node previous;
    
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public void add(T data) {
        if (isFull()) {
            throw new IllegalStateException("A lista está cheia");
        }
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int pos, T data) {
        if (isFull()) {
            throw new IllegalStateException("A lista está cheia");
        }
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        Node newNode = new Node(data);
        if (pos == 0) {
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            }
        } else if (pos == size) {
            add(data);
            return;
        } else {
            Node current = getNode(pos);
            Node previous = current.previous;
            newNode.next = current;
            newNode.previous = previous;
            previous.next = newNode;
            current.previous = newNode;
        }
        size++;
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        Node removedNode = getNode(pos);
        return remove(removedNode);
    }

    public T remove(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Nó não pode ser nulo");
        }
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            tail = node.previous;
        }

        size--;
        return node.data;
    }

    public T get(int pos) {
        return getNode(pos).data;
    }

    public void set(int pos, T data) {
        Node node = getNode(pos);
        node.data = data;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return false;
    }

    public Node getNode(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        Node current;
        if (pos < size / 2) {
            current = head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > pos; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}