package com.zj.leetcode;

import com.zj.leetcode.entity.TreeNode;

import java.util.*;

public class Solution101 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(isSymmetric(root));
        left = new TreeNode(2, null, new TreeNode(3));
        right = new TreeNode(2, null, new TreeNode(3));
        root = new TreeNode(1, left, right);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        Deque<TreeNode> levelNodeDeque = new LinkedList<>();
        levelNodeDeque.add(root.left);
        levelNodeDeque.add(root.right);
        Deque<Integer> levelVal = new LinkedList<>();
        levelVal.add(null == root.left ? null : root.left.val);
        levelVal.add(null == root.right ? null : root.right.val);
        while (!levelNodeDeque.isEmpty()) {
            int size = (levelVal.size() + 1) >> 1;
            for (int i = 0; i < size; i++) {
                Integer first = levelVal.pollFirst();
                Integer last = levelVal.pollLast();
                if (!Objects.equals(first, last)) {
                    return false;
                }
            }
            int nullNum = 0;
            size = levelNodeDeque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = levelNodeDeque.poll();
                if (null == node) {
                    levelVal.offer(null);
                    levelVal.offer(null);
                    levelNodeDeque.offer(null);
                    levelNodeDeque.offer(null);
                    nullNum += 2;
                } else {
                    levelNodeDeque.offer(node.left);
                    levelNodeDeque.offer(node.right);
                    if (null == node.left) {
                        nullNum++;
                        levelVal.offer(null);
                    } else {
                        levelVal.offer(node.left.val);
                    }
                    if (null == node.right) {
                        nullNum++;
                        levelVal.offer(null);
                    } else {
                        levelVal.offer(node.right.val);
                    }
                }
            }
            size = levelNodeDeque.size();
            if (nullNum == size) {
                return true;
            }
        }
        return false;
    }
}
