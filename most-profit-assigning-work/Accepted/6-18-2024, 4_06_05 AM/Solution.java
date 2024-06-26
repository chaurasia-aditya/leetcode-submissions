// https://leetcode.com/problems/most-profit-assigning-work

class Solution {
    class Job implements Comparable<Job>{
        int diff, prof;

        public Job(int d, int p){
            diff = d;
            prof = p;
        }

        public int compareTo(Job b){
            // if(this.diff == b.diff){
            //     return this.prof-b.prof;
            // }
            return this.diff-b.diff;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int m = worker.length;

        Job[] jobs = new Job[n];
        for(int i=0;i<n;i++){
            jobs[i] = new Job(difficulty[i], profit[i]);
        }

        Arrays.sort(jobs);
        Arrays.sort(worker);

        int i=0, j = 0;
        int res = 0;
        int curMax = jobs[0].prof;

        while(i<m && worker[i]<jobs[0].diff)
            i++;
        for(;i<m;i++){
            while(j<n && jobs[j].diff<=worker[i]){
                curMax = Math.max(curMax, jobs[j].prof);
                j++;
            }
            if(j<=n && worker[i]>=jobs[j-1].diff){
                res+=curMax;
            }else{
                break;
            }
        }
        return res;
    }
}