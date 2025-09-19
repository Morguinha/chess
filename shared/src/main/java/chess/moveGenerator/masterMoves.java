package chess.moveGenerator;

import chess.*;

import java.util.HashSet;

public interface masterMoves {
    static boolean onBoard(ChessPosition position) {
        return (position.getRow() >= 1 && position.getRow() <= 8) && (position.getColumn() >= 1 && position.getColumn() <= 8);
    }

    static HashSet<ChessMove> recurseMove(ChessBoard board, int[][] direction, ChessPosition startPosition, int startRow, int startCol, ChessGame.TeamColor team) {
        HashSet<ChessMove> possibleMoves = HashSet.newHashSet(27);
        for (int[] direct : direction) {
            int i = 1;
            boolean blocked = false;
            while (!blocked) {
                ChessPosition nextMove = new ChessPosition(startRow + direct[0] * i, startCol + direct[1] * i);
                if (!onBoard(nextMove)) {
                    blocked = true;
                } else if (board.turn(nextMove) == team) {
                    blocked = true;
                } else if (board.turn(nextMove) == null) {
                    possibleMoves.add(new ChessMove(startPosition, nextMove, null));
                } else if (board.turn(nextMove) != team) {
                    possibleMoves.add(new ChessMove(startPosition, nextMove, null));
                    blocked = true;
                } else {
                    blocked = true;
                }
                i++;
            }
        }
        return possibleMoves;
    }

    static HashSet<ChessMove> staticMove(ChessBoard board, int[][] direction, ChessPosition startPosition, int startRow, int startCol, ChessGame.TeamColor team) {
        HashSet<ChessMove> possibleMoves = HashSet.newHashSet(9);
        for (int[] direct : direction) {
            ChessPosition nextMove = new ChessPosition(startRow + direct[0], startCol + direct[1]);
            if (onBoard(nextMove) && board.turn(nextMove) != team) {
                possibleMoves.add(new ChessMove(startPosition, nextMove, null));
            }
        }

        return possibleMoves;
    }
}
