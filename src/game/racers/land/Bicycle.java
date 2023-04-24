package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.BicycleType;
import utilities.EnumContainer.Color;


/**

 The {@code Bicycle} class represents a bicycle racer that extends {@link game.racers.Racer}
 and implements {@link game.racers.land.LandRacer}.
 It has a type that is defined by {@link utilities.EnumContainer.BicycleType} enum and
 has two wheels represented by an instance of the {@link game.racers.Wheeled} class.
 */


public class Bicycle extends Racer implements  LandRacer {
    private static final  String CLASS_NAME = "Bicycle";
    private static final int DEFAULT_WHEELS = 2 ;
    private static final double DEFAULT_MAX_SPEED = 270;
    private static final double DEFAULT_ACCELERATION  = 10;
    private static final Color DEFAULT_color = Color.GREEN;
    private BicycleType type;
    private Wheeled wheeled;

    public  Bicycle(String name, double maxSpeed, double acceleration, Color color, int numOfWheels){
        super(name, maxSpeed, acceleration, color);
        this.wheeled = new Wheeled(numOfWheels);
        setType(BicycleType.MOUNTAIN);
    }

    public BicycleType getType() {
        return this.type;
    }
    public boolean setType(BicycleType type) {
        this.type = type;
        return true;
    }
    public Bicycle(){
        this(CLASS_NAME + " #" + Racer.getSerial(), DEFAULT_MAX_SPEED,  DEFAULT_ACCELERATION,DEFAULT_color, DEFAULT_WHEELS);
    }
    @Override
    public String className() {
        return CLASS_NAME;
    }
    @Override
    public String describeSpecific() {
        return ", " + this.wheeled.describeSpecific() + ", Bicycle Type: " + this.getType();
    }
}
