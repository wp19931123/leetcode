package cn.leetcode.middle;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 你可以假设树中没有重复的元素。
 */
public class BuildTreeII {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int beginin, int endin, int[] postorder, int beginpost, int endpost) {
        if (beginin > endin || beginpost > endpost) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[endpost]);
        for (int i = beginin; i <= endin; i++) {
            if (inorder[i] == node.val) {
                int goLength = i - beginin;  //左子树的长度
                node.left = buildTree(inorder, beginin, i - 1, postorder, beginpost, beginpost + goLength - 1);
                node.right = buildTree(inorder, i + 1, endin, postorder, beginpost + goLength, endpost - 1);
            }
        }
        return node;

    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = new BuildTreeII().buildTree(inorder,postorder);
        TreeNode.print(root);
    }
}
