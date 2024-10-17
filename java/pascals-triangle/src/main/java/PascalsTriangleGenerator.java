class PascalsTriangleGenerator {

    int[][] generateTriangle(int rows) {

        int[][] triangle = new int[rows][];
        int sum = 0;

        for(int i = 0; i < rows; i++) {

            triangle[i] = new int[i + 1];

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    sum = triangle[i - 1][j - 1] + triangle[i - 1][j];
                    triangle[i][j] = sum;
                }
            }
        }

        return triangle;
    }

}