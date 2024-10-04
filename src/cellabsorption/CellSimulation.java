package cellabsorption;

import java.util.Random;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Point;
import java.util.ArrayList;
import java.awt.Color;


@SuppressWarnings("SameParameterValue")
public class CellSimulation {
    private Random rand = new Random();
    private Ellipse shape;
    private CanvasWindow canvas;
    private ArrayList<Cell> cells;

    public static void main(String[] args) {
        new CellSimulation();
    }

    public CellSimulation() {
        canvas = new CanvasWindow("Cell Absorption", 800, 800);
        populateCells();

        //noinspection InfiniteLoopStatement
        while (true) {
            Point canvasCenter = new Point(canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
            for (Cell cell : cells){
            cell.moveAround(canvasCenter);
            cell.grow(0.02);
            }
            canvas.draw();
            canvas.pause(10);
        }
    }
    public void populateCells() {
        cells = new ArrayList<>();
        for (int i = 0; i < 200; i++){
            Cell cell = new Cell(canvas);
            double size = rand.nextInt(5) + 2;
            cell.createCell(
            rand.nextDouble() * (canvas.getWidth() - size),
            rand.nextDouble() * (canvas.getWidth() - size),
            size,
            Color.getHSBColor(rand.nextFloat(), rand.nextFloat() * 0.5f + 0.1f, 1));
            canvas.add(cell.getShape());
            cells.add(cell);
        }
    }
}