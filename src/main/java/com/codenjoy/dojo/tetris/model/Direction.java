package com.codenjoy.dojo.tetris.model;

public enum  Direction {
    RIGHT,
    LEFT,
    DOWN;

    public static Direction random(){
        Direction[] directions = new Direction[]{RIGHT, LEFT};
        int rnd = (int) (Math.random()*directions.length);
        return directions[rnd];
    }
}
