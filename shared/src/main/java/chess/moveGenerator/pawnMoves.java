package chess.moveGenerator;

import chess.*;

import java.util.HashSet;

public class pawnMoves implements masterMoves {
    public static HashSet<ChessMove> genMoves(ChessBoard board, ChessPosition startPos) {
        HashSet<ChessMove> possibleMoves = HashSet.newHashSet(9);
        int startRow = startPos.getRow();
        int startCol = startPos.getColumn();
        ChessGame.TeamColor team = board.colorTeam(startPos);
        int direction = 1;
        if (board.colorTeam(startPos) == ChessGame.TeamColor.BLACK) {
            direction = -1;
        }
        ChessPiece.PieceType[] promotionPieces = new ChessPiece.PieceType[]{null};
        boolean canPromote = (team == ChessGame.TeamColor.BLACK && startRow == 2) || (team == ChessGame.TeamColor.WHITE && startRow == 7);
        if (canPromote) {
            promotionPieces = new ChessPiece.PieceType[]{ChessPiece.PieceType.KNIGHT, ChessPiece.PieceType.QUEEN, ChessPiece.PieceType.ROOK, ChessPiece.PieceType.BISHOP};
        }

        for (ChessPiece.PieceType promotionPiece : promotionPieces) {
            ChessPosition moveTwo = new ChessPosition(startRow + direction * 2, startCol);
            ChessPosition moveOne = new ChessPosition(startRow + direction, startCol);
            ChessPosition moveLeft = new ChessPosition(startRow + direction, startCol - 1);
            ChessPosition moveRight = new ChessPosition(startRow + direction, startCol + 1);
            if (masterMoves.onBoard(moveOne) && board.colorTeam(moveOne) == null) {
                possibleMoves.add(new ChessMove(startPos, moveOne, promotionPiece));
            }
            if (board.colorTeam(startPos) == ChessGame.TeamColor.WHITE && startRow == 2 && board.colorTeam(moveTwo) == null && board.colorTeam(moveOne) == null ||
                    board.colorTeam(startPos) == ChessGame.TeamColor.BLACK && startRow == 7 && board.colorTeam(moveTwo) == null && board.colorTeam(moveOne) == null) {
                possibleMoves.add(new ChessMove(startPos, moveTwo, promotionPiece));
            }
            if (masterMoves.onBoard(moveLeft) && board.colorTeam(moveLeft) != team && board.getPiece(moveLeft) != null) {
                possibleMoves.add(new ChessMove(startPos, moveLeft, promotionPiece));
            }
            if (masterMoves.onBoard(moveRight) && board.colorTeam(moveRight) != team && board.getPiece(moveRight) != null) {
                possibleMoves.add(new ChessMove(startPos, moveRight, promotionPiece));
            }
        }
        return possibleMoves;
    }
}
