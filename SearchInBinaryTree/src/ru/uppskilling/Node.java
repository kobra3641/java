package ru.uppskilling;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private T data;
    private final List<Node<T>> children = new ArrayList<>();
    private final Node<T> parent;

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public void addChild(Node<T> node) {
        children.add(node);
    }

    public Node<T> addChild(T data) {
        Node<T> node = new Node<T>(data, this);
        children.add(node);
        return node;
    }

    public List<Node<T>> iterate() {
        return children;
    }

    public void remove(Node<T> node) {
        children.remove(node);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
