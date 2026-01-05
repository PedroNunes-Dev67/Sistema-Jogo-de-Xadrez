package chess;

import boardgame.Position;
import chess.exception.ChessException;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(int row, char column){
        if (column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Error, não foi possível inicializar a partida.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition(8 - position.getRow(), (char) ('a' + position.getColumn()));
    }

    @Override
    public String toString() {
        return ""+column+row;
    }
}
