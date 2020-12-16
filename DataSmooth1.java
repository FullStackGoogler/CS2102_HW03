import java.util.LinkedList;

public class DataSmooth1 {
    /**
     * Calculates the smoothed averages using a simple smoothing technique of averaging the current average, the previous average, and the succeeding average.
     * @param shows A list of {@link Show}
     * @return A list of {@link Double} containing the smoothed averages of each shows average runtime per episode.
     */
    public LinkedList<Double> dataSmooth(LinkedList<Show> shows) {
        LinkedList<Double> smoothedData = new LinkedList<>();

        //sets the avgLength field in each Show object.
        for(Show show : shows) { show.setAvgLength(calculateAvg(show.episodes)); }

        //calculates the smoothed average, starting from the second Show and ending at the second to last Show.
        for(int i = 1; i < shows.size() - 1; i++) {
            smoothedData.add(smoothedAvg(shows.get(i - 1).avgLength, shows.get(i).avgLength, shows.get(i + 1).avgLength));
        }
        smoothedData.addFirst(shows.getFirst().avgLength);
        smoothedData.addLast(shows.getLast().avgLength);

        return smoothedData;
    }

    /**
     * Calculates the average of three given numbers.
     * @param num1 A {@link Double}.
     * @param num2 A {@link Double}.
     * @param num3 A {@link Double}.
     * @return The average of the three inputted doubles.
     */
    public double smoothedAvg(double num1, double num2, double num3) { return (num1 + num2 + num3) / 3; }

    /**
     * Calculates the average runtime per episode of a given Show.
     * @param episodes A list of {@link Episode}.
     * @return The average runtime of each episode.
     */
    public double calculateAvg(LinkedList<Episode> episodes) {
        double totalTime = 0;

        for(Episode episode : episodes) {
            totalTime += episode.runTime;
        }
        return totalTime / episodes.size();
    }
}