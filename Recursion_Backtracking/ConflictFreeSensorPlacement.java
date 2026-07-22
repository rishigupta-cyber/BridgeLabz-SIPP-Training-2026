import java.util.*;

public class ConflictFreeSensorPlacement {

    public List<List<String>> placeSensors(int n){
        List<List<String>> result=new ArrayList<>();
        backtrack(n,0,new int[n],result);
        return result;
    }

    private void backtrack(int n,int row,int[] sensorCol,List<List<String>> result){
        if(row==n){
            result.add(buildGrid(n,sensorCol));
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafe(row,col,sensorCol)){
                sensorCol[row]=col;
                backtrack(n,row+1,sensorCol,result);
            }
        }
    }

    private boolean isSafe(int row,int col,int[] sensorCol){
        for(int r=0;r<row;r++){
            if(sensorCol[r]==col) return false;
            if(Math.abs(sensorCol[r]-col)==Math.abs(r-row)) return false;
        }
        return true;
    }

    private List<String> buildGrid(int n,int[] sensorCol){
        List<String> board=new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] row=new char[n];
            Arrays.fill(row,'.');
            row[sensorCol[i]]='Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args){
        ConflictFreeSensorPlacement obj=new ConflictFreeSensorPlacement();
        System.out.println(obj.placeSensors(4));
    }
}
