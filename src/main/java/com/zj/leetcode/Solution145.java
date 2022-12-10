package com.zj.leetcode;

import com.zj.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution145 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        node2.setLeft(node3);
        TreeNode root = new TreeNode(1, null, node2);
        System.out.println(postorderTraversal(root));
        System.out.println(postorderTraversal(null));
        System.out.println(postorderTraversal(new TreeNode(1)));
    }

    /**
     * 后序遍历
     *
     * @param root 根结点
     * @return 后序遍历结果
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(result, root);
        return result;
    }

    private static void postorderTraversal(List<Integer> result, TreeNode node) {
        if (null != node) {
            postorderTraversal(result, node.left);
            postorderTraversal(result, node.right);
            result.add(node.val);
        }
    }
}
