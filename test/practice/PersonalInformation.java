package practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.*;

public class PersonalInformation {

    int todayYear;
    int todayMon;
    int todayDay;

    //현재 날짜 초기화
    void init(String today){
        String[] arr = today.split("\\.");
        todayYear = Integer.parseInt(arr[0]);
        todayMon = Integer.parseInt(arr[1]);
        todayDay = Integer.parseInt(arr[2]);
    }

    String today = "2022.05.19";
    String[] terms = {"A 6", "B 12", "C 3"};
    String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

    @Test
    void personalInformation(){
        int[] answer = {};

        init(today);

        ArrayList<Integer> answerList = new ArrayList<>();
        //더해야할 년도
        Map<String, Integer> addYearMap = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String[] arr = terms[i].split(" ");
            addYearMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        for(int i = 0; i < privacies.length; i++){
            boolean del = false;
            String[] arr = privacies[i].split(" ");

            //더하게 될 개월
            int addMonth = addYearMap.get(arr[1]);
            //더하게 될 년도
            int addYear = addMonth/12;

            String[] dateArr = arr[0].split("\\.");
            int year = Integer.parseInt(dateArr[0]);
            int mon = Integer.parseInt(dateArr[1]);
            int day = Integer.parseInt(dateArr[2]);

            year += addYear;
            mon += (addMonth%12);

            if(mon > 12){
                mon = (mon%12);
                year += 1;
            }

            if(day == 1){
                if(mon == 1){
                    mon = 12;
                }
                else{
                    mon -= 1;
                }
                day = 28;
            }
            else{
                day -= 1;
            }

            if(todayYear > year){
                del = true;
            }
            else if(todayYear == year){
                if(todayMon > mon){
                    del = true;
                }
                else if(todayMon == mon){
                    if(todayDay > day){
                        del = true;
                    }
                }
            }

            if(del){
                answerList.add(i+1);
            }
        }

        answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(Arrays.toString(answer));
    }

    /**
     * 다른 사람 풀이
     */
    @Test
    public void PersonalInformation2() {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");
            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        System.out.println(Arrays.toString(answer.stream().mapToInt(integer -> integer).toArray()));
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }

    @ParameterizedTest
    @ValueSource(strings = {"2022.12.17", "2018.07.05"})
    void getDateTest(String today){
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        System.out.println((year * 12 * 28) + (month * 28) + day);
    }
}
