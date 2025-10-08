import java.util.HashMap;
import java.util.Map;

class LRUCache<K, T> {
    private int capacity;
    private Node<K, T> head;
    private Node<K, T> tail;
    private Map<K, Node<K, T>> hashMap;
    private int size;

    LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node<K, T>();
        tail = new Node<K, T>();
        head.next = tail;
        tail.prev = head;
        hashMap = new HashMap<>();
        size = 0;
    }

    void put(K key, T value) {
        if (hashMap.containsKey(key)) {
            Node<K, T> node = hashMap.get(key);
            removeNode(node);
            addAheadOfNode(node);
            return;
        }

        Node<K, T> newNode = new Node<>(key, value);
        // If Capacity is reached
        if (size == capacity) {
            removeNode(tail.prev);
            addAheadOfNode(newNode);
            hashMap.put(newNode.key, newNode);
            return;
        }
        addAheadOfNode(newNode);
        hashMap.put(newNode.key, newNode);
        size++;
    }

    T get(K key) {
        if (hashMap.containsKey(key)) {
            Node<K, T> node = hashMap.get(key);
            removeNode(node);
            addAheadOfNode(node);
            return node.value;
        }
        return null;
    }


    private void addAheadOfNode(Node<K, T> node) {
        Node<K, T> tempNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = tempNode;
        tempNode.prev = node;
    }

    private void removeNode(Node<K, T> node) {
        Node<K, T> nextNode = node.next;
        Node<K, T> prevNode = node.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        hashMap.remove(node.key);
    }

    public void printAllNode() {
        Node<K, T> currentNode = head.next;
        System.out.println();
        while (currentNode != tail) {
            System.out.print(currentNode.value + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
