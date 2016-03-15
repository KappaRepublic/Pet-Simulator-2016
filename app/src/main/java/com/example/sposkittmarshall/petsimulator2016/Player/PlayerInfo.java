package com.example.sposkittmarshall.petsimulator2016.Player;

import com.example.sposkittmarshall.petsimulator2016.Pets.BasePet;
import com.example.sposkittmarshall.petsimulator2016.Pets.Egg;

/**
 *  Created by sposkittmarshall on 2016/03/15.
 *
 *  Class to store info for the player
 */

public class PlayerInfo
{
    // Variables
    public BasePet currentPet;

    public PlayerInfo()
    {
        currentPet = new Egg();
    }

}
