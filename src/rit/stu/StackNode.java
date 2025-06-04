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

        private Node<T> stack;

    /**
     * Create an empty stack.
     */

    public StackNode() {
        this.stack = null;
    }

    /**
     * Checks if the stack is empty
     * 
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean empty() {
        return this.stack == null;
    }

    /**
     * Removes and returns the top element in the stack
     * 
     * @return the element removed from the top of the stack
     */
    @Override
    public T pop() {
        assert !empty();
        T element = this.stack.getData();
        this.stack = this.stack.getNext();
        return element;
    }

    /**
     * Adds an elemnt to the top of the stack
     * 
     * @param element the element that gets pushed
     */
    @Override
    public void push(T element) {
        this.stack = new Node<T> (element, this.stack);
    }

    /**
     * Returns the top element of the stack without removing it
     * 
     * @return the element at the top of the stack
     */
    @Override
    public T top() {
        assert !empty();
        return this.stack.getData();
    }
}
