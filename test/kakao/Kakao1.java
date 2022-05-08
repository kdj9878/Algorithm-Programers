package kakao;

import org.junit.jupiter.api.Test;

import java.util.*;

class Kakao1 {

    @Test
    void solution() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] answer = new int[id_list.length];
        Map<String, Integer> mailCount = new LinkedHashMap<>();
        Map<String, Set<String>> doSingoMap = new LinkedHashMap<>();
        // 신고 받은 횟수, 신고자 Map 초기화
        for(String id : id_list){
            mailCount.put(id, 0);
            doSingoMap.put(id, new LinkedHashSet<>());
        };

        // 신고 받은 횟수 INSERT
        for(String rp : report){
            String[] reportArr = rp.split(" ");
            String doSingo = reportArr[0];
            String getSingo = reportArr[1];
            doSingoMap.get(getSingo).add(doSingo);  // 신고 받은 사람 = ["신고 한 사람1", "신고 헌 사람 2"
        }

        for(String key : doSingoMap.keySet()){
            Set<String> set = doSingoMap.get(key);
            if(set.size() >= k){
                Iterator<String> it = set.iterator();
                while(it.hasNext()){
                    String getMailUser = it.next();
                    mailCount.put(getMailUser, mailCount.getOrDefault(getMailUser, 0) + 1);
                }
            }
        }

        int idx = 0;
        for(String key : mailCount.keySet()){
            int value = mailCount.get(key);
            answer[idx] = value;
            idx++;
        }
        for (int value : answer) System.out.println(value);
    }
}