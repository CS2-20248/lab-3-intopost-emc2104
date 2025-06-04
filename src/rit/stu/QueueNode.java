package rit.stu;

import rit.cs.Node;
import rit.cs.Queue;

/**
 * A queue implementation that uses a Node to represent the structure.
 *
 * @param <T> The type of data the queue will hold
 * @author RIT CS
 */
public class QueueNode<T> implements Queue<T> {
    /**
     * Create an empty queue.
     */
    private Node<T> queue;

    public QueueNode() {
        this.queue = null;
    }

    @Override
    public T back() {
        assert !empty();
        Node<T> current = queue;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public T dequeue() {
        assert !empty();
        T element = queue.getData();
        queue = queue.getNext();
        return element;
    }

    @Override
    public boolean empty() {
        return queue == null;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<T>(element, null);
        if(empty()) {
            queue = newNode;
        }
        else {
            Node<T> current = queue;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    @Override
    public T front() {
        assert !empty();
        return queue.getData();
    }
}
