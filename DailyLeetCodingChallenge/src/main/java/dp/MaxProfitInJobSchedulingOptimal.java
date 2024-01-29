package dp;

import dp.Job;

import java.util.*;

public class MaxProfitInJobSchedulingOptimal {
    private int lower_bound(List<Job> jobList, int key){
        int n=jobList.size(),l=0,h=n-1,best=n;
        while(l<=h){
            int mid=l+(h-l)/2;
            int value=jobList.get(mid).start;
            if(value>=key){
                best=mid;
                h=mid-1;
            }else l=mid+1;
        }
        return best;
    }
    private int maximizeProfit(List<Job> jobList, int index, int[] memo){
        if(index>= jobList.size()) return 0;
        if(memo[index]!=-1) return memo[index];

        int endTime=jobList.get(index).end;
        int indx=lower_bound(jobList,endTime);
        int take=jobList.get(index).profit+maximizeProfit(jobList,indx,memo);
        int not_take=maximizeProfit(jobList,index+1,memo);
        return memo[index]=Math.max(take,not_take);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        List<Job> jobList=new ArrayList<>();
        for(int i=0;i<n;i++){
            jobList.add(new Job(startTime[i],endTime[i],profit[i]));
        }
        Comparator<Job> c=(Job a, Job b) -> a.start<b.start? -1: a.start>b.start?1:0;
        Collections.sort(jobList,c);


        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        return maximizeProfit(jobList,0,memo);
    }
}
