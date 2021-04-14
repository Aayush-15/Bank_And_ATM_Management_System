package Project;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Person {
	Scanner sc = new Scanner(System.in); 
	
        //Initializing variables required for storing Account Holder Details
	String name;  
	String address;   
	String mobile;
	
	double curr;   
	double save; 
	
	double returns; 
	double debt;
	
        
        //Constructor to initialize all variables to default values 
	Person() {
		this.name="";
		this.address="";
		this.mobile="";
		
		this.curr=0;
		this.save=5000;
		
		this.returns=0;
		this.debt=0;
	}
	
        //this function is to scan various information from user
	void scan(int n) {
		System.out.println("Name : ");     
		this.name=sc.nextLine();
		
		System.out.println("Address : ");
		this.address=sc.next();  
		
		System.out.println("Mobile Number : ");
		this.mobile=sc.next();   
		
		System.out.println();
		
		System.out.println("Current Account Initial Balance : ");
                //do while loop so that user enters amount greater than 0 for current account
		do { 
			System.out.println("Enter Value >=0 : ");
			this.curr=sc.nextInt();
		} while(this.curr<0);
		
		System.out.println(); 
		
		System.out.println("Saving Account Initial Balance : ");  
                //do while loop so that user enters amount greater than 5000 for savings account      
		do {
			System.out.println("Enter Value >=5000 : ");   
			this.save=sc.nextInt();
		} while(this.save<5000);
		
		System.out.println(); 
                System.out.println("Your Account No. Given By Bank is "+n);
		
		this.returns=0.1*this.save; 
	}
	
        //Display function to display details of Account Holders in CONSOLE as well as in FILE
	void display(int n) {
		System.out.println("Name : "+this.name); 
                System.out.println("Your Account No : "+n);    
		System.out.println("Adress : "+this.address);                          
		System.out.println("Mobile Number : "+this.mobile+"\n");                    
		
		System.out.println("Current account balance : "+this.curr);                    
		System.out.println("Saving account balance : "+this.save+"\n");                      
		
		System.out.println("Total Profit Returns : "+this.returns);                             
		System.out.println("Total Debt : "+this.debt+"\n\n"); 
                
           //FILE MANAGEMENT
           //ERROR exception concept is used to check whether the file is present or not
          
	}
        //FILE HANDLING
        //Function for writing in file
        void write(int n)
        {
            try{
            BufferedWriter f= new BufferedWriter(new FileWriter("A:\\bank_java\\Output_File.txt",true));
            f.write("Account "+n+" Details:"); //command to write in file 
            f.newLine();    //command to go to next line 
            f.write("Name : "+this.name);    
            f.newLine(); 
            f.write("Account No: "+n);             
            f.newLine();
            f.write("Adress : "+this.address);   
            f.newLine();
            f.write("Mobile Number : "+this.mobile+"\n"); 
            f.newLine();
            f.write("Current account balance : "+this.curr);
            f.newLine();
            f.write("Saving account balance : "+this.save+"\n"); 
            f.newLine(); 
            f.write("Total Profit Returns : "+this.returns);   
            f.newLine();      
            f.write("Total Debt : "+this.debt+"\n\n");
            f.newLine(); 
            f.newLine(); 
            f.close();   
        }
        catch(Exception e) //Exception if file is not found 
         {     
                    System.out.println("Error!!  File not found");
         } 
        }
}