import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.beans.XMLDecoder;
public class MemberReader { 
	// this class will read members from a variety of files and put them into an arraylist
	/*
	 * @name readMembersFromTextFile 
	 * this will read a text file and put all Members into an arrayList
	 * @param fname the name of the file it will be reading
	 * @return result, an ArrayList of all the member objects
	 */
	public static ArrayList<Member> readMembersFromTextFile(String fname) {
		ArrayList<Member> result = new ArrayList<Member>();
		try {
			Scanner fsc = new Scanner(new File(fname));
			String line, firstName, lastName, cancer, diabetes, alz;
			int age, height, weight, bps, bpd;
			Member mem;
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();
				String parts[] = line.split("\\t");
				System.out.println(parts);
				firstName = parts[0];
				lastName = parts[1];
	            age = Integer.parseInt(parts[2]);
	            height = Integer.parseInt(parts[3]);
	            weight = Integer.parseInt(parts[4]);
	            bps = Integer.parseInt(parts[5]);
	            bpd = Integer.parseInt(parts[6]);
	            cancer = parts[7];
	            diabetes = parts[8];
	            alz = parts[9];
	            
	            mem = new Member(firstName, lastName, age, height, weight, bps, bpd, cancer, diabetes, alz);
	            result.add(mem);
	        }
	        fsc.close();
	        return result;
	        } catch (Exception ex) {
	        	return null;
	        }
	    }
	/*
	 * @name readMembersFromBinary
	 * this will read members from a .bin file
	 * @param fname, the file name (must be .bin)
	 * @return ArrayList of member objects
	 */
	public static ArrayList<Member> readMembersFromBinary(String fname) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
			ArrayList<Member> result = (ArrayList<Member>)ois.readObject();
			ois.close();
			return result;
		} catch (Exception ex) {
			return null;
		}
		
	}
	/*
	 * @name readMembersFromXML
	 * this will read members from a .xml file
	 * @param fname, the file name (must be .xml)
	 * @return ArrayList of member objects
	 */
	public static ArrayList<Member> readMembersFromXML(String fname) {
		try {
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(fname)));
			ArrayList<Member> result = (ArrayList<Member>)dec.readObject();
			dec.close();
			return result;
		} catch (Exception ex) {
			return null;
		}
	}
}