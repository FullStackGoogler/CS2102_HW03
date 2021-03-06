import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class ShowExamples {
	ShowManager1 sm1 = new ShowManager1();
	ShowManager2 sm2 = new ShowManager2();
	LinkedList<Show> shows = new LinkedList<>();
	ShowSummary report1 = new ShowSummary();

	public ShowExamples() {
		LinkedList<Episode> eps1 = new LinkedList<>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));
		Show s1 = new Show("Star Trek", 1800, eps1, false);
		shows.add(s1);
		report1.primetime.add(s1);

		LinkedList<Episode> eps2 = new LinkedList<>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		Show s2 = new Show("Futurama", 1900, eps2, false);
		shows.add(s2);
		report1.primetime.add(s2);

		LinkedList<Episode> eps3 = new LinkedList<>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		Show s3 = new Show("Animaniacs", 1630, eps3, false);
		shows.add(s3);
		report1.daytime.add(s3);

		LinkedList<Episode> eps4 = new LinkedList<>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		Show s4 = new Show("Sesame Street", 900, eps4, false);
		shows.add(s4);
		report1.daytime.add(s4);
	}
	
	@Test
	public void instructorTestOrganizeShows() {
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}

	@Test
	public void checkOrganizeShows() {
		ShowSummary report = sm1.organizeShows(shows);
		ShowSummary reportOther = sm2.organizeShows(shows);
		ShowSummary reportEmpty = new ShowSummary();

		assertEquals(report1, report);
		assertEquals(report1, reportOther);
		assertEquals(report, reportOther);
		assertEquals(reportEmpty.daytime, new LinkedList<Show>());
	}
}
/*
 Subtasks:
 - Identify the valid shows
 - Sort the valid shows into their respective time slots
 - Return a Show Summary of the sorted shows
 */