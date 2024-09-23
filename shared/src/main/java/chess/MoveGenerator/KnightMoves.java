package chess.MoveGenerator;

import chess.ChessPosition;
import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;

import java.util.HashSet;

public class KnightMoves implements calculadorXadrez {

    public static HashSet<ChessMove> getMoves(ChessBoard board, ChessPosition startPosition) {
        int[][] knightOptions = {{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2}};
        return calculadorXadrez.nonrecursiveMoves(board, knightOptions, startPosition);
    }
}
