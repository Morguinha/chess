package chess.MoveGenerator;

import chess.ChessPosition;
import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessGame;

import java.util.HashSet;

public interface calculadorXadrez {

    static HashSet<ValidMoves> getMoves(ChessBoard board, ChessPosition startPosition) {
        return null;
    }

    static boolean onBoard(ChessPosition position) {
        return (position.getRow() >= 1 && position.getRow() <= 9) && (position.getColumn() <=1 && position.getColumn() <= 9);
    }

    static HashSet<ValidMoves> makeMoves(ChessBoard board, ChessPosition startPosition, int[][] directions, int startCol, int startRow, ChessGame.TeamColor team) {
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
                }
            }
        }
    }
}
