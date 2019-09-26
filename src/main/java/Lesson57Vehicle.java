import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/*
"7. Start with a base class of a Vehicle, then create a Car class that inherits from this base class.
    Finally, create another class, a specific type of Car that inherits from the Car class.
    You should be able to hand steering, changing gears, and moving(speed in other words).
    You will want to decide where to put the appropriate state and behaviours(fields and methods).
    As mentioned above, changing gears, increasing/decreasing speed should be included.
    For you specific type of vehicle you will want to add something specific for that type of car."
 */
public class Lesson57Vehicle {
    private String name;
    private int tankSize;
    private int fullTank;
    private int maxSpeed;
    private int currentSpeed;
    private long startTime;
    private long finishTime;
    private int currentDistance;
    private long currentTime;
    private double carCondition = 100;

    Lesson57Vehicle(String name, int tankSize, int maxSpeed) {
        this.name = name;
        this.tankSize = tankSize;
        this.maxSpeed = maxSpeed;
    }

    public static void main(String[] args) throws InterruptedException {
        Lesson57Vehicle newCar = new Car("Hooyota", 75, 240);
        newCar.move(150, 300);
        System.out.println("\n");
        newCar.stop();
        System.out.println("\n");
        Car newCarSecond = new Car("Hreno", 45, 175);
        newCarSecond.move(65, 340);
        System.out.println("\n");
        newCarSecond.stop();
        System.out.println("\n");
        newCarSecond.callServiceForFuel();

    }

    public void callServiceForFuel() {
        this.tankSize = this.fullTank;
        System.out.println("The call to service was successful.\n" + getName() + " car tank is full.\n");
    }

    private int getCurrentSpeed() {
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

    protected void move(int velocity, int direction) {
        if (velocity != 0 && direction != 0) {
            if (direction < getTankSize() * 10) {
                if (velocity <= getMaxSpeed() && velocity <= 100) {
                    this.fullTank = getTankSize();
                    this.currentDistance = direction;
                    this.currentSpeed = velocity;
                    System.out.println("You car: " + getName() + " is moving with speed: " + velocity + " kph \nYou are going to drive: " + direction + " km\nIt takes you about: " + (int) ((double) direction / velocity * 60) + " min" + "\nJust for case your max distance: " + getTankSize() * 100 / 10 + " km");

                } else if (velocity <= getMaxSpeed() && velocity >= 100) {
                    this.fullTank = getTankSize();
                    this.currentDistance = direction;
                    this.currentSpeed = velocity;
                    System.out.println("You car: " + getName() + " is moving with speed: " + velocity + " kph \nYou are going to drive: " + direction + " km\nIt takes you about: " + (int) ((double) direction / velocity * 60) + " min" + "\nJust for case your max distance: " + getTankSize() * 100 / 15 + " km");
                } else System.out.println("The ability of your car doesn't allow to drive with that speed");
            } else
                System.out.println("There is no Gas station on that road, You have no enough fuel to drive " + direction + " km  on your " + getName() + " without filling up the fuel tank");
        } else
            System.out.println("The value shouldn't equal 0");
    }

    protected void stop() {

        if (getCurrentSpeed() <= 100) {
            this.carCondition -= (double) getCurrentDistance() / 1000000;
            this.tankSize -= (getCurrentDistance() / 10);
            this.currentSpeed = 0;
            System.out.println("The car is stopped. \nThe current speed: " + this.currentSpeed + "\nCar condition is: " + this.carCondition + " %");
            System.out.println("Fuel level is about: " + getTankSize() + " L");
            if (getTankSize() < 5) {
                System.out.println("You had better call the service, you almost have no fuel");
            }
        } else if (getCurrentSpeed() > 100) {
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