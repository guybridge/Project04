package au.com.wsit.animalguesser.utils;
import java.util.HashMap;

/**
 * Created by guyb on 28/08/16.
 */
public class QuestionData
{

    private HashMap<Integer, String> mQuestions;

    public QuestionData()
    {
        HashMap<Integer, String> questions = new HashMap<>();
        questions.put(0, "You enjoy the quiet and would consider yourself an introvert");
        questions.put(1, "You would consider yourself shy");
        questions.put(2, "You like trying new things");
        questions.put(3, "You like to be the life of the party");
        questions.put(4, "You like working and playing in a team");

        mQuestions = questions;
    }

    public HashMap<Integer, String> getQuestions()
    {
        return mQuestions;
    }
}
