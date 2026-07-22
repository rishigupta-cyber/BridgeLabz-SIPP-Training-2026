import java.util.*;

public class FriendGraph {

    private final Map<Integer, Set<Integer>> friendGraph = new HashMap<>();

    public void addFriendship(int u, int v) {
        friendGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        friendGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    public boolean isFriend(int u, int v) {
        return friendGraph.getOrDefault(u, Collections.emptySet()).contains(v);
    }

    public static void main(String[] args) {
        FriendGraph g = new FriendGraph();
        g.addFriendship(1,2);
        g.addFriendship(2,3);
        System.out.println(g.isFriend(1,2));
        System.out.println(g.isFriend(1,3));
    }
}
