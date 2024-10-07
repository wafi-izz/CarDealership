

public class AbstractCar {
    public static void main(String[] args) {




        Car car1 = new FourDoorToyotaTester("RXc76");
        car1.run();
        System.out.println(car1.toString());


        System.out.println("-----------------------");

        Car car2 = new TwoDoorToyotaTester("GX80-2");
        car2.accident();
        car2.repair();
        car2.run();
        System.out.println(car2);



    }
}


class FourDoorToyotaTester extends FourDoorToyota {
    public FourDoorToyotaTester(String carName) {
        super(carName);
    }
}


class TwoDoorToyotaTester extends TwoDoorToyota {
    public TwoDoorToyotaTester(String carName) {
        super(carName);
    }
}











interface Car{
    void run();
    void accident();
    void repair();
    void stop();
}
abstract class FourDoorCar implements Car{
    String carName;
    int numOfDoors;
    double maxSpeed;
    double currentSpeed;
    boolean isWorking;
    public FourDoorCar(String carName,double carMaxSpeed) {
        this.carName = carName;
        this.numOfDoors = 4;
        this.maxSpeed = carMaxSpeed;
        this.currentSpeed = 0;
        this.isWorking = true;
    }
    @Override
    public void run(){
        if (isWorking){
            System.out.println(carName + " is running");
            currentSpeed = maxSpeed;
        }
        else{
            System.out.println(carName + " can't run, needs repairs");
        }
    }
    @Override
    public void stop(){
        System.out.println(carName + " is stopping");
        currentSpeed = 0;
    }
    @Override
    public void repair(){
        System.out.println(carName + " is being repaired");
        isWorking = true;
    }
    @Override
    public void accident(){
        System.out.println(carName + " got into an accident");
        stop();
        isWorking = false;
    }
    @Override
    public String toString(){
        return "car name: " + carName + ", number of doors: " + numOfDoors + "\n\tcar max speed: " + maxSpeed + ", car Current speed: " + currentSpeed + "\n\tis car OK: " + (isWorking ?"yes":"no");
    }
}

abstract class FourDoorToyota extends FourDoorCar {
    String smartTVModel;
    public FourDoorToyota(String carName) {
        super(carName, 1700);
        this.smartTVModel = "SM-4k-2022";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tsmart TV Model: " + smartTVModel;
    }
}

abstract class FourDoorMBW extends FourDoorCar {
    String GPS;
    public FourDoorMBW(String carName) {
        super(carName, 1600);
        this.GPS = "google-mp-168";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tGPS model: " + GPS;
    }
}

abstract class FourDoorFord extends FourDoorCar  {
    double overCLockSpeed;
    public FourDoorFord(String carName) {
        super(carName, 1300);
        this.overCLockSpeed = 1.5;
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tMax Over Clock Speed: " + maxSpeed * overCLockSpeed + "Current Over Clock Speed: " + currentSpeed * overCLockSpeed;
    }
}

abstract class FourDoorHyundai extends FourDoorCar {
    String coolingModel;
    public FourDoorHyundai(String carName) {
        super(carName, 1350);
        this.coolingModel = "Hyundai-super-cooler";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tCooling model: " + coolingModel;
    }
}

abstract class TwoDoorCar implements Car {
    String carName;
    int Inheritance;
    int numOfDoors;
    double maxSpeed;
    double currentSpeed;
    boolean isWorking;
    public TwoDoorCar(String carName, double carMaxSpeed) {
        this.carName = carName;
        this.numOfDoors = 2;
        this.maxSpeed = carMaxSpeed;
        this.currentSpeed = 0;
        this.isWorking = true;
    }
    @Override
    public void run(){
        if (isWorking){
            System.out.println(carName + " is running");
            currentSpeed = maxSpeed;
        }
        else{
            System.out.println(carName + " can't run, needs repairs");
        }
    }
    @Override
    public void stop(){
        System.out.println(carName + " is stopping");
        currentSpeed = 0;
    }
    @Override
    public void repair(){
        System.out.println(carName + " is being repaired");
        isWorking = true;
    }
    @Override
    public void accident(){
        System.out.println(carName + " got into an accident");
        stop();
        isWorking = false;
    }
    @Override
    public String toString(){
        return "car name: " + carName + ", number of doors: " + numOfDoors + "\n\tcar max speed: " + maxSpeed + ", car Current speed: " + currentSpeed + "\n\tis car OK: " + (isWorking ?"yes":"no");
    }
}

abstract class TwoDoorToyota extends TwoDoorCar {
    String miniChargerModel;
    public TwoDoorToyota(String carName) {
        super(carName, 980);
        this.miniChargerModel = "SM-4k-2022";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tmini charger model: " + miniChargerModel;
    }
}

abstract class TwoDoorMBW extends TwoDoorCar {
    String heater;
    public TwoDoorMBW(String carName) {
        super(carName, 800);
        this.heater = "dyson-HT-28c";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tHeater: " + heater;
    }
}

abstract class TwoDoorFord extends TwoDoorCar  {
    double batteryCapacity;
    public TwoDoorFord(String carName) {
        super(carName, 450);
        this.batteryCapacity = 5.2;
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tMax Speed with battery: " + maxSpeed * batteryCapacity + "Current Speed with battery: " + currentSpeed * batteryCapacity;
    }
}

abstract class TwoDoorHyundai extends TwoDoorCar {
    String radioModel;
    public TwoDoorHyundai(String carName) {
        super(carName, 350);
        this.radioModel = "Hyundai-FM-90o";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tRadio : " + radioModel;
    }
}

/**
 Today's Goal:

 Car <Interface>
 -> FourDoorCar <Abstract Class>
 ->->FourDoorToyota <Class>
 ->->FourDoorBMW <Class>
 ->->FourDoorFord<Class>
 ->->FourDoorHyundai <Class>
 -> TwoDoorCar <Abstract Class>
 ->->TwoDoorToyota <Class>
 ->->TwoDoorBMW <Class>
 ->->TwoDoorFord <Class>
 ->->TwoDoorHyundai <Class>
 */