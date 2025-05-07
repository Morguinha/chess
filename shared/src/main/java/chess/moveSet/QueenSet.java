package chess.moveSet;

import chess.*;
import java.util.HashSet;

public class QueenSet {
    public static HashSet<ChessMove> generateMoves(ChessBoard board, ChessPosition position) {
        int currentRow = position.getRow();
        int currentCol = position.getColumn();
        ChessGame.TeamColor color = board.teamOfSquare(position);
        int[][] possibleMoves = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};

        return MoveGenerator.recursiveMoves(board, position, possibleMoves, currentRow, currentCol, color);
    }
}
