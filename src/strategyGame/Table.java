package strategyGame;

public class Table {

    private int size = 10;
    private Unit[][] matrix = new Unit[size][size];

    public Unit getUnit(int i, int j) {
        return matrix[i][j];
    }

    public void matrixDisplayer() {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != null) {
                    System.out.print(matrix[i][j].getPrefix() + " ");
                } else {
                    System.out.print("X ");
                }
            }
        }
    }
}
