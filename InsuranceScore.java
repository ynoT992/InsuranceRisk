
public class InsuranceScore {
// this class will contain InsuranceScore objects that will store the member's name, score, and risk
	private static String name, risk;
	private static int score;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	
	InsuranceScore(String name, int score, String risk) {
		setName(name);
		setScore(score);
		setRisk(risk);
	}
	
	InsuranceScore() {
		name = "";
		score = 0;
		risk = "";
	}
	public static void getScoreAsString(InsuranceScore InsScore) {       
	 	   // gets a list of numbers & prints it nicely to the screen
	     	System.out.println("Name:           " + InsScore.getName());
	     	System.out.println("Score:        " + InsScore.getScore());
	     	System.out.println("Verdict:       " + InsScore.getRisk());
	     	System.out.println("----------------------");
	     }
}
