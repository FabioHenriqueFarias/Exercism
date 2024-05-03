import java.util.*;

class Matrix {

    List<List<Integer>> matrix;

    Matrix(List<List<Integer>> matrix) {
        this.matrix = matrix;
    }

    Set<MatrixCoordinate> getSaddlePoints() {

        if (!isMatrixValid()) return Collections.emptySet();
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();


        for(int i = 0; i < matrix.size(); i++) {
            int maxRow = Collections.max(matrix.get(i));
            List<Integer> valuesColumn = new ArrayList<Integer>();
            boolean isFrequency = Collections.frequency(matrix.get(i), maxRow) > 2;

            int indexLine = matrix.get(i).indexOf(maxRow);

            if(isFrequency){
                List<Integer> indexes = getAllIndexes(matrix.get(i), maxRow);
                if (!indexes.isEmpty()) {

                    for(int k = 0; k < indexes.size(); k++) {
                        List<Integer> valuesColumnFrequency = new ArrayList<Integer>();

                        for (List<Integer> linesMatrix : matrix) {
                            valuesColumnFrequency.add(linesMatrix.get(indexes.get(k)));
                        }

                        if (true) throw new IllegalStateException("Matrix" + matrix.get(i).get(indexes.get(k)));

                        if (matrix.get(i).get(indexes.get(k)).equals(Collections.min(valuesColumnFrequency))) {
                            MatrixCoordinate coordinate = new MatrixCoordinate(i+1, indexLine+1);
                            saddlePoints.add(coordinate);
                        }

                    }
                }
            }


            for (List<Integer> linesMatrix : matrix) {
                valuesColumn.add(linesMatrix.get(indexLine));
            }



            if (matrix.get(i).get(indexLine).equals(Collections.min(valuesColumn))) {
                MatrixCoordinate coordinate = new MatrixCoordinate(i+1, indexLine+1);
                saddlePoints.add(coordinate);
            }

        }



        return saddlePoints;
    }

    public static List<Integer> getAllIndexes(List<Integer> list, int value) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public boolean isMatrixValid() {

        if (this.matrix == null || this.matrix.isEmpty()) return false;

        int rowSize = this.matrix.get(0).size();

        if (rowSize == 0) return false;

        for (List<?> row : this.matrix) {
            if (row.size() != rowSize) return false;
        }

        return true;
    }

}



// Preciso pegar o maior elemento da linha
// Conferir se é o menor elemento da coluna (True) -> Serve
//                                          (False) -> Não serve


/*
 * Quando eu pego o valor da linha eu tenho o índice dela na coluna, com isso posso percorrer um For para verificar nas outras linhas das colunas e verificar se ela é a menor, se sim Crio o MatrixXoordinate, se não passo para proxima linha
 * */