// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the
//actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * is a generic class that implements the StackInterface<T>
 * @param <T>
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
public class LinkedStack<T> implements StackInterface<T> {
    
    private Node topNode;
    private int size;

    /**
     * Creates an empty stack.
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }

    /**
     * Adds a new entry to the top of this stack.
     * @param newEntry an object to be added to the stack
     */
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
        size++;
    }

    /**
     * Removes and returns this stack's top entry.
     * @return either the object at the top of the stack or, if the
     * stack is empty before the operation, null
     */
    public T pop() {
        T top = peek();
        if (topNode != null) {
            topNode = topNode.getNextNode();
            size--;
        }
        else {
            throw new EmptyStackException();
        }
        return top;
    }

    /**
     * Retrieves this stack's top entry.
     * @return either the object at the top of the stack or null
     */
    public T peek() {
        T top = null;
        if (!isEmpty()) {
            top = topNode.getData();
        }
        else {
            throw new EmptyStackException();
        }
        return top;
    }

    /**
     * Detects whether this stack is empty.
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return topNode == null;
    }

    /**
     * Removes all entries from this stack.
     */
    public void clear() {
        topNode = null;
        size = 0;
    }

    /**
     * Returns the size of the stack
     * @return the size of the stack
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns a string representation of the stack
     * @return a string representation of the stack
     */
    public String toString() {
        String result = "[";
        Node currentNode = topNode;
        while (currentNode != null) {
            result += currentNode.getData() + ", ";
            currentNode = currentNode.getNextNode();
        }
        if (result.length() > 1) {
            result = result.substring(0, result.length() - 2);
        }
        result += "]";
        return result;
    }

    
    
    /**
     * is a private class that represents a node in the linked list
     */
    private class Node {
        private T data;
        private Node next;

        /**
         * Creates a new node with the given data and next node
         */
        public Node(T data) 
        { 
            this.data = data; 
        }
        
        /**
         * Creates a new node with the given data and next node
         */
        public Node(T entry, Node node) 
        { 
         this(entry); 
            this.setNextNode(node); 
        }

        /**
         * Returns the data in the node
         */
        private T getData() {
            return data;
        }

        /**
         * Sets the data in the node
         */
        private Node getNextNode() {
            return next;
        }

        /**
         * Sets the next node
         */
        private void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }
}


