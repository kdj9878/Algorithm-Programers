package dfsBfs;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GameBestFastRoot {


    /*문제 설명
    ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
    위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다. 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.

    만약, 상대 팀이 자신의 팀 진영 주위에 벽을 세워두었다면 상대 팀 진영에 도착하지 못할 수도 있습니다. 예를 들어, 다음과 같은 경우에 당신의 캐릭터는 상대 팀 진영에 도착할 수 없습니다.

    게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요. 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.

    제한사항
    maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
    n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
    maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
    처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.*/

    int[][] maps = 	{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

    Map<Integer, Node> graph = new HashMap<>();
    int answer = 2;
    int goalNodeNum;
    boolean flag = false;
    int maxValue;


    class Node{
        int num;
        PriorityQueue<Integer> lines;
        boolean checked;

        Node(int num){
            this.num = num;
            this.lines = new PriorityQueue<>(Collections.reverseOrder());
            this.checked = false;
        }

        void addLine(int line){
            this.lines.add(line);
        }

        int getNum(){
            return this.num;
        }

        boolean getStatus(){
            return this.checked;
        }

        void checked(boolean status){
            this.checked = status;
        }

        PriorityQueue<Integer> getLines(){
            return this.lines;
        }
    }

    void init(int[][] maps){
        //goal node num setting
        goalNodeNum = maps.length * maps[0].length;

        //노드 번호
        int num = 1;
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length; j++){
                Node node = new Node(num);
                //위쪽 체크
                if(i-1 > -1 && maps[i-1][j] == 1){
                    node.addLine(num-maps[0].length);
                }
                //아래쪽 체크
                if(i+1 != maps.length && maps[i+1][j] == 1){
                    node.addLine(num+maps[0].length);
                }
                //왼쪽 체크
                if(j-1 > -1 && maps[i][j-1] == 1){
                    node.addLine(num-1);
                }
                //오른쪽 체크
                if(j+1 != maps[0].length && maps[i][j+1] == 1){
                    node.addLine(num+1);
                }
                graph.put(num, node);
                num++;
            }
        }

    }

    void DFS(Node node, int depth, int maxValue){
        System.out.println(depth);
        PriorityQueue<Integer> lines = node.getLines();
        //목적지에 도달했거나 간선 정보가 없는 경우
        if(lines.size() != 0 && lines.contains(goalNodeNum)){
            answer = Math.min(answer, depth);
            if(answer == maxValue){
                flag = true;
            }
        }
        else{
            for(int line : lines){
                if(flag){
                    break;
                }
                //방문하지 않았을 경우
                Node target = graph.get(line);
                if(!target.getStatus()){
                    target.checked(true); //방문으로 설정
                    DFS(target, depth+1, maxValue);
                    target.checked(false); //다시 미방문으로 변경
                }


            }

        }
    }

    @Test
    void gameBestFastRoot(){
        //Graph 그리기
        init(maps);
        Node first = graph.get(1);
        first.checked(true);
        maxValue = (maps.length + maps[0].length) - 3;
        DFS(first, 0, maxValue);

        if(answer == 10000){
            answer = -1;
        }
        else{
            answer += 2;
        }

        System.out.println(answer);
    }

    Map<Integer, PriorityQueue<Integer>> graphBFS;
    boolean[] visited;
    int goal;
    void initBFS(int[][] maps){
        graphBFS = new HashMap<>();
        //노드 번호
        int num = 0;
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length; j++){
                PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());
                //위쪽 체크
                if(i-1 > -1 && maps[i-1][j] == 1){
                    pq.add(num-maps[0].length);
                }
                //아래쪽 체크
                if(i+1 != maps.length && maps[i+1][j] == 1){
                    pq.add(num+maps[0].length);
                }
                //왼쪽 체크
                if(j-1 > -1 && maps[i][j-1] == 1){
                    pq.add(num-1);
                }
                //오른쪽 체크
                if(j+1 != maps[0].length && maps[i][j+1] == 1){
                    pq.add(num+1);
                }
                graphBFS.put(num, pq);
                num++;
            }
        }
        //visited array setting
        visited = new boolean[num+1];
    }

    void BFS(int start, Map<Integer, PriorityQueue<Integer>> graphBFS, int goal){
        Queue<Integer> queue = new LinkedList<Integer>(); //BFS에 사용할 Queue
        queue.offer(start);
        visited[start] = true;
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            int nodeIndex = queue.poll();
            //System.out.println(nodeIndex + 1);
            if((nodeIndex + 1) == goal){
                break;
            }
            //큐에서 꺼낸 노드와 연결된 노드들 체크
            while(!graphBFS.get(nodeIndex).isEmpty()){
                int temp = graphBFS.get(nodeIndex).poll();
                // 방문하지 않았으면 방문처리 후 큐에 넣기
                if(!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                }

            }
            answer+=1;
        }
    }

    @Test
    void gameBestFastRootByBFS(){
        //Graph 그리기
        initBFS(maps);
        int goal = maps.length * maps[0].length;
        BFS(0, graphBFS, goal);

        if(answer == 10000){
            answer = -1;
        }
        System.out.println(answer);
    }
}
