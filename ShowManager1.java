import java.util.LinkedList;

public class ShowManager1 {
	/**
	 * Organizes the non-special shows based on their standard military broadcast time.
	 * @param shows A list of {@link Show} to be organized.
	 * @return A {@link ShowSummary} of the non-special daytime, primetime, and late nighttime shows
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows) {
		LinkedList<Show> daytime = new LinkedList<>();
		LinkedList<Show> primetime = new LinkedList<>();
		LinkedList<Show> latenight = new LinkedList<>();

		for(Show show : shows) {
			if(!show.isSpecial) {
				if(show.broadcastTime >= 600 && show.broadcastTime < 1700)
					daytime.add(show);
				else if(show.broadcastTime >= 1700 && show.broadcastTime < 2200)
					primetime.add(show);
				else if(show.broadcastTime >= 2200 || show.broadcastTime < 100)
					latenight.add(show);
			}
		}
		return new ShowSummary(daytime, primetime, latenight);
	}
}