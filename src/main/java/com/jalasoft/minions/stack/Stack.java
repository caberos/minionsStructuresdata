package com.jalasoft.minions.stack;

import com.jalasoft.minions.linkedlist.LinkedList;

/**
 * Created by OPTIMUS on 22/05/2019.
 */
public class Stack<T> {
    LinkedList<T> stack;

    public Stack(){
        stack = new LinkedList<T>();
    }

    /**
     * Method to get the stack is empty.
     * @return boolean.
     */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    /**
     * Method to add in the stack.
     * @param node - node.
     */
    public void add(T node){
        stack.addLast(node);
    }

    /**
     * method to remove the last in the stack.
     */
    public void remove(){
        stack.removeLast();
    }
}
