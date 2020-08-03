package AVL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SE140279
 */
public class AVLNode {

    public String email;
    public int point;
    public int height;
    public AVLNode left;
    public AVLNode right;
/**
 * AVLNode 
 * @param email
 * @param point 
 */
    public AVLNode(String email,int point) {
        this.email = email;
        this.point = point;
        this.left = null;
        this.right = null;
    }
/**
 * 
 * @return email
 */
    public String getEmail() {
        return email;
    }
/**
 * set email
 * @param email 
 */
    public void setEmail(String email) {
        this.email = email;
    }
/**
 * get point
 * @return point
 */
    public int getPoint() {
        return point;
    }
/**
 * set email
 * @param point 
 */
    public void setPoint(int point) {
        this.point = point;
    }
/**
 * get height
 * @return height
 */
    public int getHeight() {
        return height;
    }
/**
 * set height
 * @param height 
 */
    public void setHeight(int height) {
        this.height = height;
    }
/**
 * 
 * @return left
 */
    public AVLNode getLeft() {
        return left;
    }
/**
 * set left
 * @param left 
 */
    public void setLeft(AVLNode left) {
        this.left = left;
    }
/**
 * get right
 * @return right
 */
    public AVLNode getRight() {
        return right;
    }
/**
 * set right
 * @param right 
 */
    public void setRight(AVLNode right) {
        this.right = right;
    }
/**
 * print email and point
 * @return 
 */
    public String toString() {
        return "(" + email + ", " + point + ") ";
    }
/**
 * write to file
 * @return email + point
 */
    public String toFile() {
        return email + ", " + point;
    }
}
