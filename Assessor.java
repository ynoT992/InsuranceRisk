import java.util.ArrayList;
/**
 * @author tony rispoli
 * This class will calculate a number that expresses the risk
 * for a member. This number is dependent on all the factors
 * that the user input and will be used in the InsuranceScore
 * object and written to the file
 */
public class Assessor {
	// will need to convert height & weight 
	// to m and kg from in and lbs
	public static double calcBMI(int height, int weight) {
		// 1 in = 0.0254 m
		// 1 lb = 0.453592 kg
		double bmi = (weight*0.453592) / Math.pow(height*0.0254, 2);
		return bmi;
	}
	//also need to find blood pressure category
	public static String calcBP(int bps, int bpd) {
		if(bps < 120 && bpd < 80) {
			return "normal";
		}
		else if(bps >= 120 && bps <= 129 && bpd < 80) {
			return "elevated";
		}
		else if(bps >= 130 && bps <= 139 || bpd >= 80 && bpd <= 89) {
			return "stage 1";
		}
		else if(bps >= 140 || bpd >= 90) {
			return "stge 2";
		}
		else if(bps >= 180 || bpd >= 120) {
			return "crisis";
		}
		else {
			return null;
		}
	}
	public static int ageNum(int age) {
		if(age < 30) {
			return 0;
		}
		else if(age < 45) {
			return 10;
		}
		else if(age < 60) {
			return 20;
		}
		else {
			return 30;
		}
	}
	public static int BMINum(double bmi) {
		if (bmi >= 18.5 && bmi <= 24.9) {
			return 0;
		}
		else if (bmi >= 25.0 && bmi <= 29.9) {
			return 30;
		}
		else if(bmi >= 30.0 && bmi <= 34.9) {
			return 75;
		}
		else {
			return 0;
		}
	}
	public static int BPNum(int bps, int bpd) {
		String BPState = calcBP(bps,bpd);
		if(BPState.equals("normal")) {
			return 0;
		}
		else if(BPState.equals("elevated")) {
			return 15;
		}
		else if(BPState.equals("stage 1")) {
			return 30;
		}
		else if(BPState.equals("stage 2")) {
			return 75;
		}
		else if(BPState.equals("crisis")) {
			return 100;
		}
		else {
			return 0;
		}
	}
	public static int genNum(String cancer, String diabetes, String alz) {
		int genScore = 0;
		if(cancer.equals("y")) {
			genScore = genScore + 10;
		}
		if(diabetes.equals("y")) {
			genScore = genScore + 10;
		}
		if(alz.equals("y")) {
			genScore = genScore + 10;
		}
		return genScore;
	}
	public static String calcRisk(int score) {
		if(score <= 20) {
			return "low risk";
		}
		else if(score <= 50) {
			return "moderate risk";
		}
		else if(score <= 75) {
			return "high risk";
		}
		else {
			return "uninsurable";
		}
	}
	public static ArrayList<InsuranceScore> assessMember(ArrayList<Member> members) {
		ArrayList<InsuranceScore> totScores = new ArrayList<InsuranceScore>();
		for(Member member:members) {
			int score = 0;
			String name = member.getLastName() + ", " + member.getFirstName();
			int ageScore = ageNum(member.getAge());
			int BMIScore = BMINum(calcBMI(member.getHeight(), member.getWeight()));
			int BPScore = BPNum(member.getBPS(),member.getBPD());
			int genScore = genNum(member.getCancer(), member.getDiabetes(), member.getAlz());
			score = ageScore + BMIScore + BPScore + genScore;
			String risk = calcRisk(score);
			InsuranceScore memScore = new InsuranceScore(name, score, risk);
			totScores.add(memScore);
		}
		return totScores;
	}
}
