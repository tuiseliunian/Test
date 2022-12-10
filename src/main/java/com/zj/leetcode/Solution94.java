package com.zj.leetcode;

import com.zj.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        node2.setLeft(node3);
        TreeNode root = new TreeNode(1, null, node2);
        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversal(null));
        System.out.println(inorderTraversal(new TreeNode(1)));
    }

    /**
     * 中序遍历
     *
     * @param root 根结点
     * @return 中序遍历结果
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(result, root);
        return result;
    }

    private static void inorderTraversal(List<Integer> result, TreeNode node) {
        if (null != node) {
            inorderTraversal(result, node.left);
            result.add(node.val);
            inorderTraversal(result, node.right);
        }
    }
}
