package NO1603设计停车系统;

public class ParkingSystem {

    int big;
    int small;
    int medium;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(1 == carType) {
            boolean result = this.big > 0 ? true : false;
            big --;
            return result;
        }
        else if(2 == carType) {
            boolean result = this.medium > 0 ? true : false;
            this.medium --;
            return result;
        }
        else if(3 == carType) {
            boolean result = this.small > 0 ? true : false;
            this.small --;
            return result;
        }

        return false;
    }
}