package factory;

import game.arenas.Arena;
import game.racers.Racer;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import utilities.EnumContainer;


/**
 * A factory class for creating instances of `Arena` and `Racer` objects using reflection.
 *
 * This class is implemented as a Singleton, meaning that only one instance of this class can exist
 * in the program at any given time. To get an instance of the `RaceBuilder` class, call the static
 * `getInstance()` method.
 *
 * The `RaceBuilder` class provides three methods for building objects: `buildArena()`, `buildRacer()`,
 * and `buildWheeledRacer()`. Each of these methods takes in various parameters for specifying the
 * type and properties of the object to be created.
 *
 * The `buildArena()` method takes in a `String` representing the fully qualified class name of the
 * desired `Arena` class, as well as the length and maximum number of racers for the arena. It then
 * uses reflection to dynamically load the class and create a new instance of the class using the
 * specified parameters.
 *
 * The `buildRacer()` method takes in a `String` representing the fully qualified class name of the
 * desired `Racer` class, as well as various properties of the racer, such as its name, maximum speed,
 * acceleration, and color. It then uses reflection to dynamically load the class and create a new
 * instance of the class using the specified parameters.
 *
 * The `buildWheeledRacer()` method is similar to the `buildRacer()` method, but it also takes in an
 * additional parameter for specifying the number of wheels on the racer.
 *
 * All of these methods can throw various exceptions related to reflection, such as `ClassNotFoundException`,
 * `NoSuchMethodException`, `SecurityException`, `InstantiationException`, `IllegalAccessException`,
 * `IllegalArgumentException`, and `InvocationTargetException`.
 *
 * Note that this class is intended to be used with properly defined `Arena` and `Racer` subclasses
 * that have public constructors with specific parameter types. If a subclass does not follow these
 * conventions, then the `buildArena()` and `buildRacer()` methods may not work as intended.
 *
 */

public class RaceBuilder {

    private static RaceBuilder instance;
    private ClassLoader classLoader;
    private Class<?> classObject;
    private Constructor<?> constructor;

    private RaceBuilder(){

    }

    public static RaceBuilder getInstance(){
        if (instance == null)
            instance = new RaceBuilder();
        return instance;
    }

    public   Arena  buildArena(String arenaType, double length, int maxRacers) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        classLoader = ClassLoader.getSystemClassLoader();
        classObject = classLoader.loadClass(arenaType);
        constructor = classObject.getConstructor(double.class, int.class);
        return (Arena) constructor.newInstance(length, maxRacers);
    }


    public Racer buildRacer(String racerType, String name, double maxSpeed, double acceleration,utilities.EnumContainer.Color color)throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        classLoader = ClassLoader.getSystemClassLoader();
        classObject = classLoader.loadClass(racerType);
        constructor = classObject.getConstructor(String.class, double.class, double.class, utilities.EnumContainer.Color.class);
        return (Racer) constructor.newInstance(name, maxSpeed, acceleration, color);
    }


    public Racer buildWheeledRacer(String racerType, String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color, int numOfWheels) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        classLoader = ClassLoader.getSystemClassLoader();
        classObject = classLoader.loadClass(racerType);
        constructor = classObject.getConstructor(String.class, double.class, double.class, utilities.EnumContainer.Color.class, int.class);
        return (Racer) constructor.newInstance(name, maxSpeed, acceleration, color, numOfWheels);
    }

}
