package chess.moveSet;

import chess.*;
import java.util.HashSet;

public class KingSet {
    public static HashSet<ChessMove> generateMoves(ChessBoard board, ChessPosition position) {
        int currentCol = position.getColumn();
        int currentRow = position.getRow();
        int[][] possibleMoves = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        ChessGame.TeamColor color = board.teamOfSquare(position);

        return MoveGenerator.singleMoves(board, position, possibleMoves, currentRow, currentCol, color);
    }
}
