class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            if(hasPath(u,v,adj,n)) return e;
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        return new int[]{};
    }

    boolean hasPath(int src,int dest,List<List<Integer>> adj,int n){

      Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];

        q.offer(src);
        vis[src] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == dest) return true;
            for(int nei : adj.get(curr)){
                if(!vis[nei]){
                    vis[nei] = true;
                    q.offer(nei);
                }
            }
        }
        return false;
    }
}