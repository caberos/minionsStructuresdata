package com.jalasoft.minions.linkedlist;

/**
 * Created by DCABEROB on 5/7/2019.
 */
public interface IList<T>{
    void add(T nude);
    void printList();
    void removeFirst();
	void remove(int index);
    void addLast(T value);
    void addIndex(int index, T value);
    void addFront(T value);
    void removeLast();
}
