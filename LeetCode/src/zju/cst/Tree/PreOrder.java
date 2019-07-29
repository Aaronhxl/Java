package zju.cst.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Package: zju.cst.Tree
 * Description： 二叉树的前序遍历
 * Author: huanglong
 * Date: Created in 2019/7/29 0:54
 * Version: 0.0.1
 */
public class PreOrder {

    private class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 前序遍历非递归实现
     * @param root
     * @return
     */
    private static List<Integer> preOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        TreeNode t = root;
        while ( t != null || !s.isEmpty()){
            while ( t != null ){
                s.add(t);
                result.add(t.val);
                t = t.left;
            }
            if(!s.isEmpty()){
                TreeNode pop = s.pop();
                t = pop.right;
            }
        }
        return result;
    }


}
