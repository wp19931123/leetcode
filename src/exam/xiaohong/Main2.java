package exam.xiaohong;


import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ceng = sc.nextLine();
        String mid = sc.nextLine();
        String[] cengs = ceng.split(" ");
        String[] mids = mid.split(" ");
        List<Integer> c = new ArrayList<>();
        List<Integer> m = new ArrayList<>();
        for (int i = 0; i < cengs.length; i++) {
            c.add(Integer.valueOf(cengs[i]));
            m.add(Integer.valueOf(mids[i]));
        }
        TreeNode root = createFromLevelInOrder(c, m, 0, c.size() - 1);
        List<Integer> yezi = yezi(root);
        List<Integer> pre = preorderTraversal(root);
        List<Integer> post = postorderTraversal(root);
        for (int i = 0; i < yezi.size(); i++) {
            System.out.print(yezi.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < pre.size(); i++) {
            System.out.print(pre.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < post.size(); i++) {
            System.out.print(post.get(i) + " ");
        }
    }

    private static TreeNode createFromLevelInOrder(List<Integer> layer, List<Integer> mid, int L, int R) {

        if (layer.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(layer.get(0));
        int k;
        for (k = L; k <= R; k++) {
            if (layer.get(0) == mid.get(k))
                break;
        }
        List left = new ArrayList();
        List right = new ArrayList();
        for (int i = 1; i < layer.size(); i++) {
            boolean isLeft = false;
            for (int j = L; j < k; j++) {
                if (layer.get(i) == mid.get(j)) {
                    isLeft = true;
                    break;
                }
            }
            if (isLeft)
                left.add(layer.get(i));
            else {
                right.add(layer.get(i));
            }
        }
        root.left = createFromLevelInOrder(left, mid, L, k - 1);
        root.right = createFromLevelInOrder(right, mid, k + 1, R);
        return root;
    }

    //前序
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) //如果为空树则返回
            return res;
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur != null) {
                res.add(cur.val);//访问根节点
                s.push(cur.right); //入栈右孩子
                s.push(cur.left);//入栈左孩子
            }
        }
        return res;
    }

    //前序
    public static List<Integer> yezi(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) //如果为空树则返回
            return res;
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur != null) {
                if (cur.left == null && cur.right == null) {
                    res.add(cur.val);
                }
                s.push(cur.right); //入栈右孩子
                s.push(cur.left);//入栈左孩子
            }
        }
        return res;
    }

    //后序
    public static List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                ret.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        Collections.reverse(ret);
        return ret;
    }

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
