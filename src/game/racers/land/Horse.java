package game.racers.land;

import game.racers.Racer;
import utilities.EnumContainer.Breed;
import utilities.EnumContainer.Color;

public class Horse extends Racer implements LandRacer {

    private static final  String CLASS_NAME = "Horse";
    private static final int DEFAULT_WHEELS = 2 ;
    private static final double DEFAULT_MAX_SPEED = 50;
    private static final double DEFAULT_ACCELERATION  = 3;
    private static final Color DEFAULT_color = Color.BLACK;
    private Breed breed;

    /**

     The Horse class represents a type of Racer that is designed to race on land.
     It extends the Racer class and implements the LandRacer interface.
     This class contains information about the horse's breed, color, and other properties.
     The Horse class provides methods to set and get the horse's breed.
     @author [Your Name]
     @version [Date]
     */

    public Horse(String name, double maxSpeed, double acceleration, Color color){
        super(name, maxSpeed, acceleration, color);
        this.setBreed(Breed.THOROUGHBRED);

    }

    public Horse(){
        this(CLASS_NAME + " #" +  Racer.getSerial(), DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);
    }
    @Override
    public String className() {
        return CLASS_NAME;
    }
    @Override
    public String describeSpecific() {
        return   " , Breed: " + this.getBreed();
    }
    public Breed getBreed() {
        return this.breed;
    }
    public boolean setBreed(Breed breed) {
        this.breed = breed;
        return true;
    }
}
