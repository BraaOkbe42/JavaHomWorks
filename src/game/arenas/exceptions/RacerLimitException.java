package game.arenas.exceptions;

public class RacerLimitException extends Exception{
    public RacerLimitException(int maxRacers, int serialNumber){
        super("Arena is full! (" + maxRacers + " active racers exist). racer #" +serialNumber+  " was not added");
    }
}
