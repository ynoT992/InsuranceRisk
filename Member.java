import java.util.ArrayList;
import java.io.Serializable;
/**
 * @author tony rispoli
 * this class creates Member objects to be able to calculate the risk associated with their health
 * the Member object will be used in just about every other class, as it is a cornerstone
 */
public class Member implements Serializable {
	private String firstName, lastName, cancer, diabetes, alz;
    private int age, height, weight, bps, bpd;
    //getters and setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
    	return lastName;
    }
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
    	this.age = age;
    }
    public int getHeight() {
    	return height;
    }
    public void setHeight(int height) {
    	this.height = height;
    }
    public int getWeight() {
    	return weight;
    }
    public void setWeight(int weight) {
    	this.weight = weight;
    }
    public int getBPS() {
    	return bps;
    }
    public void setBPS(int bps) { 
    	this.bps = bps;
    }
    public int getBPD() {
    	return bpd;
    }
    public void setBPD(int bpd) {
    	this.bpd = bpd;
    }
    public String getCancer() {
    	return cancer;
    }
    public void setCancer(String cancer) {
    	this.cancer = cancer;
    }
    public String getDiabetes() {
    	return diabetes;
    }
    public void setDiabetes(String diabetes) {
    	this.diabetes = diabetes;
    }
    public String getAlz() {
    	return alz;
    }
    public void setAlz(String alz) {
    	this.alz = alz;
    }
    //creates member object with all necessary input
    public Member(String firstName, String lastName, int age, int height, int weight, int bps,
    		int bpd, String cancer, String diabetes, String alz) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setBPS(bps);
        setBPD(bpd);
        setCancer(cancer);
        setDiabetes(diabetes);
        setAlz(alz);
        getMembersAsString(this);
    }

    public Member() { // used for xml serialization
    	firstName = "";
    	lastName = "";
    	age = 0;
    	height = 0;
    	weight = 0;
    	bps = 0;
    	bpd = 0;
    	cancer = "";
    	diabetes = "";
    	alz = "";
    }
    /*
     * @name getMembersAsString
     * this will print a member's information in a pretty format to the screen
     * @param Member member uses object to grab information already set
     * @return void but prints to screen 
     */
    public static void getMembersAsString(Member member) {       
     	System.out.println(member.getLastName() + ", " + member.getFirstName());
     	System.out.println("Age:           " + member.getAge());
     	System.out.println("Height:        " + member.getHeight() + " in");
     	System.out.println("Weight:       " + member.getWeight() + " lbs");
     	System.out.println("BP Syst:      " + member.getBPS());
     	System.out.println("BP Dias:       " + member.getBPD());
     	System.out.println("Cancer:         " + member.getCancer());
     	System.out.println("Diabetes:       " + member.getDiabetes());
     	System.out.println("Alzheimer's:    " + member.getAlz());
     	System.out.println("----------------------");
     }
    /*
     * @name toString
     * used for saving to the text file, as it keeps the original format it read it from
     * @param Member m works backwards and stores member information in a tab-delimited list
     * @return mem, the tab-delimited list
     */
    public static String toString(Member m) {
    	String mem = (m.getFirstName() + "\t" + m.getLastName() + "\t" + m.getAge() + "\t" + m.getHeight() + "\t" 
        + m.getWeight() + "\t" + m.getBPS() + "\t" + m.getBPD() + "\t" + m.getCancer() + "\t" 
    	+ m.getDiabetes() + "\t" + m.getAlz());
    	return mem;
    }


}
