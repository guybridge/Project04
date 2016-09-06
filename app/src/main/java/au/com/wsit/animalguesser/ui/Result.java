package au.com.wsit.animalguesser.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import au.com.wsit.animalguesser.R;
import au.com.wsit.animalguesser.utils.Constants;

public class Result extends AppCompatActivity
{
    private ImageView mAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mAnimal = (ImageView) findViewById(R.id.animalImageView);

        // Get intent data
        Intent intent = getIntent();
        switch (intent.getStringExtra(Constants.KEY_ANIMAL))
        {
            case(Constants.KEY_DOLPHIN):
                mAnimal.setImageResource(R.drawable.dolphin);
                break;
            case (Constants.KEY_ELEPHANT):
                mAnimal.setImageResource(R.drawable.elephant);
                break;
            case (Constants.KEY_MONKEY):
                mAnimal.setImageResource(R.drawable.monkey);
                break;
            case (Constants.KEY_PANDA):
                mAnimal.setImageResource(R.drawable.redpanda);
                break;
            case (Constants.KEY_TIGER):
                mAnimal.setImageResource(R.drawable.tiger);
                break;

        }

        Toast.makeText(this, "You are a " + intent.getStringExtra(Constants.KEY_ANIMAL), Toast.LENGTH_LONG).show();


    }
}
