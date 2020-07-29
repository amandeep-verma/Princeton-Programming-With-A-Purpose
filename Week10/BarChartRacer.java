/* *****************************************************************************
program produces animated bar charts, using BarChart.java
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {


    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int totalDisplay = Integer.parseInt(args[1]);
        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();

        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        BarChart chart = new BarChart(title, xAxis, source);
        StdAudio.loop("soundtrackA.wav");
        while (in.hasNextLine()) {

            // to avoid the empty line
            in.readLine();

            String nextLine = in.readLine();
            int records = Integer.parseInt(nextLine);

            String caption = "";

            Bar[] bars = new Bar[records];
            for (int i = 0; i < records; i++) {

                String seq = in.readLine();

                // splitting the line with regex
                String[] set = seq.split(",");

                // setting the caption to the bar chart
                caption = set[0];
                bars[i] = new Bar(set[1], Integer.parseInt(set[3]), set[4]);
            }
            Arrays.sort(bars);

            // sets the caption
            chart.setCaption(caption);

            // add the bars to the bar chart
            for (int i = 0; i < totalDisplay; i++) {
                chart.add(bars[records - 1 - i].getName(), bars[records - 1 - i].getValue(),
                          bars[records - 1 - i].getCategory());
            }

            // draw the bar chart
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            StdDraw.clear();
            chart.reset();
        }
    }
}
