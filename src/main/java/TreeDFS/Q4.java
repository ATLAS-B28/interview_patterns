package TreeDFS;

//Problem Challenge 1 - Tree Diameter
/*
* The diameter of a binary tree is defined as the length of
* the longest path between any two nodes in the tree.
* The path length is measured by the number of edges between
* the nodes, not the number of nodes.
* */
public class Q4 {

    public static class TreeNode3 {
        int val;
        TreeNode3 left;
        TreeNode3 right;

        TreeNode3(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int treeDiameter;

    public static int findDiameter(TreeNode3 root) {
        treeDiameter = 0;
        calculateHeight(root);

        return treeDiameter;
    }

    private static int calculateHeight(TreeNode3 currNode) {
        if(currNode == null) {
            return 0;
        }

        int leftHeight = calculateHeight(currNode.left);
        int rightHeight = calculateHeight(currNode.right);

        System.out.println("treeDiameter: "+treeDiameter);
        int currDiameter = leftHeight + rightHeight;
        treeDiameter = Math.max(treeDiameter, currDiameter);

        System.out.println("currDiameter: "+currDiameter);
        System.out.println("leftHeight: "+leftHeight);
        System.out.println("rightHeight: "+rightHeight);
        System.out.println("currNode.val: "+currNode.val);
        System.out.println("leftHeight + rightHeight + 1: "+(leftHeight + rightHeight + 1));
        System.out.println("----");
        return Math.max(leftHeight, rightHeight) + 1;
        //any of the two comes add 1 to it, we add 1 for the current
        //node to be taken into account
        /*
        * In the context of the "Tree Diameter" problem,
        * the height of a node represents the length of the
        * longest path from that node to a leaf node. It measures the
        * number of edges in that path.
        * On the other hand, the tree diameter is the length
        * of the longest path between any two nodes in the
        * tree, measured in terms of the number of edges.
        * It does not necessarily go through the root node.
        * */
    }

    public static void main(String[] args) {

        TreeNode3 root = new TreeNode3(1);
        root.left = new TreeNode3(2);
        root.right = new TreeNode3(3);
        root.left.left = new TreeNode3(4);
        root.left.right = new TreeNode3(5);
        root.right.left = new TreeNode3(6);
        root.right.right = new TreeNode3(7);

        System.out.println("Diameter: "+findDiameter(root));
    }
}
