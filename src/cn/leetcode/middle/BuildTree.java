package cn.leetcode.middle;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 你可以假设树中没有重复的元素。
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回    3
 *       / \
 *      9  20
 *        /  \
 *      15   7
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int beginpre, int endpre,int[] inorder,int beginin, int endin) {
        if(beginpre > endpre || beginin > endin) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[beginpre]);
        for(int i = beginin;i <= endin;i++) {
            if(inorder[i] == node.val) {
                int leftLength = i - beginin;
                node.left = buildTree(preorder, beginpre+1,beginpre+leftLength,inorder,beginin,i-1);
                node.right = buildTree(preorder, beginpre+leftLength+1,endpre,inorder,i+1,endin);
            }
        }
        return node;
    }
}
