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

    private Node<T> queue;

    /**
     * Create an empty queue.
     */

    public QueueNode() {
        this.queue = null;
    }

    /**
     * Returns the last element of the queue
     * 
     * @return the element in the back of the queue
     */
    @Override
    public T back() {
        assert !empty();
        Node<T> current = queue;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * Removes and returns the first element of the queue
     * 
     * @return the element in the front of the queue
     */
    @Override
    public T dequeue() {
        assert !empty();
        T element = queue.getData();
        queue = queue.getNext();
        return element;
    }

    /**
     * Checks if the queue is empty
     * 
     * @return true if the queue has no elements, false otherwise
     */
    @Override
    public boolean empty() {
        return queue == null;
    }

    /**
     * Adds an element to the back of the queue
     * 
     * @param element the value added to the queue
     */
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

    /**
     * Returns the first value of the queue
     * 
     * @return the element in the front of the queue
     * @throws AssertionError if the queue is empty
     */
    @Override
    public T front() {
        assert !empty();
        return queue.getData();
    }
}
