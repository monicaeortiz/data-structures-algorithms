import java.util.*;

class TallyVotes {
	public static void main(String[] args) {
		String[][] votes = { { "A", "C", "D", "B" }, { "A", "C", "B", "D" }, { "A", "D", "C", "B" },
				{ "B", "C", "A", "D" }, { "B", "D", "C", "A" }, { "C", "B", "A", "D" }, { "C", "D", "B", "A" },
				{ "D", "C", "B", "A" } };
		// create Ballot objects and put into ArrayList
		ArrayList<Ballot> ballots = new ArrayList<Ballot>();
		for (int i = 0; i < votes.length; i++){
			ballots.add(new Ballot(votes[i]));
		}

		// run the ranked-choice
		int round = 1;
		boolean done = false;
		while(!done){
			System.out.println("Round #" + round);
			Collections.sort(ballots);
			done =  (ballots);
			System.out.println("---------------------");
			round++;
		}
	}

	// run one round of ranked choice voting
	public static boolean oneRound(ArrayList<Ballot> ballots) {
		String top = null;
		String bottom = null;
		int topCount = 0;
		int bottomCount = ballots.size() + 1;
		int index = 0;
		while(index < ballots.size()){
			String next = ballots.get(index).getCandidate();
			int count = processVotes(next, index, ballots);
			if (count > topCount){
				topCount = count;
				top = next;
			}
			if (count < bottomCount){
				bottomCount = count;
				bottom = next;
			}
			index += count;
		}

		if (topCount == bottomCount){
			System.out.println("Election has no winner");
			return true;
		}
		else if (topCount > ballots.size() / 2.0){
			System.out.println("Winner is "  + top);
			return true;
		}
		else {
			System.out.println("No winner, eliminating " + bottom);
			eliminate(bottom, ballots);
			return false;
		}

	}

	// count and report votes for the next candidate
	public static int processVotes(String name, int index, ArrayList<Ballot> ballots){
		int count = 0;
		while(index < ballots.size() && ballots.get(index).getCandidate().equals(name)){
			index++;
			count++;
		}
		double percent = 100.0 * count/ballots.size();
		System.out.printf("%d votes for %s (%4.1f%%)\n", count, name, percent);
		return count;
	}

	public static void eliminate(String candidate, ArrayList<Ballot> ballots){
		for (Ballot b: ballots){
			b.eliminate(candidate);
		}
	}

}
