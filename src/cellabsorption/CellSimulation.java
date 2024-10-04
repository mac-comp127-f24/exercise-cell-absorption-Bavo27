package cellabsorption;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;


@SuppressWarnings("SameParameterValue")
public class CellSimulation {

    private CanvasWindow canvas;
    private Cell cell;

    public static void main(String[] args) {
        new CellSimulation();
    }

    public CellSimulation() {
        canvas = new CanvasWindow("Cell Absorption", 800, 800);
        cell = new Cell(canvas);
        cell.populateCells();

        //noinspection InfiniteLoopStatement
        while (true) {
            Point canvasCenter = new Point(canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
            cell.moveAround(canvasCenter);
            cell.grow(0.02);

            canvas.draw();
            canvas.pause(10);
        }
        }
    }