package au.com.wsit.animalguesser.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import au.com.wsit.animalguesser.R;
import au.com.wsit.animalguesser.adapter.QuestionAdapter;
import au.com.wsit.animalguesser.utils.QuestionData;
import au.com.wsit.animalguesser.utils.QuestionItems;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView mRecycler;
    RecyclerView.LayoutManager mLayoutManager;
    QuestionAdapter mQuestionAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Setup the recyclerView
        mRecycler = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecycler.setLayoutManager(mLayoutManager);

        // Get the question data
        QuestionData questionData = new QuestionData();

        QuestionItems[] questionItems = new QuestionItems[questionData.getQuestions().size()];
        
        for (int i = 0; i < questionData.getQuestions().size(); i++)
        {
            Log.i(TAG, "Question: " + questionData.getQuestions().get(i));

            QuestionItems item = new QuestionItems();
            item.setQuestion(questionData.getQuestions().get(i));

            questionItems[i] = item;

        }

        mQuestionAdapter = new QuestionAdapter(MainActivity.this, questionItems);
        mRecycler.setAdapter(mQuestionAdapter);



    }
}
