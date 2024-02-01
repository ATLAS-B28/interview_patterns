package TreeDFS;

//Count Paths for a Sum
public class Q5 {

    public static class TreeNode4 {
        int val;
        TreeNode4 left;
        TreeNode4 right;

        TreeNode4(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int countPaths(TreeNode4 root, int sum) {
        if(root == null) {
            return 0;
        }

        return dfs(root, sum)  + countPaths(root.left, sum) + countPaths(root.right, sum);
        /*
        * dfs(root, sum) -
        * The dfs method counts the number of paths that start from the current node and sum up to the remaining sum.
        * countPaths(root.left, sum)-
        * It counts the number of paths in the left subtree that sum up to the given target sum.
        * countPaths(root.right, sum)
        *  It counts the number of paths in the right subtree that sum up to the given target sum.
        *
        * it gives
        * we get the total count of paths in the binary tree that sum up to the given target sum.
        * */
    }

    private static int dfs(TreeNode4 root, int sum) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        if(root.val == sum) {
            count++;
            System.out.println("Count: " + count);
        }
        /*
        * If root.val == sum, then it means that we have found a path
        * starting from the current node that sums up to the target sum.
        * count++ increments the count variable by 1. This is done
        * to keep track of the number of paths that have been found so far.
        * By including this code within the dfs method, you can see the count
        * of paths that sum up to the target sum as the algorithm traverses
        * the binary tree.
        * */

        count += dfs(root.left, sum - root.val);
        count += dfs(root.right, sum - root.val);

        System.out.println("After calculating for " + root.val + " Count: " + count);
        return count;
    }

    public static void main(String[] args) {

        TreeNode4 root = new TreeNode4(12);
        root.left = new TreeNode4(7);
        root.right = new TreeNode4(1);
        root.left.left = new TreeNode4(4);
        root.right.left = new TreeNode4(10);
        root.right.right = new TreeNode4(5);
        System.out.println("Tree has path: " + countPaths(root, 11));

    }
}
