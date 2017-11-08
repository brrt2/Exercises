public class TicTacToe {
    private static final int SIZE=3;
    private Character[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};

    private char lastPlayer ='\0';

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if (isWin(x, y)) {
            return "Wygral " + lastPlayer ;
        } else if (isDraw()) {
            return "Wynik remisowy";
        } else {
            return "Brak zwyciezcy";
        }
    }

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * SIZE;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for (int i = 0; i < SIZE; i++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }
        if (horizontal == playerTotal
                || vertical == playerTotal
                || diagonal1 == playerTotal
                || diagonal2 == playerTotal) {
            return true;
        }
        return false;
    }

    
    private void checkAxis(int liczba) {
        if (liczba < 1 || liczba > 3) {
            throw new RuntimeException("Podany argument nie miesci sie w planszy !");
        }
    }

    private void setBox(int x, int y,char lastPlayer){
        if(board[x-1][y-1]!='\0'){
            throw new RuntimeException("To pole jest zajete");
        }else {
            board[x-1][y-1]=lastPlayer;
        }
    }

    public char nextPlayer() {
        if(lastPlayer =='X'){
            return '0';
        }
        return 'X';
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

}
