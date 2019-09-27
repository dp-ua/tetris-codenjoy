package com.codenjoy.dojo.tetris.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
//    DOWN -
//    приземление фигурки;
//    ACT -
//    вращение фигурки
//    по часовой
//    стрелке на 90градусов;
//
//    ACT(2) -
//    вращение на 180градусов;
//
//    ACT(3) -
//    вращение против
//    часовой стрелки
//    на 90градусов;
//
//    ACT(0,0) -
//
//    обнуление стакана(как и при его переполнении будут сняты штрафные очки).

    public String reset() {
        return "ACT(0,0)";
    }

    public static String rotate(Direction direction) {
        switch (direction) {
            case RIGHT:
                return "ACT";
            case LEFT:
                return "ACT(3)";
            case DOWN:
                return "ACT(2)";
            default:
                return "ACT(2),ACT(2)";
        }
    }


    public static String go(Direction direction, int count) {
        if (count < 0) throw new IllegalArgumentException("count must be more than 0");
        List<Direction> moves = new ArrayList<>();
        for (int i = 0; i < count; i++) moves.add(direction);
        String chString = moves.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return chString;
    }

    public static String go(Direction direction) {
        return direction.toString();
    }

    public static String goLeft() {
        return go((Direction.LEFT));
    }

    public static String goRight() {
        return go(Direction.RIGHT);
    }

    public static String goDown() {
        return go(Direction.DOWN);
    }
}
