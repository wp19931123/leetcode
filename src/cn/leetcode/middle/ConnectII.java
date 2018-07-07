package cn.leetcode.middle;

/**
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class ConnectII {

    //首先申请了一个节点temp作为记录节点,创建left指针指向temp，然后进入循环进行层次遍历；
    //如果当前节点有左子树，将left->next指向root->left（这里如果是每层的第一次操作，
    // temp->next将指向root->left，因为初始位置left是指向temp的），如果有右子树，同样的操作。
    public void connect(TreeLinkNode root) {
        TreeLinkNode tmp = new TreeLinkNode(0);
        TreeLinkNode left = tmp;
        while(root != null) {
            if(root.left != null) {
                left.next = root.left;
                left = root.left;
            }
            if(root.right != null) {
                left.next = root.right;
                left = root.right;
            }
            root = root.next;
            if(root == null) {
                left = tmp;
                root = tmp.next;
                tmp.next = null;
            }
        }
    }
}
