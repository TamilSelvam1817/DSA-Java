import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
public class WordLadder1 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        int len = wordList.size();
        for(int i=0; i<len; i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().second;
            q.remove();

            if(word.equals(endWord) == true) return step;

            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord) == true){
                        set.remove(replacedWord);
                        q.offer(new Pair(replacedWord, step+1));
                    }
                }
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
