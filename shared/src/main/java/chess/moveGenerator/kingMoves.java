package chess.moveGenerator;

import chess.*;

import java.util.HashSet;

public class kingMoves implements masterMoves {
    public static HashSet<ChessMove> genMoves(ChessBoard board, ChessPosition startPos) {
        int startRow = startPos.getRow();
        int startCol = startPos.getColumn();
        int[][] moves = {{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};
        ChessGame.TeamColor team = board.colorTeam(startPos);

        return masterMoves.staticMove(board, moves, startPos, startRow, startCol, team);
    }
}
