package dp;

import java.util.*;


    class Job{
        int start,end,profit;
        Job(int start,int end,int profit){
            this.start=start;
            this.end=end;
            this.profit=profit;
        }
    }
    class MaxProfitInJobSchedulingBrute {
        private int maximizeProfit(List<Job> jobList,int index,int prevEndTime,int[][] memo){
            if(index>= jobList.size()) return 0;

            if(memo[index][prevEndTime+1]!=-1) return memo[index][prevEndTime+1];
            int take=0;
            int currStartTime=jobList.get(index).start;

            if(prevEndTime==-1 || prevEndTime<=currStartTime) take=jobList.get(index).profit+maximizeProfit(jobList,index+1,
                    jobList.get(index).end,memo);
            int not_take=maximizeProfit(jobList,index+1,prevEndTime,memo);
            return memo[index][prevEndTime+1]=Math.max(take,not_take);
        }
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n=startTime.length;
            List<Job> jobList=new ArrayList<>();
            for(int i=0;i<n;i++){
                jobList.add(new Job(startTime[i],endTime[i],profit[i]));
            }
            Comparator<Job> c=(Job a, Job b) -> a.start<b.start? -1: a.start>b.start?1:0;
            Collections.sort(jobList,c);

            int maxEndTime=0;
            for(int i=0;i<n;i++) maxEndTime=Math.max(endTime[i],maxEndTime);

            int[][] memo=new int[n+1][maxEndTime+2];
            for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
            return maximizeProfit(jobList,0,-1,memo);
        }
    }






