class Solution {
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    void dfs(int[][] heights,boolean[][] visited,int i,int j,int preValue){

        if(i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) return;

        if(visited[i][j] == true || preValue > heights[i][j]) return;

        visited[i][j] = true;
        
        for(int[] d : dir){
            int nx = i + d[0];
            int ny = j + d[1];
            dfs(heights,visited,nx,ny,heights[i][j]);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
      
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i=0;i<n;i++){
            dfs(heights,pacific,i,0,Integer.MIN_VALUE); //left col
            dfs(heights,atlantic,i,m-1,Integer.MIN_VALUE); //right col
        }

         for(int j=0;j<m;j++){
            dfs(heights,pacific,0,j,Integer.MIN_VALUE); //top row
            dfs(heights,atlantic,n-1,j,Integer.MIN_VALUE); //bottom
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j])
               ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
}
