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
   
   //FINISH ME!!//
   private void insert(int key, Node n) {
      Node z = bstinsert(key, n);
      z.color = RED;
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
   
   //WRITE ME!!
   public static void leftRotate(){
      leftRotate(n); 
   }
   private static void leftRotate(Node n) {
      //do stuff
   }
   
   //WRITE ME!!
   public static void rightRotate() {
      rightRotate(n); 
   }
   private static void rightRotate(Node n) {
      //do stuff
   }


   
   public static void main(String[] args) {
      RBTree t = new RBTree();
      t.insert(12);
      t.insert(36);
      t.insert(19);
      t.insert(1);
      t.insert(13);
      t.insert(15);
   }
}