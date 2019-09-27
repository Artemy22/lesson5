/*
"7. Start with a base class of a Vehicle, then create a Car class that inherits from this base class.
    Finally, create another class, a specific type of Car that inherits from the Car class.
    You should be able to hand steering, changing gears, and moving(speed in other words).
    You will want to decide where to put the appropriate state and behaviours(fields and methods).
    As mentioned above, changing gears, increasing/decreasing speed should be included.
    For you specific type of vehicle you will want to add something specific for that type of car."
 */
public class Lesson57Vehicle {
    private int gear = 0;
    private String name;
    private int tankSize;
    private int fullTank;
    private int maxSpeed;
    private int currentSpeed;
    private int currentDistance;
    private double carCondition = 100;

    Lesson57Vehicle(String name, int tankSize, int maxSpeed) {
        this.name = name;
        this.tankSize = tankSize;
        this.maxSpeed = maxSpeed;
    }

    public static void main(String[] args) throws InterruptedException {

        Lesson57Vehicle newCar = new Car("Hooyota", 75, 240);
        newCar.move(124);
        newCar.move(568);
        System.out.println("\n");
        newCar.upGear();
        System.out.println("Gear is up to " + newCar.getGear() + ". Current speed: " + newCar.getCurrentSpeed());
        newCar.upGear();
        System.out.println("Gear is up to " + newCar.getGear() + ". Current speed: " + newCar.getCurrentSpeed());
        newCar.downGear();
        System.out.println("Gear is down to " + newCar.getGear() + ". Current speed: " + newCar.getCurrentSpeed());
        newCar.stop();
        System.out.println("\n");

        Car newCarSecond = new Car("Mamaz", 450, 110);
        newCarSecond.move(3340);
        newCarSecond.upGear();
        System.out.println("Gear is up to " + newCarSecond.getGear() + ". Current speed: " + newCarSecond.getCurrentSpeed());
        newCarSecond.downGear();
        System.out.println("Gear is down to " + newCarSecond.getGear() + ". Current speed: " + newCarSecond.getCurrentSpeed());
        System.out.println("\n");
        newCarSecond.stop();
        System.out.println("\n");
        newCarSecond.callServiceForFuel();

    }

    int getGear() {
        return gear;
    }

    void callServiceForFuel() {
        this.tankSize = this.fullTank;
        System.out.println("The call to service was successful.\n" + getName() + " car tank is full.\n");
    }

    int getCurrentSpeed() {
        return currentSpeed;
    }

    private int getCurrentDistance() {
        return currentDistance;
    }

    private int getTankSize() {
        return tankSize;
    }

    private int getMaxSpeed() {
        return maxSpeed;
    }

    private String getName() {
        return name;
    }

    void move(int direction) {
        if (direction != 0) {
            upGear();
            this.fullTank = getTankSize();
            this.currentDistance = direction;
            System.out.println("You car: " + getName() + "\nYou are going to drive: " + direction + " km\n" + "\nJust for case your max distance: " + getTankSize() * 100 / 10 + " km");
        } else System.out.println("Direction shouldn't equal 0");
    }

    void upGear() {
        if (this.gear < 7 && this.currentSpeed <= this.maxSpeed) {
            this.gear++;
            this.currentSpeed += this.maxSpeed / 7;
        } else System.out.println("The gear is already Max");
    }

    void downGear() {
        if (this.gear > 0 && this.currentSpeed > 0) {
            this.gear--;
            this.currentSpeed -= this.maxSpeed / 7;
        } else if (this.gear == 0 && this.currentSpeed == 0) {
            stop();
            System.out.println("The gear is already Min (0). Be attentive it's not safe to drive with no gear");
        }
    }

    void stop() {

        if (getCurrentSpeed() <= 100) {
            this.gear = 0;
            this.carCondition -= (double) getCurrentDistance() / 1000000;
            this.tankSize -= (getCurrentDistance() / 10);
            this.currentSpeed = 0;
            System.out.println("The car is stopped. \nThe current speed: " + this.currentSpeed + "\nCar condition is: " + this.carCondition + " %");
            System.out.println("Fuel level is about: " + getTankSize() + " L");
            if (getTankSize() < 5) {
                System.out.println("You had better call the service, you almost have no fuel");
            }
        } else if (getCurrentSpeed() > 100) {
            this.gear = 0;
            this.carCondition -= (double) getCurrentDistance() / 1010101;
            this.currentSpeed = 0;
            this.tankSize -= (getCurrentDistance() / 7);
            System.out.println("The car is stopped. \nThe current speed: " + this.currentSpeed + "\nCar condition is: " + this.carCondition + " %");
            System.out.println("Fuel level is about: " + getTankSize() + " L");
            if (getTankSize() < 5) {
                System.out.println("You had better call the service, you almost have no fuel");
            }
        }
    }

    public static class Car extends Lesson57Vehicle {
        Car(String name, int tankSize, int maxSpeed) {
            super(name, tankSize, maxSpeed);
        }
    }
}