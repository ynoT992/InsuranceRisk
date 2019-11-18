
public class InsuranceScore {
// @author tony rispoli
// this class will contain InsuranceScore objects that will store the member's name, score, and risk
	private static String name, risk;
	private static int score;
	/*
	 * getters and setters to get required inputs for an InsuranceScore object
	 */
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
	/*
	 * InsuranceScore object contains nothing more than member's first and last name, their risk score,
	 *  and the verdict associated with score
	 */
	InsuranceScore(String name, int score, String risk) {
		setName(name);
		setScore(score);
		setRisk(risk);
		toString(this);
	}
	
	InsuranceScore() {
		name = "";
		score = 0;
		risk = "";
	}
	/*
	 * @name getScoreAsString
	 * to be used for the writeAssessmentToScreen function to format assessment
	 * @param InsuranceScore InsScore an object that we need information from
	 * @return void, but prints to the screen through system.out
	 */
	public static void getScoreAsString(InsuranceScore InsScore) {       
	 	   // prints assessment nicely to the screen
	     	System.out.println("Name:           " + InsScore.getName());
	     	System.out.println("Score:          " + InsScore.getScore());
	     	System.out.println("Verdict:        " + InsScore.getRisk());
	     	System.out.println("---------------------------------");
	}
	/*
	 * @name toString
	 * this formats each InsuranceScore object into a JSON format
	 * @param InsuranceScore ins will need the info from the object
	 * @return score - a string that has JSON formatting
	 */
	public static String toString(InsuranceScore ins) {
		String score = ("\t { \n" +
		"\t\t Name: " + ins.getName() + "\n" +
		"\t\t Score: " + ins.getScore() + "\n" +
		"\t\t Verdict: " + ins.getRisk() + "\n" +
		"\t } \n");
		return score;
	}
}
