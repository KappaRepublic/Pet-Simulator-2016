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

public class FriedChicken extends BasePet
{

    public FriedChicken(Context givenContext)
    {
        context = givenContext;
        // Set up basic variables
        speciesName = "Fried Chicken";
        petName = "Kunel Sanders";
        health = 5;
        strength = 1;
        defense = 1;
        speed = 1;

        petImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.friedchicken);
    }

}
