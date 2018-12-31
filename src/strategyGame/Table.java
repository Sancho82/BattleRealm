package strategyGame;

public class Table {

    private int size = 10;
    private Cell[][] matrix = new Cell[size][size];

    public Cell getCell(int i, int j) {
        return matrix[i][j];
    }

    public void matrixLoader() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = new Cell();
            }
        }
        matrix[0][1].setUnit(new Warrior());
        matrix[1][0].setUnit(new Warrior());
        matrix[1][1].setUnit(new Warrior());

        matrix[0][1].changeOccupancy();
        matrix[1][0].changeOccupancy();
        matrix[1][1].changeOccupancy();

        matrix[8][8].setUnit(new Warrior());
        matrix[9][8].setUnit(new Warrior());
        matrix[8][9].setUnit(new Warrior());


        matrix[8][8].changeOccupancy();
        matrix[9][8].changeOccupancy();
        matrix[8][9].changeOccupancy();


    }

    public void matrixDisplayer() {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j].getUnit().getName() + " ");
            }
        }
    }
}
