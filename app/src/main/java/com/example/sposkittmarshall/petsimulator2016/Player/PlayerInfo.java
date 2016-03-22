package com.example.sposkittmarshall.petsimulator2016.Player;

import android.content.Context;

import com.example.sposkittmarshall.petsimulator2016.Pets.BasePet;
import com.example.sposkittmarshall.petsimulator2016.Pets.Bear;
import com.example.sposkittmarshall.petsimulator2016.Pets.Egg;

/**
 *  Created by sposkittmarshall on 2016/03/15.
 *
 *  Class to store info for the player
 */

public class PlayerInfo
{
    // Variables
    public String playerName;
    public BasePet currentPet;

    public PlayerInfo(String givenPlayerName, Context givenContext)
    {
        playerName = givenPlayerName;
        currentPet = new Bear(givenContext);
    }

}
