package com.example.tictactoeproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    // PLAYER REPRESENTAION
    //    0 -x
    //    1 -o

    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    // STATE REPRESENTATION
    //  0 -x
    //  1 -o
    //  2 -NULL

    int[][] winPositions ={{0,1,2}, {3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                               {0,4,8},{2,4,6}};

    public void playerTap(View view){ // view is input
        ImageView img = (ImageView)view;   // image view's variable
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if (!gameActive ){
            gameReset(view);
        }
        if(gameState[tappedImage] == 2 && gameActive ) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);



            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status= findViewById((R.id.status));
                status.setText("O's Turn to PLAY");

            }

            else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status= findViewById((R.id.status));
                status.setText("X's Turn to PLAY");


            }


            img.animate().translationYBy(1000f).setDuration(60);
        }
        for(int[] winPosition: winPositions){
           if (gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]] &&
            gameState[winPosition[0]]!=2)
            {

                String winnerStr;
               gameActive=false;
                if(gameState[winPosition[0]]==0){
                   winnerStr= "X has WON";
                    Toast.makeText(this, "Congratulation!!!  X has WON ", Toast.LENGTH_SHORT).show();
               }
               else {
                   winnerStr="O has WON";
                    Toast.makeText(this, "Congratulation!!!  O has WON ", Toast.LENGTH_SHORT).show();
               }
                TextView status= findViewById((R.id.status));
                status.setText(winnerStr);
            }
        }


    }

    public void gameReset(View view){
        gameActive = true;
        activePlayer =0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);

        TextView status= findViewById((R.id.status));
        status.setText("X's Turn  TAP to PLAY");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}