import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        Set<String> set = new HashSet<>();
        int len = wordList.size();
        for(int i=0; i<len; i++){
            set.add(wordList.get(i));
        }
        Queue<List<String>> q = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.offer(ls);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();

        while(!q.isEmpty()){
            List<String> vec = q.peek();
            q.remove();

            if(vec.size() > level){
                level++;
                for(String it : usedOnLevel){
                    set.remove(it);
                }
            }

            String word = vec.get(vec.size()-1);

            if(word.equals(endWord)){
                if(ans.size() == 0){
                    ans.add(new ArrayList<>(vec));
                }else if(ans.get(0).size() == vec.size()){
                    ans.add(new ArrayList<>(vec));
                }
            }
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord) == true){
                        vec.add(replacedWord);
                        List<String> temp = new ArrayList<>(vec);
                        q.offer(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");

        List<List<String>> res = findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
