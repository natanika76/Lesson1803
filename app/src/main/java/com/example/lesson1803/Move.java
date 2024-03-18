package com.example.lesson1803;

public enum Move {
    ROCK("Камень"),
    PAPER("Бумага"),
    SCISSORS("Ножницы");

    private String value;
    Move(String value) {
        this.value = value;
    }
}
