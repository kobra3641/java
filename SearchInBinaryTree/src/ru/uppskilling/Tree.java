package ru.uppskilling;

import java.util.List;

public class Tree<T> extends Node<T> {

    public Tree(T data) {
        super(data, null);
    }

    public static boolean contains(List<Node<String>> childrens, String text) {
        return recurse(childrens, text);
    }

    public static boolean recurse(List<Node<String>> childrens, String text) {
        return childrens.stream().anyMatch(children -> children.getData().equals(text) ||
                children.getChildren().size() > 0 && recurse(children.getChildren(), text));
    }

    public static <T> void printTree(Node<T> node) {
        printTree(node, 0);
    }

    public static <T> void printTree(Node<T> node, int level) {
        printNode(node, level);
        if(node.getChildren() != null) {
            for(Node children: node.iterate()) {
                printTree(children, level + 1);
            }
        }
    }

    public static <T> void printNode(Node<T> node, int level) {
        for(int i=0; i<level; i++) {
            System.out.print(" ");
        }
        System.out.println(node.getData());
    }
}