package game.arenas.land;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.land.LandRacer;
import utilities.EnumContainer.Coverage;
import utilities.EnumContainer.Surface;


/** מגישים :
 * ברא אלעוקבי ת.ז 212654297
 * סאמר מסאעד ת.ז 324812643
 */

/**

 LandArena is a subclass of Arena that represents a racing arena on land.
 It allows only LandRacers to participate and has a default length of 800 meters
 and a maximum of 8 racers. The default friction value is 0.5.
 LandArena has attributes for coverage and surface type which can be set
 and retrieved using the getCoverage(), setCoverage(), getSurface() and setSurface() methods.
 @author [Your Name]
 @version [The Date]
 */
public class LandArena extends Arena {
    final static double DEFAULT_FRICTION = 0.5;
    final static int DEFAULT_MAX_RACERS = 8;
    final static int DEFAULT_LENGTH = 800;
    private Coverage coverage;
    private Surface surface;

    public LandArena(double length, int maxRacers){
        super(length, maxRacers, DEFAULT_FRICTION);
        setCoverage(Coverage.GRASS);
        setSurface(Surface.FLAT);
    }

    public LandArena(){
        this(DEFAULT_LENGTH, DEFAULT_MAX_RACERS);
    }

    @Override
    public void addRacer(Racer newRacer) throws RacerLimitException, RacerTypeException {
        if(!(newRacer instanceof LandRacer)){
            throw new RacerTypeException(newRacer.className(), "LandArena");
        }
        if (super.getActiveRacers().size() +1 > super.getMaxRacers() ){
            throw new RacerLimitException(super.getActiveRacers().size() , newRacer.getSerialNumber());
        }
        super.getActiveRacers().add(newRacer);
    }

    public Coverage getCoverage() {
        return coverage;
    }

    public boolean setCoverage(Coverage coverage) {
        this.coverage = coverage;
        return true;
    }

    public Surface getSurface() {
        return surface;
    }

    public boolean setSurface(Surface surface) {
        this.surface = surface;
        return true;
    }
}
