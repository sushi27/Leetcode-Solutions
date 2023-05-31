package challenges.Problem1396;

import javafx.util.Pair;

import java.util.HashMap;

class UndergroundSystem {
    private final HashMap<Object, Pair<String, Integer>> customer = new HashMap<>();
    private final HashMap<Object, Pair<Double, Double>> stationTime = new HashMap<>();
    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        customer.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInData = customer.get(id);
        String stationKey = checkInData.getKey() + "-" + stationName;
        int timeTaken = t - checkInData.getValue();
        Pair<Double, Double> journeyTime = stationTime.getOrDefault(stationKey, new Pair<>(0.0, 0.0));
        stationTime.put(stationKey, new Pair<>(journeyTime.getKey() + timeTaken, journeyTime.getValue()+1));
        customer.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        Pair<Double, Double> journeyTime = stationTime.get(key);
        return journeyTime.getKey()/journeyTime.getValue();
    }
}
public class Solution {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
    }
}
