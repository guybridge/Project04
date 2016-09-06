package au.com.wsit.animalguesser.utils;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
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

        HashMap<Integer, String> animals = new HashMap<>();

        animals.put(0, Constants.KEY_DOLPHIN);
        animals.put(1, Constants.KEY_MONKEY);
        animals.put(2, Constants.KEY_ELEPHANT);
        animals.put(3, Constants.KEY_PANDA);
        animals.put(4, Constants.KEY_TIGER);

        Random random = new Random();
        int number = random.nextInt(5);

        Log.i(TAG, "Random number is: " + number);
        Log.i(TAG, "Animal is: " + animals.get(number));


        return animals.get(number);



    }







}
