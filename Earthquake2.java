import java.util.LinkedList;

class Earthquake2 {
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
        double maxVal = 0;
        double previousDate = 0;
        boolean getVal = false;

        for(int i = 0; i < data.size(); i++) {
            double num = data.get(i);

            if(getVal) {
                if(isDate(num)) {
                    reports.add(new MaxHzReport(previousDate, maxVal));
                    getVal = false;
                    i--;
                }
                else if(num > maxVal) {
                    maxVal = num;
                }
            }
            else if(isDate(num)) {
                if(extractMonth(num) == month) {
                    getVal = true;
                    previousDate = num;
                }
                maxVal = 0;
            }
        }

        //adds the last MaxHzReport, if any.
        if (maxVal != 0)
            reports.add(new MaxHzReport(previousDate, maxVal));

        return reports;
    }
}