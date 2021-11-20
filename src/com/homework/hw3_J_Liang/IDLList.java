package com.homework.hw3_J_Liang;

import java.util.ArrayList;

public class IDLList<E> {
    class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E elem) {
            this.data = elem;
            next = null;
            prev = null;
        }

        public Node(E elem, Node<E> prev, Node<E> next) {
            this.data = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private ArrayList<Node<E>> indices;

    public IDLList() {
        this.indices = new ArrayList<>();
        this.head = new Node(null);
        this.tail = new Node(null);
        this.size = 0;
    }

    public boolean add(int index, E elem) {
        Node newNode = new Node(elem);
        int len = size();
        if (index < 0) {
            throw new NullPointerException("error");
        }
        if (len < index) {
            throw new NullPointerException("error");
        }
        //如果index是开头
        if (index != 0) {
            Node preNode = indices.get(index - 1);
            preNode.next = newNode;
            newNode.prev = preNode;
        } else {
            newNode.prev = null;
            head = newNode;
        }
        //如果index是结尾，
        if (index < len - 1) {
            Node nextNode = indices.get(index);
            nextNode.prev = newNode;
            newNode.next = nextNode;
        } else {
            newNode.next = null;
            tail = newNode;
        }
        indices.add(index, newNode);
        size++;
        return true;
    }

    public boolean add(E elem) {
        Node newNode = new Node(elem);
        newNode.prev = null;
        int len = size();
        if (len == 0) {
            head = newNode;
            tail = newNode;
            newNode.prev = null;
            newNode.next = null;
        } else {
            Node nextNode = indices.get(0);
            nextNode.prev = newNode;
            newNode.next = nextNode;
            head = newNode;
            newNode.prev = null;
        }
        indices.add(0, newNode);
        size++;
        return true;

    }

    public boolean append(E elem) {
        Node newNode = new Node(elem);
        int len = size();
        if (len == 0) {
            head = newNode;
            tail = newNode;
            newNode.prev = null;
            newNode.next = null;
        } else {
            Node preNode = indices.get(len - 1);
            preNode.next = newNode;
            newNode.prev = preNode;
            newNode.next = null;
            tail = newNode;
        }
        indices.add(len, newNode);
        size++;
        return true;
    }

    public E get(int index) {
        int len = size();
        if (index < 0) {
            throw new NullPointerException("error");
        } else if (index < len) {
            return indices.get(index).data;
        } else {
            throw new NullPointerException("error");
        }
    }

    public E getHead() {
        int len = size();
        if (len != 0) {
            return head.data;
        } else {
            throw new NullPointerException("error");
        }
    }

    public E getLast() {
        int len = size();
        if (len != 0) {
            return tail.data;
        } else {
            throw new NullPointerException("error");
        }
    }

    public int size() {
        //size = indices.size();
        return size;
    }

    public E remove() {
        int len = indices.size();
        if (len != 0) {
            E res = head.data;
            //System.out.println(res);
            indices.remove(0);
            head = indices.get(0);
            head.prev = null;
            size--;
            return res;
        } else {
            throw new NullPointerException("error");
        }
    }

    public E removeLast() {
        int len = indices.size();
        if (len != 0) {
            E res = tail.data;
            indices.remove(len - 1);
            tail = indices.get(len - 2);
            size--;
            return res;
        } else {
            throw new NullPointerException("error");
        }
    }

    public E removeAt(int index) {
        int len = indices.size();
        if (index < 0 || len <= index) {
            throw new NullPointerException("error");
        }
        E res = indices.get(index).data;
        if (index == 0) {
            this.remove();
        } else if (index == len - 1) {
            this.removeLast();
        } else {
            Node preNode = indices.get(index - 1);
            Node nextNode = indices.get(index + 1);
            preNode.next = nextNode;
            nextNode.prev = preNode;
            indices.remove(index);
            size--;
        }
        return res;
    }

    public boolean remove(E elem) {
        int len = indices.size();
        if (len == 0) {
            throw new NullPointerException("error");
        }
        //TODO
        for (int i = 0; i < len; i++) {
            if (elem.equals(indices.get(i).data)) {
                this.removeAt(i);
                return true;
            }
        }
        throw new NullPointerException("error");
    }

    @Override
    public String toString() {
        int len = size();
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (int i = 0; i < len - 1; i++) {
            s.append(indices.get(i).data);
            s.append(", ");
        }
        s.append(indices.get(len - 1).data);
        s.append("]");

        return s.toString();
    }

}
