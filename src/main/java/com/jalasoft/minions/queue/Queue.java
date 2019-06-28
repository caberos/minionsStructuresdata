package com.jalasoft.minions.queue;

import com.jalasoft.minions.linkedlist.LinkedList;

/**
 * Created by DCABEROB on 5/22/2019.
 */
public class Queue<T> {
    LinkedList<T> queue;

     public Queue(){
         queue = new LinkedList<>();
     }

    /**
     * Method to add in the queue
     * @param value - value.
     */
    public void add(T value) {
         queue.add(value);
     }

    /**
     * Method to remove the first in the queue
     */
    public void remove() {
        queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public T getIndex(int index){
        return queue.getIndex();
    }
}
