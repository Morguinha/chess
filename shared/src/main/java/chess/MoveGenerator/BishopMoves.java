package chess.MoveGenerator;

import chess.ChessPosition;
import chess.ChessMove;
import chess.ChessBoard;
import chess.ChessGame;

import java.util.HashSet;

public class BishopMoves implements calculadorXadrez {

    public static HashSet<ValidMoves> getMoves(ChessBoard board, ChessPosition startPosition) {
        int startCol = startPosition.getColumn();
        int startRow = startPosition.getRow();
        double[][] bishopOptions = {{-1.1},{1,1},{1,-1},{-1,-1}};

        ChessGame.TeamColor team = board.getTeam(startPosition);

        return calculadorXadrez.makeMoves(board, startPosition, bishopOptions, startRow, startCol, team);
    }
}
