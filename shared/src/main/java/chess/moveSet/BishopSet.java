package chess.moveSet;

import chess.*;
import java.util.HashSet;

public class BishopSet {
    public static HashSet<ChessMove> generateMoves(ChessBoard board, ChessPosition position) {
        int currentCol = position.getColumn();
        int currentRow = position.getRow();
        int[][] possibleMoves = {{1,-1},{1,1},{-1,1},{-1,-1}};

        return MoveGenerator.recursiveMoves(board, position, possibleMoves, currentRow, currentCol);
    }
}
