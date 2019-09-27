package com.codenjoy.dojo.tetris.model.figures;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.tetris.client.GlassBoard;

import java.util.ArrayList;
import java.util.List;

public class FSquare extends BasicFigure {

    @Override
    public List<Point> getPointsShouldBeFree(Point startPoint) {
        List<Point> result = new ArrayList<>();
        Point copy = startPoint.copy();
        result.add(copy);
        copy.change(Direction.RIGHT);
        result.add(copy.copy());
        return result;
    }

    private static FSquare mInstance;

    private FSquare() {
    }

    public static FSquare getInstance(GlassBoard board) {
        if (mInstance == null) {
            mInstance = new FSquare();
        }
        mInstance.setBoard(board);
        return mInstance;
    }

}
