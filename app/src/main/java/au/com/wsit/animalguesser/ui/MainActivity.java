package au.com.wsit.animalguesser.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import au.com.wsit.animalguesser.R;
import au.com.wsit.animalguesser.adapter.QuestionAdapter;
import au.com.wsit.animalguesser.utils.QuestionData;
import au.com.wsit.animalguesser.utils.QuestionItems;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mLayoutManager;
    private QuestionAdapter mQuestionAdapter;
    private Button mSubmitButton;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Setup the recyclerView
        mRecycler = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecycler.setLayoutManager(mLayoutManager);

        mSubmitButton = (Button) findViewById(R.id.submitButton);

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

        mSubmitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Get intent data
                Intent intent = new Intent(MainActivity.this, Result.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });



    }
}
