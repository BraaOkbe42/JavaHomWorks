package game.racers.naval;

import game.racers.Racer;
import game.racers.Wheeled;
import game.racers.land.LandRacer;
import utilities.EnumContainer.BoatType;
import utilities.EnumContainer.Team;
import utilities.EnumContainer.Color;



public class RowBoat extends Racer implements NavalRacer {

    private static final  String CLASS_NAME = "RowBoat";
    private static final double DEFAULT_MAX_SPEED = 75;
    private static final double DEFAULT_ACCELERATION  = 10;
    private static final Color DEFAULT_color = Color.RED;
    private BoatType type ;
    private Team team;



/** מגישים :
 * ברא אלעוקבי ת.ז 212654297
 * סאמר מסאעד ת.ז 324812643
 */


    /**

     The RowBoat class represents a type of naval racer that is designed to be rowed.
     It extends the Racer class and implements the NavalRacer interface.
     A RowBoat racer has a type and a team.
     The class provides methods to get and set the type and team of the racer.
     */

    public Team getTeam() {
        return this.team;
    }
    public boolean setTeam(Team team) {
        this.team = team;
        return true;
    }
    public BoatType getType() {
        return this.type;
    }

    public RowBoat(String name, double maxSpeed, double acceleration, Color color){
        super(name, maxSpeed, acceleration, color);
        setTeam(Team.DOUBLE);
        setType(BoatType.SKULLING);
    }
    public RowBoat(){
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
    public boolean setType(BoatType type) {
        this.type = type;
        return true;
    }
}
