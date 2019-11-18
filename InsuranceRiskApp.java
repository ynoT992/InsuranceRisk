import java.util.Scanner;
import java.util.ArrayList;
public class InsuranceRiskApp { 
	// this is the final app that puts all classes together
	public static void printWelcome() {
		//greets the user
		System.out.println("****************************************");
		System.out.println("        INSURANCE SCORE CARD            ");
		System.out.println("This app scores a potential customer    ");
		System.out.println("on various health attributes: blood     ");
		System.out.println("pressure, age, height, weight, and      ");
		System.out.println("family history of disease. It writes    ");
		System.out.println("each member's insurance grade to a      ");
		System.out.println("JSON file so that they can be easily    ");
		System.out.println("shared on a web-based data exchange.    ");
		System.out.println("****************************************");
		System.out.println();
	}
	public static void printMenu() {
		//presents the options
		System.out.println("");
		System.out.println("Here are your choices: ");
		System.out.println("   1. List members");
		System.out.println("   2. Add a new member");
		System.out.println("   3. Save members");
		System.out.println("   4. Load members");
		System.out.println("   5. Assess members");
		System.out.println("   6. Save assessments as JSON");
		System.out.println("   7. Exit");
	}
	public static void main(String[] args) {
		printWelcome();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name of member file: ");
		// reads original file of members
		String fname = sc.nextLine();
		int choice;
		ArrayList<Member> members = new ArrayList<Member>();
		ArrayList<String> ins = new ArrayList<String>();
		if(fname.contains(".txt")) {
			members = MemberReader.readMembersFromTextFile(fname);
		}
		else if(fname.contains(".bin")) {
			members = MemberReader.readMembersFromBinary(fname);
		}
		else if(fname.contains(".xml")) {
			members = MemberReader.readMembersFromXML(fname);
		}
		else {
			members = null;
		}
		if(members == null) {
			System.out.println("Something went wrong.");
		}	
		else {
			System.out.println(members.size() + " members were read.");
			do {
				printMenu();
				System.out.print("Please enter your choice: ");
				choice = sc.nextInt();
				if(choice == 1) {
					// list all members
					MemberWriter.writeMembersToScreen(members);
				}
				else if(choice == 2) {
					// add a new member
					System.out.print("Enter first name: ");
					String firstName = sc.next();
					System.out.print("Enter last name: ");
					String lastName = sc.next();
					System.out.print("Enter age: ");
					int age = sc.nextInt();
					System.out.print("Enter height in inches: ");
					int height = sc.nextInt();
					System.out.print("Enter weight in pounds: ");
					int weight = sc.nextInt();
					System.out.print("Enter blood pressure (sys and dia): ");
					int bps = sc.nextInt();
					int bpd = sc.nextInt();
					System.out.println("Has a famiy member had...");
					System.out.print("Cancer? ");
					String cancer = sc.next();
					System.out.print("Diabetes? ");
					String diabetes = sc.next();
					System.out.print("Alzheimers? ");
					String alz = sc.next();
					Member member = new Member(firstName, lastName, age, height,
							weight, bps, bpd, cancer, diabetes, alz);
					members.add(member);
					System.out.println("The new member has been added.");
				}
				else if(choice == 3) {
					// save members
					System.out.print("(T)ext, (B)inary, or (X)ml? ");
					String save = sc.next();
					System.out.println("Enter name of output file: ");
					String fOut = sc.next();
					if(save.equals("T")) {
						MemberWriter.writeMembersToTextFile(fOut, members);
						System.out.println("Members were written successfully.");
					}
					else if(save.equals("B")) {
						MemberWriter.writeMembersToBinary(fOut, members);
						System.out.println("Members were written successfully.");
					}
					else if(save.equals("X")) {
						MemberWriter.writeMembersToXML(fOut, members);
						System.out.println("Members were written successfully.");
					}
					else {
						System.out.println("That is an invalid choice.");
					}
				}
				else if(choice == 4) {
					// load members from txt, bin, xml
					System.out.print("(T)ext, (B)inary, or (X)ML? ");
					String load = sc.next();
					System.out.println("Enter name of input file: ");
					String fIn = sc.next();
					if(load.equals("T")) {
						MemberReader.readMembersFromTextFile(fIn);
						System.out.println(members.size() + " members were read.");
					}
					else if(load.equals("B")) {
						MemberReader.readMembersFromBinary(fIn);
						System.out.println(members.size() + " members were read.");
					}
					else if(load.equals("X")) {
						MemberReader.readMembersFromXML(fIn);
						System.out.println(members.size() + " members were read.");
					}
				}
				else if(choice == 5) {
					// assess members
					System.out.println("Here are the insurance assessments: ");
					for (Member m : members) {
						InsuranceScoreWriter.writeAssessmentsToScreen(Assessor.assessMember(m));
					}
				}
				else if(choice == 6) {
					// write assessment to json
					System.out.println("Enter name of JSON file: ");
					String json = sc.next();
					for(int i = 0; i < members.size(); i++) {
						ins.add(InsuranceScore.toString(Assessor.assessMember(members.get(i))));
					}
				    InsuranceScoreWriter.writeAssessmentsToJSON(json, ins);
					System.out.println("File written successfully");
				}
				else if(choice == 7) {
					System.out.println("************************************");
					System.out.println("      INSURANCE SCORE CARD");
					System.out.println("            THANK YOU");
					System.out.println("************************************");
					// quit
					break;
				}
				else {
					System.out.println("Please choose a valid choice.");
				}
			} while(choice != 7);
			
		}
		sc.close();
	}
}
