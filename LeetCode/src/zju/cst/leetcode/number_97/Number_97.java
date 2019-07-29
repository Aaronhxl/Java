package zju.cst.leetcode.number_97;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_97 {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 中序遍历实现1
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal01(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode t = root;
        while (true){
            while (t != null){
                treeNodes.add(t);
                t = t.left;
            }
            if(!treeNodes.isEmpty()){
                t = treeNodes.pop();
                result.add(t.val);
                t = t.right;
            }else{
                break;
            }
        }
        return result;
    }

    /**
     * 中序遍历实现2
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal02(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode t = root;
        while ( t != null || !treeNodes.isEmpty()){
            while (t != null){
                treeNodes.add(t);
                t = t.left;
            }
            if(!treeNodes.isEmpty()){
                t = treeNodes.pop();
                result.add(t.val);
                t = t.right;
            }
        }
        return result;
    }
}
