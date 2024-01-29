package arrays;

import java.util.*;

public class FIndPlayersWithZeroOrOneLoses {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer,Integer> losers=new TreeMap<>();
        Set<Integer> winners=new TreeSet<>();
        int m=matches.length;
        if(m==0) return res;

        for(int i=0;i<2;i++) res.add(new ArrayList<>());
        for(int i=0;i<m;i++) winners.add(matches[i][0]);

        for(int i=0;i<m;i++){
            int lost=matches[i][1];
            winners.remove(lost);
            losers.put(lost, losers.getOrDefault(lost,0)+1);
        }

        for(Map.Entry<Integer,Integer> t:losers.entrySet()){
            if(t.getValue()==1) res.get(1).add(t.getKey());
        }
        res.get(0).addAll(new ArrayList<>(winners));
        return res;
    }
}
