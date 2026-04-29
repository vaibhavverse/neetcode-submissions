class Solution {
    public int[] topo(int num, int[][] prerequisites,int[] indegree,int[] ans,List<List<Integer>> adj) {

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        int idx = 0;
        for(int i=0;i<num;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int u = q.poll();
            count++;
            ans[idx++] = u;
            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.offer(v);
                }
            }
        }
        if(count == num) return ans;
        return new int[0];
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int num = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[num];

        for(int i=0;i<num;i++) adj.add(new ArrayList<>());

        for(int[] v : prerequisites){
            int a = v[0];
            int b = v[1];

            adj.get(b).add(a);
            indegree[a]++;
        }
         int[] ans = new int[num];

        return topo(num,prerequisites,indegree,ans,adj);
    }
}
