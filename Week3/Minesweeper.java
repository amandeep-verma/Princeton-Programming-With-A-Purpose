/* *****************************************************************************
Minesweeper.java takes three integer command-line arguments m, n, and k and p
rints an m-by-n grid of cells with k mines, using asterisks for mines and integers
for the neighboring mine counts (with two space characters between each cell)
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        char[][] board = new char[m + 2][n + 2];

        for (int i = 0; i < k; i++) {
            int row = 1 + (int) (Math.random() * m);
            int col = 1 + (int) (Math.random() * n);
            if (board[row][col] == '*') {
                k++;
                continue;
            }
            board[row][col] = '*';
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (board[i][j] != '*') {
                    int count = 0;
                    for (int g = i - 1; g <= i + 1; g++) {
                        for (int h = j - 1; h <= j + 1; h++) {
                            if (board[g][h] == '*') {
                                count++;
                            }
                        }
                    }
                    board[i][j] = (char) (count + '0');
                }
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
