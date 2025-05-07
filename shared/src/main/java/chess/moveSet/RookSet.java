package chess.moveSet;

import chess.*;
import java.util.HashSet;

public class RookSet {
    public static HashSet<ChessMove> generateMoves(ChessBoard board, ChessPosition position) {
        int currentRow = position.getRow();
        int currentCol = position.getColumn();
        ChessGame.TeamColor team = board.teamOfSquare(position);
        int[][] possibleMoves = {{1,0},{0,-1},{0,1},{-1,0}};

        return MoveGenerator.recursiveMoves(board, position, possibleMoves, currentRow, currentCol, team);
    }
}
