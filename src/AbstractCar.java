import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

public class AbstractCar {
    public static void main(String[] args) {




        Car car1 = new FourDoorToyota("a");
        car1.run();
        System.out.println(car1.toString());
        car1.stop();


        System.out.println("-----------------------");

        Car car2 = new TwoDoorToyota("b");
        car2.accident();
        car2.repair();
        car2.run();
        System.out.println("car price is:" + car1.sell());
        System.out.println("car price is:" + car2.sell());
        System.out.println(car2);

        System.out.println("\n=========================================\n");

        Dealer dealer = new Dealer("alex","UK","fancy");
        dealer.addCar(car1);
        dealer.addCar(car2);
        dealer.showAllCars();
//        dealer.customerMenu();
        dealer.dealerMenu();


    }
}


//class FourDoorToyotaTester extends FourDoorToyota {
//    public FourDoorToyotaTester(String carName) {
//        super(carName);
//    }
//    @Override
//    public String toString() {
//        return "Four Door Toyota Car [ name:" + carName + ", Doors" + numOfDoors + ", max speed/current speed" + maxSpeed +"/"+ currentSpeed +  + " ]";
//    }
//}
//
//
//class TwoDoorToyotaTester extends TwoDoorToyota {
//    public TwoDoorToyotaTester(String carName) {
//        super(carName);
//    }
//}




//Add Sell Function that returns double into Car interface and implement it from the inner classes(calculate price by year mileage and power)

//implement toString function on the all classes(not interface and abstract classes)






