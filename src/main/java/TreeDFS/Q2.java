package TreeDFS;
//All Paths for a Sum

import java.util.*;
public class Q2 {

    public static class TreeNode1  {

        int val;
        TreeNode1 left;
        TreeNode1 right;
        TreeNode1(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    }
    public static List<List<Integer>> findPathS(TreeNode1 root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();

        findPathRecursive(root, targetSum,  currPath, result);
        return result;
    }

    private static void findPathRecursive(TreeNode1 currNode, int targetSum, List<Integer> currPath, List<List<Integer>> result) {
        if(currNode == null) {
            return;
        }

        currPath.add(currNode.val);

        if(currNode.left == null && currNode.right == null && currNode.val == targetSum) {
            result.add(new ArrayList<>(currPath));
        } else {
            findPathRecursive(currNode.left, targetSum - currNode.val, currPath, result);
            findPathRecursive(currNode.right, targetSum - currNode.val, currPath, result);
        }

        currPath.remove(currPath.size() - 1);
        /*
        * By removing the last element from currentPath, we are effectively
        * backtracking to explore other paths in the binary tree. After
        * exploring a path, we remove the last element so that we can
        * continue exploring other paths from the current node's parent.
        * */
    }

    public static void main(String[] args) {

        TreeNode1 root = new TreeNode1(5);
        root.left = new TreeNode1(4);
        root.right = new TreeNode1(8);
        root.left.left = new TreeNode1(11);
        root.left.left.left = new TreeNode1(7);
        root.left.left.right = new TreeNode1(2);

        root.right.left = new TreeNode1(13);
        root.right.right = new TreeNode1(4);
        root.right.right.right = new TreeNode1(1);
        System.out.println("Sum is :"+findPathS(root, 18));


    }


}
