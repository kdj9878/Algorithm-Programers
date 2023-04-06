package practice.lv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnUninhabitedIslandTrip {

    //간선 관계를 저장하는 변수
    Map<Integer, List<Node>> graph = new HashMap<>();
    //하나의 섬당 최대 버틸 수 있는 일자를 저장하는 변수
    Map<Integer, Integer> serviveMap = new HashMap<>();
    //각 타일의 생존일수를 저장하는 변수
    Map<Integer, Integer> islandScore = new HashMap<>();
    //타일을 방문했는지 체크하는 변수
    boolean[] checked;

    String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};

    //타일의 정보를 저장하는 클래스
    class Node{
        int idx; //타일의 인덱스
        int score;//타일의 생존일수

        Node(int idx, int score){
            this.idx = idx;
            this.score = score;
        }

        int getIdx(){
            return this.idx;
        }

        int getScore(){
            return this.score;
        }
    }

    //graph 그리기
    void init(List<char[]> arr){
        checked = new boolean[maps.length * maps[0].length()];
        int num = 0;
        for(int i = 0; i < arr.size(); i++){
            for(int j = 0; j < arr.get(0).length; j++){
                List<Node> line = new ArrayList<>();
                //바다가 아닌 부분만
                if(arr.get(i)[j] != 'X'){
                    //위쪽 체크
                    if(i-1 > -1 && arr.get(i-1)[j] != 'X'){
                        line.add(new Node(num - arr.get(0).length, arr.get(i-1)[j] - '0'));
                    }
                    //아래쪽 체크
                    if(i+1 != arr.size() && arr.get(i+1)[j] != 'X'){
                        line.add(new Node(num + arr.get(0).length, arr.get(i+1)[j] - '0'));
                    }
                    //왼쪽 체크
                    if(j-1 > -1 && arr.get(i)[j-1] != 'X'){
                        line.add(new Node(num - 1, arr.get(i)[j-1] - '0'));
                    }
                    //오른쪽 체크
                    if(j+1 != arr.get(0).length && arr.get(i)[j+1] != 'X'){
                        line.add(new Node(num + 1, arr.get(i)[j+1] - '0'));
                    }
                    //주위에 갈 수 있는 타일이 없는 경우 해당 타일의 생존일수만 저장
                    if(line.size() == 0){
                        serviveMap.put(num, arr.get(i)[j] - '0');
                    }
                    else{
                        islandScore.put(num, arr.get(i)[j] - '0');
                    }
                }

                graph.put(num, line);
                num++;
            }
        }
    }

    //DFS 실행
    void DFS(int initStart, int start, boolean[] checked){
        List<Node> nodeList = graph.get(start);
        //체크하고 시작
        checked[start] = true;
        if(nodeList.size() == 0){
            return;
        }else{
            for(int i = 0; i < nodeList.size(); i++){
                Node node = nodeList.get(i);
                //해당 타일을 방문하지 않았을 경우
                if(!checked[node.getIdx()]){
                    checked[node.getIdx()] = true; //타일 방문여부 체크
                    serviveMap.put(initStart, serviveMap.getOrDefault(initStart, islandScore.get(initStart)) + node.getScore()); //방문한 타일의 생존일수를 저장
                    DFS(initStart, node.getIdx(), checked);//타일 이동
                }
            }
        }
    }

    @Test
    void anUninhabitedIslandTrip(){
        int[] answer;
        List<char[]> arr = Stream.of(maps).map(x -> x.toCharArray()).collect(Collectors.toList());
        init(arr);
        for(int i = 0; i < checked.length; i++){
            //이미 방문한 경우는 DFS 메소드 안 타게
            if(!checked[i]){
                DFS(i, i, checked);
            }
        }
        //생존 가능한 타일이 없는 경우
        if(serviveMap.size() == 0){
            System.out.println("-1");
            return;
        }

        answer = new int[serviveMap.size()];
        //정렬을 위해서 우선순위큐 사용
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(Map.Entry<Integer, Integer> entry : serviveMap.entrySet()){
            pq.add(entry.getValue());
        }
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx] = pq.poll();
            idx++;
        }

        System.out.println(Arrays.toString(answer));
    }
}
