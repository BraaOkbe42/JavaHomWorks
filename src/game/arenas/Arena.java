package game.arenas;

import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import utilities.Point;


import java.util.ArrayList;


/** מגישים :
 * ברא אלעוקבי ת.ז 212654297
 * סאמר מסאעד ת.ז 324812643
 */

/**

 This is an abstract class that represents an Arena where racers compete.
 It contains common functionality for all Arenas, such as adding and initializing racers,
 updating the race state, and displaying results. Each subclass should implement the addRacer method.
 */
public abstract class Arena {
    private ArrayList <Racer> activeRacers;
    private ArrayList <Racer> completedRacers;
    private final double FRICTION;
    private final  int MAX_RACERS;
    private final static int  MIN_Y_GAP = 10;
    private double length;




    public Arena(double length, int MaxRacers, double friction){
        this.setlenght(length);
        this.MAX_RACERS = MaxRacers;
        this.FRICTION = friction;
        this.setActiveRacer(new ArrayList<Racer>());
        this.setCompletedRacers(new ArrayList<Racer>());
    }


    public void initRace(){
        int gap = 0;
        for (Racer racer: this.getActiveRacers()){
            racer.initRace(this,new Point(0, gap), new Point(this.getLength(), gap));
            gap += MIN_Y_GAP;
        }
    }

    public void crossFinishLine(Racer racer){
        if (racer.getCurrentLocation().getX() >= this.getLength()){
            this.getActiveRacers().remove(racer);
            this.getCompletedRacers().add(racer);
        }
    }
    public void playTurn(){
        ArrayList<Racer> arrayListcopy = new ArrayList<Racer>(this.getActiveRacers());
        for (Racer racer:arrayListcopy){
            racer.move(this.getFriction());
            if(racer.getCurrentLocation().getX() >= this.getLength()){
                this.crossFinishLine(racer);
            }
        }
    }

    public void  showResults(){
        int i = 0;
        for ( i = 0; i<getCompletedRacers().size();i++){
            System.out.println("#"+i+"-> " +getCompletedRacers().get(i).describeRacer() +getCompletedRacers().get(i).describeSpecific());
        }

    }
    public void setCompletedRacers(ArrayList<Racer> completedRacers) {
        this.completedRacers = completedRacers;
    }

    public void setActiveRacer(ArrayList<Racer> racers){
        this.activeRacers = racers;
    }
    public void setlength(double length){
        this.length = length;
    }
    public boolean  hasActiveRacers(){
        return !(activeRacers.isEmpty());
    }
    public ArrayList<Racer> getActiveRacers() {
        return this.activeRacers;
    }

    public ArrayList<Racer> getCompletedRacers() {
        return this.completedRacers;
    }

    public double getFriction() {
        return this.FRICTION;
    }


    public int getMaxRacers() {
        return this.MAX_RACERS;
    }

    public double getLength() {
        return this.length;
    }
    public boolean setlenght(double length){
        this.length = length;
        return true;
    }
    public abstract void addRacer(Racer newRacer) throws RacerLimitException, RacerTypeException;




}
