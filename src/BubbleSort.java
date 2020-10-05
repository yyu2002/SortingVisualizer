import processing.core.PApplet;

public class BubbleSort extends PApplet {
    private int numValues;
    private int[] values;
    private int i;
    private int j;
    private int rectWidth;

    public void setup() {
        numValues = 100;
        size(800, 500);
        frameRate(1000);

        values = new int[numValues];
        rectWidth = width / values.length;
        i = 0;
        j = 0;

        for (int i = 0; i < values.length; i++) {
            values[i] = (int) random(height);
        }
    }

    public void draw() {
        background(0);

        // swap values
        if (values[j] > values[j + 1]) {
            swap(values, j, j + 1);
        }

        // increment i and j each loop of draw()
        if (i < values.length) {
            j++;
            if (j >= values.length - i - 1) {
                j = 0;
                i++;
            }
        } else {
            System.out.println("Finished!");
            noLoop();
        }

        // display rectangles (values) each loop of draw()
        for (int i = 0; i < values.length; i++) {
            stroke(255);
            rect(i * rectWidth, height - values[i], rectWidth, values[i]);
        }
    }

    private void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}
