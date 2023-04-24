package game.racers.naval;

import game.racers.Racer;
import game.racers.land.LandRacer;
import utilities.EnumContainer;


/** מגישים :
 * ברא אלעוקבי ת.ז 212654297
 * סאמר מסאעד ת.ז 324812643
 */

/**

 SpeedBoat is a class representing a speedboat racer in a racing game.
 It extends the Racer abstract class and implements the NavalRacer interface.
 It has a maximum speed, acceleration, color, and a team and type that can be set.
 */


public class SpeedBoat extends Racer implements NavalRacer {
    private static final  String CLASS_NAME = "SpeedBoat";
    private static final double DEFAULT_MAX_SPEED = 170;
    private static final double DEFAULT_ACCELERATION  = 5;
    private static final EnumContainer.Color DEFAULT_color = EnumContainer.Color.RED;
    private EnumContainer.BoatType type ;
    private EnumContainer.Team team;


    public SpeedBoat(String name, double maxSpeed, double acceleration, EnumContainer.Color color){
        super(name, maxSpeed, acceleration, color);
        setTeam(EnumContainer.Team.DOUBLE);
        setType(EnumContainer.BoatType.SKULLING);
    }
    public SpeedBoat(){
        this(CLASS_NAME + " #" + Racer.getSerial(), DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);
    }
    @Override
    public String className() {
        return CLASS_NAME;
    }
    @Override
    public String describeSpecific() {
        return  ", Type: " + this.getType() + ", Team: " + this.getTeam();
    }
    public EnumContainer.Team getTeam() {
        return this.team;
    }
    public boolean setTeam(EnumContainer.Team team) {
        this.team = team;
        return true;
    }
    public EnumContainer.BoatType getType() {
        return this.type;
    }
    public boolean setType(EnumContainer.BoatType type) {
        this.type = type;
        return true;
    }
}
