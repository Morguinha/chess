package chess.moveGenerator;

import chess.*;

import java.util.HashSet;

public class queenMoves implements masterMoves {
    public static HashSet<ChessMove> genMoves(ChessBoard board, ChessPosition startPos) {
        int startRow = startPos.getRow();
        int startCol = startPos.getColumn();
        int[][] moves = {{1, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, 0}, {-1, 1}, {-1, -1}};
        ChessGame.TeamColor team = board.turn(startPos);

        return masterMoves.recurseMove(board, moves, startPos, startRow, startCol, team);
    }
}
