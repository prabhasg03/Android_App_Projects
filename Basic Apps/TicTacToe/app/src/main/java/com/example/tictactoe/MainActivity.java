package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int currentPlayer = 0; // 0: O, 1: X
    private boolean gameActive = true;
    private static int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2}; // 0: O, 1: X, 2: Empty
    private final int[][] winningPositions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    public void ontap(View view) {
        ImageView tappedImageView = (ImageView) view;
        int tappedPosition = Integer.parseInt(tappedImageView.getTag().toString());
        if (gameState[tappedPosition] == 2 && gameActive) {
            TextView statusTextView = findViewById(R.id.tv);
            tappedImageView.setTranslationY(-1000);
            if (++currentPlayer > 1) {
                currentPlayer = 0;
            }
            gameState[tappedPosition] = currentPlayer;
            if (currentPlayer == 0) {
                tappedImageView.setImageResource(R.drawable.o);
                statusTextView.setText("X's Turn");
            } else {
                tappedImageView.setImageResource(R.drawable.x);
                statusTextView.setText("O's Turn");
            }
            tappedImageView.animate().translationYBy(1000).setDuration(200);
            for (int[] winningPosition : winningPositions) {
                if ((gameState[winningPosition[0]] == gameState[winningPosition[1]]) &&
                        (gameState[winningPosition[1]] == gameState[winningPosition[2]]) &&
                        (gameState[winningPosition[0]] != 2)) {
                    gameActive = false;
                    statusTextView.setText((gameState[winningPosition[0]] == 0) ? "O has won" : "X has won");
                    break;
                }
            }
            if (currentPlayer == 1 && gameActive) {
                boolean isDraw = true;
                for (int i : gameState) {
                    if (i == 2) {
                        isDraw = false;
                        break;
                    }
                }
                if (isDraw) {
                    gameActive = false;
                    statusTextView.setText("It's a Draw");
                }
            }
        }
        if (!gameActive) {
            Button playAgainButton = findViewById(R.id.bt);
            playAgainButton.setVisibility(View.VISIBLE);
        }
    }
    public void playAgain(View view){
        Button playAgainButton = findViewById(R.id.bt);
        playAgainButton.setVisibility(View.INVISIBLE);
        TextView statusTextView = findViewById(R.id.tv);
        statusTextView.setText("O's Turn");
        gameActive = true;
        currentPlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.iv0)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.iv1)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.iv2)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.iv3)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.iv4)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.iv5)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.iv6)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.iv7)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.iv8)).setImageDrawable(null);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play=findViewById(R.id.bt);
        play.setVisibility(View.INVISIBLE);
    }
}