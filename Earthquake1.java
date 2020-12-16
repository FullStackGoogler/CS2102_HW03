import java.util.LinkedList;

public class Earthquake1 {
    // checks whether a datum is a date
    boolean isDate(double anum) { return (int)anum > 10000000; }
    // extracts the month from an 8-digit date
    int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

    /**
     * Finds the maximum seismic measurement for each day in a given month.
     * @param data A list of {@link Double} sensor data and dates.
     * @param month The target month.
     * @return A list of {@link MaxHzReport} in a given month.
     */
    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
        LinkedList<MaxHzReport> reports = new LinkedList<>();

        for(int i = 0; i < data.size(); i++) {
            double num = data.get(i);

            if(isDate(num) && extractMonth(num) == month) {
                int j = i + 1;
                double highest = data.get(j);

                while(!isDate(data.get(j)) && j < data.size()-1) {
                    if(data.get(j) > highest)
                        highest = data.get(j);
                    j++;
                }
                reports.add(new MaxHzReport(num, highest));
            }
        }
        return reports;
    }
}