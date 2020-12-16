import static org.junit.Assert.*;
import org.junit.Test;

import java.util.LinkedList;

public class DataSmoothExamples {
    LinkedList<Show> shows = new LinkedList<>();
    LinkedList<Show> twoShows = new LinkedList<>();

    LinkedList<Double> showResults = new LinkedList<>();
    LinkedList<Double> twoShowResults = new LinkedList<>();

    DataSmooth1 D1 = new DataSmooth1();
    DataSmooth2 D2 = new DataSmooth2();
  
    public DataSmoothExamples() {
		LinkedList<Episode> eps1 = new LinkedList<>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));

		Show starTrek = new Show("Star Trek", 1800, eps1, false);
		shows.add(starTrek);
		twoShows.add(starTrek);
		
		LinkedList<Episode> eps2 = new LinkedList<>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));

		Show futurama = new Show("Futurama", 1900, eps2, false);
		shows.add(futurama);
		twoShows.add(futurama);
		
		LinkedList<Episode> eps3 = new LinkedList<>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3, false));
		
		LinkedList<Episode> eps4 = new LinkedList<>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4, false));

	    showResults.add(60.0);
	    showResults.add(29.75);
	    showResults.add(29.08333);
	    showResults.add(58.0);

	    twoShowResults.add(60.0);
	    twoShowResults.add(22.25);
    }
  
    @Test
    public void instructorTestDS() {
	    LinkedList<Double> runtimes = D1.dataSmooth(shows);
	  
	    for(int i = 0; i < runtimes.size(); i++) {
		    assertEquals(runtimes.get(i), showResults.get(i), .01);
	    }
    }

    @Test
	public void checkDataSmooth() {
		LinkedList<Double> runtimes1 = D1.dataSmooth(shows);
		LinkedList<Double> runtimes2 = D2.dataSmooth(shows);
		LinkedList<Double> runTimesDouble1 = D1.dataSmooth(twoShows);
		LinkedList<Double> runTimesDouble2 = D2.dataSmooth(twoShows);

		for(int i = 0; i < runtimes1.size(); i++) { assertEquals(showResults.get(i), runtimes1.get(i), .01); }
		for(int i = 0; i < runtimes2.size(); i++) { assertEquals(showResults.get(i), runtimes2.get(i), .01); }
		for(int i = 0; i < runtimes1.size(); i++) { assertEquals(runtimes1.get(i), runtimes2.get(i), .01); }

		for(int i = 0; i < runTimesDouble1.size(); i++) { assertEquals(twoShowResults.get(i), runTimesDouble1.get(i), 0.01); }
		for(int i = 0; i < runTimesDouble1.size(); i++) { assertEquals(runTimesDouble1.get(i), runTimesDouble2.get(i), 0.01); }
	}
}
/*
 Subtasks:
 - Calculate the average runtime of each episode for all given shows
 - Find the values to be calculated, which include any value aside from the first and last value
 - Take the current number, the previous number, and the number after and find the average of those three
 - Return a list containing the smoothed out averages
 */