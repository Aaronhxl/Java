package zju.cst.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Package: zju.cst.Tree
 * Description： 二叉树的后序遍历
 * Author: huanglong
 * Date: Created in 2019/7/29 1:16
 * Version: 0.0.1
 */
public class LaterOrder {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val &&
                    left.equals(treeNode.left) &&
                    right.equals(treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }

    private static List<Integer> laterOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode t = root;
        TreeNode pre = t;
        while (t != null || !s.isEmpty()){
            while (t != null){
                s.push(t);
                t = t.left;
            }
            TreeNode peek = s.peek();
            if(peek.right != null && !pre.equals(peek.right)){
                t = peek.right;
            }else {
                TreeNode pop = s.pop();
                result.add(pop.val);
                pre = pop;
            }
        }
        return result;
    }
}
