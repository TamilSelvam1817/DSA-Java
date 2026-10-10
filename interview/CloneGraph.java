import java.util.*;

class Node{
    public int val;
    public List<Node> neighbors;

    public Node(int val){
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}
public class CloneGraph {
    private static List<List<Integer>> getAdjList(Node node){
        List<List<Integer>> res = new ArrayList<>();
        if(node == null) return res;

        Queue<Node> q = new LinkedList<>();
        Set<Node> vis = new HashSet<>();

        q.offer(node);
        vis.add(node);

        while(!q.isEmpty()){
            Node cur = q.poll();
            List<Integer> neighbors = new ArrayList<>();

            for(Node neighbor : cur.neighbors){
                neighbors.add(neighbor.val);

                if(vis.add(neighbor)){
                    q.offer(neighbor);
                }
            }
            res.add(neighbors);
        }
        return res;
    }
    private static Node cloneUtil(Node node, Map<Node, Node> map){
        if(map.containsKey(node)){
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for(Node neighbor : node.neighbors){
            newNode.neighbors.add(cloneUtil(neighbor, map));
        }

        return newNode;
    }   
    public static Node cloneGraph(Node node){
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();

        return cloneUtil(node, map);
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node cloned = cloneGraph(node1);
        System.out.println(getAdjList(cloned));

    }
}
