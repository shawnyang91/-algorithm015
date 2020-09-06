package com.shumin.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 树的前序遍历
 * @author: yangshumin
 * @create: 2020-09-06 23:27
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            ret.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return ret;
    }

}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
