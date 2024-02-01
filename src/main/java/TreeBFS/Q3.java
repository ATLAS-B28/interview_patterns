package TreeBFS;
//Level Averages in a Binary Tree

import java.util.*;

public class Q3 {

    public static List<Double> levelAverages(TreeNode root) {
        List<Double> averages = new ArrayList<>();

        if(root == null) {
            return averages;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                levelSum += node.val;

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            double levelAvg = levelSum / levelSize;
            averages.add(levelAvg);
        }

        return averages;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = levelAverages(root);
        System.out.println("Level averages are: " + result);
    }
}
