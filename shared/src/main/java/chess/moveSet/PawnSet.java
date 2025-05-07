package chess.moveSet;

import chess.*;
import java.util.HashSet;

public class PawnSet {
    public static HashSet<ChessMove> generateMoves(ChessBoard board, ChessPosition position) {
        int currentRow = position.getRow();
        int currentCol = position.getColumn();
        ChessGame.TeamColor color = board.teamOfSquare(position);
        ChessPiece.PieceType[] promotionType = new ChessPiece.PieceType[]{null};
        if (color == ChessGame.TeamColor.WHITE) {
            int moveDirection = 1;
        }
        else {int moveDirection = -1;}
        boolean promotion = (color == ChessGame.TeamColor.WHITE && currentRow == 7) || (color == ChessGame.TeamColor.BLACK && currentRow == 2);
        if (promotion) {
            promotionType = new ChessPiece.PieceType[] {ChessPiece.PieceType.BISHOP, ChessPiece.PieceType.KNIGHT, ChessPiece.PieceType.QUEEN, ChessPiece.PieceType.ROOK};
        }

    }
}
