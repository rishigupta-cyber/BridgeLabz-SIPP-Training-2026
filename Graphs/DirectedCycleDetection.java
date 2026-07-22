import java.util.*;

public class DirectedCycleDetection {

    public boolean hasCycle(Map<Integer,List<Integer>> graph,int n){
        int[] state=new int[n];
        for(int i=0;i<n;i++){
            if(state[i]==0 && dfs(graph,i,state)){
                return true;
            }
        }
        return false;
    }

    private boolean dfs(Map<Integer,List<Integer>> graph,int node,int[] state){
        state[node]=1;
        for(int next:graph.getOrDefault(node,Collections.emptyList())){
            if(state[next]==1) return true;
            if(state[next]==0 && dfs(graph,next,state)) return true;
        }
        state[node]=2;
        return false;
    }

    public static void main(String[] args){
        DirectedCycleDetection d=new DirectedCycleDetection();
        Map<Integer,List<Integer>> graph=new HashMap<>();
        graph.put(0,Arrays.asList(1));
        graph.put(1,Arrays.asList(2));
        graph.put(2,Arrays.asList(0));
        System.out.println(d.hasCycle(graph,3));
    }
}
