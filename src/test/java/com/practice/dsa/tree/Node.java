package com.practice.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {


    int data;
    List<Node> children;


    Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}
