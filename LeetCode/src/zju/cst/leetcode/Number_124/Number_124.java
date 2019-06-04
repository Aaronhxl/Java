package zju.cst.leetcode.Number_124;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */
public class Number_124 {

    public static void main(String[] args) {

    }


    public int maxPathSum(TreeNode root) {
        maxPathSumCore(root);
        return MAX;
    }
    public int MAX = Integer.MIN_VALUE;

    /**
     * 每一个节点都可以作为其和路径的最高点
     *
     * @param node
     * @return
     */
    public  int maxPathSumCore(TreeNode node) {
        if(null == node) return 0;
        int a = maxPathSumCore(node.left);
        int b = maxPathSumCore(node.right);
        if((a+b+node.val) > MAX) MAX = (a+b+node.val);
        if((a+node.val) > MAX) MAX = (a+node.val);
        if((b+node.val) > MAX) MAX = (b+node.val);
        if(node.val > MAX) MAX = node.val;
        int maxViaThisNode = ((a + node.val) > node.val ? (a + node.val) : node.val);
        return (maxViaThisNode > (b + node.val) ? maxViaThisNode : (b + node.val));
    }

    /**
     * 我们可以把问题拆分开：即便最后的最大路径没有经过根节点，它必然也有自己的“最高点”，因此我们只要针对所有结点，求出：如果路径把这个节点作为“最高点”，路径最长可达多少？记为max。然后在max中求出最大值MAX即为所求结果。和“求整数序列中的最大连续子序列”一样思路。
     *
     * 下面就是找各个“最高点”对应的max之间的关系了。
     *
     * 我们拿根节点为例，对于经过根节点的最大路径的计算方式为：
     *
     * 我们找出左子树中以左孩子为起点的最大路径长度a，和右子树中以右孩子为起点的最大路径长度b。然后这个点的max=MAX(a+b+node.val,a+node.val,b+node.val,node.val)
     *
     * 因此我们定义一个函数来算上面的a或者b，它的参数是一个节点，它的返回值是最大路径长度，但是这个路径的起点必须是输入节点，而且路径必须在以起点为根节点的子树上。
     *
     * 那么函数func(node)的return值可以这样定义：returnMAX(func(node.left)+node.val,func(node.right)+node.val,node.val)
     *
     * 终止条件是node==null，直接返回0。
     *
     * 接着我们发现上述计算max和求出MAX的过程完全可以放到func(node)里去。
     *
     * 按照这个思路的代码，maxPathSumCore就是上面func(node)的实现
     */
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}


