package java.com.jalasoft.minions.queue;

import java.com.jalasoft.minions.linkedlist.LinkedList;

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
     * @param value
     */
    public void add(T value) {
         queue.add(value);
     }
}
