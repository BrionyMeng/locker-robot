package locker;

import java.util.ArrayList;
import java.util.List;

public class Locker {
    private int gridNumber;

    public Locker(int gridNumber) {
        this.gridNumber = gridNumber;
    }

    public Ticket storeBag() {
        if (!this.findEmptyGrid().isEmpty()) {
            List<Grid> emptyGrid = this.findEmptyGrid();
            emptyGrid.get(0).occupationStatus = Grid.status.occupied;
            System.out.println(emptyGrid.get(0).id);
            return new Ticket(1);
        }
        else return null;
    }

    private List<Grid> findEmptyGrid() {
        List<Grid> emptyGrid=new ArrayList<>();
        Grid testGrid=new Grid(1);
        emptyGrid.add(testGrid);
        return emptyGrid;
    }
}
