package practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.*;

public class PersonalInformation {

    /*문제 설명
    고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다.
    약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다.
    당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다. 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.

    예를 들어, A라는 약관의 유효기간이 12 달이고, 2021년 1월 5일에 수집된 개인정보가 A약관으로 수집되었다면 해당 개인정보는 2022년 1월 4일까지 보관 가능하며 2022년 1월 5일부터 파기해야 할 개인정보입니다.
    당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.

    모든 달은 28일까지 있다고 가정합니다.

    다음은 오늘 날짜가 2022.05.19일 때의 예시입니다.

    약관 종류	유효기간
    A	6 달
    B	12 달
    C	3 달
    번호	개인정보 수집 일자	약관 종류
    1	2021.05.02	A
    2	2021.07.01	B
    3	2022.02.19	C
    4	2022.02.20	C
    첫 번째 개인정보는 A약관에 의해 2021년 11월 1일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
    두 번째 개인정보는 B약관에 의해 2022년 6월 28일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
    세 번째 개인정보는 C약관에 의해 2022년 5월 18일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
    네 번째 개인정보는 C약관에 의해 2022년 5월 19일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
    따라서 파기해야 할 개인정보 번호는 [1, 3]입니다.

    오늘 날짜를 의미하는 문자열 today, 약관의 유효기간을 담은 1차원 문자열 배열 terms와 수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies가 매개변수로 주어집니다.
    이때 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

    제한사항
    today는 "YYYY.MM.DD" 형태로 오늘 날짜를 나타냅니다.
        1 ≤ terms의 길이 ≤ 20
    terms의 원소는 "약관 종류 유효기간" 형태의 약관 종류와 유효기간을 공백 하나로 구분한 문자열입니다.
    약관 종류는 A~Z중 알파벳 대문자 하나이며, terms 배열에서 약관 종류는 중복되지 않습니다.
    유효기간은 개인정보를 보관할 수 있는 달 수를 나타내는 정수이며, 1 이상 100 이하입니다.
        1 ≤ privacies의 길이 ≤ 100
    privacies[i]는 i+1번 개인정보의 수집 일자와 약관 종류를 나타냅니다.
    privacies의 원소는 "날짜 약관 종류" 형태의 날짜와 약관 종류를 공백 하나로 구분한 문자열입니다.
    날짜는 "YYYY.MM.DD" 형태의 개인정보가 수집된 날짜를 나타내며, today 이전의 날짜만 주어집니다.
    privacies의 약관 종류는 항상 terms에 나타난 약관 종류만 주어집니다.
    today와 privacies에 등장하는 날짜의 YYYY는 연도, MM은 월, DD는 일을 나타내며 점(.) 하나로 구분되어 있습니다.
            2000 ≤ YYYY ≤ 2022
            1 ≤ MM ≤ 12
    MM이 한 자릿수인 경우 앞에 0이 붙습니다.
            1 ≤ DD ≤ 28
    DD가 한 자릿수인 경우 앞에 0이 붙습니다.
    파기해야 할 개인정보가 하나 이상 존재하는 입력만 주어집니다.*/

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
