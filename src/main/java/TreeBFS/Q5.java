package TreeBFS;
//Problem Challenge 1 - Connect All Level Order Siblings

import java.util.*;
 public class Q5 {
     public static class TreeNode {
         int data;
         TreeNode left, right, nextRight;
         TreeNode(int data) {
             this.data = data;
             left = right = nextRight = null;
         }
     };

     public static void connect(TreeNode root) {

         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);

         q.add(null);

         while(!q.isEmpty()) {
             TreeNode p = q.peek();
             q.remove();

             if(p != null) {

                 p.nextRight = q.peek();

                 if(p.left != null) {
                     q.add(p.left);
                 }

                 if(p.right != null) {
                     q.add(p.right);
                 }
             } else if (!q.isEmpty()) {

                 q.add(null);
             }
         }
     }

     public static  void printNext(TreeNode root) {
         while(root != null) {
             System.out.print(root.data + " ");
             root = root.nextRight;
         }
     }

     public static void main(String[] args) {
         TreeNode root = new TreeNode(10);
         root.left = new TreeNode(8);
         root.right = new TreeNode(2);
         root.left.left = new TreeNode(3);
         root.right.right = new TreeNode(90);

         // Populates nextRight pointer in all nodes
         connect(root);

         // Let us check the values of nextRight pointers of all nodes

         System.out.println("Following are populated nextRight pointers in all nodes");
         printNext(root);

     }
 }