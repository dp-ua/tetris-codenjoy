package com.codenjoy.dojo.tetris.model.figures;

import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.tetris.client.GlassBoard;

import java.util.List;

public abstract class BasicFigure {
    protected GlassBoard board;

    public void setBoard(GlassBoard board) {
        this.board = board;
    }

    public boolean isGoodPoint(Point point) {
        List<Point> pointsShouldBeFree = getPointsShouldBeFree(point);
        for (Point p : pointsShouldBeFree) {
            if (!board.isFree(p.getX(), p.getY())) return false;
        }
        return true;
    }

    public abstract List<Point> getPointsShouldBeFree(Point startPoint);

}

