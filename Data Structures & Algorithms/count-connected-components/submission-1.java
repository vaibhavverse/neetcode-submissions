class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];

        int num = edges.length;

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

      Queue<Integer> q = new LinkedList<>();
      int com = 0;
    
      for(int i=0;i<n;i++){
        if(!vis[i]){
            q.offer(i);
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int nei : adj.get(curr)){
                    if(!vis[nei]){
                        vis[nei] = true;
                        q.offer(nei);
                    }
                }
            } 
            com++; 
        }
      }
      return com;
    }
}
