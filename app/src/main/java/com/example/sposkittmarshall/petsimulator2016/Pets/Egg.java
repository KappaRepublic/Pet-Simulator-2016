package com.example.sposkittmarshall.petsimulator2016.Pets;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import com.example.sposkittmarshall.petsimulator2016.R;

/**
 *  Created by sposkittmarshall on 2016/03/15.
 *
 *  The basic pet of the game, which can grow into any stage 2 pet
 *  Every player will start with this one
 *
 */

public class Egg extends BasePet
{

    public Egg(Context givenContext)
    {
        context = givenContext;
        // Set up basic variables
        speciesName = "Egg";
        health = 5;
        strength = 1;
        defense = 1;
        speed = 1;

        petImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.egg);
    }

}
