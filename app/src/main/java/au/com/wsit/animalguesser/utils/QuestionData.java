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
        questions.put(0, "You enjoy eating fish and hanging around with your family");
        questions.put(1, "You are often quiet but can be very noisy");
        questions.put(2, "You are cheeky and get up to no good all the time");
        questions.put(3, "You enjoy alone time");
        questions.put(4, "You are outgoing and aggressive");

        mQuestions = questions;
    }

    public HashMap<Integer, String> getQuestions()
    {
        return mQuestions;
    }
}
