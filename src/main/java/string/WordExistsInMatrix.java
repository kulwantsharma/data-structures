package string;

public class WordExistsInMatrix {
    public static void main(String[] args) {

        char[][] mat = {
                {'o', 'f', 'a', 's'},
                {'l', 'l', 'q', 'w'},
                {'z', 'o', 'w', 'k'}
        };

        String word = "follow";
        System.out.println(doesWordExists(mat, word));

    }

    private static boolean doesWordExists(char[][] mat, String word) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (doesWordExistsUtil(mat, i, j, new boolean[mat.length][mat[0].length], word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean doesWordExistsUtil(char[][] mat, int i, int j, boolean[][] visited, String word, int k) {

        if (i < 0 || j < 0 || i == mat.length || j == mat[0].length) {
            return false;
        }

        if (visited[i][j]) {
            return false;
        }

        if (mat[i][j] != word.charAt(k)) {
            return false;
        }

        visited[i][j] = true;
        if (k == word.length() - 1 && mat[i][j] == word.charAt(k)) return true;

        return doesWordExistsUtil(mat, i - 1, j, visited, word, k + 1)
                || doesWordExistsUtil(mat, i + 1, j, visited, word, k + 1)
                || doesWordExistsUtil(mat, i, j - 1, visited, word, k + 1)
                || doesWordExistsUtil(mat, i, j + 1, visited, word, k + 1);

    }
}
