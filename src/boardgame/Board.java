package boardgame;

import boardgame.exception.BoardException;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {

        if (rows < 1 || columns < 1){
            throw new BoardException("Error, a quantidade de linhas e colunas devem ser maiores que 0");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[this.rows][this.columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){

        return pieces[row][column];
    }

    public Piece piece(Position position){

        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){

        if (thereAPiece(position)){
            throw new BoardException("Já existe uma peça nesta posição: "+position);
        }
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece remocePiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Esta posição não existe");
        }
        if (piece(position) == null){
            return null;
        }

        Piece aux = piece(position);

        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    private boolean positionExists(int row, int column){

        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }

    public boolean positionExists(Position position){

        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereAPiece(Position position){

        if (!positionExists(position)){
            throw new BoardException("Esta posição não existe");
        }
        return piece(position) != null;
    }
}
