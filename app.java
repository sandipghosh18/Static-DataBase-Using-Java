import java.util.ArrayList;
import java.util.Scanner;

class database
{
	String welcome="WELCOME TO STUDENT DATABASE 1.0";
	String close="THANKS FOR USING STUDENT DATABASE.\nlogged Out!";
	String dbname;
}

class studentinfo
{
	private int id;
	String name;
	String department;
	String emailId;

	
	
   studentinfo(int id,String name,String department,String emailId)
	{
		this.id=id;
		this.name=name;
		this.department=department;
		this.emailId=emailId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}

class operationDataBase
{
	studentinfo stinfo;
	Scanner sc = new Scanner(System.in);
	int Id;
	String name;
	String Department;
	String mailId;
	public ArrayList<studentinfo> sArray= new ArrayList<studentinfo>();
	
	
	public void add()
	{
		System.out.println("Enter Student Id");
		Id= sc.nextInt();
		boolean cc= checkprimary(Id);
		if(cc==false)
		{
			System.out.println("The Id already exits in the Db");
			add();
			return;
			
		}
		
		System.out.println("Enter Student Name");
		name=sc.next();
		
		System.out.println("Enter Student Department");
		Department=getDepartment();
		
		System.out.println("Enter Student Email Id");
		mailId=sc.next();
		studentinfo x;
		 x = new studentinfo(Id,name,Department,mailId);
		
		 sArray.add(x);
		 System.out.println("Record added inside database");
		
	}
	
	public void display()
	{
		System.out.println("------------------------------------------------\n\n");
		System.out.println("ID \t Name \t Department\t Email");
		
		if(sArray.size()==0)
		{
			System.out.println("\tNo Data");
		}
		for(studentinfo si: sArray)
		{
			
			System.out.println("----------------------------------------------------");
			System.out.println(si.getId()+"\t"+si.getName()+"\t "+si.getDepartment()+"\t\t "+si.getEmailId());
			
		}
		System.out.println("----------------------------------------------------");
	}
	
	public String getDepartment()
	{
		System.out.println("Enter your choice for Department\n"
				+ "1.CSE\n2.ECE\n3.EE\n4.ME");
		int choice;
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			return "CSE";
		case 2:
			return "ECE";
		case 3:
			return "EE";
		case 4:
			return "ME";
			default:
				return getDepartment();
		}
		
	}
	
	public boolean checkprimary(int id)
	{
		for(studentinfo sicheck: sArray)
		{
			if(sicheck.getId()==id)
			{
				return false;
				
			}
			
		}
		return true;
		
		
		
		
	}
	
	public void getStudent()
	{
		System.out.println("Enter the Student Id:");
		int sid=sc.nextInt();
		if(checkprimary(sid)==false)
		{
			for(studentinfo info:sArray)
			{
				if(info.getId()==sid)
				{
					System.out.println("ID:"+info.getId()+"\nName:  "+info.getName()
					+"\nDepartment:"+ info.getDepartment()+"\nEmail: "+info.getEmailId());
				}
				
				
			}
		}
		else
		{
			System.out.println("No ID matched inside the database");
		}
		
	}
	
	public void deleteStudent()
	{
		System.out.println("Enter the student ID:");
		int id=sc.nextInt();
		boolean check=checkprimary(id);
		if(check==false)
		{
		int index =getIndex(id);
		sArray.remove(index);
		System.out.println("Record deleted....");
		}
		else
		{
			System.out.println("No such Id found in the DataBase");
		}
		
	}
		
	
	
	public int getIndex(int id)
	{
		int count=0;
	
		for(studentinfo si:sArray)
		{
			if(si.getId()==id)
			{
				return count;
			}
			count++;
			
		
	     }
		return 0;
	
    }
}



public class App {
	
      database db= new database();
      operationDataBase op= new operationDataBase();
     
      Scanner sc = new Scanner(System.in);
    
	public  void sessionStar()
	{  System.out.println(db.welcome);
	   System.out.println("Enter your DataBase Name:");
	   String name= db.dbname=sc.next();
		while(true)
		{
		System.out.println("\nChoose an option for Database operation\nTable Name:"
				+name+""
				+ "\n---------------------------------------------------------------------"
				+ "\n1:Add Student\n2:Display DataBase\n3:Display of a student information\n"
				+ "4:Delete a student:\n5.Enter any other key to get logged Out");
		int choice =sc.nextInt();
		
		
		switch(choice)
		{
		case 1:
			op.add();
			break;
		case 2:
			op.display();
			break;
		case 3:
			op.getStudent();
			break;
		case 4:
			op.deleteStudent();
			break;
			
			default:
				System.out.println("Are you sure to Log Out? enter Y/N");
				String str=sc.next();
				if(str.equals("Y")||str.equals("y"))
				{
					System.out.println(db.close);
					System.exit(11);
				}
				else
				{
					break;
				}
				
				
				
			
		}
	    }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App obj= new App();
		obj.sessionStar();
		

	}

}
