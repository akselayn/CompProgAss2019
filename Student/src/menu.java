import java.util.Scanner;

public class menu {
	static long startTime = System.currentTimeMillis(); //Starting time will be used to calculate execution time
	public static void main(String[]args){
		
		int selection;				//Menu asks user to make selection and switches starting  function according to user's selection.
	Scanner input= new Scanner(System.in);
	
	
	System.out.println("MAIN MENU\n*******************\n1-Show Student Information\n2-Show All Students Information\n"
			+ "3-Update Student Information\n4-Delete Student Information\n5-Add Student Information\n6-Show GPA Information"
			+ "\n7-Calculate Average GPA\n8-EXIT\n*******************\nPlease Enter Your Choice (1-8):");
	selection=input.nextInt(); 
		switch(selection) {
			case 1: 
				Student.showStudentInfo();
				break;
			case 2: 
				Student.showAllStudentInfo();
				break;
			case 3: 
				Student.updateStudentInfo();
				break;
			case 4:
				Student.delStudentInfo();
				break;
			case 5:
				Student.addStudentInfo();
				break;
			case 6:
				Student.showGPAInfo();
				break;
			case 7: 
				Student.calcAvrGpa();
				break;
			case 8: 					// in case of selecting exit program stops and shows time taken.
				System.out.println("Good Bye");
				input.close();
				System.out.println("Time taken : " + ( System.currentTimeMillis() - startTime ) + " millisecond(s)." );
				break;
			default:					
				System.out.println("Please enter selection in correct form");
				break;
				}
	
	}
		
}
