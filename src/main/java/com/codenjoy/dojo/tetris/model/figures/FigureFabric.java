package com.codenjoy.dojo.tetris.model.figures;

import com.codenjoy.dojo.tetris.client.GlassBoard;
import com.codenjoy.dojo.tetris.model.Elements;

public class FigureFabric {
    public BasicFigure getFigureObject(Elements element, GlassBoard board){
        switch (element){
            case YELLOW:
                return FSquare.getInstance(board);

            case BLUE:
            case CYAN:
            case ORANGE:
            case GREEN:
            case PURPLE:
            case RED:
            case NONE:
            default:
                throw new IllegalStateException("Unexpected value: " + element);
        }
    }
}
