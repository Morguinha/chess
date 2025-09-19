package chess.moveGenerator;

import chess.ChessGame;
import chess.ChessPosition;

import java.util.HashSet;

public class bishopMoves implements masterMoves {
    public static HashSet<ChessMove> genMoves(ChessBoard board, ChessPosition startPos) {
        int startRow = startPos.getRow();
        int startCol = startPos.getColumn();
        int[][] moves = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        return masterMoves.recurseMove(board, moves, startPos, startRow, startCol, team);
    }
}
