import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TestingStudent {static long startTime = System.currentTimeMillis(); 
public static void main(String[]args){
	int selection;
	Scanner input= new Scanner(System.in);
	
	
	System.out.println("TEST MENU\n*******************\n1-Bubble Sorting ArrayList \n2-Bubble Sorting Array\n"
			+ "3-Quick Sorting  Student List\n4-Linear Search of Student Information\n"
			+ "5-Binary Search of Student Information\n6-Deleting Student using ArrayList "
			+ "\n7-Deleting Student Using Array\n8-EXIT\n*******************\nPlease Enter Your Choice (1-8):");
	selection=input.nextInt(); 
	switch(selection) {
	case 1: 
		bubblesrtArrList();
		break;
	case 2: 
		 bubblesrtArray();
		break;
	case 3: 
		quickSorting();
		break;
	case 4:
		linearSearch();
		break;
	case 5:
		binarySearch();
		break;
	case 6:
		delStudentInfo();
		break;
	case 7:
		delstudentArray();
		break;
	case 8:
		System.out.println("Good Bye");
		input.close();
		 
		break;
	default:
		System.out.println("Please enter selection in correct form");
		break;
	}

}
public static void bubblesrtArrList()
{long startTime = System.currentTimeMillis(); 
	ArrayList<Student> stuList=new ArrayList<Student>();
	Student temp;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Students.txt"));
			String line;
				while((line=reader.readLine())!=null) 
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
					stuList.add(st);
				}reader.close();
			}
	
		catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();}
      
      if (stuList.size()>1) // Checking ArrayList has more than one member
      {
          for (int x=0; x<stuList.size(); x++) //Outer loop for Bubble sort
          {
              for (int i=0; i < stuList.size()-x-1; i++) {
                  if (stuList.get(i).getName().compareTo(stuList.get(i+1).getName()) > 0)
                  {
                      temp = stuList.get(i);
                      stuList.set(i,stuList.get(i+1) );
                      stuList.set(i+1, temp);
                  }
              }
          }
      }
      System.out.println("ID \tName \tSurname \tCourse1Grade\tCourse2Grade\tCourse3Grade\tCourse4Grade\tCourse5Grade\tGPA");
      for(int i=0;i<stuList.size();i++) 
  	{Student st1= new Student();
  	st1=stuList.get(i);
  	System.out.println(st1.getID()+"\t"+st1.getName()+"\t"+st1.getSurname()+"\t\t"+st1.getCrs1grd()+"\t\t"
  	+st1.getCrs2grd()+"\t\t"+st1.getCrs3grd()+"\t\t"+st1.getCrs4grd()+"\t\t"+st1.getCrs5grd()+"\t\t"+st1.getGPA());
  	}
      System.out.println("Time taken : " + ( System.currentTimeMillis() - startTime ) + " millisecond(s)." );
     
}

public static void bubblesrtArray()
{
	long startTime = System.currentTimeMillis(); 
	System.out.println("Please enter how many students you want to sort");
	Scanner input= new Scanner(System.in);
	int numofstu=input.nextInt();
	Student[] stuArray=new Student[numofstu];
	Student temp;
	int index=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Students.txt"));
			String line;
				while(numofstu>index) 
				{    line=br.readLine();
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
					stuArray[index]=st;
					index++;
				}br.close();
			}
	
		catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();}
      
      
          for (int x=0; x<stuArray.length; x++) //Outer loop for Bubble sort
          {
              for (int i=0; i < stuArray.length-i; i++) {
                  if (stuArray[i].getName().compareTo(stuArray[i+1].getName()) > 0)
                  {
                      temp = stuArray[i];
                      stuArray[i]=stuArray[i+1] ;
                      stuArray[i+1]= temp;
                  }
              }
          }
          System.out.println("ID \tName \tSurname \tCourse1Grade\tCourse2Grade\tCourse3Grade\tCourse4Grade\tCourse5Grade\tGPA");
          for(int i=0;i<stuArray.length;i++) 
      	{Student st1= new Student();
      	st1=stuArray[i];
      	System.out.println(st1.getID()+"\t"+st1.getName()+"\t"+st1.getSurname()+"\t\t"+st1.getCrs1grd()+"\t\t"
      	+st1.getCrs2grd()+"\t\t"+st1.getCrs3grd()+"\t\t"+st1.getCrs4grd()+"\t\t"+st1.getCrs5grd()+"\t\t"+st1.getGPA());
      	}
          System.out.println("Time taken : " + ( System.currentTimeMillis() - startTime ) + " millisecond(s)." );
input.close();
}

