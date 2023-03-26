package practice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WalkInThePark {

    String[] park = {"OSO","OOO","OXO","OOO"};

    String[] routes = {"E 2","S 3","W 1"};

    int[] curPlace = new int[2];
    int[] tempPlace = new int[2];

    int maxRow;
    int maxColumn;

    char[][] map;

    void init(String[] park){
        map = new char[park.length][park[0].length()];
        maxRow = park.length;
        maxColumn = park[0].length();
        for(int i = 0; i < park.length; i++){
            if(park[i].indexOf("S") > -1) {
                curPlace[0] = i;
                curPlace[1] = park[i].indexOf("S");
            }
            char[] arr = park[i].toCharArray();
            map[i] = arr;
        }
    }

    void start(String[] routes){
        boolean conState = false;
        for(String route : routes){
            String[] routeArr = route.split(" ");
            String direction = routeArr[0];
            int moveCnt = Integer.parseInt(routeArr[1]);
            tempPlace = curPlace.clone();
            while(moveCnt > 0){
                if(!move(direction)){
                    conState = true;
                    break;
                }

                moveCnt -= 1;
                conState = false;
            }

            if(conState){
                continue;
            }
            curPlace = tempPlace.clone();
        }
    }

    boolean move(String direction){
        boolean state = true;
        if(direction.equals("E")){
            state = RIGHT();
        }
        else if(direction.equals("W")){
            state = LEFT();
        }
        else if(direction.equals("N")){
            state = UP();
        }
        else{
            state = DOWN();
        }
        return state;
    }

    boolean RIGHT(){
        if(tempPlace[1] == maxColumn-1){
            return false;
        }else{
            if(map[tempPlace[0]][tempPlace[1] + 1] == 'X'){
                return false;
            }
            tempPlace[1] = tempPlace[1] + 1;
        }
        return true;
    }

    boolean LEFT() {
        if(tempPlace[1] == 0){
            return false;
        }
        else{
            if(map[tempPlace[0]][tempPlace[1] - 1] == 'X'){
                return false;
            }

            tempPlace[1] = tempPlace[1] - 1;
        }
        return true;
    }

    boolean UP(){
        if(tempPlace[0] == 0){
            return false;
        }
        else{
            if(map[tempPlace[0] - 1][tempPlace[1]] == 'X'){
                return false;
            }
            tempPlace[0] = tempPlace[0] - 1;
        }
        return true;
    }

    boolean DOWN(){
        if(tempPlace[0] == maxRow-1){
            return false;
        }
        else{
            if(map[tempPlace[0] + 1][tempPlace[1]] == 'X'){
                return false;
            }
            tempPlace[0] = tempPlace[0] + 1;
        }
        return true;
    }

    @Test
    void walkInThePark(){
        init(park);
        start(routes);

        System.out.println(Arrays.toString(curPlace));
    }
}
