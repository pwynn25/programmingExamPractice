package chess;

import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    private final ChessGame.TeamColor pieceColor;
    private Collection<ChessMove> validMoves;
    private PieceType pieceType;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.pieceType = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return pieceType;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ChessPiece that)) {
            return false;
        }
        return pieceColor == that.pieceColor && Objects.equals(validMoves, that.validMoves) && pieceType == that.pieceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, validMoves, pieceType);
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "pieceColor=" + pieceColor +
                ", validMoves=" + validMoves +
                ", pieceType=" + pieceType +
                '}';
    }
}
