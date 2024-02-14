import java.util.Arrays;

class Matrix {
    String matrixAsString;
    int [][] matrix;
    int rowsLength;
    int columnsLength;


    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
        this. matrix = transformIntoMatrix();
    }

    int [][] transformIntoMatrix(){

        String[] rows = this.matrixAsString.split("\n");
        String[] columns =rows[0].split("\\s+");

        this.rowsLength = rows.length;
        this.columnsLength = columns.length;

        int[][] matrix = new int[rows.length][columns.length];

        String formattedValues = this.matrixAsString.replace("\n", " ");
        String[] separateValues = formattedValues.split("\\s+");

        int count = 0;
        for(int i = 0; i < rows.length; i++ ){
            for (int j = 0; j < columns.length; j++) {
                matrix[i][j] = Integer.parseInt(separateValues[count]);
                count++;
            }

        }

        return matrix;
    }

    int[] getRow(int rowNumber) {

        rowNumber -= 1;
        int limit = this.rowsLength;
        if(this.columnsLength != this.rowsLength) limit -= 1;

        int [] row = new int[limit];


        for (int j = 0; j < limit; j++) {
            row[j] = this.matrix[rowNumber][j];
        }

        return row;
    }


    int[] getColumn(int columnNumber) {
        columnNumber -= 1;
        int limit = this.columnsLength;

        if(this.columnsLength != this.rowsLength) limit -= 1;

        int [] column = new int[limit];

        for (int i = 0; i < limit; i++) {
            column[i] = this.matrix[i][columnNumber];
        }


        return column;
    }

}
