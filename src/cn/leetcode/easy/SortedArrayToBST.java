package cn.leetcode.easy;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return  null;
        }

        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if(l > r) {
            return null;
        }
        if(l == r) {
            return new TreeNode(nums[l]);
        }
        int mid = l + (r - l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,l,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,r);
        return root;
    }

}
