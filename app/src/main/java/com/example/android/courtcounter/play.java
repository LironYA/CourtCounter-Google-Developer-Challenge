package com.example.android.courtcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class play extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int addOneTeamA = 0; //points counter for the statistics
    int addTWoTeamA = 0; //points counter for the statistics
    int addThreeTeamA = 0; //points counter for the statistics
    int addOneTeamB = 0; //points counter for the statistics
    int addTWoTeamB = 0; //points counter for the statistics
    int addThreeTeamB = 0; //points counter for the statistics

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
    }

    /**
     * Menu
     */
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.rules) {
            Toast.makeText(
                    getApplicationContext(),
                    "If the player successfully shoots from outside of the 3 points line, the basket is worth 3 points" + "\n" + "otherwise it is worth 2 points. \nIt is also possible to score one point when shooting from the free throw line, \nafter a foul for instance",
                    Toast.LENGTH_LONG).show();
        }
        if (id == R.id.play) {
            Toast.makeText(
                    getApplicationContext(),
                    "Court counter",
                    Toast.LENGTH_LONG).show();
            Intent i = new Intent(play.this, MainActivity.class);
            startActivity(i);
        }
        if (id == R.id.winner) {
            if (scoreTeamA > scoreTeamB) {
                Toast.makeText(
                        getApplicationContext(),
                        "Team A won!",
                        Toast.LENGTH_LONG).show();
            }
            if (scoreTeamA == scoreTeamB) {
                Toast.makeText(
                        getApplicationContext(),
                        "It's a tie!",
                        Toast.LENGTH_LONG).show();
            }
            if (scoreTeamA < scoreTeamB) {
                Toast.makeText(
                        getApplicationContext(),
                        "Team B won!",
                        Toast.LENGTH_LONG).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        addOneTeamA = addOneTeamA + 1;
        displayForTeamA(scoreTeamA);
    }


    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        addOneTeamB = addOneTeamB + 1;
        displayForTeamB(scoreTeamB);
    }


    //Resets scores value to zero and displaying it on the screen
    public void resetCounter(View view) {
        scoreTeamA = 0; //score counter
        scoreTeamB = 0;
        addOneTeamA = 0; //statistics counter
        addTWoTeamA = 0;
        addThreeTeamA = 0;
        addOneTeamB = 0;
        addTWoTeamB = 0;
        addThreeTeamB = 0;

        displayForTeamB(scoreTeamB);
        displayForTeamA(scoreTeamA);
        displayStatistics("Press the button for game statistics");
    }

    //statistics
    public void statistics(View view) {
        displayStatistics("Team A tried to score 3 points " + addThreeTeamA + " times \n" + addTWoTeamA + " times 2 points and " + addOneTeamA + " times free throw points\n" + "Team B tried to score 3 points " + addThreeTeamB + " times \n" + addTWoTeamB + " times 2 points and " + addOneTeamB + " times free throw points");
        // displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    //Statistics
    public void displayStatistics(String score) {
        TextView scoreView = (TextView) findViewById(R.id.statistics_text);
        scoreView.setText(String.valueOf(score));
    }

    //Random function +3 for team A
    public void addThreeForTeamARandom(View view) {

        int yesno = new Random().nextInt(4 - 1) + 1;
        if (yesno == 1)
            scoreTeamA = scoreTeamA + 3;
        addThreeTeamA = addThreeTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    //Random function +2 for team A
    public void addTwoForTeamARandom(View view) {

        int yesno = new Random().nextInt(3 - 1) + 1;
        if (yesno == 1)
            scoreTeamA = scoreTeamA + 2;
        addTWoTeamA = addTWoTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    //Random function +3 for team B
    public void addThreeForTeamBRandom(View view) {

        int yesno = new Random().nextInt(3 - 1) + 1;
        if (yesno == 1)
            scoreTeamB = scoreTeamB + 3;
        addThreeTeamB = addThreeTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    //Random function +2 for team B
    public void addTwoForTeamBRandom(View view) {

        int yesno = new Random().nextInt(3 - 1) + 1;
        if (yesno == 1)
            scoreTeamB = scoreTeamB + 2;
        addTWoTeamB = addTWoTeamB + 1;
        displayForTeamB(scoreTeamB);
    }
}


