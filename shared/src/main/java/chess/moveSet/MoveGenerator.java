package chess.moveSet;

import chess.*;
import java.util.HashSet;

public class MoveGenerator {

    static HashSet<ChessMove> recursiveMoves(ChessBoard board, ChessPosition position, int[][] possibleMoves, int currentRow, int currentCol) {
        HashSet<ChessMove> moves = HashSet.newHashSet(30);
        for (int[] direction : possibleMoves) {
            boolean blocked = false;
            int i = 1;
            while (!blocked) {
                ChessPosition nextPosition = new ChessPosition(currentRow + direction[1]*i, currentCol + direction[0]*i);
                if (!MoveGenerator.onBoard(nextPosition)) {
                    blocked = true;
                }
                else if (board.getPiece(nextPosition) == null) {
                    moves.add(new ChessMove(position, nextPosition, null));
                }
            }
        }
        return moves;
    }

    static HashSet<ChessMove> singleMoves() {
        return null;
    }

    static boolean onBoard(ChessPosition position) {
        return (position.getRow() >=1 && position.getColumn() <=8) && (position.getColumn() >=1 && position.getRow() <=8);
    }
}
