package com.example.lesson1803;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Player3Fragment extends Fragment {

    RadioButton paperRadioButton, scissorsRadioButton, stoneRadioButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player3, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        paperRadioButton = getView().findViewById(R.id.Player3PaperRadioButton);
        scissorsRadioButton = getView().findViewById(R.id.Player3ScissorsRadioButton);
        stoneRadioButton = getView().findViewById(R.id.Player3StoneRadioButton);
        paperRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.thirdPlayerChoice = Move.PAPER;
            }
        });
        scissorsRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.thirdPlayerChoice = Move.SCISSORS;
            }
        });
        stoneRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.thirdPlayerChoice = Move.ROCK;
            }
        });
    }
}