import processing.core.PApplet;

public class BubbleSort extends PApplet {
    private int[] values;
    private int i;
    private int j;
    private int rectWidth;

    /**
     * Defines initial environment properties such as screen size and to load media such as images and fonts as the
     * program starts
     */
    public void setup() {
        int width = 800;
        int height = 500;
        size(width, height); // set window size

        int frameRate = 1000; // run at max frame rate possible
        frameRate(frameRate);

        int numValues = 50;
        values = new int[numValues];
        for (int i = 0; i < values.length; i++) {
            values[i] = (int) random(this.height);
        } // create NUM_VALUES random values

        rectWidth = this.width / values.length; // sets the width of each rect value

        i = 0; // initialize index variables
        j = 0;
    }

    /**
     * Continuously executes the lines of code contained inside its block until the program is stopped or noLoop()
     * is called
     */
    public void draw() {
        background(0);

        // increment i and j each loop of draw()
        if (i < values.length) {
            // swap values
            if (values[j] > values[j + 1]) {
                swap(values, j, j + 1);
            }

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

    /**
     * Swaps values at indices i and j in the given array.
     *
     * @param values array of values to be sorted
     * @param i      index i
     * @param j      index j
     */
    private void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}
