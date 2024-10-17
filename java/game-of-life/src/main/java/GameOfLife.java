class GameOfLife {

    public int[][] tick(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0]; // Retorna uma matriz vazia
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int liveNeighbors = 0;

                // Contar vizinhos vivos
                for (int[] direction : directions) {
                    int neighborRow = i + direction[0];
                    int neighborCol = j + direction[1];

                    // Verifique se o vizinho está dentro dos limites da matriz
                    if (neighborRow >= 0 && neighborRow < matrix.length &&
                            neighborCol >= 0 && neighborCol < matrix[i].length) {
                        liveNeighbors += matrix[neighborRow][neighborCol];
                    }
                }

                // Aplicar as regras do jogo
                if (matrix[i][j] == 1) { // Célula viva
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        newMatrix[i][j] = 0; // Morre
                    } else {
                        newMatrix[i][j] = 1; // Continua viva
                    }
                } else { // Célula morta
                    if (liveNeighbors == 3) {
                        newMatrix[i][j] = 1; // Torna-se viva
                    } else {
                        newMatrix[i][j] = 0; // Permanece morta
                    }
                }
            }
        }

        return newMatrix;
    }
}

