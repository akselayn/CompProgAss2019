import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;



public class Student {
	static ArrayList<Student> StuList= new ArrayList<Student>();
	private static String[] args;

	private String ID,name,surname;
	private int crs1grd,crs2grd,crs3grd,crs4grd,crs5grd;
	double GPA;

public Student(){	//copy of constructor 
		this.name="name";	
		this.ID="ID";
		this.surname="surname";
		this.crs1grd=100;
		this.crs2grd=100;
		this.crs3grd=100;
		this.crs4grd=100;
		this.crs5grd=100;
		}

public Student(String id,String name,String sname,int g1,int g2,int g3,int g4,int g5) {
		this.ID=id;			//Constructor of Student object with arguments
		this.name=name;
		this.surname=sname;
		this.crs1grd=g1;
		this.crs2grd=g2;
		this.crs3grd=g3;
		this.crs4grd=g4;
		this.crs5grd=g5;
		this.GPA= calcGpa( g1,g2, g3, g4, g5);
	}

public void setID(String i) {this.ID=i;}//Set Methods to set Student objects' private fields
public void setName(String n) {this.name=n;}
public void setSurame(String n) {this.surname=n;}
public void setCrs1grd(int g) {this.crs1grd=g;}
public void setCrs2grd(int g) {this.crs2grd=g;}
public void setCrs3grd(int g) {this.crs3grd=g;}
public void setCrs4grd(int g) {this.crs4grd=g;}
public void setCrs5grd(int g) {this.crs5grd=g;}


public String  getID() {return this.ID;}//Get Methods to get Student objects' private fields
public String getName() {return this.name;}
public String getSurname() {return this.surname;}
public int getCrs1grd() {return this.crs1grd;}
public int getCrs2grd() {return this.crs2grd;}
public int getCrs3grd() {return this.crs3grd;}
public int getCrs4grd() {return this.crs4grd;}
public int getCrs5grd() {return this.crs5grd;}
public double getGPA() {return this.GPA;}
public static double calcGpa(int g1,int g2,int g3,int g4,int g5) //Method for calculating GPA using 5 grades
{
	double GPA=(g1+g2+g3+g4+g5)/5;
	return GPA;
}

public static void calcAvrGpa() // Method for calculating average GPA
{
	double totalGrades=0;
	int numOfStud=0;
	StuList.clear();			// before reading students from file to ArrayList clears the ArrayList. 
		try {					//Reading from file each line holds one student info and splitting each line to Student's fields
		BufferedReader br2 = new BufferedReader(new FileReader("Students.txt"));
		 String line;
			while((line=br2.readLine())!=null) 
			{    
			String[] pieces = line.split(Pattern.quote(","));
			int c1g= Integer.parseInt(pieces[3]);
			int c2g = Integer.parseInt(pieces[4]);
			int c3g =Integer.parseInt(pieces[5]);
			int c4g = Integer.parseInt(pieces[6]);
			int c5g = Integer.parseInt(pieces[7]);
			numOfStud++;		 //(Number of Student) variable increases after reading each Student
			totalGrades+=calcGpa(c1g,c2g,c3g,c4g,c5g);// Calculating each Student's GPA and add to Total Grades.
			
			}br2.close();
		}
			
		catch (IOException e) {
		System.out.println(e);
		e.printStackTrace();}
		
	double average=totalGrades/numOfStud;	// Dividing Total Grades to Number of Students to get average GPA
	System.out.println("Average GPA of "+numOfStud+" Students= "+average);
	
	menu.main(args);
}	

	
	
	

