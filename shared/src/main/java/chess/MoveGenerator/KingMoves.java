package chess.MoveGenerator;

import chess.ChessPosition;
import chess.ChessGame;
import chess.ChessBoard;
import chess.ChessMove;

import java.util.HashSet;

public class KingMoves implements calculadorXadrez {

    public static HashSet<ChessMove> getMoves(ChessBoard board, ChessPosition startPosition) {
        int[][] kingOptions = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        return calculadorXadrez.nonrecursiveMoves(board, kingOptions, startPosition);
    }
}
