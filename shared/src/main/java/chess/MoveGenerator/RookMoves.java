package chess.MoveGenerator;

import chess.ChessGame;
import chess.ChessPosition;
import chess.ChessBoard;
import chess.ChessMove;

import java.util.HashSet;

public class RookMoves implements calculadorXadrez {
    public static HashSet<ChessMove> getMoves(ChessBoard board, ChessPosition startPosition) {
        int startRow = startPosition.getRow();
        int startCol = startPosition.getColumn();
        int[][] rookOptions = {{1,0},{-1,0},{0,1},{0,-1}};

        ChessGame.TeamColor team = board.whichTeam(startPosition);

        return calculadorXadrez.recursiveMoves(board, startPosition, rookOptions, startCol, startRow, team);
    }
}
