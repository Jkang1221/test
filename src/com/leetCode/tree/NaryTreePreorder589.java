package com.leetCode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NaryTreePreorder589 {
    public static List<Integer> preorder(Node root) {
        LinkedList<Node> res = new LinkedList<>();
        List<Integer> out = new ArrayList<>();
        res.add(root);
        while (!res.isEmpty()){
            Node curNode = res.pollLast();
            out.add(curNode.val);
            Collections.reverse(curNode.children);
            for (Node i :curNode.children) {
                res.add(i);
            }
        }
        return out;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public void printTree(Node node, String str) {
        if (null == node) {
            return;
        } else {
            for (int i = 0; i < node.children.size(); i++) {
                printTree(node.children.get(i), str + "**");

            }
            System.out.println(str + node.val);
        }
    }
}
