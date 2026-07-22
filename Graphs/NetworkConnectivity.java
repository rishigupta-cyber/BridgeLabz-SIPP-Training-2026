import java.util.*;

public class NetworkConnectivity {

    public int countNetworkSegments(Map<Integer,List<Integer>> network,int n){
        Set<Integer> visited=new HashSet<>();
        int count=0;

        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                count++;
                dfs(network,i,visited);
            }
        }
        return count;
    }

    private void dfs(Map<Integer,List<Integer>> network,int node,Set<Integer> visited){
        visited.add(node);
        for(int next:network.getOrDefault(node,Collections.emptyList())){
            if(!visited.contains(next)){
                dfs(network,next,visited);
            }
        }
    }

    public static void main(String[] args){
        NetworkConnectivity n=new NetworkConnectivity();
        Map<Integer,List<Integer>> graph=new HashMap<>();
        graph.put(0,Arrays.asList(1));
        graph.put(1,Arrays.asList(0,2));
        graph.put(2,Arrays.asList(1));
        graph.put(3,new ArrayList<>());
        System.out.println(n.countNetworkSegments(graph,4));
    }
}
