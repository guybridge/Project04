package au.com.wsit.animalguesser.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.TreeMap;

import au.com.wsit.animalguesser.R;
import au.com.wsit.animalguesser.utils.QuestionItems;

/**
 * Created by guyb on 28/08/16.
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>
{

    private Context mContext;
    private QuestionItems[] mQuestions;
    // For storing answers
    private TreeMap<Integer, String> mAnswers = new TreeMap<>();

    public QuestionAdapter(Context context, QuestionItems[] items)
    {
        mContext = context;
        mQuestions = items;
    }

    @Override
    public QuestionAdapter.QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.questions_list_item, parent, false);
        QuestionViewHolder viewHolder = new QuestionViewHolder(view);
        return viewHolder;
    }

    // Get the answers from the adapter
    public TreeMap<Integer, String> getmAnswers()
    {
        return mAnswers;
    }



    @Override
    public void onBindViewHolder(QuestionAdapter.QuestionViewHolder holder, final int position)
    {
        holder.bindQuestion(mQuestions[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(mContext, mQuestions[position].getQuestion(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mQuestions.length;
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mQuestionText;
        private Spinner mSpinnerAnswers;

        public QuestionViewHolder(View itemView)
        {
            super(itemView);

            mQuestionText = (TextView) itemView.findViewById(R.id.questionTextView);
            mSpinnerAnswers = (Spinner) itemView.findViewById(R.id.answerSpinner);
        }

        // Bind the item data to the XML
        public void bindQuestion(QuestionItems item)
        {
            mQuestionText.setText(item.getQuestion());

            // Spinner setup
            ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(mContext, R.array.likeness_values, android.R.layout.simple_spinner_item);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinnerAnswers.setAdapter(spinnerAdapter);

            mSpinnerAnswers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                    String answer = parent.getSelectedItem().toString();

                    mAnswers.put(position, answer);

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });

        }
    }
}
