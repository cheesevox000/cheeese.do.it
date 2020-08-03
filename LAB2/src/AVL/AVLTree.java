package AVL;

import java.io.PrintWriter;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SE140279
 */
public class AVLTree {
/**
 * using hash map for store with key is point, and value email
 */
    HashMap<String, Integer> hm = new HashMap<>();
    private AVLNode root;
/**
 * for the first return root = null
 */
    public AVLTree() {
        this.root = null;
    }
/**
 * get root
 * @return root
 */
    public AVLNode getRoot() {
        return root;
    }
/**
 * check height of tree is null or have element
 * @param node
 * @return 
 */
    public int height(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }
/**
 * update height of element node after rotations or delete
 * @param node
 */
    private void updateHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }
/**
 * method insert a node to AVL tree
 * @param pointinput
 * @param email 
 */
    public void insert(int pointinput, String email) {
        System.out.println("\n[INSERT] " + "(" + email + ", " + pointinput + ")");
	root = insertToTree(root, email, pointinput);
        System.out.println("Left Node Right");
	inOrder(root);
	System.out.println("Node Left Right");
	preOrder(root);
        System.out.println("Left Right Node");
        postOrder(root);
        
    }
/**
 * method insert a node to AVL tree
 * @param node
 * @param email
 * @param pointinput
 * @return 
 */
    public AVLNode insertToTree(AVLNode node, String email, int pointinput) {
        if (node == null) {
            return new AVLNode(email,pointinput);
        } else if (node.point > pointinput) {
            node.left = insertToTree(node.left, email, pointinput);
        } else if (node.point < pointinput) {
            node.right = insertToTree(node.right, email,pointinput);
        }
        return rebalance(node);
    }
/**
 * get balance between node 
 * if node == null return height of node = 0 
 * @param node
 * @return 
 */
    private int getBalace(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.right) - height(node.left);
    }
/**
 * check AVL tree empty or not 
 * @return 
 */
    public boolean isEmpty() {
        return root == null;
    }
/**
 * if tree unbalance
 * method to set left-left
 * @param node
 * @return 
 */
    public AVLNode leftRotation(AVLNode node) {
        AVLNode x = node.right;
        AVLNode y = x.left;
        x.left = node;
        node.right = y;
        updateHeight(node);
        updateHeight(x);
        return x;
    }
/**
 * if tree unbalance
 * method to set right-right
 * @param node
 * @return 
 */
    public AVLNode rightRotation(AVLNode node) {
        AVLNode x = node.left;
        AVLNode y = x.right;
        x.right = node;
        node.left = y;
        updateHeight(node);
        updateHeight(x);
        return x;
    }
/**
 * method point at a node
 * and get node for to print
 * @param node
 * @return 
 */
    public String visit(AVLNode node) {
        if (node == null) {
            return null;
        }
        return node.toString();
    }
/**
 * method point at a node
 * and get node for to print
 * @param node
 * @return 
 */
    public String goNode(AVLNode node) {
        if (node == null) {
            return null;
        }
        return node.toFile();
    }
/**
 * this node for using search and return a node have point input
 * @param inputPoint
 * @param node
 * @return 
 */
    public AVLNode find(int inputPoint, AVLNode node) {
        if (node == null) {
            return null;
        }
        if (node.point == inputPoint) {
            return node;
        } else if (inputPoint < node.point) {
            return find(inputPoint, node.left);
        } else {
            return find(inputPoint, node.right);
        }
    }
/**
 * method using for rebalance a tree with right-right, left-left, right-left, left-right
 * @param node
 * @return 
 */
    public AVLNode rebalance(AVLNode node) {
        updateHeight(node);
        int balance = getBalace(node);
        //unbalance in the right of tree
        if (balance > 1) {
            //in
            if (height(node.right.right) > height(node.right.left)) {
                node = leftRotation(node);
            } else {
                node.right = rightRotation(node.right);
                node = leftRotation(node);
            }
            //unbalance in the left of the tree
        } else if (balance < -1) {
            if (height(node.left.left) > height(node.left.right)) {
                node = rightRotation(node);
            } else {
                node.left = leftRotation(node.left);
                node = rightRotation(node);
            }
        }
        return node;
    }
    /**
     * debug mod
     * @param p 
     */
    public void inOrder(AVLNode p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        System.out.print(visit(p));
        inOrder(p.right);
    }
/**
 * the method travel from left => right => node
 * @param p
 * @param pw 
 */
    public void inOrder(AVLNode p, PrintWriter pw) {
        if (p == null) {
            return;
        }
        inOrder(p.left, pw);
        pw.println(visit(p));
        inOrder(p.right, pw);
    }
/**
 * debug mod
 * @param p 
 */
    public void preOrder(AVLNode p) {
        if (p == null) {
            return;
        }
        System.out.print(visit(p));
        preOrder(p.left);
        preOrder(p.right);
    }
/**
 * the method travel from node => left => right
 * @param p
 * @param pw 
 */
    public void preOrder(AVLNode p, PrintWriter pw) {
        if (p == null) {
            return;
        }
        pw.println(visit(p));
        preOrder(p.left, pw);
        preOrder(p.right, pw);
    }

    private AVLNode max(AVLNode node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }
    public void postOrder(AVLNode p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        inOrder(p.right);
        System.out.print(visit(p));

    }
/**
 * the method travel from lrn
 * @param p
 * @param pw 
 */
    public void postOrder(AVLNode p, PrintWriter pw) {
        if (p == null) {
            return;
        }
        postOrder(p.left, pw);
        postOrder(p.right, pw);
        pw.println(visit(p));
    }
    /**
     * find min point of tree
     *
     * @param node
     * @return point
     */
    private AVLNode min(AVLNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
/**
 * print the form left-node-right
 * @param pw 
 */
    public void lnr(PrintWriter pw) {
        inOrder(root, pw);
    }
/**
 * print the from node-left-right
 * @param pw 
 */
    public void nlr(PrintWriter pw) {
        preOrder(root, pw);
    }
/**
 * print the form left- right -node
 * @param pw 
 */
    public void lrn(PrintWriter pw) {
        postOrder(root, pw);
    }
/**
 * remove by copy left
 * @param node
 * @param inputPoint
 * @return 
 */
    private AVLNode removeByCopyingRight(AVLNode node, int inputPoint) {
        if (node == null) {
            return null;
        }
        if (node.point > inputPoint) {
            node.left = removeByCopyingRight(node.left, inputPoint);
        } else if (node.point < inputPoint) {
            node.right = removeByCopyingRight(node.right, inputPoint);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                AVLNode p2 = max(node);
                node.email = p2.getEmail();
                node.point = p2.getPoint();
                node.left = removeByCopyingRight(node.left, p2.getPoint());
            }
        }
        return rebalance(node);
    }
}
