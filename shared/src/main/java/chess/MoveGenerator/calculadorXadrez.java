package chess.MoveGenerator;

import chess.ChessPosition;
import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessGame;

import java.util.HashSet;

public interface calculadorXadrez {

    static HashSet<ChessMove> getMoves(ChessBoard board, ChessPosition startPosition) {
        return null;
    }

    static boolean onBoard(ChessPosition position) {
        return (position.getRow() >= 1 && position.getRow() <= 8) &&
                (position.getColumn() >= 1 && position.getColumn() <= 8);
    }

    static HashSet<ChessMove> recursiveMoves(ChessBoard board, ChessPosition startPosition, int[][] directions, int startCol, int startRow, ChessGame.TeamColor team) {
        HashSet<ChessMove> actualMoves = HashSet.newHashSet(28);
        for (int[] direction : directions) {
            boolean blocked = false;
            int j = 1;
            while (!blocked) {
                ChessPosition potentialMove = new ChessPosition(startRow + direction[1]*j, startCol + direction[0]*j);
                if(!onBoard(potentialMove)) {
                    blocked = true;
                }
                else if (board.whichTeam(potentialMove) == team) {
                    blocked = true;
                }
                else if (board.whichTeam(potentialMove) != team) {
                    actualMoves.add(new ChessMove(startPosition, potentialMove, null));
                    blocked = true;
                }
                else if (board.getPiece(potentialMove) == null) {
                    actualMoves.add(new ChessMove(startPosition, potentialMove, null));
                }
                else {
                    blocked = true;
                }
                j++;
            }
        }
        return actualMoves;
    }

    static HashSet<ChessMove> nonrecursiveMoves(ChessBoard board, int[][] pieceMoves, ChessPosition startPosition) {
        HashSet<ChessMove> validMoves = HashSet.newHashSet(10);
        int startCol = startPosition.getColumn();
        int startRow = startPosition.getRow();
        ChessGame.TeamColor team = board.whichTeam(startPosition);
        for (int[] pieceMove : pieceMoves) {
            ChessPosition potentialMove = new ChessPosition(startRow + pieceMove[1], startCol + pieceMove[0]);
            if (board.whichTeam(potentialMove) != team && onBoard(potentialMove)) {
                validMoves.add(new ChessMove(startPosition, potentialMove, null));
            }
        }
        return validMoves;
    }
}
