class Pair{
    int dist;
    int node;
    Pair(int d,int n){
        dist = d;
        node = n;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
             adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];//src
            int v = time[1];//dest
            int w = time[2];//time
            adj.get(u).add(new Pair(w,v));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dist - b.dist);

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new Pair(0,k));// dist, node

        while(!pq.isEmpty()){
            Pair curr = pq.poll();//node with smallest distance
            int u = curr.node; //curr node
            int d = curr.dist; // shotest distance to react from k node to u

            if(d > dist[u]) continue; //skip same nodes that pushes multiple times

            for(Pair nei : adj.get(u)){
                int v = nei.node; // destination node
                int w = nei.dist; // weight of edge u → v

                if(d + w < dist[v]){ // we found shorter path than it has on node
                    dist[v] = d + w;
                    pq.offer(new Pair(dist[v],v));
                }
            }
        }
        int max = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(dist[i],max);
        }
        return max;
    }
}
