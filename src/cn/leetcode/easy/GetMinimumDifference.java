package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 */
public class GetMinimumDifference {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        t1.right = t2;
        t2.left = t3;
        System.out.println(new GetMinimumDifference().getMinimumDifference2(t1));
    }

    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        int maxL = -1;
        int minR = Integer.MAX_VALUE;
        //找左子树的最大值
        if(root.left != null) {
            maxL = getMaxNode(root.left);
        }

        //找右子树的最小值
        if(root.right != null) {
            minR  = getMinNode(root.right);
        }
        if(maxL == -1) {
            return minR-root.val;
        }
        int diffL = root.val - maxL;
        int diffR = minR - root.val;
        return diffL > diffR ? diffR : diffL;
    }
    //求BST树的最大节点值
    public int getMaxNode(TreeNode root) {
        int maxL = root.val;
        if(root.right != null) {
            return getMaxNode(root.right);
        }
        return maxL;
    }

    //求BST树的最小节点值
    public int getMinNode(TreeNode root) {
        int minR = root.val;
        if(root.left != null) {
            return getMinNode(root.left);
        }
        return minR;
    }

    //中序遍历得到有序数组，求有序数组中的相邻两个元素的差值的最小值即可
    public int getMinimumDifference2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = inOrder(root,list);
        int min = Integer.MAX_VALUE;
        for(int i = 1;i < list.size();i++) {
            if(list.get(i) - list.get(i-1) < min) {
                min = list.get(i) - list.get(i-1);
            }
        }
        return min;
    }
    //中序遍历
    public List<Integer> inOrder(TreeNode root,List<Integer> list) {
       if(root == null) {
           return list;
       }
       inOrder(root.left,list);
       list.add(root.val);
       inOrder(root.right,list);
       return list;
    }

}
