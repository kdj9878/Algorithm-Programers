package practice.lv1.cleanUpYourDesktop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CleanUpYourDesktop {

    int[] draggedLength(String[] wallpaper){
        int[] answer = new int[4];
        StringBuilder sb = new StringBuilder();
        int min = 51;
        int max = -1;
        for(int i = 0; i < wallpaper.length; i++){
            String str = wallpaper[i];
            int idx = str.indexOf("#");
            int lidx = str.lastIndexOf("#");
            if(idx > -1){
                sb.append("1");
                min = Math.min(min, idx);
                max = Math.max(max, lidx);
            }
            else{
                sb.append("0");
            }
        }

        answer[0] = sb.indexOf("1");
        answer[1] = min;
        answer[2] = sb.lastIndexOf("1") + 1;
        answer[3] = max+1;

        return answer;
    }

    @Test
    void testCase1(){
        String[] wallpaper = {".#...", "..#..", "...#."};
        int[] answer = draggedLength(wallpaper);
        Assertions.assertArrayEquals(new int[]{0, 1, 3, 4}, answer);
    }

    @Test
    void testCase2(){
        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        int[] answer = draggedLength(wallpaper);
        Assertions.assertArrayEquals(new int[]{1, 3, 5, 8}, answer);
    }

    @Test
    void testCase3(){
        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        int[] answer = draggedLength(wallpaper);
        Assertions.assertArrayEquals(new int[]{0, 0, 7, 9}, answer);
    }

    @Test
    void testCase4(){
        String[] wallpaper = {"..", "#."};
        int[] answer = draggedLength(wallpaper);
        Assertions.assertArrayEquals(new int[]{1, 0, 2, 1}, answer);
    }

}
