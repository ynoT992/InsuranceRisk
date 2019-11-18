import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class InsuranceScoreWriter {
	/*
	 * @name writeAssessmentsToScreen
	 * this simply formats the assessments and prints to the screen in a nice manner
	 * @param InsuranceScore InsScore this is used to get the object & formats it in a string
	 * @return formats & prints the member's assessment to the screen
	 */
	public static String writeAssessmentsToScreen(InsuranceScore InsScore) {
        InsuranceScore.getScoreAsString(InsScore);
        return "";
    }
	/*
	 * @name writeAssessmentstoJSON
	 * sends the assessments found already to a JSON file
	 * @param fname what the file will be saved as
	 * @param insSore arraylist of the InsuranceScore objects to be written
	 */
	public static boolean writeAssessmentsToJSON(String fname, ArrayList<String> insString) {
    	try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
            pw.write("Assessments { \n");
            for(int i = 0; i < insString.size(); i++) {
          		pw.write(insString.get(i));
            }
    	    pw.write("}");
            pw.close();
            return true;
    	} catch (Exception ex) {
    		return false;
    	}
    }
}
