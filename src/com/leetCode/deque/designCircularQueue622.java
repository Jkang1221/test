package com.leetCode.deque;

public class designCircularQueue622 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
    }
}

class MyCircularQueue {
    private int[] arr;
    private int capacity;
    private int front;
    private int rear;

    public MyCircularQueue(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        if ((rear + 1) % capacity == front) {
            return true;
        }
        return false;
    }
}
