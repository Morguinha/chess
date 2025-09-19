package chess.moveGenerator;

import chess.*;

import java.util.HashSet;

public class knightMoves implements masterMoves {
    public static HashSet<ChessMove> genMoves(ChessBoard board, ChessPosition startPos) {
        int startRow = startPos.getRow();
        int startCol = startPos.getColumn();
        int[][] moves = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
        ChessGame.TeamColor team = board.turn(startPos);

        return masterMoves.staticMove(board, moves, startPos, startRow, startCol, team);
    }
}
