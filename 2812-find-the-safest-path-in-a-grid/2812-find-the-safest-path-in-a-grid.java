class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        if(grid.get(0).get(0)==1 || grid.get(n-1).get(n-1)==1)
            return 0;

        int[][] dist = new int[n][n];

        for(int[] row:dist)
            Arrays.fill(row,-1);

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){

            int[] cur=q.poll();

            for(int[] d:dir){

                int x=cur[0]+d[0];
                int y=cur[1]+d[1];

                if(x<0||y<0||x>=n||y>=n||dist[x][y]!=-1)
                    continue;

                dist[x][y]=dist[cur[0]][cur[1]]+1;
                q.offer(new int[]{x,y});
            }
        }

        int low=0;
        int high=2*n;

        while(low<=high){

            int mid=(low+high)/2;

            if(canReach(dist,mid)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return high;
    }

    boolean canReach(int[][] dist,int safe){

        int n=dist.length;

        if(dist[0][0]<safe)
            return false;

        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][n];

        q.offer(new int[]{0,0});
        vis[0][0]=true;

        while(!q.isEmpty()){

            int[] cur=q.poll();

            if(cur[0]==n-1 && cur[1]==n-1)
                return true;

            for(int[] d:dir){

                int x=cur[0]+d[0];
                int y=cur[1]+d[1];

                if(x<0||y<0||x>=n||y>=n)
                    continue;

                if(vis[x][y])
                    continue;

                if(dist[x][y]<safe)
                    continue;

                vis[x][y]=true;
                q.offer(new int[]{x,y});
            }
        }

        return false;
    }
}