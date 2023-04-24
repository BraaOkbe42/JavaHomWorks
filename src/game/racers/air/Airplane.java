package game.racers.air;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Color;
import utilities.Point;

public class Airplane extends Racer implements AerialRacer{
    private static final  String CLASS_NAME = "Airplane";
    private static final int DEFAULT_WHEELS = 3 ;
    private static final double DEFAULT_MAX_SPEED = 855;
    private static final double DEFAULT_ACCELERATION  = 100;
    private static final Color DEFAULT_color = Color.BLACK;

    private Wheeled wheeled;


    /**

     The Airplane class represents a type of Racer that is designed to race in the air.
     It extends the Racer class and implements the AerialRacer interface.
     This class contains information about the airplane's wheels, color, and other properties.
     The Airplane class uses the Wheeled class to describe the number of wheels the airplane has.
     @author [Your Name]
     @version [Date]
     */
     public Airplane(){
         this(CLASS_NAME +" #" +Racer.getSerial(),DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION,Color.BLACK,DEFAULT_WHEELS);
     }


    public Airplane(String name, double maxSpeed, double acceleration, Color color, int numOfwheels){
         super(name, maxSpeed, acceleration, color);
         this.wheeled = new Wheeled(numOfwheels);
     }

    @Override
    public String className() {
        return this.CLASS_NAME;
    }

    @Override
    public String describeSpecific() {
        return ", " + wheeled.describeSpecific();
    }

}
