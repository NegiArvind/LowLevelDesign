class Node<K, T> {
    K key;
    T value;
    Node<K, T> next;
    Node<K, T> prev;

    Node() {
    }

    Node(K key, T value) {
        this.key = key;
        this.value = value;
    }
}