interface Car{
    void run();
    void accident();
    void repair();
    void stop();
    double sell();
    String getCarName();
}
abstract class FourDoorCar implements Car{
    String carName;
    int numOfDoors;
    double maxSpeed;
    double currentSpeed;
    boolean isWorking;
    int year;
    double mileage;
    double power;
    public FourDoorCar(String carName,double carMaxSpeed, double power) {
        this.carName = carName;
        this.numOfDoors = 4;
        this.maxSpeed = carMaxSpeed;
        this.currentSpeed = 0;
        this.isWorking = true;
        this.year = 0;
        this.mileage = 0;
        this.power = power;
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
    @Override
    public double sell() {
//        year=4;
//        mileage=8000;
        double sellRate =year / mileage * 10000;
        if(mileage == 0) sellRate = year * 1.5;
        if(year == 0) sellRate =  10;
        return 25000 + (( sellRate ) * power);
    }
    @Override
    public String getCarName() {
        return carName;
    }
}

class FourDoorToyota extends FourDoorCar {
    String smartTVModel;
    public FourDoorToyota(String carName) {
        super(carName, 1700,1200);
        this.smartTVModel = "SM-4k-2022";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tsmart TV Model: " + smartTVModel;
    }
    @Override
    public double sell() {
        return super.sell() * 0.5;
    }
}

class FourDoorMBW extends FourDoorCar {
    String GPS;
    public FourDoorMBW(String carName) {
        super(carName, 1600,1600);
        this.GPS = "google-mp-168";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tGPS model: " + GPS;
    }
    @Override
    public double sell() {
        return super.sell() * 1.5;
    }
}

class FourDoorFord extends FourDoorCar  {
    double overCLockSpeed;
    public FourDoorFord(String carName) {
        super(carName, 1300,1100);
        this.overCLockSpeed = 1.5;
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tMax Over Clock Speed: " + maxSpeed * overCLockSpeed + "Current Over Clock Speed: " + currentSpeed * overCLockSpeed;
    }
}

class FourDoorHyundai extends FourDoorCar {
    String coolingModel;
    public FourDoorHyundai(String carName) {
        super(carName, 1350,900);
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
    int year;
    double mileage;
    double power;
    public TwoDoorCar(String carName, double carMaxSpeed,double power) {
        this.carName = carName;
        this.numOfDoors = 2;
        this.maxSpeed = carMaxSpeed;
        this.currentSpeed = 0;
        this.isWorking = true;
        this.year = 0;
        this.mileage = 0;
        this.power = power;
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
    @Override
    public double sell() {
//        year=4;
//        mileage=8000;
        double sellRate =year / mileage * 10000;
        if(mileage == 0) sellRate = year * 1.5;
        if(year == 0) sellRate =  10;
        return 25000 + (( sellRate ) * power);
    }
    @Override
    public String getCarName() {
        return carName;
    }
}

class TwoDoorToyota extends TwoDoorCar {
    String miniChargerModel;
    public TwoDoorToyota(String carName) {
        super(carName, 980,300);
        this.miniChargerModel = "SM-4k-2022";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tmini charger model: " + miniChargerModel;
    }
    @Override
    public double sell() {
        return super.sell() * 1.5;
    }
}

class TwoDoorMBW extends TwoDoorCar {
    String heater;
    public TwoDoorMBW(String carName) {
        super(carName, 800,600);
        this.heater = "dyson-HT-28c";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tHeater: " + heater;
    }
    @Override
    public double sell() {
        return super.sell() * 2.1;
    }
}

class TwoDoorFord extends TwoDoorCar  {
    double batteryCapacity;
    public TwoDoorFord(String carName) {
        super(carName, 450,550);
        this.batteryCapacity = 5.2;
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tMax Speed with battery: " + maxSpeed * batteryCapacity + "Current Speed with battery: " + currentSpeed * batteryCapacity;
    }
}

class TwoDoorHyundai extends TwoDoorCar {
    String radioModel;
    public TwoDoorHyundai(String carName) {
        super(carName, 350,200);
        this.radioModel = "Hyundai-FM-90o";
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tRadio : " + radioModel;
    }
    @Override
    public double sell() {
        return super.sell() * 0.9;
    }
}







//Create Dealer Class
//
//In the dealer store money, Cars and information about dealer.
//
//IT should have show all cars, sell car and add car functions.
//
//To manage everything we need to have a menu so we need to have dealerMenu() function so that we will just run it and we will control other functions by scanners.



class Dealer {
    double money;
    ArrayList<Car> carList;
    String name;
    String location;
    String dealShopType;
    public Dealer (String name, String location, String dealShopType) {
        this.name = name;
        this.location = location;
        this.dealShopType = dealShopType;
        this.carList = new ArrayList<>();
    }
    public String showAllCars() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car);
            sb.append("\n");
        }
        return sb.toString();
    }
    public String showAllCarsByType(String type) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            if (car.getClass().toString().equals("class " + type)) {
                sb.append(car);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    public void sellCar(Car car) {
        car.sell();
        carList.remove(car);
        System.out.println("car: \n\t[" + car +"]\n has been sold ");
    }
    public void addCar(Car car) {
        carList.add(car);
        System.out.println("car: \n\t[" + car +"]\n has been add to DealerShip ");
    }
    public void customerMenu() {
        while (true) {
            System.out.println("\nــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ");
            System.out.println("welcome to darrel dealer ship, deals better than the devil's ");
            System.out.println("ــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ");
            System.out.println();
            printMenu();
            System.out.print("choose your option: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    viewCars();
                    break;
                case 2:
                    viewCarsByType();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public void dealerMenu() {
        while (true) {
            printDealerMenu();
            System.out.print("choose your option: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    addNewCar();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void addNewCar() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Car Name: ");
            String carName = sc.nextLine();

            System.out.println("1 - 4D toyota");
            System.out.println("2 - 4D BMW");
            System.out.println("3 - 4D Ford");
            System.out.println("4 - 4D Hyundai");
            System.out.println("5 - 2D toyota");
            System.out.println("6 - 2D BMW");
            System.out.println("7 - 2D Ford");
            System.out.println("8 - 2D Hyundai");

            System.out.print("Car Type: ");
            int carType = sc.nextInt();
            String carClassName = "";
            switch (carType) {
                case 1:
                    carClassName = FourDoorToyota.class.getName();
                    break;
                case 2:
                    carClassName = FourDoorMBW.class.getName();
                    break;
                case 3:
                    carClassName = FourDoorFord.class.getName();
                    break;
                case 4:
                    carClassName = FourDoorHyundai.class.getName();
                    break;
                case 5:
                    carClassName = TwoDoorToyota.class.getName();
                    break;
                case 6:
                    carClassName = TwoDoorMBW.class.getName();
                    break;
                case 7:
                    carClassName = TwoDoorFord.class.getName();
                    break;
                case 8:
                    carClassName = TwoDoorHyundai.class.getName();
                    break;
                default:
                    System.out.println("Invalid option");
            }
            Class<?> myClass = Class.forName(carClassName);
            Constructor<?> constructor = myClass.getConstructor(String.class);
            Car car = (Car) constructor.newInstance(carName);
            carList.add(car);
            System.out.println(showAllCars());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    private void viewCars() {
        System.out.println(showAllCars());
        System.out.println();
        System.out.print("Enter Car Name To Buy: ");
        Scanner sc = new Scanner(System.in);
        String carName = sc.nextLine();
        for (Car car : carList) {
            if (car.getCarName().equals(carName)) {
                System.out.println("congrats , you are the proud owner of: \n\t[" + car + "]");
                money += car.sell();
                break;
            }
        }
    }
    private void viewCarsByType() {
        String carClassName = "";
        System.out.println("1 - 4D toyota");
        System.out.println("2 - 4D BMW");
        System.out.println("3 - 4D Ford");
        System.out.println("4 - 4D Hyundai");
        System.out.println("5 - 2D toyota");
        System.out.println("6 - 2D BMW");
        System.out.println("7 - 2D Ford");
        System.out.println("8 - 2D Hyundai");
        System.out.print("choose car type to browse: ");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1:
                carClassName = FourDoorToyota.class.getName();
                break;
            case 2:
                carClassName = FourDoorMBW.class.getName();
                break;
            case 3:
                carClassName = FourDoorFord.class.getName();
                break;
            case 4:
                carClassName = FourDoorHyundai.class.getName();
                break;
            case 5:
                carClassName = TwoDoorToyota.class.getName();
                break;
            case 6:
                carClassName = TwoDoorMBW.class.getName();
                break;
            case 7:
                carClassName = TwoDoorFord.class.getName();
                break;
            case 8:
                carClassName = TwoDoorHyundai.class.getName();
                break;
            default:
                System.out.println("Invalid option");
        }


        System.out.println(showAllCarsByType(carClassName));
        System.out.println();
        System.out.print("Enter Car Name To Buy: ");
        Scanner sc2 = new Scanner(System.in);
        String carName = sc2.nextLine();
        for (Car car : carList) {
            if (car.getCarName().equals(carName)) {
                System.out.println("congrats , you are the proud owner of: \n\t[" + car + "]");
                money += car.sell();
                break;
            }
        }

    }

    private void printMenu() {
        System.out.println("1 - browse cars");
        System.out.println("2 - search by type");
        System.out.println("0 - exit");
    }
    private void printDealerMenu() {
        System.out.println("1 - add new Car");
        System.out.println("0 - exit");
    }
}