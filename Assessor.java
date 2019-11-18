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
	
	/* 
	 * @name calcBMI
	 * converts the height from inches into meters by multiplying by 0.0254
	 * converts the weight to kg by multiplying by 0.453592
	 * @param height which gets converted
	 * @param weight which gets converted
	 * @return bmi, calculated by weight in kg / height in m squared
	 */
	public static double calcBMI(int height, int weight) {
		// 1 in = 0.0254 m
		// 1 lb = 0.453592 kg
		double bmi = (weight*0.453592) / Math.pow(height*0.0254, 2);
		return bmi;
	}
	//also need to find blood pressure category
	/* 
	 * @name calcBP
	 * puts the user's blood pressure into a category based on where their bps
	 * and bpd is currently at
	 * @param bps, safe level is under 120
	 * @param bpd, safe level is under 80
	 * @return string describing their blood pressure state
	 */
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
	/* 
	 * @name ageNum
	 * determines the risk associated with a member based on their current age
	 * @param age to determine risk level
	 * @return 0, 10, 20, or 30 based on how old the member is
	 */
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
	/*
	 * @name BMINum
	 * determines the risk associated with a member based on the BMI calculated from calcBMI
	 * @param bmi calculated from an earlier method
	 * @return 0, 30, or 75 to determine how healthy the user is based on body mass
	 */
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
	/* 
	 * @name BPNum
	 * calculates risk associated with the blood pressure state found earlier
	 * @param bps to calc with
	 * @param bpd to find bp state
	 * @return 0, 15, 30, 75, or 100 based on the member's blood pressure
	 */
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
	/* 
	 * @name genNum
	 * this finds the risk associated with the member's genetic history
	 * @param cancer to see if the member is at a higher risk
	 * @param diabetes to see if the member is at a higher risk
	 * @param alz to see if the member is at a higher risk
	 * @return 0, 10, 20, or 30 based on member's family history
	 */
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
	/*
	 * @name calcRisk
	 * this calculates the risk string associated with a member
	 * @param score to take in the total member's score to determine a state
	 * @return "low risk," "moderate risk," "high risk," or "uninsurable" 
	 * based on how high their score is
	 */
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
	/*
	 * @name assessMember
	 * this calculates the total score of a member's risk by calling all methods above
	 * @param Member m takes in one member & uses all information
	 * to find a risk level
	 * @return memScore, a running count of how risky it would be to insure them
	 */
	public static InsuranceScore assessMember(Member m) {
		int score = 0;
		String name = m.getLastName() + ", " + m.getFirstName();
		int ageScore = ageNum(m.getAge());
		int BMIScore = BMINum(calcBMI(m.getHeight(), m.getWeight()));
		int BPScore = BPNum(m.getBPS(),m.getBPD());
		int genScore = genNum(m.getCancer(), m.getDiabetes(), m.getAlz());
		score = ageScore + BMIScore + BPScore + genScore;
		String risk = calcRisk(score);
		InsuranceScore memScore = new InsuranceScore(name, score, risk);
		return memScore;
	}
}