package tree.bst;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
    List<Integer> first=new ArrayList<>();
    List<Integer> second=new ArrayList<>();
    private boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    private void traverse(TreeNode root,List<Integer> temp){
        if(root==null) return;
        if(isLeaf(root)) temp.add(root.val);
        traverse(root.left,temp);
        traverse(root.right,temp);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        traverse(root1,first);
        traverse(root2,second);
        int m=first.size()-1,n=second.size()-1;
        if(m!=n) return false;

        while(m>=0 && n>=0){
            if(first.get(m)!=second.get(n)) return false;
            m--;
            n--;
        }
        return true;
    }
}
