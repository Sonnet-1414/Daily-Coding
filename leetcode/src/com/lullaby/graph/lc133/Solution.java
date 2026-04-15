package com.lullaby.graph.lc133;

import com.sun.source.tree.UsesTree;

import java.awt.image.ImageProducer;
import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

//class Solution {
//    Map<Node, Node> map = new HashMap<>();
//    public Node cloneGraph(Node node) {
//        if(node == null) return node;
//        if (map.containsKey(node)) return map.get(node);
//
//        Node cloneNode = new Node(node.val, new ArrayList<>());
//        map.put(node, cloneNode);
//        for (Node node1 : node.neighbors) {
//            cloneNode.neighbors.add(cloneGraph(node1));
//        }
//
//        return cloneNode;
//    }
//}

///**
// * DFS
// */
//class Solution {
//    Map<Node, Node> mark = new HashMap<>();
//    public Node cloneGraph(Node node) {
//        if (node == null) return null;
//        if (mark.containsKey(node)) return mark.get(node);
//        Node cloneNode = new Node(node.val, new ArrayList<>());
//        mark.put(node, cloneNode);
//        for (Node neighbor : node.neighbors) {
//            cloneNode.neighbors.add(cloneGraph(neighbor));
//        }
//
//        return cloneNode;
//    }
//}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> mark = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        mark.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node peekNode = queue.poll();
            Node cloneNode = mark.get(peekNode);
            for (Node neighbor : peekNode.neighbors) {
                if (!mark.containsKey(neighbor)) {
                    mark.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                cloneNode.neighbors.add(mark.get(neighbor));
            }
        }

        return mark.get(node);
    }
}