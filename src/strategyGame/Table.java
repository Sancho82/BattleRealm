package strategyGame;

public class Table {

    private int size = 10;
    private Unit[][] matrix = new Unit[size][size];

    public Unit getUnit(int i, int j) {
        return matrix[i][j];
    }

    public void matrixLoader() {

        matrix[0][1] = new Warrior();
        matrix[1][0] = new Warrior();
        matrix[1][1] = new Warrior();

        matrix[8][8] = new Warrior();
        matrix[9][8] = new Warrior();
        matrix[8][9] = new Warrior();

    }

    public void matrixDisplayer() {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != null) {
                    System.out.print(matrix[i][j].getPrefix() + " ");
                } else {
                    System.out.print("X");
                }
            }
        }
    }
}
