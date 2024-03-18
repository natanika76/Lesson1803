package com.example.lesson1803;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button resultButton;
    public static Move firstPlayerChoice;
    public static Move secondPlayerChoice;
    public static Move thirdPlayerChoice;
    TextView resultTextView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultButton = (Button) findViewById(R.id.resultButton);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 33) {
                    loadFragment(new Player1Fragment());
                }
                else if(progress > 33 && progress < 66){
                    loadFragment(new Player2Fragment());
                }
                else if(progress > 66){
                    loadFragment(new Player3Fragment());
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstPlayerChoice == null || secondPlayerChoice == null || thirdPlayerChoice == null){
                    resultTextView.setText("Не выбран ход");
                    return;
                }
                if (firstPlayerChoice.equals(secondPlayerChoice) && firstPlayerChoice.equals(thirdPlayerChoice)) {
                    resultTextView.setText("Ничья");
                    return;
                }

                if ((firstPlayerChoice.equals(Move.ROCK) && secondPlayerChoice.equals(Move.SCISSORS) && thirdPlayerChoice.equals(Move.SCISSORS))
                        || (firstPlayerChoice.equals(Move.SCISSORS) && secondPlayerChoice.equals(Move.PAPER) && thirdPlayerChoice.equals(Move.PAPER))
                        || (firstPlayerChoice.equals(Move.PAPER) && secondPlayerChoice.equals(Move.ROCK) && thirdPlayerChoice.equals(Move.ROCK))){
                    resultTextView.setText("Победил 1");
                }
                if ((secondPlayerChoice.equals(Move.ROCK) && firstPlayerChoice.equals(Move.SCISSORS) && thirdPlayerChoice.equals(Move.SCISSORS))
                        || (secondPlayerChoice.equals(Move.SCISSORS) && firstPlayerChoice.equals(Move.PAPER) && thirdPlayerChoice.equals(Move.PAPER))
                        || (secondPlayerChoice.equals(Move.PAPER) && firstPlayerChoice.equals(Move.ROCK) && thirdPlayerChoice.equals(Move.ROCK))){
                    resultTextView.setText("Победил 2");
                }
                if ((thirdPlayerChoice.equals(Move.ROCK) && secondPlayerChoice.equals(Move.SCISSORS) && firstPlayerChoice.equals(Move.SCISSORS))
                        || (thirdPlayerChoice.equals(Move.SCISSORS) && secondPlayerChoice.equals(Move.PAPER) && firstPlayerChoice.equals(Move.PAPER))
                        || (thirdPlayerChoice.equals(Move.PAPER) && secondPlayerChoice.equals(Move.ROCK) && firstPlayerChoice.equals(Move.ROCK))){
                    resultTextView.setText("Победил 3");
                }
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
