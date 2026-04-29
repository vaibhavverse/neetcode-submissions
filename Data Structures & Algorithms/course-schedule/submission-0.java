class Solution {

    boolean topoLog(List<List<Integer>> adj,int num,int[] indegree){

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<num;i++){
            if(indegree[i] == 0){
                count++;
                q.offer(i);
                }
        }
        while(!q.isEmpty()){
            int u = q.poll();

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    count++;
                    q.offer(v);
                }
            }
        }
        if(count == num) return true;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int num = numCourses;
        int[] indegree = new int[num];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<num;i++) adj.add(new ArrayList<>());
        for(int[] pre : prerequisites){
            int a = pre[0];//a
            int b = pre[1];//b

            adj.get(b).add(a); //b --> a

            indegree[a]++;  //arrow ja rha hai a mein
        }
        return topoLog(adj,num,indegree);
    }
}
