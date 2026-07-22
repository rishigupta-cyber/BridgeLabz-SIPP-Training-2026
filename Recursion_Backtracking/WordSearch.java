public class WordSearch {

    public boolean exists(char[][] grid,String word){
        boolean[][] visited=new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(backtrack(grid,word,0,i,j,visited)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] grid,String word,int idx,int r,int c,boolean[][] visited){
        if(idx==word.length()) return true;

        if(r<0||r>=grid.length||c<0||c>=grid[0].length) return false;
        if(visited[r][c]||grid[r][c]!=word.charAt(idx)) return false;

        visited[r][c]=true;

        boolean found=backtrack(grid,word,idx+1,r+1,c,visited)
                ||backtrack(grid,word,idx+1,r-1,c,visited)
                ||backtrack(grid,word,idx+1,r,c+1,visited)
                ||backtrack(grid,word,idx+1,r,c-1,visited);

        visited[r][c]=false;
        return found;
    }

    public static void main(String[] args){
        WordSearch obj=new WordSearch();
        char[][] grid={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(obj.exists(grid,"ABCCED"));
    }
}
