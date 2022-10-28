// RBTree insert and rotate
// COSC 330 - Algorithms
// Ashley Robbins & Trong Bao
// Oct 28, 2022

import java.util.Random; 


public class RBTree {
   private static final boolean RED = true;
   private static final boolean BLACK = false;
   private Node root;
   private Node nil;
   
   public RBTree() {
      nil = new Node(-1, nil, nil, nil);
      root = nil;
   }
   
      
   private static class Node {
      private int key;
      private Node left, right, parent;
      private boolean color;
      
      private Node(int key, Node left, Node right, Node parent) {
         this.key = key;
         this.left = left;
         this.right = right;
         this.parent = parent;
         color = BLACK;
      }
   }
   
   public void insert(int key) {
      if (root == nil) {
         root = new Node(key, nil, nil, nil);
      } else {
         insert(key, root);
      }
   }
   
   private void insert(int key, Node n) {
      Node z = bstinsert(key, n);
      z.color = RED;
    
      //this is where we start fixing
      while(z.parent.color == RED) {
      
         if(z.parent == z.parent.parent.left) {
            Node uncle = z.parent.parent.right;
            
               if(uncle.color == RED) {
                  z.parent.color = BLACK; 
                  uncle.color = BLACK; 
                  z.parent.parent.color = RED; 
                  z = z.parent.parent; 
               }
               
               else {
               
                  if(z == z.parent.right) {
                     z = z.parent; 
                     leftRotate(z); 
                  }
                  
                  z.parent.color = BLACK; 
                  z.parent.parent.color = RED;
                  rightRotate(z);  
               }
            
         }
         
         else {
            Node uncle = z.parent.parent.left; 
            
            if(uncle.color = RED) {
               z.parent.color = BLACK; 
               uncle.color = BLACK; 
               z.parent.parent.color = RED; 
               z = z.parent.parent; 
            }
            else {
               if(z == z.parent.left) {
                  z = z.parent; 
                  rightRotate(z); 
               }
               z.parent.color = BLACK; 
               z.parent.parent.color = RED; 
               leftRotate(z); 
            }
         } 
      } 
      root.color = BLACK; 
 
   }
   
   private Node bstinsert(int key, Node n) {
      assert n != nil;
      if (key < n.key) {
         if (n.left != nil) {
            return bstinsert(key, n.left);
         } else {
            n.left = new Node(key, nil, nil, n);
            return n.left;
         }
      } else if (key > n.key) {
         if (n.right != nil) {
            return bstinsert(key, n.right);
         } else {
            n.right = new Node(key, nil, nil, n);
            return n.right;
         }
      } else {
         return n;
      }
   }
   
   
   public void leftRotate(Node z){
      privateLeftRotate(z); 
   }
   private void privateLeftRotate(Node n) {
      Node parent = n; 
      Node child = parent.right; 
      parent.right = child.left; 
      
      if(child.left != nil) child.left.parent = parent;
      
      replace(parent, child); 
      
      child.left = parent; 
      
      parent.parent = child; 
    
   }
   
   
   public void rightRotate(Node z) {
      privateRightRotate(z); 
   }
   private void privateRightRotate(Node n) {
      Node parent = n; 
      Node child = parent.left; 
      parent.left = child.right; 
      
      System.out.println("child = " + child);
      System.out.println( "parent = " + parent); 
      System.out.println("child.right = " + child.right); 
      System.out.println("child.right.parent = " + child.right.parent); 
      if(child.right != nil) child.right.parent = parent;

      replace(parent, child); 
      
      child.right = parent; 
      
      parent.parent = child; 
   }
   
   
   private void replace(Node n, Node child) {
      Node parent = n.parent; 
      child.parent = parent;
      if(parent == nil) root = child; 
      else if (parent.left == n) parent.left = child; 
      else parent.right = child; 
   }


   
   public static void main(String[] args) {
      Random rand = new Random(); 
      
      RBTree t = new RBTree();
      
      //sorted data
      /*t.insert(26); 
      t.insert(13); 
      t.insert(34); 
      t.insert(9); 
      t.insert(14);
      t.insert(30); 
      t.insert(78); */
      
      //random data
      for(int i = 0; i < 10; i++) {
         int nextRand = rand.nextInt(100);
         System.out.println("nextRand = " + nextRand); 
         t.insert(nextRand);  
      }
   }
}