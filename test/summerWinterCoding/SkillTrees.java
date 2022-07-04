package summerWinterCoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SkillTrees {

    /*문제 설명
    선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

    예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

    위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다.
    따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

    선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.*/

    /*제한 조건
    스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
    스킬 순서와 스킬트리는 문자열로 표기합니다.
    예를 들어, C → B → D 라면 "CBD"로 표기합니다
    선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
    skill_trees는 길이 1 이상 20 이하인 배열입니다.
    skill_trees의 원소는 스킬을 나타내는 문자열입니다.
    skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.*/




            String skill = "CBD";
    String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

    Pattern pattern;

    void init(String skill){
        String regex = "";
        char[] chaArr = skill.toCharArray();
        for(int i = 0; i < chaArr.length; i++){
            if(i != chaArr.length-1){
                regex += String.valueOf(chaArr[i]);
                regex += "|";
            }
            else{
                regex += String.valueOf(chaArr[i]);
            }
        }
        pattern = Pattern.compile(regex);
    }

    @Test
    @DisplayName("스킬 트리")
    void skillTrees(){
        int answer = 0;
        init(skill);

        for(String sk : skill_trees){
            ArrayList<String> list = new ArrayList<>();
            Matcher m = pattern.matcher(sk);
            while(m.find()){
                int start = m.start();
                int end = m.end();
                list.add(sk.substring(start, end));
            }

            boolean flag = true;
            for(int j = 0; j < list.size(); j++){
                if(!String.valueOf(skill.charAt(j)).equals(list.get(j))){
                    flag = false;
                }
            }

            if(!flag){
                continue;
            }
            answer++;
        }

        System.out.println("answer => " + answer);
    }

    @Test
    @DisplayName("스킬 트리 - 다른 사람 풀이")
    void skillTresOther(){
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        System.out.println("answer => " + answer);
    }

    @Test
    @DisplayName("indexOf 테스트")
    void indexOfTest(){
        String skill = "CBD";
        // 매칭되는 문자열의 인덱스를 반환하는데.. 앞에 C가 없을 경우 B에 해당하는 1을 반환
        String target = "BD";
        System.out.println(skill.indexOf(target));
    }
}
