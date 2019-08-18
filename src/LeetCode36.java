/*
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */

public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 得到这个数字
                    int num = board[i][j] - '1';
                    // 得到当前属于哪个块
                    int blockIndex = (i / 3) * 3 + j / 3;
                    // 判断一行或一列或一个块的这个数字(num)是否已经出现过
                    if (row[i][num] || column[j][num] || block[blockIndex][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    column[j][num] = true;
                    block[blockIndex][num] = true;
                }
            }
        }
        return true;
    }

}
