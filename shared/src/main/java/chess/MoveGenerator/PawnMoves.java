package chess.MoveGenerator;

import chess.*;

import java.util.HashSet;

public class PawnMoves implements calculadorXadrez {

    public static HashSet<ChessMove> getMoves(ChessBoard board, ChessPosition startPosition) {
        HashSet<ChessMove> validMoves = HashSet.newHashSet(30);
        int startCol = startPosition.getColumn();
        int startRow = startPosition.getRow();
        int quantityMove = 0;
        if (board.whichTeam(startPosition) == ChessGame.TeamColor.WHITE) {
            quantityMove = 1;
        } else {
            quantityMove = -1;
        }
        ChessPiece.PieceType[] promotionOptions = new ChessPiece.PieceType[]{null};
        ChessGame.TeamColor team = board.whichTeam(startPosition);
        boolean promotion = (team == ChessGame.TeamColor.WHITE && startRow == 7) || (team == ChessGame.TeamColor.BLACK && startRow == 2);

        if (promotion) {
            promotionOptions = new ChessPiece.PieceType[]{ChessPiece.PieceType.QUEEN, ChessPiece.PieceType.BISHOP, ChessPiece.PieceType.KNIGHT, ChessPiece.PieceType.ROOK};
        }

        for (ChessPiece.PieceType promotionOption : promotionOptions) {
            ChessPosition moveFront = new ChessPosition(startRow + quantityMove, startCol);
            if (calculadorXadrez.onBoard(moveFront) && board.getPiece(moveFront) == null) {
                validMoves.add(new ChessMove(startPosition, moveFront, promotionOption));
            }
            ChessPosition frontLeft = new ChessPosition(startRow + quantityMove, startCol-1);
            if (calculadorXadrez.onBoard(frontLeft) && board.getPiece(frontLeft) != null && board.whichTeam(frontLeft) != team) {
                validMoves.add(new ChessMove(startPosition, frontLeft, promotionOption));
            }
            ChessPosition frontRight = new ChessPosition(startRow + quantityMove, startCol+1);
            if (calculadorXadrez.onBoard(frontRight) && board.getPiece(frontRight) != null && board.whichTeam(frontRight) != team) {
                validMoves.add(new ChessMove(startPosition, frontRight, promotionOption));
            }
            ChessPosition moveTwo = new ChessPosition(startRow + quantityMove*2, startCol);
            // better run time if check here rather than have a different variable that is changed to false, that then must be checked every time
            if (calculadorXadrez.onBoard(moveTwo) && ((board.whichTeam(startPosition) == ChessGame.TeamColor.WHITE && startRow == 2) ||
                    (board.whichTeam(startPosition) == ChessGame.TeamColor.BLACK && startRow == 7))
                    && board.getPiece(moveTwo) == null && board.getPiece(moveFront) == null) {
                validMoves.add(new ChessMove(startPosition, moveTwo, promotionOption));
            }
        }

        return validMoves;
    }
}
