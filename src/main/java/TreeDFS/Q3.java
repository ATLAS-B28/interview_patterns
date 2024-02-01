package TreeDFS;

//Sum of Path Numbers

public class Q3 {

    public static class TreeNode2 {
        int val;
        TreeNode2 left;
        TreeNode2 right;

        TreeNode2(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int sumNumbers(TreeNode2 root) {
        return sumNumbersRecursive(root, 0);
    }

    private static int sumNumbersRecursive(TreeNode2 currNode, int currSum) {

        if(currNode == null) {
            return 0;
        }

        int newSum = currSum * 10 + currNode.val;
        System.out.println("newSum: "+newSum);
        //we multiply currSum with 10 to make space for the new current node value
        /*
        * For example, let's say currSum is 12 and the value of the current
        * node is 3. By multiplying currSum by 10, we get 120.
        * Then, by adding the value of the current node (3), we get 123.
        * This represents the new sum, which is the path number up to the current node
        * */

        if(currNode.left == null && currNode.right == null) {
            return newSum;
        }

        int leftSum = sumNumbersRecursive(currNode.left, newSum);
        int rightSum = sumNumbersRecursive(currNode.right, newSum);

        System.out.println("leftSum: "+leftSum);
        System.out.println("rightSum: "+rightSum);
        System.out.println(leftSum+rightSum);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {

        TreeNode2 root = new TreeNode2(4);
        root.left = new TreeNode2(9);
        root.right = new TreeNode2(0);
        root.left.left = new TreeNode2(5);
        root.left.right = new TreeNode2(1);

        System.out.println("Sum of path numbers: "+sumNumbers(root));
    }
}
/*
*     4
     / \
    9   0
   / \
  5   1
The sum of path numbers can be calculated as follows:

Path 1: 4 -> 9 -> 5

Path Number: 495
Path 2: 4 -> 9 -> 1

Path Number: 491
Path 3: 4 -> 0

Path Number: 40
The sum of these path numbers is: 495 + 491 + 40 = 1026
*
*
* */