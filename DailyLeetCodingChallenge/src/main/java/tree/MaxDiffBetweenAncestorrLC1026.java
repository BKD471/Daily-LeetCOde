package tree;

import tree.bst.TreeNode;

public class MaxDiffBetweenAncestorrLC1026 {

    int maxDiff = 0;

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        if (isLeaf(root)) return new int[]{root.val, root.val};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int mx = Math.max(left[1], right[1]);
        int mn = Math.min(left[0], right[0]);

        maxDiff = Math.max(maxDiff, Math.max(Math.abs(mx - root.val), Math.abs(mn - root.val)));
        mn = Math.min(root.val, mn);
        mx = Math.max(root.val, mx);
        return new int[]{mn, mx};
    }

    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;
        dfs(root);
        return maxDiff;
    }

}
