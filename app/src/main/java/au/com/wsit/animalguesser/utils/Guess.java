package au.com.wsit.animalguesser.utils;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by guyb on 3/09/16.
 */
public class Guess
{


    private static final String TAG = Guess.class.getSimpleName();
    private TreeMap<Integer, String> mAnswers;
    private Context mContext;

    public Guess(Context context, TreeMap<Integer, String> answers)
    {
        mContext = context;
        mAnswers = answers;
    }

    public String guessAnimal()
    {

        int dolphin = 0;
        int elephant = 0;
        int monkey = 0;
        int panda = 0;
        int tiger = 0;



        // Dophin
        Log.i(TAG, "Guess is: " + mAnswers.get(0));
        if(mAnswers.get(0).equals(Constants.KEY_THIS_IS_ME))
        {
            dolphin = 5;
        }

        // Elephant
        Log.i(TAG, "Guess is: " + mAnswers.get(1));
        if(mAnswers.get(1).equals(Constants.KEY_ELEPHANT))
        {
            elephant = 5;
        }

        // Monkey
        Log.i(TAG, "Guess is: " + mAnswers.get(2));

        // Panda
        Log.i(TAG, "Guess is: " + mAnswers.get(3));

        // Tiger
        Log.i(TAG, "Guess is: " + mAnswers.get(4));

        // Find the highest
        int animalPointsArray[] = {dolphin, elephant, monkey, panda, tiger};


        return Constants.KEY_MONKEY;



    }

    public int determinePoints(String answer)
    {

        try
        {
            switch (answer)
            {
                case "Not me":
                    return 0;
                case "Maybe":
                    return 1;
                case "Sometimes":
                    return 2;
                case "Often":
                    return 3;
                case "This is me":
                    return 4;
                default:
                    return 0;
            }
        }
        catch (NullPointerException e)
        {
            Toast.makeText(mContext, "Not enough answers", Toast.LENGTH_SHORT).show();
            return 0;
        }


    }





}
