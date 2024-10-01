package chess.MoveGenerator;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;
import chess.ChessGame;

import java.util.HashSet;

public class QueenMoves implements calculadorXadrez {
    public static HashSet<ChessMove> getMoves(ChessBoard board, ChessPosition startPosition) {
        int startCol = startPosition.getColumn();
        int startRow = startPosition.getRow();
        int[][] queenOptions = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};

        ChessGame.TeamColor team = board.whichTeam(startPosition);

        return calculadorXadrez.recursiveMoves(board, startPosition, queenOptions, startRow, startCol, team);
    }
}
