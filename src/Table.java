public class Table {

    private int size = 10;
    private Cell[][] matrix = new Cell[size][size];

    public void matrixLoader() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }

    public void matrixDisplayer() {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j].getName() + " ");
            }
        }
    }
}
