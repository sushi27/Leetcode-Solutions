package challenges.Problem1603;

class ParkingSystem {
    private final int[] carSize;
    public ParkingSystem(int big, int medium, int small) {
        carSize = new int[4];
        carSize[1] = big;
        carSize[2] = medium;
        carSize[3] = small;
    }

    public boolean addCar(int carType) {
        if(carSize[carType] == 0) return false;
        carSize[carType]--;
        return true;
    }
}

public class Solution {
    public static void main(String[] args) {
        ParkingSystem ob = new ParkingSystem(1, 1, 0);
        System.out.println(ob.addCar(1));
        System.out.println(ob.addCar(2));
        System.out.println(ob.addCar(3));
        System.out.println(ob.addCar(1));
    }
}
