package ru.uppskilling;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        StackOnQueue stackOnQueue = new StackOnQueue();
        stackOnQueue.push(1);
        stackOnQueue.push(2);
        System.out.println(stackOnQueue.top());
        System.out.println(stackOnQueue.pop());
        System.out.println(stackOnQueue.top());
        System.out.println(stackOnQueue.isEmpty());
    }

    static class StackOnQueue {

        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();
        private int top;

        public StackOnQueue() {}

        public void push(int x) {
            q1.add(x);
            top = x;
        }

        public int top() {
            return top;
        }

        public int pop() {
            int n = q1.size();
            for(int i=0; i<n-1; i++) {
                int curr = q1.remove();
                q2.add(curr);
                top = curr;
            }
            int ele = q1.remove();
            n = q2.size();
            for(int i=0; i<n; i++) {
                q1.add(q2.remove());
            }
            return ele;
        }

        public boolean isEmpty() {
            return q1.isEmpty();
        }

    }
}
