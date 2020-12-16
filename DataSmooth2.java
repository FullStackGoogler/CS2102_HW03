import java.util.LinkedList;

public class DataSmooth2 {
    /**
     * Calculates the smoothed averages using a simple smoothing technique of averaging the current average, the previous average, and the succeeding average.
     * @param shows A list of {@link Show}
     * @return A list of {@link Double} containing the smoothed averages of each shows average runtime per episode.
     */
    public LinkedList<Double> dataSmooth(LinkedList<Show> shows) {
        LinkedList<LinkedList<Double>> tripleNums = new LinkedList<>();
        LinkedList<Double> avgData = new LinkedList<>();
        LinkedList<Double> smoothedData = new LinkedList<>();

        //adds each Show's average runtime per episode to avgData.
        for(Show show : shows) { avgData.add(calculateAvg(show.episodes)); }

        //adds a LinkedList of Doubles containing the numbers to be averaged.
        for(int i = 0; i < avgData.size(); i++) {
            LinkedList<Double> addToList = new LinkedList<>();

            if (i == 0 || i == avgData.size()-1) {
                addToList.add(avgData.get(i));
            }
            else {
                addToList.add(avgData.get(i-1));
                addToList.add(avgData.get(i));
                addToList.add(avgData.get(i+1));
            }
            tripleNums.add(addToList);
        }

        //calculates the smoothed average.
        for(LinkedList<Double> list: tripleNums) {
            double sum = 0;

            for(double singles: list) { sum = sum + singles; }

            smoothedData.add(sum / list.size());
        }
        return smoothedData;
    }

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