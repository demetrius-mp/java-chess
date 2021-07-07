package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {

            // acima 1 casa
            p.setValues(this.position.getRow() - 1, this.position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // acima 2 casas
            p.setValues(this.position.getRow() - 2, this.position.getColumn());
            Position p2 = new Position(this.position.getRow() - 1, this.position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // diagonal esquerda
            p.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // diagonal direita
            p.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        else {
            // acima 1 casa
            p.setValues(this.position.getRow() + 1, this.position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // acima 2 casas
            p.setValues(this.position.getRow() + 2, this.position.getColumn());
            Position p2 = new Position(this.position.getRow() + 1, this.position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // diagonal esquerda
            p.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // diagonal direita
            p.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
    
}
