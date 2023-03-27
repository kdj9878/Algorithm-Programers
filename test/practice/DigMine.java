package practice;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class DigMine {

    Queue<Integer> fatigueQueue = new LinkedList<>();

    Queue<String> maineralsQueue = new LinkedList<>();
    int[] picksCnt;
    String[] minerals;
    int answer = 0;


    void init(){
        picksCnt = new int[]{0, 1, 1};
        minerals = new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
    }

    void scanMinerals(String[] minerals){
        int cnt = 0;
        int mineralsLen = minerals.length;
        int fatigue = 0;
        for(String mine : minerals){
            if(mine.equals("diamond")){
                fatigue += 25;
            }else if(mine.equals("iron")){
                fatigue += 5;
            }else{
                fatigue += 1;
            }
            maineralsQueue.add(mine);
            cnt++;

            if(cnt == 5){
                mineralsLen -= 5;
                fatigueQueue.add(fatigue);
                fatigue = 0;
                cnt = 0;
            }else if(mineralsLen == cnt){
                fatigueQueue.add(fatigue);
            }
        }
    }

    void digging(){

        while(!fatigueQueue.isEmpty()){
            int fatigue = fatigueQueue.poll();

            if(fatigue <= 5){
                checkPicks("stone");
            }
            else if(fatigue > 5 && fatigue <= 24){
                checkPicks("iron");
            }
            else if(fatigue >= 25){
                checkPicks("dia");
            }
        }
    }

    /**
     * 다이아 곡괭이가 없을경우에는 철 -> 돌
     * 철 곡괭이가 없을 경우에는 돌 -> 다이아
     * 돌 곡괭이가 없을 경우에는 철 -> 다이아
     **/
    void checkPicks(String pickType){
        int result = -1;
        //다이아곡괭이일 경우 철 곡괭이부터 검색
        if(pickType.equals("dia")){
            for(int i = 0; i < picksCnt.length; i++){
                if(picksCnt[i] > 0){
                    result = i;
                    break;

                }
            }
        }
        else{
            for(int i = 2; i > -1; i--){
                if(picksCnt[i] > 0){
                    result = i;
                    break;
                }
            }
        }

        //더이상 사용할 수 있는 곡괭이가 없을 경우
        if(result == -1){
            return;
        }

        doDig(result);

        if(result == 0){
            picksCnt[0] = picksCnt[0] - 1;
        }else if(result == 1){
            picksCnt[1] = picksCnt[1] - 1;
        }else{
            picksCnt[2] = picksCnt[2] - 1;
        }
    }

    //5번 캐기
    void doDig(int pickIdx){
        int digCnt = 0;
        //더이상 캘 광물이 없거나 5번 캤을 경우 정지
        while(!maineralsQueue.isEmpty() && digCnt < 5){
            String material = maineralsQueue.poll();
            if(pickIdx == 0){
                answer += 1;
            }else if(pickIdx == 1){
                if(material.equals("diamond")){
                    answer += 5;
                }
                else if(material.equals("iron")){
                    answer += 1;
                }
                else{
                    answer += 1;
                }
            }else{
                if(material.equals("diamond")){
                    answer += 25;
                }
                else if(material.equals("iron")){
                    answer += 5;
                }
                else{
                    answer += 1;
                }
            }
            digCnt++;
        }
    }


    @Test
    void digMine(){
        init();
        //광물을 스캔
        scanMinerals(minerals);

        digging();

        System.out.println(answer);
    }
}
