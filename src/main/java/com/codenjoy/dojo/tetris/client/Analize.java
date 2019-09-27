package com.codenjoy.dojo.tetris.client;

import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.tetris.model.Command;
import com.codenjoy.dojo.tetris.model.Direction;
import com.codenjoy.dojo.tetris.model.Elements;
import com.codenjoy.dojo.tetris.model.figures.BasicFigure;
import com.codenjoy.dojo.tetris.model.figures.FigureFabric;

public class Analize {
    private Board board = null;
    FigureFabric fabric = new FigureFabric();

    public String getNextMove() {
        Elements current = board.getCurrentFigureType();
        BasicFigure currentFigure = fabric.getFigureObject(current, board.getGlass());
        Point currentFigurePoint = board.getCurrentFigurePoint();
        Point pointToMove = getPointToMove(currentFigure);
        if (pointToMove != null) {
            return getCommandForBias(currentFigurePoint, pointToMove) + ", " +Command.goDown();
        } else return getRandomMove();

    }

    private String getRandomMove() {
        int rnd = (int) (Math.random() * 7) + 1;

        return Command.go(Direction.random(), rnd);
    }


    private Point getPointToMove(BasicFigure figure) {
        Point point = board.getCurrentFigurePoint();
        GlassBoard glass = board.getGlass();
        point.setX(0);
        point.setY(0);
        while (true) {
            if (glass.isOutOfField(point.getX(), point.getY())) break;
            if (glass.isFree(point.getX(), point.getY())) if (figure.isGoodPoint(point)) return point;
            point.change(com.codenjoy.dojo.services.Direction.RIGHT);
            if (glass.isOutOfField(point.getX(), point.getY())) {
                point.setX(0);
                point.change(com.codenjoy.dojo.services.Direction.UP);
            }
        }
        return null;
    }

    private String getCommandForBias(Point current, Point target) {
        int bias = target.getX() - current.getX();
        if (bias > 0) return Command.go(Direction.RIGHT, Math.abs(bias));
        if (bias < 0) return Command.go(Direction.LEFT, Math.abs(bias));
        else return "";
    }

    public void acceptAndAnalizeBoard(Board board) {
        this.board = board;


    }


}
