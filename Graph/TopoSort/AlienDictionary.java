import java.util.*;

public class AlienDictionary {
    private static List<Integer> topoSort(int V, List<List<Integer>> adj){
        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        if(topo.size() < V)
            return new ArrayList<>();

        return topo;
    }
    public static String findOrder(String[] words){
        int N = words.length;
        int k = 26;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; i++){
            adj.add(new ArrayList<>());
        }

        boolean[] used = new boolean[k];
        for(String word : words){
            for(char ch : word.toCharArray()){
                used[ch-'a'] = true;
            }
        }

        for(int i=0; i<N-1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(), s2.length());

            boolean found = false;
            for(int ptr=0; ptr<len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    found = true;
                    break;
                }
            }

            if(!found && s1.length() > s2.length())
                return "";
        }

        List<Integer> topo = topoSort(k, adj);

        if(topo.isEmpty())
            return "";

        StringBuilder ans = new StringBuilder();
        for(int it : topo){
            if(used[it]){
                ans.append((char)(it+'a'));
            }
        }

        return ans.toString();
    }
    public static void main(String[] args) {
        String[] words = {"ab", "cd", "ef", "ad"};
        System.out.println(findOrder(words));
    }
}
