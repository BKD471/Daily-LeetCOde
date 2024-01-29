package tree;

import tree.bst.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Brute{
    List<List<Integer>> res=new ArrayList<>();
    private boolean checkLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    private void rootToLeafPaths(TreeNode root, List<Integer> temp){
        if(root==null) return;
        if(checkLeaf(root)) {
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        temp.add(root.val);
        rootToLeafPaths(root.left,temp);
        rootToLeafPaths(root.right,temp);
        temp.remove(temp.size()-1);
    }
    private boolean isPallindrome(List<Integer> temp){
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i:temp) hash.put(i,hash.getOrDefault(i,0)+1);

        int oddCount=0;
        for(int k:hash.values()){
            if((k&1)==1) oddCount++;
        }

        return oddCount<=1;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null) return 0;
        rootToLeafPaths(root,new ArrayList<>());
        int count=0;
        for(List<Integer> temp:res){
            if(isPallindrome(temp)) count++;
        }
        return count;
    }
}



/***
 * Best approach with little modification
 * ***/


public class PseudoPallindromicPathsInBT {
    int[] hash;
    int res=0;
    private boolean checkLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    private void rootToLeafPaths(TreeNode root){
        if(root==null) return;
        if(checkLeaf(root)) {
            hash[root.val]++;
            if(isPallindrome(hash)) res++;
            hash[root.val]--;
            return;
        }

        hash[root.val]++;
        rootToLeafPaths(root.left);
        rootToLeafPaths(root.right);
        hash[root.val]--;
    }
    private boolean isPallindrome(int[] hash){
        int oddCount=0;
        for(int i=0;i<=9;i++){
            if((hash[i]&1)==1) oddCount++;
        }
        return oddCount<=1;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null) return 0;
        hash=new int[10];
        rootToLeafPaths(root);
        return res;
    }
}