package TreeBFS;
//Zigzag Traversal

import java.util.*;

public class Q2 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftToRight = true;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            Deque<Integer> currentLevel = new LinkedList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                assert node != null;
                if(isLeftToRight) {
                    currentLevel.offerLast(node.val);
                } else {
                    currentLevel.offerFirst(node.val);
                }

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(new ArrayList<>(currentLevel));
            isLeftToRight = !isLeftToRight;
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
        root.right.left.left = new TreeNode(20);

        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
