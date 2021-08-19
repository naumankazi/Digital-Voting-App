package com.example.votingbooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.LogRecord;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity<i> extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button Total;
    ConstraintLayout consLayout1,consLayout2;
    TextView resultText,votecount,votedText;
    int[][] v1=new int[6][2];
    int i,temp1,temp2,j;
    float[] percentage={0, 0, 0, 0, 0, 0};
    double total=0;

    Handler myHandler=new Handler();
    Runnable myRunnable=new Runnable() {
        @Override
        public void run() {
            votedText.setVisibility(View.INVISIBLE);
        }
    };


    public void Vote1(View view)
    {
        v1[0][0]++;
        votedText.setText("You voted Candidate1");
        votedText.setVisibility(View.VISIBLE);
        Log.i("Count1", Integer.toString(v1[0][0]));
        myHandler.postDelayed(myRunnable,1000);
        //Toast.makeText(this, "You voted Candidate1", LENGTH_SHORT).show();
    }

    public void Vote2(View view)
    {
        v1[1][0]++;
        votedText.setText("You voted Candidate2");
        votedText.setVisibility(View.VISIBLE);
        Log.i("Count2", Integer.toString(v1[1][0]));
        myHandler.postDelayed(myRunnable,1000);
        //Toast.makeText(this, "You voted Candidate2", LENGTH_SHORT).show();
    }

    public void Vote3(View view)
    {
        v1[2][0]++;
        votedText.setText("You voted Candidate3");
        votedText.setVisibility(View.VISIBLE);
        Log.i("Count3", Integer.toString(v1[2][0]));
        myHandler.postDelayed(myRunnable,1000);
        //Toast.makeText(this, "You voted Candidate3", LENGTH_SHORT).show();
    }

    public void Vote4(View view)
    {
        v1[3][0]++;
        votedText.setText("You voted Candidate4");
        votedText.setVisibility(View.VISIBLE);
        Log.i("Count4", Integer.toString(v1[3][0]));
        myHandler.postDelayed(myRunnable,1000);
        //Toast.makeText(this, "You voted Candidate4", LENGTH_SHORT).show();
    }

    public void Vote5(View view)
    {
        v1[4][0]++;
        votedText.setText("You voted Candidate5");
        votedText.setVisibility(View.VISIBLE);
        Log.i("Count5", Integer.toString(v1[4][0]));
        myHandler.postDelayed(myRunnable,1000);
        //Toast.makeText(this, "You voted Candidate5", LENGTH_SHORT).show();
    }

    public void Vote6(View view)
    {
        v1[5][0]++;
        votedText.setText("You voted Candidate6");
        votedText.setVisibility(View.VISIBLE);
        Log.i("Count6", Integer.toString(v1[5][0]));
        myHandler.postDelayed(myRunnable,1000);
        //Toast.makeText(this, "You voted Candidate6", LENGTH_SHORT).show();
    }

    public void voteCount(View view)
    {
        /*
        for(i=0;i<6;i++)
        {
            Log.i("ValueAtPos",Integer.toString(v1[i][1]));
        }
         */
        consLayout1.setVisibility(View.INVISIBLE);
        consLayout2.setVisibility(View.VISIBLE);
        /*
        for(i=0;i<v1.length;i++)
        {
            if(maxVote<v1[i][0])
            {
                maxVote=v1[i][0];
                j=i;
            }
        }
        */

        for(i=0;i<6;i++)
        {
            Log.i("ValueBeforeAtPos",Integer.toString(v1[i][0]));
        }

        for (i = 0; i < 6; i++)
        {
            for (j = i + 1; j < 6; j++)
            {
                if (v1[i][0] < v1[j][0])
                {
                    temp1 = v1[i][0];
                    v1[i][0] = v1[j][0];
                    v1[j][0] = temp1;

                    temp2 = v1[i][1];
                    v1[i][1] = v1[j][1];
                    v1[j][1] = temp2;

                }
            }


        }

        for(i=0;i<6;i++)
        {
            Log.i("ValueOf0AtPos",Integer.toString(v1[i][0]));
        }

        for(i=0;i<6;i++)
        {
            Log.i("ValueOf1AtPos",Integer.toString(v1[i][1]));
        }

        for(i=0;i<6;i++)
        {
            total+=v1[i][0];
        }

        for(i=0;i<6;i++)
        {
            percentage[i]= (float) ((v1[i][0]*100)/total);
        }

        String voteCount="";



        for(i=0;i<6;i++)
        {
            voteCount="\nCandidate"+ Integer.toString(v1[i][1]) + " got " +Float.toString(percentage[i])+"% of votes.";
            votecount.append(voteCount);
        }

        //Log.i("MaxVote is for Candidate", Integer.toString(j));

    }

    public void totalVoteCount(View view)
    {
        Total.setVisibility(View.INVISIBLE);
        String result="Total no of votes casted: "+ total;
        resultText.setText(result);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        Total=(Button)findViewById(R.id.Total);
        consLayout1=(ConstraintLayout)findViewById(R.id.consLayout1);
        consLayout2=(ConstraintLayout)findViewById(R.id.consLayout2);
        resultText=(TextView)findViewById(R.id.resultText);
        votecount=(TextView)findViewById(R.id.votecount);
        votedText=(TextView)findViewById(R.id.votedText);

        for (i=0;i<6;i++)
        {
            v1[i][0]=0;
        }

        for (i=0;i<6;i++)
        {
            v1[i][1]=i+1;
        }


    }
}