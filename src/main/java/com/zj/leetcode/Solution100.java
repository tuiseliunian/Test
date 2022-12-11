package com.zj.leetcode;

import com.zj.leetcode.entity.TreeNode;

public class Solution100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(p, q));
        p = new TreeNode(1, new TreeNode(2), null);
        q = new TreeNode(1, new TreeNode(2), null);
        System.out.println(isSameTree(p, q));
        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(isSameTree(p, q));
    }

    /**
     * 判断树1：p和树2：q是否为同一个树
     *
     * @param p 树1
     * @param q 树2
     * @return 树是否相同
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null != p && null != q) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
