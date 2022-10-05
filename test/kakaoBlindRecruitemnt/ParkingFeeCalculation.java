package kakaoBlindRecruitemnt;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ParkingFeeCalculation {

    /*문제 설명
    주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다. 아래는 하나의 예시를 나타냅니다.*/

    /*요금표
    기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
       180	        5000	    10	       600


    입/출차 기록
    시각(시:분)	차량 번호	내역
       05:34	  5961	    입차
       06:00	  0000	    입차
       06:34	  0000	    출차
       07:59	  5961	    출차
       07:59	  0148	    입차
       18:59	  0000	    입차
       19:09	  0148	    출차
       22:59	  5961	    입차
       23:00	  5961	    출차

    어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
    0000번 차량은 18:59에 입차된 이후, 출차된 내역이 없습니다. 따라서, 23:59에 출차된 것으로 간주합니다.
    00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.
    누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
    누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
    초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
    ⌈a⌉ : a보다 작지 않은 최소의 정수를 의미합니다. 즉, 올림을 의미합니다.
    주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다. 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.*/

    /*제한사항
    fees의 길이 = 4

    fees[0] = 기본 시간(분)
    1 ≤ fees[0] ≤ 1,439
    fees[1] = 기본 요금(원)
    0 ≤ fees[1] ≤ 100,000
    fees[2] = 단위 시간(분)
    1 ≤ fees[2] ≤ 1,439
    fees[3] = 단위 요금(원)
    1 ≤ fees[3] ≤ 10,000
    1 ≤ records의 길이 ≤ 1,000

    records의 각 원소는 "시각 차량번호 내역" 형식의 문자열입니다.
    시각, 차량번호, 내역은 하나의 공백으로 구분되어 있습니다.
    시각은 차량이 입차되거나 출차된 시각을 나타내며, HH:MM 형식의 길이 5인 문자열입니다.
    HH:MM은 00:00부터 23:59까지 주어집니다.
    잘못된 시각("25:22", "09:65" 등)은 입력으로 주어지지 않습니다.
    차량번호는 자동차를 구분하기 위한, `0'~'9'로 구성된 길이 4인 문자열입니다.
    내역은 길이 2 또는 3인 문자열로, IN 또는 OUT입니다. IN은 입차를, OUT은 출차를 의미합니다.
    records의 원소들은 시각을 기준으로 오름차순으로 정렬되어 주어집니다.
    records는 하루 동안의 입/출차된 기록만 담고 있으며, 입차된 차량이 다음날 출차되는 경우는 입력으로 주어지지 않습니다.
    같은 시각에, 같은 차량번호의 내역이 2번 이상 나타내지 않습니다.
    마지막 시각(23:59)에 입차되는 경우는 입력으로 주어지지 않습니다.
    아래의 예를 포함하여, 잘못된 입력은 주어지지 않습니다.
    주차장에 없는 차량이 출차되는 경우
    주차장에 이미 있는 차량(차량번호가 같은 차량)이 다시 입차되는 경우*/

    int[] fees = {180, 5000, 10, 600};
    String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

    Map<String, Car> carMap = new HashMap<>();
    private int defaultTime;
    private int defaultPrice;
    private int danwiMinute;
    private int danwiPrice;
    private int usedTime;

    class Car implements Comparable<Car>{
        private String carNumber;
        private boolean state;
        private LocalTime time;
        private int usedTime;

        public Car(String carNumber, boolean state, LocalTime time){
            this.carNumber = carNumber;
            this.state = state;
            this.time = time;
            this.usedTime = 0;
        }

        public String getCarNumber(){
            return this.carNumber;
        }

        public boolean getState(){
            return this.state;
        }

        public LocalTime getTime(){
            return this.time;
        }

        public int getUsedTime(){
            return this.usedTime;
        }

        public void setTime(LocalTime time){
            this.time = time;
        }

        public void setState(boolean state){
            this.state = state;
        }

        public void setUsedTime(int usedTime){
            this.usedTime += usedTime;
        }

        @Override
        public int compareTo(Car nextCar){
            int ai = Integer.parseInt(this.carNumber);
            int bi = Integer.parseInt(nextCar.getCarNumber());
            if(ai > bi) return 1;
            if(ai < bi) return -1;
            return 0;
        }
    }

    void init(int[] fees){
        this.defaultTime = fees[0];
        this.defaultPrice = fees[1];
        this.danwiMinute = fees[2];
        this.danwiPrice = fees[3];
    }

    @Test
    void parkingFeeCalculation(){
        List<Car> carList = new ArrayList<Car>();
        init(fees);
        for(int i = 0; i < records.length; i++){
            String[] arr = records[i].split(" ");
            LocalTime time = LocalTime.parse(arr[0], DateTimeFormatter.ofPattern("HH:mm"));
            String carNumber = arr[1];
            String state = arr[2];

            if(state.equals("IN")){
                if(carMap.get(carNumber) != null){
                    Car car = carMap.get(carNumber);
                    car.setTime(time);
                    car.setState(true);
                    carMap.put(carNumber, car);
                }
                else{
                    carMap.put(carNumber, new Car(carNumber, true, time));
                }
            }
            else{
                Car car = carMap.get(carNumber);
                int usedTime = getTimeDiff(car.getTime(), time);
                car.setUsedTime(usedTime);
                car.setState(false);
                carMap.put(carNumber, car);
            }
        }

        //나간 기록이 없는 차량 처리
        for(Map.Entry<String, Car> entry : carMap.entrySet()){
            if(entry.getValue().getState()){
                Car car = carMap.get(entry.getKey());
                int usedTime = getTimeDiff(car.getTime(), LocalTime.parse("23:59", DateTimeFormatter.ofPattern("HH:mm")));
                car.setUsedTime(usedTime);
                car.setState(false);
                carMap.put(entry.getKey(), car);
            }
        }

        for(Car car : carMap.values()){
            carList.add(car);
        }

        //정렬
        Collections.sort(carList);

        int[] answer = new int[carList.size()];
        int i = 0;
        for(Car car : carList){
            answer[i] = getPrice(car.getUsedTime());
            i++;
        }

        System.out.println(Arrays.toString(answer));
    }

    //시간 차이 계산
    public int getTimeDiff(LocalTime t1, LocalTime t2){
        return Math.toIntExact(ChronoUnit.SECONDS.between(t1,t2) / 60);
    }

    // 요금 계산
    public int getPrice(int usedTime){
        if(usedTime < defaultTime){
            return defaultPrice;
        }
        else{
            double usedMinute = (double)(usedTime - defaultTime) / danwiMinute;
            return (usedTime - defaultTime) % danwiMinute == 0 ? (int)(usedMinute * danwiPrice) + defaultPrice : (int)(Math.ceil(usedMinute) * danwiPrice) + defaultPrice;
        }
    }

    public int timeToInt(String time) {
        String temp[] = time.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }

    //다른 사람 풀이
    public int[] solution(int[] fees, String[] records) {

        TreeMap<String, Integer> map = new TreeMap<>();

        for(String record : records) {
            String temp[] = record.split(" ");
            //출차를 한 기록이 있으면 결국엔 주차장을 이용한 시간만큼 저장
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
        }
        int idx = 0, ans[] = new int[map.size()];
        for(int time : map.values()) {
            //출차 기록이 없는 경우 1439(23:59)를 더함
            if(time < 1) time += 1439;
            //이용 시간에서 기본 시간을 제외
            time -= fees[0];
            int cost = fees[1];
            //기본 시간을 초과했을 경우
            if(time > 0)
                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

            ans[idx++] = cost;
        }
        return ans;
    }

}
