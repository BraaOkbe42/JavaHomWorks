package game.arenas.air;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.air.AerialRacer;
import utilities.EnumContainer.Vision;
import utilities.EnumContainer.Weather;
import utilities.EnumContainer.Height;
import utilities.EnumContainer.Wind;


public class AerialArena extends Arena {
    final static double DEFAULT_FRICTION = 0.4;
    final static int DEFAULT_MAX_RACERS = 4;
    final static int DEFAULT_LENGTH = 1500;
    private Vision vision = Vision.SUNNY;
    private Weather weather = Weather.DRY;
    private Height height = Height.HIGH;
    private Wind wind = Wind.HIGH;

    /** מגישים :
     * ברא אלעוקבי ת.ז 212654297
     * סאמר מסאעד ת.ז 324812643
     */

    /**

     AerialArena is a subclass of Arena that represents a racing arena in the air.
     It allows only AerialRacers to participate and has a default length of 1500 meters
     and a maximum of 4 racers. The default friction value is 0.4.
     AerialArena has attributes for vision, weather, height, and wind which can be set
     and retrieved using the getVision(), setVision(), getWeather(), setWeather(),
     getHeight(), setHeight(), getWind() and setWind() methods.
     @author [Your Name]
     @version [The Date]
     */


    public AerialArena(){
        this(DEFAULT_LENGTH, DEFAULT_MAX_RACERS );
    }

    @Override
    public void addRacer(Racer newRacer) throws RacerLimitException, RacerTypeException {
        if(!(newRacer instanceof AerialRacer)){
            throw new RacerTypeException(newRacer.className(), "AerialArena");
        }
        if (super.getActiveRacers().size() + 1 > super.getMaxRacers()  ){
            throw new RacerLimitException(super.getActiveRacers().size() , newRacer.getSerialNumber());
        }
        super.getActiveRacers().add(newRacer);
    }


    public AerialArena(double length, int maxRacers){
        super(length, maxRacers, DEFAULT_FRICTION);
    }

    public boolean setWind(Wind wind){
            this.wind = wind;
            return true;
        }

    public Wind getWind(){
        return this.wind;
    }

    public boolean setVision(Vision vision){
            this.vision = vision;
        return true;
    }
    public Vision getVision(){
        return this.vision;
    }

    public boolean setHeight(Height height){
        this.height = height;
        return true;
    }

    public Height getHeight(){
        return this.height;
    }

    public  boolean setWeather(Weather weather){
        this.weather = weather;
        return true;
    }

    public Weather getWeather(){
        return this.weather;
    }

}
