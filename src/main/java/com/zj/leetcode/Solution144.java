package com.zj.leetcode;

import com.zj.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        node2.setLeft(node3);
        TreeNode root = new TreeNode(1, null, node2);
        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversal(null));
        System.out.println(preorderTraversal(new TreeNode(1)));
    }

    /**
     * 先序遍历
     *
     * @param root 根结点
     * @return 先序遍历结果
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(result, root);
        return result;
    }

    private static void preorderTraversal(List<Integer> result, TreeNode node) {
        if (null != node) {
            result.add(node.val);
            preorderTraversal(result, node.left);
            preorderTraversal(result, node.right);
        }
    }
}
