public class Floyd {

    //Test of floydWarshall() method
    public static void main(String[] args) {
        int l = 5;
        int INF = (int) 1e5;

        int[][] mat = new int[l + 1][l + 1];
        for (int i = 0; i <= l; i++) {
            for (int j = 0; j <= l; j++) {
                mat[i][j] = INF;
            }
        }

        mat[1][2] = 1;
        mat[1][3] = 5;
        mat[1][4] = 7;
        mat[2][3] = 2;
        mat[2][5] = 2;
        mat[3][4] = 1;
        mat[4][2] = 4;
        mat[5][1] = 3;

        floydWarshall(mat, l);

        System.out.println("Shortest Path Matrix:");
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                if (mat[i][j] == INF) {
                    System.out.printf("%6s", "INF");
                } else {
                    System.out.printf("%6d", mat[i][j]);
                }
            }
            System.out.println();
        }
    }


    public static void floydWarshall(int[][] mat, int l) {
        for (int k = 0; k < l; k++) {
            for (int u = 0; u < l; u++) {
                for (int v = 0; v < l; v++) {
                    mat[u][v] = Math.min(mat[u][v], mat[u][k] + mat[k][v]);
                }
            }
        }
    }
}