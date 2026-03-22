package com.practice.dsa.tree;

public class gfg extends Object {


    public void addNode(Node parentNode, Node node) {

        if (parentNode == null) {
            new Node(node.data);
            System.out.println("Root Node Added " + node.data);

        } else {
            parentNode.children.add(node);
            System.out.println("Parent Node " + parentNode.data + "Added " + node.data);
        }


    }

    public void printLeafNodes(Node node) {

        if (node.children.isEmpty()) {
            System.out.println("Root Node " + node.data);
        }
        for (Node child : node.children) {
            printLeafNodes(child);
        }


    }

    public void printChildNode(Node node) {

        System.out.println("Root Node Here  " + node.data);

        for (Node child : node.children) {
            System.out.print(" " + child.data);
        }
        System.out.println();
        for (Node child : node.children) {
            printChildNode(child);
        }

    }


    public void printDegree(Node node) {


        System.out.println("Degree Of Node " + node.data + " is " + node.children.size());

        for (Node child : node.children) {
            printDegree(child);
        }
    }


    void printParent(Node node, Node parentNode) {

        if (parentNode == null) {
            System.out.println(node.data + " -> Null");
        } else {
            System.out.println(node.data + " -> " + parentNode.data);
        }

        for (Node child : node.children) {

            printParent(child, node);
        }


    }

    public int printTotalNoOfNodes(Node root) {

        if (root == null) return 0;

        int count=1;


        for(Node child : root.children){

           count=count +  printTotalNoOfNodes(child);

        }
        return count;


    }

    public int depthOfTree(Node root) {

        if (root == null) return 0;

        int count =1;

        for(Node child : root.children){

            if(root.children.size()>1){
                count=count+depthOfTree(child);
                break;
            }
        }

        return count;

    }


    public static void main(String[] args) {

        gfg gfg = new gfg();

        Node root = new Node(0);

        gfg.addNode(null, root);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        gfg.addNode(root, node1);
        gfg.addNode(root, node2);
        gfg.addNode(node2, node3);
        gfg.addNode(node2, node4);

        //  gfg.printLeafNodes(root);
        //gfg.printChildNode(root);
        // gfg.printDegree(root);
       // gfg.printParent(root, null);

       // System.out.println(gfg.printTotalNoOfNodes(root));
        System.out.println(gfg.depthOfTree(root)-1);



    }
}
