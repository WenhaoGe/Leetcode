class Solution {
    public String tictactoe(int[][] moves) {

        char[][] board = new char[3][3];
        int index = 0;
        int count = 0;
        for (int[] move : moves) {

            if (index % 2 == 0) {
                board[move[0]][move[1]] = 'x';
            } else {
                board[move[0]][move[1]] = 'o';
            }
            index++;
            count++;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'x' && board[i][j] != 'o') {
                    board[i][j] = '*';
                }
            }
        }
        int row = 0;

        while (row < 3) {

            char c = board[row][0];

            if (board[row][1] == c && board[row][2] == c) {
                if (c == 'x') {
                    return "A";
                } else if (c == 'o') {
                    return "B";
                }
            }
            row++;
        }
        int col = 0;
        while (col < 3) {

            char c = board[0][col];

            if (board[1][col] == c && board[2][col] == c) {
                if (c == 'x') {
                    return "A";
                } else if (c == 'o') {
                    return "B";
                }
            }
            col++;
        }
        char c = board[0][0];

        if (c == board[2][2] && board[1][1] == c) {
            if (c == 'x') {
                return "A";
            } else if (c == 'o') {
                return "B";
            }
        }

        c = board[0][2];

        if (c == board[1][1] && c == board[2][0]) {
            if (c == 'x') {
                return "A";
            } else if (c == 'o') {
                return "B";
            }
        }

        if (count == 9) {
            return "Draw";
        } else {
            return "Pending";
        }

    }
}