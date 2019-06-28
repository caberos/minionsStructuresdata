package com.jalasoft.minions.linkedlist;

/**
 * Created by DCABEROB on 5/7/2019.
 */
public class Node<T> {

    T value;
    Node next;

    public Node(T value) {
        this.value = value;
        next = null;
    }
}
