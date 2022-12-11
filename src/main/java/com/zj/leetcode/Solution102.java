package com.zj.leetcode;

import com.zj.leetcode.entity.TreeNode;

import java.util.*;

public class Solution102 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(9, null, null);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(levelOrder(root));
    }

    /**
     * 层序遍历
     *
     * @param root 根结点
     * @return 层序遍历结果
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                levelResult.add(node.val);
                if (null != node.left) {
                    deque.offer(node.left);
                }
                if (null != node.right) {
                    deque.offer(node.right);
                }
            }
            result.add(levelResult);
        }
        return result;
    }
}
