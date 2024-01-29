package tree;

import tree.bst.TreeNode;

import java.util.*;

class Pair{
    int node,time;
    Pair(int node,int time){
        this.node=node;
        this.time=time;
    }
}
public class TimeToRot {
    private void buildGraph(Map<Integer,List<Integer>> adjacencyList,TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            if(!adjacencyList.containsKey(root.val)) adjacencyList.put(root.val,new ArrayList<>());
            if(!adjacencyList.containsKey(root.left.val)) adjacencyList.put(root.left.val,new ArrayList<>());
            adjacencyList.get(root.val).add(root.left.val);
            adjacencyList.get(root.left.val).add(root.val);
        }
        if(root.right!=null){
            if(!adjacencyList.containsKey(root.val)) adjacencyList.put(root.val,new ArrayList<>());
            if(!adjacencyList.containsKey(root.right.val)) adjacencyList.put(root.right.val,new ArrayList<>());
            adjacencyList.get(root.val).add(root.right.val);
            adjacencyList.get(root.right.val).add(root.val);
        }

        buildGraph(adjacencyList,root.left);
        buildGraph(adjacencyList,root.right);
    }

    private int rottenTime(Map<Integer,List<Integer>> adjacencyList,int start){
        boolean[] vis=new boolean[100001];
        vis[start]=true;

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(start,0));

        int maxTime=0;
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int node=temp.node;
            int time=temp.time;

            for(int t:adjacencyList.get(node)){
                if(!vis[t]){
                    q.offer(new Pair(t,time+1));
                    vis[t]=true;
                    maxTime=Math.max(maxTime,time+1);
                }
            }
        }
        return maxTime;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adjacencyList=new HashMap<>();
        buildGraph(adjacencyList,root);
        if(adjacencyList.isEmpty()){
            if(start==root.val) return 0;
            return -1;
        }
        return rottenTime(adjacencyList,start);
    }
}
