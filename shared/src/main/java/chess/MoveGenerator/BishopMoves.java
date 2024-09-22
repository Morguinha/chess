package chess.MoveGenerator;

import chess.ChessPosition;
import chess.ChessMove;
import chess.ChessBoard;
import chess.ChessGame;

import java.util.HashSet;

public class BishopMoves implements calculadorXadrez {

    public static HashSet<ChessMove> getMoves(ChessBoard board, ChessPosition startPosition) {
        int startCol = startPosition.getColumn();
        int startRow = startPosition.getRow();
        int[][] bishopOptions = {{1,1},{1,-1},{-1,1},{-1,-1}};

        ChessGame.TeamColor team = board.whichTeam(startPosition);

        return calculadorXadrez.makeMoves(board, startPosition, bishopOptions, startRow, startCol, team);
    }
}
