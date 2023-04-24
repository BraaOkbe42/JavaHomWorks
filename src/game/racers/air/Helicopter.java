package game.racers.air;

import game.racers.Racer;
import utilities.EnumContainer.Color;

public class Helicopter extends Racer implements AerialRacer {
    private static final  String CLASS_NAME = "Helicopter";
    private static final double DEFAULT_MAX_SPEED = 400;
    private static final double DEFAULT_ACCELERATION  = 50;
    private static final Color DEFAULT_color = Color.BLUE;

    /**

     The Helicopter class represents a type of Racer that is designed to race in the air.
     It extends the Racer class and implements the AerialRacer interface.
     This class contains information about the helicopter's color and other properties.
     @author [Your Name]
     @version [Date]
     */




    public Helicopter(){
        this(CLASS_NAME +" #" + Racer.getSerial(), DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);
    }

    @Override
    public String className() {
        return this.CLASS_NAME;
    }

    @Override
    public String describeSpecific() {
        return "";
    }

    public Helicopter(String name, double maxSpeed, double acceleration, Color color){
        super(name, maxSpeed, acceleration, color);

    }
}
