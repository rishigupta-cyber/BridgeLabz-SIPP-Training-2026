import java.util.*;

public class UndirectedCycleDetection {

    public boolean hasCycle(Map<Integer,List<Integer>> graph,int n){
        Set<Integer> visited=new HashSet<>();
        for(int i=0;i<n;i++){
            if(!visited.contains(i) && dfs(graph,i,-1,visited)){
                return true;
            }
        }
        return false;
    }

    private boolean dfs(Map<Integer,List<Integer>> graph,int node,int parent,Set<Integer> visited){
        visited.add(node);
        for(int next:graph.getOrDefault(node,Collections.emptyList())){
            if(!visited.contains(next)){
                if(dfs(graph,next,node,visited)) return true;
            }else if(next!=parent){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        UndirectedCycleDetection u=new UndirectedCycleDetection();
        Map<Integer,List<Integer>> graph=new HashMap<>();
        graph.put(0,Arrays.asList(1,2));
        graph.put(1,Arrays.asList(0,2));
        graph.put(2,Arrays.asList(0,1));
        System.out.println(u.hasCycle(graph,3));
    }
}
