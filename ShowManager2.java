import java.util.LinkedList;

public class ShowManager2 {
	/**
	 * Organizes the non-special shows based on their standard military broadcast time.
	 * @param shows A list of {@link Show} to be organized.
	 * @return A {@link ShowSummary} of the non-special daytime, primetime, and late nighttime shows
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows) {
		LinkedList<Show> sifted = new LinkedList<>();
		LinkedList<Show> daytime = new LinkedList<>();
		LinkedList<Show> primetime = new LinkedList<>();
		LinkedList<Show> latenight = new LinkedList<>();

		//adds any Shows that aren't specials or overnight.
		for(Show show : shows) {
			if(!show.isSpecial && (show.broadcastTime >= 600 || show.broadcastTime < 100)) {
				sifted.add(show);
			}
		}

		for(Show show : sifted) {
			if(!show.isSpecial) {
				if(show.broadcastTime >= 600 && show.broadcastTime < 1700)
					daytime.add(show);
				else if(show.broadcastTime >= 1700 && show.broadcastTime < 2200)
					primetime.add(show);
				else
					latenight.add(show);
			}
		}
		return new ShowSummary(daytime, primetime, latenight);
	}
}