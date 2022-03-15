package ru.uppskilling;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int length1 = 3;
        generateBinaryNumbersByLength(length1);
        int length2 = 9;
        generateBinaryNumbersByLength(length2);
    }

    public static void generateBinaryNumbersByLength(int length) {
        if(length == 0)
            return;
        Queue<String> q = new LinkedList<>();
        q.add("1");
        int total = 0;
        while(total < length) {
            String curr = q.poll();
            System.out.print(curr + " ");
            q.add(curr + "0");
            q.add(curr + "1");
            total++;
        }
    }
}
