package com.abhishek.algorithms.davincicode.adt.list;

import com.abhishek.algorithms.davincicode.nodes.linkedlist.singly.SinglyNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionPointOfTwoList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    // Using aux space: O(n)
    public static <T> SinglyNode<T> intersectionPoint(SinglyNode<T> l1, SinglyNode<T> l2) {
        if (l1 == null || l2 == null)
            return null;
        Set<SinglyNode<T>> set = new HashSet<SinglyNode<T>>();
        SinglyNode<T> temp = l1;
        while (temp != null) {
            set.add(temp);
            temp = temp.getNext();
        }
        temp = l2;
        while (temp != null) {
            if (set.contains(temp))
                return temp;
            temp = temp.getNext();
        }
        return null;
    }

    // Method-2
    public static <T> SinglyNode<T> intersectionPoint2(SinglyNode<T> l1, SinglyNode<T> l2) {
        if (l1 == null || l2 == null)
            return null;
        int n1 = size(l1);
        int n2 = size(l2);
        if (n1 == n2) {
            SinglyNode<T> p1 = l1, p2 = l2;
            while (p1 != null) {
                if (p1 == p2)
                    return p1;
                p1 = p1.getNext();
                p2 = p2.getNext();
            }
            return null;
        } else {
            int diff = Math.abs(n1 - n2);
            SinglyNode<T> temp = (n1 > n2) ? l2 : l1;
            int count = 1;
            while (count <= diff) {
                temp = temp.getNext();
            }
            SinglyNode<T> t = (n1 > n2) ? l1 : l2;
            return found(t, temp.getNext()) ? temp.getNext() : null;
        }
    }

    public static <T> boolean found(SinglyNode<T> l1, SinglyNode<T> l2) {
        SinglyNode<T> temp = l1;
        while (temp != null) {
            if (temp == l2)
                return true;
        }
        return false;
    }

    public static <T> int size(SinglyNode<T> l) {
        if (l == null)
            return 0;
        else {
            int count = 0;
            SinglyNode<T> temp = l;
            while (l != null) {
                count++;
                l = l.getNext();
            }
            return count;
        }
    }
}
