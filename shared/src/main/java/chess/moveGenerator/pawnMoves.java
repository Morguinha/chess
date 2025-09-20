package chess.moveGenerator;

import chess.*;

import java.util.Collection;
import java.util.HashSet;

public class pawnMoves implements masterMoves {
    public static HashSet<ChessMove> genMoves(ChessBoard board, ChessPosition startPos) {
        HashSet<ChessMove> possibleMoves = HashSet.newHashSet(9);
        int startRow = startPos.getRow();
        int startCol = startPos.getColumn();
        ChessGame.TeamColor team = board.turn(startPos);
        int direction = 1;
        if (board.turn(startPos) == ChessGame.TeamColor.BLACK) {
            direction = -1;
        }
        ChessPiece.PieceType[] promotionPieces = new ChessPiece.PieceType[]{null};
        boolean canPromote = (team == ChessGame.TeamColor.BLACK && startRow == 2) || (team == ChessGame.TeamColor.WHITE && startRow == 7);
        if (canPromote) {
            promotionPieces = new ChessPiece.PieceType[]{ChessPiece.PieceType.KNIGHT, ChessPiece.PieceType.QUEEN, ChessPiece.PieceType.ROOK, ChessPiece.PieceType.BISHOP};
        }

        for (ChessPiece.PieceType promotionPiece : promotionPieces) {
            ChessPosition moveTwo = new ChessPosition(startRow + direction)
        }
    }
}
