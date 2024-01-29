package tree.bst;

public class RangeSumBst {
    private static int sum=0;
    private void traverse(TreeNode root,int low,int high){
        if(root==null) return;
        if(root.val>=low && root.val<=high) sum+=root.val;
        traverse(root.left,low,high);
        traverse(root.right,low,high);
    }
    public int rangeSumBSTApproach1(TreeNode root, int low, int high) {
        sum=0;
        traverse(root,low,high);
        return sum;
    }

    public int rangeSumBSTApproach2(TreeNode root, int low, int high) {
        if(root==null) return 0;
        if(root.val>=low && root.val<=high) return root.val
                +rangeSumBSTApproach2(root.left,low,high)
                +rangeSumBSTApproach2(root.right,low,high);
        if(root.val>high) return rangeSumBSTApproach2(root.left,low,high);
        else return rangeSumBSTApproach2(root.right,low,high);
    }
}
