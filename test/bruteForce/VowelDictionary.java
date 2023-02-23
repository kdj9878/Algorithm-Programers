package bruteForce;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {
    String MAPPING = "AEIOU";
    int[] RATE_OF_INCREASE = {781, 156, 31, 6, 1};

    /**
     * 솔직히 이해가 잘 안됨
     * @param word
     */
    @ParameterizedTest
    @ValueSource(strings = {"A","AAAE", "I", "EIO", "AE"})
    void vowelDictionary(String word){
        int answer = word.length();

        for (int i = 0; i < word.length(); i++) {
            answer += (RATE_OF_INCREASE[i] * MAPPING.indexOf(word.charAt(i)));
        }

        System.out.println(answer);
    }


    List<String> list = new ArrayList<>();
    String goal;

    boolean finalBreak = false;

    void init(String word){
        goal = word;
    }

    void dfs(String str, int len) {
        if(len > 5) return;
        list.add(str);
        if(str.equals(goal)) {
            finalBreak = true;
            return;
        };
        for(int i = 0; i < 5; i++) {
            dfs(str + "AEIOU".charAt(i), len + 1);
            if(finalBreak){
                return;
            }
        }
    }

    /**
     * DFS를 활용한 풀이
     * @param word
     */
    @ParameterizedTest
    @ValueSource(strings = {"A", "AAAE", "I", "EIO", "AE"})
    void useDfs(String word) {
        init(word);
        dfs("", 0);
        System.out.println(list.indexOf(word));
    }
}
