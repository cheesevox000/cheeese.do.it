/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SE140279
 */
public class queue {
    
     private class Node {

        private manageGamer user;
        private Node next;
        private Node prev;
        /**
         * 
         * @param userInfo 
         */
        public Node(manageGamer gamer) {
            this.user = gamer;
        }

        public Node() {
        }

        public manageGamer getUser() {
            return user;
        }

        public void setUser(manageGamer user) {
            this.user = user;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    public queue() {
    }
    /**
     * with add new queue i creating a new node
     * 1. add new node behind head node
     * 2. if not behind head, we add new node after tail node
     * 3. if not behind head or after tail, we add node in 
     * @param g 
     */
public void newqueue(manageGamer g) {
        Node newNode = new Node(g);
        Node curr = null;
        /**
         * if head == null, queue is empty
         * add new node for head and tail 
         */
        if (head == null) {    
            head = newNode;tail = newNode;
            size++;
            return;
        }
        for (int i = 0; i < size; i++) {
            if(newNode.user.getPoint() <= head.user.getPoint()){
                newNode.next = head;
                head.prev = newNode;head = newNode;
                size++;
                return;         // new node < head, add new node after head 
            }
            if(newNode.user.getPoint() > tail.user.getPoint()){
                tail.next = newNode;newNode.prev = tail;
                tail = newNode;
                size++;
                return;         // if node > tail, add new node behind tail
            }
            for(curr = head ; curr.next != null; curr = curr.next){
                if(curr.next.user.getPoint() >= newNode.user.getPoint()){
                    newNode.next = curr.next;
                    newNode.prev = curr;
                    curr.next.prev = newNode;
                    curr.next = newNode;
                    size ++;
                    return;      // if tail < node > head , add new node at between
                }
            }
        }
    }
/**
 * add a new user have a highest point
 * @return tail because tail is biggest,
 * 
 */
    public manageGamer front() {
        return tail.user;
    }
    
/**
 * if empty head is empty
 * @return 
 */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * 
     * @return check size of queue
     */
    public int size() {
        return size;
    }
    /**
     * set tail is empty, transfer the node to previous
     */
    
     public void dequeue() {
        tail.user = null;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        }
        size--;
    }
     /**
      * print all players and count numbers from tail
      * @return 
      */
    public String print() {
        Node curr = tail;
        int sizel = size;
        String lines = curr.user.getUserEmail() + ", " + curr.user.getPoint() + "\n";
        for (int i = 0; i < sizel - 1; i++) {
            lines = lines + curr.prev.user.getUserEmail() + ", " + curr.prev.user.getPoint() + "\n";
            curr = curr.prev;
        }
        return lines;
    }
    /**
     * with a current = head, we ran from smallest to largest if equals email return current
     * @param email
     * @return null 
     */
    public manageGamer search(String email) {
        Node curr = head;
        while (curr != null) {
            if (curr.user.getUserEmail().equals(email)) {
                return curr.user;
            }
            curr = curr.next;
        }
        return null;
    }
    /**
     * delete the email 
     * 1.if it is the smallest number, delete head
     * 2.if it is the largest number, delete tail
     * 3.if it not in 2 case behind, while loop for find a position of email
     * @param email 
     */
    public void delete(String email) {
        if (head.user.getUserEmail().equals(email)) {
            head = head.next;
            size--;
        }
        if(tail.user.getUserEmail().equals(email)){
            tail = tail.prev;
            size--;
            
        }
        Node current = head;
        while (current.next != tail) {
            if (current.next.user.getUserEmail().equals(email)) {
                current.next.next.prev = current;
                current.next = current.next.next;
                size--;
            }
            current = current.next;
        }
        
    }
    /**
     * @param email
     * @param npoint
     * provide the email that needs update, delete it, and add a new queue for change
     */
    public void update(String email, int npoint) {
        if(search(email) != null){
            delete(email);
            manageGamer g = new manageGamer(email, npoint);
            newqueue(g);
        }
    }
}

