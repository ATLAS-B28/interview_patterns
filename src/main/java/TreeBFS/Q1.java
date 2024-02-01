package TreeBFS;

import java.util.*;

public class Q1 {
     public static List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
         if(root == null) {
             return result;
         }

         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);

         while(!queue.isEmpty()) {
             int levelSize = queue.size();//size of queue is number of nodes in current level
             List<Integer> currentLevel = new ArrayList<>();

             for(int i = 0; i < levelSize; i++) {
                 TreeNode node = queue.poll();
                 assert node != null;
                 currentLevel.add(node.val);

                 if(node.left != null) {
                     queue.offer(node.left);
                 }

                 if(node.right != null) {
                     queue.offer(node.right);
                 }
             }
             result.add(currentLevel);
         }

         return result;
     }

     public static void main(String[] args) {
         TreeNode root = new TreeNode(12);
         root.left = new TreeNode(7);
         root.right = new TreeNode(1);
         root.left.left = new TreeNode(9);
         root.right.left = new TreeNode(10);
         root.right.right = new TreeNode(5);
         List<List<Integer>> result = levelOrder(root);
         System.out.println("Level order traversal: " + result);
     }
}
