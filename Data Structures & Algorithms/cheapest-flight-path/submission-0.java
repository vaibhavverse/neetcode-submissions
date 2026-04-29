class Pair{
    int node;
    int dist;
    int stops;
    Pair(int n,int d,int c){
        node = n;
        dist = d;
        stops = c;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int[] f : flights){
            int u = f[0];//src
            int v = f[1];//dist
            int w = f[2];//price

            adj.get(u).add(new Pair(v,w,0));
        }
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        q.offer(new Pair(src,0,0));
        dist[src] = 0;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int node = curr.node;
            int distance = curr.dist;
            int stop = curr.stops;

            if(k < stop) continue;
            for(Pair nei : adj.get(node)){
              int adjNode = nei.node;
              int weight = nei.dist;

              if(distance + weight < dist[adjNode] && stop <= k){
                dist[adjNode] = distance + weight;
                q.offer(new Pair(adjNode,dist[adjNode],stop+1));
              }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}
