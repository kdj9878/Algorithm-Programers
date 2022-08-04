package skillTest;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Cache {
    int cacheSize = 3;
    String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
    Map<String, LocalDateTime> map = new HashMap<>();

    public void deleteOldCache(Map<String, LocalDateTime> map){
        LocalDateTime minTime = LocalDateTime.MAX;
        String minTimeKey = "";
        for(Map.Entry<String, LocalDateTime> var :map.entrySet()){
            if(var.getValue().isBefore(minTime)){
                minTimeKey = var.getKey();
                minTime = var.getValue();
            }
        }
        map.remove(minTimeKey);
    }

    /* 42.5 점 */
    @Test
    public void solution() {
        long answer = 0;
        LocalDateTime time;
        for(int i = 0; i < cities.length; i++){
            time = LocalDateTime.now();
            if(map.get(cities[i].toLowerCase()) != null){
                map.put(cities[i].toLowerCase(), time);
                answer += 1;
            }
            else{
                if(map.size() == cacheSize){
                    deleteOldCache(map);
                }
                map.put(cities[i].toLowerCase(), time);
                answer += 5;
            }
        }

        System.out.println(answer);
        return;
    }
}
