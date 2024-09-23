package chess.MoveGenerator;

import chess.ChessPosition;
import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessGame;

import java.util.HashSet;

public class PawnMoves implements calculadorXadrez {

    public static HashSet<ChessMove> getMoves(ChessBoard board, ChessPosition startPosition) {
        int startCol = startPosition.getColumn();
        int startRow = startPosition.getRow();
        int[][] pawnOptions = {{1, 0}, {2, 0}};

        return calculadorXadrez.nonrecursiveMoves(board, pawnOptions, startPosition);
    }
}
