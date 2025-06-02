package rit.stu;

import static org.junit.Assert.assertTrue;

import rit.cs.Node;
import rit.cs.Stack;

/**
 * A stack implementation that uses a Node to represent the structure.
 *
 * @param <T> The type of data the stack will hold
 * @author RIT CS
 */
public class StackNode<T> implements Stack<T> {

    /**
     * Create an empty stack.
     */
    private Node<T> stack;

    public StackNode() {
        this.stack = null;
    }

    @Override
    public boolean empty() {
        return this.stack == null;
    }

    @Override
    public T pop() {
        assert !empty();
        T element = this.stack.getData();
        this.stack = this.stack.getNext();
        return element;
    }

    @Override
    public void push(T element) {
        this.stack = new Node<T> (element, this.stack);
    }

    @Override
    public T top() {
        assert !empty();
        return this.stack.getData();
    }
}
