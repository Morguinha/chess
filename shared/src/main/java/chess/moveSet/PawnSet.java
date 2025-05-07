package chess.moveSet;

import chess.*;
import java.util.HashSet;

public class PawnSet {
    public static HashSet<ChessMove> generateMoves(ChessBoard board, ChessPosition position) {
        int currentRow = position.getRow();
        int currentCol = position.getColumn();
        ChessGame.TeamColor color = board.teamOfSquare(position);
        ChessPiece.PieceType[] pawnPieces = new ChessPiece.PieceType[]{null};
        int moveDirection;
        if (color == ChessGame.TeamColor.WHITE) {
            moveDirection = 1;
        }
        else {moveDirection = -1;}
        boolean promotion = (color == ChessGame.TeamColor.WHITE && currentRow == 7) || (color == ChessGame.TeamColor.BLACK && currentRow == 2);

        if (promotion) {
            pawnPieces = new ChessPiece.PieceType[] {ChessPiece.PieceType.BISHOP, ChessPiece.PieceType.KNIGHT, ChessPiece.PieceType.QUEEN, ChessPiece.PieceType.ROOK};
        }

        HashSet<ChessMove> moves = HashSet.newHashSet(20);
        for (ChessPiece.PieceType pawnPiece : pawnPieces) {
            ChessPosition moveForward = new ChessPosition(currentRow + moveDirection, currentCol);
            if (MoveGenerator.onBoard(moveForward) && (board.getPiece(moveForward) == null)) {
                moves.add(new ChessMove(position, moveForward, pawnPiece));
            }
            ChessPosition moveLeft = new ChessPosition(currentRow + moveDirection, currentCol-1);
            if (MoveGenerator.onBoard(moveLeft) && (board.teamOfSquare(moveLeft) != color) && (board.getPiece(moveLeft) != null)) {
                moves.add(new ChessMove(position, moveLeft, pawnPiece));
            }
            ChessPosition moveRight = new ChessPosition(currentRow + moveDirection, currentCol+1);
            if (MoveGenerator.onBoard(moveRight) && (board.teamOfSquare(moveRight) != color) && (board.getPiece(moveRight) != null)) {
                moves.add(new ChessMove(position, moveRight, pawnPiece));
            }

            ChessPosition moveTwo = new ChessPosition(currentRow + moveDirection*2, currentCol);
            if (MoveGenerator.onBoard(moveTwo) && ((color == ChessGame.TeamColor.WHITE && currentRow == 2) || (color == ChessGame.TeamColor.BLACK && currentRow == 7)) && (board.getPiece(moveForward) == null) && (board.getPiece(moveTwo) == null)) {
                moves.add(new ChessMove(position, moveTwo, pawnPiece));
            }
        }
        return moves;
    }
}
