package JZoffer.backtrace;

/* 矩阵中的路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]
但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 */
public class ExistedPath {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '0';    // 将 board[i][j] 值暂存于变量 tmp ，并修改为字符 '/' ，代表此元素已访问过，防止之后搜索时重复访问。

        boolean res = dfs(i - 1, j, board, word, index + 1) || dfs(i + 1, j, board, word, index + 1)
                || dfs(i, j - 1, board, word, index + 1) || dfs(i, j + 1, board, word, index + 1);
        board[i][j] = temp;  // 将 tmp 暂存值还原至 board[i][j] 元素。
        return res; // 回溯最终返回值
    }
}
