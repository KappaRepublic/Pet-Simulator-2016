package com.example.sposkittmarshall.petsimulator2016.Pets;

/**
 *  Created by sposkittmarshall on 2016/03/15.
 *
 *  Base class that all pet classes will be based on.
 *  Stores any functions and variables used by all pets.
 */

public class BasePet
{
    // Variables
    protected String petName;
    protected String speciesName;

    protected int health;     // If health reaches 0, the pet dies
    protected int strength;   // The pets strength, how much damage an attack does
    protected int defense;    // The pets defense, decreases how much damage the pet takes
    protected int speed;      // The pets speed, determines if the pet attacks first

    // Getters and Setters
    public String getPetName()
    {
        return petName;
    }

    public String getSpeciesName()
    {
        return speciesName;
    }

    public int getHealth()
    {
        return health;
    }

    public int getStrength()
    {
        return strength;
    }

    public int getDefense()
    {
        return defense;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setPetName(String value)
    {
        petName = value;
    }

    public void setSpeciesName(String value)
    {
        speciesName = value;
    }

    public void setHealth(int value)
    {
        health = value;
    }

    public void setStrength(int value)
    {
        strength = value;
    }

    public void setDefense(int value)
    {
        defense = value;
    }

    public void setSpeed(int value)
    {
        speed = value;
    }
}
