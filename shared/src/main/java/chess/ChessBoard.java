package chess;

import java.util.Arrays;
import java.util.Objects;

import static chess.ChessGame.TeamColor.BLACK;
import static chess.ChessGame.TeamColor.WHITE;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    private ChessPiece[][] squares = new ChessPiece[8][8];
    public ChessBoard() {
        
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        squares[position.getRow()-1][position.getColumn()-1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow()-1][position.getColumn()-1];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        clearBoard();
        ChessGame.TeamColor white = WHITE;
        ChessGame.TeamColor black = BLACK;
        addPiece(new ChessPosition(1,1),new ChessPiece(white, ChessPiece.PieceType.ROOK));
        addPiece(new ChessPosition(1,2),new ChessPiece(white, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(1,3),new ChessPiece(white, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(1,4),new ChessPiece(white, ChessPiece.PieceType.QUEEN));
        addPiece(new ChessPosition(1,5),new ChessPiece(white, ChessPiece.PieceType.KING));
        addPiece(new ChessPosition(1,6),new ChessPiece(white, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(1,7),new ChessPiece(white, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(1,8),new ChessPiece(white, ChessPiece.PieceType.ROOK));


        for(int i = 1; i <= squares[1].length; i++) {
            addPiece(new ChessPosition(2,i),new ChessPiece(white, ChessPiece.PieceType.PAWN));
        }
        // add the black pieces
        addPiece(new ChessPosition(8,1),new ChessPiece(black, ChessPiece.PieceType.ROOK));
        addPiece(new ChessPosition(8,2),new ChessPiece(black, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(8,3),new ChessPiece(black, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(8,4),new ChessPiece(black, ChessPiece.PieceType.QUEEN));
        addPiece(new ChessPosition(8,5),new ChessPiece(black, ChessPiece.PieceType.KING));
        addPiece(new ChessPosition(8,6),new ChessPiece(black, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(8,7),new ChessPiece(black, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(8,8),new ChessPiece(black, ChessPiece.PieceType.ROOK));

        for(int i = 1; i <= squares[6].length; i++) {
            addPiece(new ChessPosition(7,i),new ChessPiece(BLACK, ChessPiece.PieceType.PAWN));
        }

    }
    public void clearBoard() {
        for(int i = 0; i < 8; i++) {
            for(int b = 0; b < 8; b++) {
                squares[i][b] = null;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(squares, that.squares);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(squares);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 7; i >= 0; i--) {
            for(int b = 0; b < 8; b++) {
                sb.append(squares[i][b]).append(" | ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
