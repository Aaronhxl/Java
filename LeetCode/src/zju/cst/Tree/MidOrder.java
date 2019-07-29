package zju.cst.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Package: zju.cst.Tree
 * Description： 二叉树的中序遍历
 * Author: huanglong
 * Date: Created in 2019/7/29 1:06
 * Version: 0.0.1
 */
public class MidOrder {

    private class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 中序非递归遍历
     * @param root
     * @return
     */
    private static List<Integer> midOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode t = root;
        while ( t != null || !s.isEmpty()){
            while (t != null){
                s.add(t);
                t = t.left;
            }
            //其实这里不需要判空
            TreeNode pop = s.pop();
            result.add(pop.val);
            t = pop.right;
        }
        return result;
    }
}
