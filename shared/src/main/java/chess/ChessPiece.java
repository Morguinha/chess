package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import chess.MoveGenerator.*;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
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
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        /* Have a switch, which then goes into which case has the right piece.
        Seperate program files for each piece case, which checks if move is allowed, then adds the move to an array
        Passed in is the board, and the position on the board
         */

        return switch (type) {
            case KING -> KingMoves.getMoves(board, myPosition);
            case QUEEN -> QueenMoves.getMoves(board, myPosition);
            case BISHOP -> BishopMoves.getMoves(board, myPosition);
            case KNIGHT -> KnightMoves.getMoves(board, myPosition);
            case ROOK -> RookMoves.getMoves(board, myPosition);
            case PAWN -> PawnMoves.getMoves(board, myPosition);
        };
    }
}
