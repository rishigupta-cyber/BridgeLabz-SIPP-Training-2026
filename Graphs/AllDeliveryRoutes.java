import java.util.*;

public class AllDeliveryRoutes {

    public List<List<Integer>> findAllRoutes(Map<Integer,List<Integer>> roads,int start,int target){
        List<List<Integer>> result=new ArrayList<>();
        dfs(roads,start,target,new ArrayList<>(),new HashSet<>(),result);
        return result;
    }

    private void dfs(Map<Integer,List<Integer>> roads,int current,int target,List<Integer> path,Set<Integer> visited,List<List<Integer>> result){
        path.add(current);
        visited.add(current);

        if(current==target){
            result.add(new ArrayList<>(path));
        }else{
            for(int next:roads.getOrDefault(current,Collections.emptyList())){
                if(!visited.contains(next)){
                    dfs(roads,next,target,path,visited,result);
                }
            }
        }

        path.remove(path.size()-1);
        visited.remove(current);
    }

    public static void main(String[] args){
        AllDeliveryRoutes a=new AllDeliveryRoutes();
        Map<Integer,List<Integer>> roads=new HashMap<>();
        roads.put(1,Arrays.asList(2,3));
        roads.put(2,Arrays.asList(4));
        roads.put(3,Arrays.asList(4));
        roads.put(4,new ArrayList<>());
        System.out.println(a.findAllRoutes(roads,1,4));
    }
}
