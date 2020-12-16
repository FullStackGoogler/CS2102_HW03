import static org.junit.Assert.*;
import org.junit.Test;

import java.util.LinkedList;

public class EarthquakeExamples {
    Earthquake1 E1 = new Earthquake1();
    Earthquake2 E2 = new Earthquake2();

    LinkedList<Double> noData = new LinkedList<>();
    LinkedList<Double> threeDates = new LinkedList<>();

    LinkedList<MaxHzReport> NovReports = new LinkedList<>();
    LinkedList<MaxHzReport> OctReports = new LinkedList<>();
    LinkedList<MaxHzReport> noReports = new LinkedList<>();

    public EarthquakeExamples() {
        threeDates.add(20151013.0);
        threeDates.add(10.0);
        threeDates.add(5.0);
        threeDates.add(20151020.0);
        threeDates.add(40.0);
        threeDates.add(50.0);
        threeDates.add(45.0);
        threeDates.add(20151101.0);
        threeDates.add(6.0);

        NovReports.add(new MaxHzReport(20151101.0,6.0));
        OctReports.add(new MaxHzReport(20151013.0, 10.0));
        OctReports.add(new MaxHzReport(20151020.0,50.0));
    }

    @Test
    public void instructorTestEQ() {
        assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
    }

    @Test
    public void checkDailyMaxForMonth() {
        assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
        assertEquals(NovReports, E2.dailyMaxForMonth(threeDates, 11));
        assertEquals(OctReports, E1.dailyMaxForMonth(threeDates, 10));
        assertEquals(OctReports, E2.dailyMaxForMonth(threeDates, 10));
        assertEquals(noReports, E1.dailyMaxForMonth(noData, 9));
        assertEquals(noReports, E2.dailyMaxForMonth(noData, 9));
        assertEquals(noReports, E1.dailyMaxForMonth(threeDates, 6));
        assertEquals(noReports, E2.dailyMaxForMonth(threeDates, 6));
    }
}
/*
 Subtasks:
 - Check for a valid date
 - After being given a valid date, find the max measurement for the given date
 - Return a list containing the reports for each valid date, which consists of the given date and the max measurement reported
 */
