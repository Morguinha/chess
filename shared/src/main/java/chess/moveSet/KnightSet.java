package chess.moveSet;

import chess.*;
import java.util.HashSet;

public class KnightSet {
    public static HashSet<ChessMove> generateMoves(ChessBoard board, ChessPosition position) {
        int currentRow = position.getRow();
        int currentCol = position.getColumn();
        ChessGame.TeamColor color = board.teamOfSquare(position);
        int[][] possibleMoves = {{2,-1},{2,1},{1,-2},{1,2},{-1,-2},{-1,2},{-2,-1},{-2,1}};

        return MoveGenerator.singleMoves(board, position, possibleMoves, currentRow, currentCol, color);
    }
}