public static void quickSorting() {
	long startTime = System.currentTimeMillis(); 
	ArrayList<Student> stuList=new ArrayList<Student>();
			try {
			BufferedReader reader = new BufferedReader(new FileReader("Students.txt"));
			String line;
				while((line=reader.readLine())!=null) 
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
					stuList.add(st);
				}reader.close();
			}
	
		catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();}
			ArrayList<Student> sortedList=new ArrayList<Student>();
			sortedList=quickSort(stuList);
			 for(int i=0;i<sortedList.size();i++) 
			  	{Student st1= new Student();
			  	st1=sortedList.get(i);
			  	System.out.println(st1.getID()+"\t"+st1.getName()+"\t"+st1.getSurname()+"\t\t"+st1.getCrs1grd()+"\t\t"
			  	+st1.getCrs2grd()+"\t\t"+st1.getCrs3grd()+"\t\t"+st1.getCrs4grd()+"\t\t"+st1.getCrs5grd()+"\t\t"+st1.getGPA());
			  	}
			      System.out.println("Time taken : " + ( System.currentTimeMillis() - startTime ) + " millisecond(s)." );
			
}
public static ArrayList<Student> quickSort(ArrayList<Student> list)
{	if (list.size() <= 1) 
        return list; // Already sorted  

    ArrayList<Student> lesser = new ArrayList<Student>();
    ArrayList<Student> greater = new ArrayList<Student>();
    Student pivot = list.get(list.size()-1); // Use last Student as pivot
    for (int i = 0; i < list.size()-1; i++)
    {
        
        if (list.get(i).getName().compareTo(pivot.getName()) < 0)
            lesser.add(list.get(i));    
        else
            greater.add(list.get(i));   
    }

    lesser = quickSort(lesser);
    greater = quickSort(greater);

    lesser.add(pivot);
    lesser.addAll(greater);
   

    return lesser;
}
public static void linearSearch()
 {
	long startTime = System.currentTimeMillis(); 
	ArrayList<Student> StuList=new ArrayList<Student>();
	System.out.println("Which Student you want to see\nEnter Student name=");
	Scanner input= new Scanner(System.in);
	String query= input.nextLine();
	input.close();
	BufferedReader br1;
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
	
	 
	 if (query.equals(name)) { 
		 Student st= new Student(ID,name,surname,c1g,c2g,c3g,c4g,c5g);
		 StuList.add(st);
		 }
	 
		}br1.close();
	}
        	
catch (IOException e) {
    System.out.println(e);
    e.printStackTrace();}	
	
	
	for(int i=0;i<StuList.size();i++) {
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
	System.out.println("Time taken : " + ( System.currentTimeMillis() - startTime ) + " millisecond(s)." );

}
public static void binarySearch() 
{ long startTime = System.currentTimeMillis(); 
ArrayList<Student> StuList=new ArrayList<Student>();
	System.out.println("Which Student you want to see\nEnter Student name=");
Scanner input= new Scanner(System.in);
String query= input.nextLine();
input.close();
BufferedReader br1;
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
 int c5g = Integer.parseInt(pieces[7]);Student st= new Student(ID,name,surname,c1g,c2g,c3g,c4g,c5g);
 StuList.add(st); }
	 
		br1.close();
	}
       	
catch (IOException e) {
   System.out.println(e);
   e.printStackTrace();}
	
	 for (int i = 0; i < StuList.size(); i++){
	        String fName = (StuList.get(i).getName());
	        String lName = (StuList.get(i).getName());
	        //System.out.println(fName + " " + fName.length());
	        //System.out.println(lName + " " + lName.length());
	            if (query.equals(fName)){
	            		Student st1=StuList.get(i);
	            		System.out.println("Student ID= "+ st1.getID()); 
	       		 		System.out.println("Student Name= "+ st1.getName());
	       		 		System.out.println("Student Surname= "+ st1.getSurname());
	       		 		System.out.println("Course1 Grade= "+ st1.getCrs1grd());
	       		 		System.out.println("Course2 Grade= "+ st1.getCrs2grd());
	       		 		System.out.println("Course3 Grade= "+ st1.getCrs3grd());
	       		 		System.out.println("Course4 Grade= "+ st1.getCrs4grd());
	       		 		System.out.println("Course5 Grade= "+ st1.getCrs5grd());
	       		 		}
	            else if (query.equals(lName) ){
	            		Student st1=StuList.get(i);
	            		System.out.println("Student ID= "+ st1.getID()); 
	    	       		System.out.println("Student Name= "+ st1.getName());
	    	       		System.out.println("Student Surname= "+ st1.getSurname());
	    	       		System.out.println("Course1 Grade= "+ st1.getCrs1grd());
	    	       		System.out.println("Course2 Grade= "+ st1.getCrs2grd());
	    	       		System.out.println("Course3 Grade= "+ st1.getCrs3grd());
	    	       		System.out.println("Course4 Grade= "+ st1.getCrs4grd());
	    	       		System.out.println("Course5 Grade= "+ st1.getCrs5grd());
	                	}
	            
}System.out.println("Time taken : " + ( System.currentTimeMillis() - startTime ) + " millisecond(s)." );
	 }
public static void delStudentInfo() //Deleting Student information
{	
	long startTime = System.currentTimeMillis(); 
	ArrayList<Student> StuList=new ArrayList<Student>();
	System.out.println("Enter Student ID you want to delete:"); 	//asks user student Id to be deleted.
	Scanner input= new Scanner(System.in);
	String idToDelete=input.nextLine();
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
				e.printStackTrace();
				}
		}
			
	System.out.println("Time taken : " + ( System.currentTimeMillis() - startTime ) + " millisecond(s)." );
	 }
public static void delstudentArray()
{
	long startTime = System.currentTimeMillis(); 
	Student[] stuArray=new Student[50];
	int index=0;
	System.out.println("Enter Student ID you want to delete:"); 	
	Scanner input= new Scanner(System.in);
	String idToDelete=input.nextLine();

		try {
			BufferedReader br = new BufferedReader(new FileReader("Students.txt"));
			String line;
			
			while((line=br.readLine())!=null)
				 
				{   String[] pieces = line.split(Pattern.quote(","));
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
					stuArray[index]=st;
					index++;}
				}br.close();
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
      
      
          for (int x=0; x<index; x++) 
          {
        	  Student st1= new Student();
  			st1=stuArray[x];
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
  				e.printStackTrace();
  				}
          }
          
          System.out.println("Time taken : " + ( System.currentTimeMillis() - startTime ) + " millisecond(s)." );
input.close();
}
}
