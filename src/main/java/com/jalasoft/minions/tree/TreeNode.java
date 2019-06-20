package com.jalasoft.minions.tree;

import java.util.Comparator;

/**
 * Created by OPTIMUS on 09/06/2019.
 */
public class TreeNode<T> {

    T value;
    TreeNode<T> left, rigth;
    int high;

    public TreeNode(T value) {
        this.value = value;
        left = null;
        rigth = null;
        high = 1;
    }

    /**
     */
    public void setHigh() {
        if (left!=null || rigth!=null){
            if (left.getHigh() <= rigth.getHigh()) {
                high += rigth.high;
            }else {
                high+=left.getHigh();
            }
        }
    }

    public int getHigh() {
        return high;
    }
}