	public static void showStudentInfo() // Function to show one student
	{
		StuList.clear();
		System.out.println("Which Student you want to see\nEnter Student ID=");
		Scanner input= new Scanner(System.in); // Asks user to enter ID of Student that wanted to be shown.
		String query= input.nextLine();			
		BufferedReader br1;						// Reading student info from File
			try {
				br1 = new BufferedReader(new FileReader("Students.txt"));
		        String line =br1.readLine(); 
				while( (line=br1.readLine())!=null) 
				{
		     
			     String[] pieces = line.split(Pattern.quote(","));
			     String ID = pieces[0];
				 String name = pieces[1];
				 String surname = pieces[2];
				 int c1g= Integer.parseInt(pieces[3]);
				 int c2g = Integer.parseInt(pieces[4]);
				 int c3g =Integer.parseInt(pieces[5]);
				 int c4g = Integer.parseInt(pieces[6]);
				 int c5g = Integer.parseInt(pieces[7]);
				
		 
			 if (query.equals(ID)) { 			// Linear Search of wanted student ID in read Student ID if equals added to ArrayList
				 Student st= new Student(ID,name,surname,c1g,c2g,c3g,c4g,c5g); 
				 StuList.add(st);
				 }
			 
				}br1.close();
				}
			        	
			catch (IOException e) {
			    System.out.println(e);
			    e.printStackTrace();}	
	
		
		for(int i=0;i<StuList.size();i++) { // Listing found students from Array list
			Student st1= new Student();
			st1=StuList.get(i);
			
			 System.out.println("Student ID= "+ st1.getID()); 
			 System.out.println("Student Name= "+ st1.getName());
			 System.out.println("Student Surname= "+ st1.getSurname());
			 System.out.println("Course1 Grade= "+ st1.getCrs1grd());
			 System.out.println("Course2 Grade= "+ st1.getCrs2grd());
			 System.out.println("Course3 Grade= "+ st1.getCrs3grd());
			 System.out.println("Course4 Grade= "+ st1.getCrs4grd());
			 System.out.println("Course5 Grade= "+ st1.getCrs5grd());}
		
		menu.main(args);
	}

public static void showAllStudentInfo()  //Shows All students info asks user to select way of sorting and lists students according to user selection
{
		int selection;
		Scanner input= new Scanner(System.in);
		System.out.println("Show All Students MENU\n*******************\n1-Show Students ascending to ID\n2-Show Students Alphabetically \n"
				+ "3-Show Students sorted according to GPA\nPlease Enter Your Choice (1-3):");
		selection=input.nextInt(); 
		StuList.clear();
				try {				//Reading student info from File
					BufferedReader br2 = new BufferedReader(new FileReader("Students.txt"));
					String line;
						while((line=br2.readLine())!=null) 
						{    
							String[] pieces = line.split(Pattern.quote(","));
							String ID = pieces[0];
							String name = pieces[1];
							String surname = pieces[2];
							int c1g= Integer.parseInt(pieces[3]);
							int c2g = Integer.parseInt(pieces[4]);
							int c3g =Integer.parseInt(pieces[5]);
							int c4g = Integer.parseInt(pieces[6]);
							int c5g = Integer.parseInt(pieces[7]);
		 
							Student st= new Student(ID,name,surname,c1g,c2g,c3g,c4g,c5g);
							StuList.add(st);	//adding students read from file to ArrayList.
						}br2.close();
						}
	        	
				catch (IOException e) {
					System.out.println(e);
					e.printStackTrace();}
					System.out.println("ID \tName \tSurname \tCourse1Grade\tCourse2Grade\tCourse3Grade\tCourse4Grade\tCourse5Grade\tGPA");	
	
		if (selection==1) {	//sorting is made according to Student ID
			
			Collections.sort(StuList, new Comparator<Student>() {
			        public int compare(Student s1, Student s2) {
			           return Integer.valueOf(Integer.parseInt(s1.getID())).compareTo(Integer.parseInt(s2.getID()));
			        }
			});
		}
		if (selection==2) {// sorting is made according to Student name
			
			Collections.sort(StuList, new Comparator<Student>() {
			        public int compare(Student s1, Student s2) {
			           String name1=s1.getName().toUpperCase();
			           String name2=s2.getName().toUpperCase();
			           return name1.compareTo(name2);
			        }
			});
		}
		if (selection==3) { //sorting is made according to Student GPA
			
			Collections.sort(StuList, new Comparator<Student>() {
			        public int compare(Student s1, Student s2) {
			        	return Double.valueOf(s1.getGPA()).compareTo(s2.getGPA());
			        }
			});
		}
					for(int i=0;i<StuList.size();i++) //Listing Sorted Students from ArrayList.
		{Student st1= new Student();
		st1=StuList.get(i);
		System.out.println(st1.getID()+"\t"+st1.getName()+"\t"+st1.getSurname()+"\t\t"+st1.getCrs1grd()+"\t\t"
		+st1.getCrs2grd()+"\t\t"+st1.getCrs3grd()+"\t\t"+st1.getCrs4grd()+"\t\t"+st1.getCrs5grd()+"\t\t"+st1.getGPA());
		}
		menu.main(args);
		 }	
		
	        	

public static void addStudentInfo() { //Adding new Student to file
		Scanner input= new Scanner(System.in); //Asks user to input needed information
		System.out.println("Enter Student info you want to add");
		System.out.println("Enter ID=");
		String ID= input.nextLine();
		System.out.println("Enter Name=");
		String name= input.nextLine();
		System.out.println("Enter Surname=");
		String surname= input.nextLine();
		System.out.println("Enter Course1 Grade=");
		int c1g= input.nextInt();
		System.out.println("Enter Course2 Grade=");
		int c2g= input.nextInt();
		System.out.println("Enter Course3 Grade=");
		int c3g= input.nextInt();
		System.out.println("Enter Course4 Grade=");
		int c4g= input.nextInt();
		System.out.println("Enter Course5 Grade=");
		int c5g= input.nextInt();
		double gpa=calcGpa(c1g,c2g,c3g,c4g,c5g);
		FileWriter fw;				// Writing entered information of new student to file using file writer.
			try {
				fw = new FileWriter("Students.txt", true);
				fw.write(ID+","+name+ "," + surname + "," + c1g + ","+ c2g + "," + c3g + ","
					+ c4g + "," + c5g+ "," +gpa+ ","+System.lineSeparator());
				fw.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		menu.main(args);
	}

public static void updateStudentInfo() //Updating Student information
{
	StuList.clear();					// clear the ArrayList from previous entries if exists
	System.out.println("Enter Student ID you want to update:"); //asks user to input ID wanted to be updated
	Scanner input= new Scanner(System.in);
	String idToUpdate=input.nextLine();
	BufferedReader br3;
		try {							//Read students info from file 
			br3 = new BufferedReader(new FileReader("Students.txt"));
	        String line;
			while((line=br3.readLine())!=null) {
			
	     String[] pieces = line.split(Pattern.quote(","));
	     String ID = pieces[0];
		 String name = pieces[1];
		 String surname = pieces[2];
		 int c1g= Integer.parseInt(pieces[3]);
		 int c2g = Integer.parseInt(pieces[4]);
		 int c3g =Integer.parseInt(pieces[5]);
		 int c4g = Integer.parseInt(pieces[6]);
		 int c5g = Integer.parseInt(pieces[7]);
		 Student st= new Student(ID,name,surname,c1g,c2g,c3g,c4g,c5g);
		 	 if (idToUpdate.equals(ID)) {	//if  the wanted Student is found it is asked user to enter new info
		 		 ID=idToUpdate;
			 System.out.println("Old name: "+name+", Update to:");
			 name=input.nextLine();
			 System.out.println("Old Surname: "+surname+", Update to:");
			 surname=input.nextLine();
			 System.out.println("Old Course1Grade:"+c1g+",Update to:");
			 c1g=input.nextInt();
			 System.out.println("Old Course2Grade:"+c2g+",Update to:");
			 c2g=input.nextInt();
			 System.out.println("Old Course3Grade:"+c3g+",Update to:");
			 c3g=input.nextInt();
			 System.out.println("Old Course4Grade:"+c4g+",Update to:");
			 c4g=input.nextInt();
			 System.out.println("Old Course5Grade:"+c5g+",Update to:");
			 c5g=input.nextInt();
			
			 Student st1= new Student(ID,name,surname,c1g,c2g,c3g,c4g,c5g);
			
		 		 
		 		System.out.println("Are you sure to update?1.Y/2.N:");// ask user before updating
				int sure=input.nextInt();
				if(sure==1){StuList.add(st1);}
				else {StuList.add(st);}
		 		} 	
		 	
	 	 
		 	 else {StuList.add(st);}
	 	 
	 	
	  
	 }br3.close();
	
	}
        	
		catch (IOException e) {
		    System.out.println(e);
		    e.printStackTrace();}
	FileWriter fw1;						//Clear the content of file before re-writing
		try 
		{
			fw1 = new FileWriter("Students.txt", false);
			fw1.write("");
			fw1.close();
				}
		 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 for(int i=0;i<StuList.size();i++) {
			Student st1= new Student();
			st1=StuList.get(i);
			FileWriter fw;
		try 							//Write the students in ArrayList to file.
		{
			fw = new FileWriter("Students.txt", true);
			fw.write(st1.getID()+","+st1.getName()+ "," + st1.getSurname() + "," + st1.getCrs1grd() + ","
					+st1.getCrs2grd() + "," + st1.getCrs3grd() + ","+st1.getCrs4grd() + "," +st1.getCrs5grd()+ "," 
					+System.lineSeparator());
				fw.close();
				}
		 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
				
			 menu.main(args);	
	 }

public static void delStudentInfo() //Deleting Student information
{
	StuList.clear(); 				// Clear the content of ArrayList 
	System.out.println("Enter Student ID you want to delete:"); 	//asks user student Id to be deleted.
	Scanner input= new Scanner(System.in);
	String idToDelete=input.nextLine();
	System.out.println("Are you sure to delete ID="+idToDelete+" Student ?1.Y/2.N:"); //asks user for confirmation of delete
	int sure=input.nextInt();
	if (sure==1) {
		BufferedReader br3;				//read all Students from file and add to ArrayList unless it is not equals to Id to be deleted.
		try {
			br3 = new BufferedReader(new FileReader("Students.txt"));
			String line;
			while((line=br3.readLine())!=null) {
		
				String[] pieces = line.split(Pattern.quote(","));
				String ID = pieces[0];
				String name = pieces[1];
				String surname = pieces[2];
				int c1g= Integer.parseInt(pieces[3]);
				int c2g = Integer.parseInt(pieces[4]);
				int c3g =Integer.parseInt(pieces[5]);
				int c4g = Integer.parseInt(pieces[6]);
				int c5g = Integer.parseInt(pieces[7]);
					if (!idToDelete.equals(ID)) {
						Student st= new Student(ID,name,surname,c1g,c2g,c3g,c4g,c5g);
						StuList.add(st);
					}
	 	  
			}br3.close();
	
			}	
        	
		catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();}
	FileWriter fw1;		//Clear the content of file before re-writing
		try 
		{
			fw1 = new FileWriter("Students.txt", false);
			fw1.write("");
			fw1.close();
			}
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 for(int i=0;i<StuList.size();i++) {
			Student st1= new Student();
			st1=StuList.get(i);
				FileWriter fw; //Write the students in ArrayList to file.
				try 
				{
					fw = new FileWriter("Students.txt", true);
					fw.write(st1.getID()+","+st1.getName()+ "," + st1.getSurname() + "," + st1.getCrs1grd() + ","
							+st1.getCrs2grd() + "," + st1.getCrs3grd() + ","+st1.getCrs4grd() + "," +st1.getCrs5grd()+ "," 
							+System.lineSeparator());
					fw.close();
				}
				catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}}
			
	menu.main(args);	
	 }

public static void showGPAInfo() 								//Function to show student's GPA
{
	System.out.println("Enter Student ID you want to see GPA:");//Asks user input student id to show GPA
	Scanner input= new Scanner(System.in);
	String idForGPA=input.nextLine();
		BufferedReader br3;										//Read all students from file
		try {	
			br3 = new BufferedReader(new FileReader("Students.txt"));
			String line;
			while((line=br3.readLine())!=null) {
		
				String[] pieces = line.split(Pattern.quote(","));
				String ID = pieces[0];
				String name = pieces[1];
				String surname = pieces[2];
				int c1g= Integer.parseInt(pieces[3]);
				int c2g = Integer.parseInt(pieces[4]);
				int c3g =Integer.parseInt(pieces[5]);
				int c4g = Integer.parseInt(pieces[6]);
				int c5g = Integer.parseInt(pieces[7]);
					if (idForGPA.equals(ID)) {	//If entered id is found GPA calculated and listed 
						Student st= new Student(ID,name,surname,c1g,c2g,c3g,c4g,c5g);
						 System.out.println("Student ID= "+ st.getID()); 
						 System.out.println("Student Name= "+ st.getName());
						 System.out.println("Student Surname= "+ st.getSurname());
						 System.out.println("Course1 Grade= "+ st.getCrs1grd());
						 System.out.println("Course2 Grade= "+ st.getCrs2grd());
						 System.out.println("Course3 Grade= "+ st.getCrs3grd());
						 System.out.println("Course4 Grade= "+ st.getCrs4grd());
						 System.out.println("Course5 Grade= "+ st.getCrs5grd());
						 System.out.println("GPA= "+ calcGpa(c1g, c2g, c3g, c4g, c5g));
					}
			 	  
			}br3.close();
	
			}	
        	
		catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();}
	menu.main(args);
}
		

}
