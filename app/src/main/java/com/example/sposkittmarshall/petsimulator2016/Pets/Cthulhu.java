package com.example.sposkittmarshall.petsimulator2016.Pets;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.example.sposkittmarshall.petsimulator2016.R;

/**
 *  Created by sposkittmarshall on 2016/03/15.
 *
 *  The basic pet of the game, which can grow into any stage 2 pet
 *  Every player will start with this one
 *
 */

public class Cthulhu extends BasePet
{

    public Cthulhu(Context givenContext)
    {
        context = givenContext;
        // Set up basic variables
        speciesName = "Cthulhu";
        petName = "Steve";
        health = 10;
        strength = 3;
        defense = 2;
        speed = 1;

        petImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.cthulu);
    }

}
