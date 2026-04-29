class Solution {
    public boolean validTree(int n, int[][] edge) {

        if(edge.length != n - 1) return false; //true has edge = n - 1
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];

        int num = edge.length;

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e : edge){
           adj.get(e[0]).add(e[1]);
           adj.get(e[1]).add(e[0]);
        }
      Queue<Integer> q = new LinkedList<>();
      int st = 0;
      int count = 1;
      
      vis[st] = true;
      q.offer(st);
      while(!q.isEmpty()){
        int curr = q.poll();
        for(int nei : adj.get(curr)){
            if(!vis[nei]){
                vis[nei] = true;
                count++;
                q.offer(nei);
            }
        }
      }
      return count == n;
    }
}
