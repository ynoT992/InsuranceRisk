import java.util.ArrayList;
import java.io.*;
import java.beans.XMLEncoder;
import org.json.simple.*;
public class MemberWriter {
	/*
	 * @name writeMembersToScreen
	 * will present the members in a nice format to the screen
	 * @param members, an ArrayList of the member objects
	 * @return void, but prints each member to the screen
	 */
    public static void writeMembersToScreen(ArrayList<Member> members) {
        for (Member m : members) {
            Member.getMembersAsString(m);
        }
    }
    /*
     * @name writeMembersToTextFile
     * will write all the members stored in the arraylist to a .txt file
     * @param fname the name that the file will be saved as
     * @param members, the arraylist of the member objects
     * @return True or False, dependent on whether or not the ArrayList is present & if the file is .txt
     */
    public static boolean writeMembersToTextFile(String fname, 
    ArrayList<Member> members) {
        try {
        	FileWriter fw = new FileWriter(fname);
        	for(Member m : members) {
        		fw.write(Member.toString(m) + "\n");
        	}
        	fw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    /*
     * @name writeMembersToBinary
     * will write all the members stored in the arraylist to a .bin file
     * @param fname the name that the file will be saved as
     * @param members, the arraylist of the member objects
     * @return True or False, dependent on whether or not the ArrayList is present & if the file is .bin
     */
    public static boolean writeMembersToBinary(String fname, ArrayList<Member> members) {
    	try {
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
    	    oos.writeObject(members);
    	    oos.close();
    	    return true;
    	} catch (Exception ex) {
    	    return false;
    	    }
    }
    /*
     * @name writeMembersToXML
     * will write all the members stored in the arraylist to a .xml file
     * @param fname the name that the file will be saved as
     * @param members, the arraylist of the member objects
     * @return True or False, dependent on whether or not the ArrayList is present & if the file is .xml
     */
    public static boolean writeMembersToXML(String fname, ArrayList<Member> members) {
    	try {
    	    XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fname)));
    	    enc.writeObject(members);
    	    enc.close();
    	    return true;
    	} catch (Exception ex) {
    	            return false;
            }
    }
}