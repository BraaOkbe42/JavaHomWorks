package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Engine;
import utilities.EnumContainer.Color;

/**

 The Car class represents a type of Racer that is designed to race on land.
 It extends the Racer class and implements the LandRacer interface.
 This class contains information about the car's engine, wheels, color, and other properties.
 The Car class also provides methods to set and get the car's engine type.
 It uses the Wheeled class to describe the number of wheels the car has.
 @author [Your Name]
 @version [Date]
 */

public class Car extends Racer implements LandRacer {

    private static final  String CLASS_NAME = "Car";
    private static final int DEFAULT_WHEELS = 4 ;
    private static final double DEFAULT_MAX_SPEED = 400;
    private static final double DEFAULT_ACCELERATION  = 20;
    private static final Color DEFAULT_color = Color.RED;
    private Engine engine;
    private Wheeled wheeled;
    public Car(String name, double maxSpeed, double acceleration, Color color, int numOfwheels){
        super(name, maxSpeed, acceleration, color);
        this.wheeled = new Wheeled(numOfwheels);
        setEngine(Engine.FORURSTROKE);
    }
    public Engine getEngine() {
        return engine;
    }
    public boolean setEngine(Engine engine) {
        this.engine = engine;
        return true;
    }
    public Car(){
        this(CLASS_NAME + " #" + Racer.getSerial(),DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color, DEFAULT_WHEELS );
    }
    @Override
    public String className() {
        return CLASS_NAME;
    }
    @Override
    public String describeSpecific() {
        return  ", " + this.wheeled.describeSpecific() + ", Engine Type: " + this.getEngine();
    }
}
