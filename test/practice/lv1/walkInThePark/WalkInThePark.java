package practice.lv1.walkInThePark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WalkInThePark {

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
        if(direction.equals("E")){
            return RIGHT();
        }
        else if(direction.equals("W")){
            return LEFT();
        }
        else if(direction.equals("N")){
            return UP();
        }
        else{
            return DOWN();
        }
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
    void walkInTheParkTest1(){
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        init(park);
        start(routes);
        Assertions.assertArrayEquals(new int[]{2,1}, curPlace);
    }

    @Test
    void walkInTheParkTest2(){
        String[] park = {"SOO","OXX","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        init(park);
        start(routes);
        Assertions.assertArrayEquals(new int[]{0,1}, curPlace);
    }

    @Test
    void walkInTheParkTest3(){
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        init(park);
        start(routes);
        Assertions.assertArrayEquals(new int[]{0,0}, curPlace);
    }
}
