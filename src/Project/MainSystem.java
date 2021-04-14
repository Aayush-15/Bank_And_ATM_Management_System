package Project;
import java.util.Scanner;  //import Scanner class
import java.io.BufferedWriter;
import java.io.FileWriter; 
public class MainSystem {
	public static void main(String[] args)  //main method
        {
		Scanner sc = new Scanner(System.in); //creating Scanner object
		Accounts acc = new Accounts();  //object of Accounts class 
		
		System.out.println("Welcome to Bank/ATM Interface !");
		int choice=0;
                //Asking the choice of user
		while(choice!=3)
		{
			System.out.println("*************************");
			System.out.println("1. Create New Account");
			System.out.println("2. Choose Account");
			System.out.println("3. Exit");
			System.out.println("*************************\n");
			
			System.out.println("Option 1 : ");
			choice = sc.nextInt();
			
			System.out.println();
			
			if(choice == 1) //It is to create a NEW ACCOUNT       
				acc.add();
			else if(choice == 2) //to choose a Account   
			{
				if(acc.n == 0)
				{
					System.out.println("No Accounts Available !\n");
					continue;
				}
				
				System.out.println("Enter Your Account No: ");              
				int x = 0;
                                //loop so that user enter correct account no.   
				do {
					System.out.println("Select from (1 - "+acc.n+") : "); 
					x = sc.nextInt();
                                        System.out.println();
                                        System.out.println("Your Account No. is "+x);    
				} while(x<1 && x>acc.n);
				
				x--;
				
				System.out.println("\n*************************");
				System.out.println("(1) Withdraw");            
				System.out.println("(2) Check Balance");
				System.out.println("(3) Deposit");
				System.out.println("(4) Loan");  
				System.out.println("(5) Money Transfer");
				System.out.println("*************************\n");
				//User to choose which operation he wants to perform
				System.out.println("Option 2 : ");
				int choice2 = sc.nextInt();       
				
				System.out.println();
				
				int val=0;
				if(choice2 == 1) //option for  Withdraw
				{
					System.out.println("Enter the amount to be Withdrawn : ");
					val=0;
					//loop to validate so that user do not enter negative value 
					do {
						System.out.println("Enter Value >=0 : ");
						val=sc.nextInt(); //Scanning the amount to be Withdrawn
					} while(val<0);
					
					acc.account[x].withdraw(val); //calling withdraw function through object
				}
				else if(choice2 == 2) //option to Check Balance  
				{
					System.out.println("Account "+(x+1)+" Balance : ");
					acc.account[x].balance();
				}
				else if(choice2 == 3)  //option for Deposit
				{
					System.out.println("Enter the amount to be Deposited : ");
					val=0;
					//loop to validate so that user doesn't enter negative value 
					do {
						System.out.println("Enter Value >=0 : ");
						val=sc.nextInt(); //Scanning the amount to be Deposited  
					} while(val<0);    
					
					acc.account[x].deposit(val); //calling deposit function through object
				}
				else if(choice2 == 4) //option for Loan 
				{
					System.out.println("Enter the amount to be Lent : ");  
					val=0;
					//loop to check user do not enter negative value   
					do {
						System.out.println("Enter Value >=0 and <=1000: "); 
						val=sc.nextInt(); //Scanning the amount to be lent  
					} while(val<0);
					
					acc.account[x].loan(val);
				}
				else if(choice2 == 5) //option for Money Transfer    
				{
					System.out.println("Enter Account no. in which you need to transfer: ");
					int y=0;
					//loop to check user enter correct Account No; 
					do {
						System.out.println("Select from (1 - "+acc.n+") : ");
						y = sc.nextInt();
					} while(y<1 && y>acc.n);
					
					System.out.println("Enter the amount to be Transferred : ");
					val=0;
					//Scanning the amount to be transferred 
					do {
						System.out.println("Enter Value >=0 : ");
						val=sc.nextInt();
					} while(val<0);
					
					acc.transfer(x+1,y,val);
				}
                                else //invalid option condition
					System.out.println("Invalid Option 2 !\n");
			}
			else if(choice == 3) 
				System.out.println("Exiting .... "); //Option to exit
			else
				System.out.println("Invalid Option 1 !\n"); 
		}
                //Asking user whether he is banker or not
                //if Banker then only accessible to get the display of all account holder details  
                
        System.out.println("Press Y|y if you Are a banker");
		
        char ch=sc.next().charAt(0);
		
        boolean chk=true;
		
        if(ch=='Y'||ch=='y')    
		{   
			int choice3=0;
			if(chk==true);
			{   
				System.out.println("Welcome To Admin Page");                 
				while(choice3!=3)
				{       
                                        //Again Providing choice 
                      System.out.println("Enter Your Option"); 
					System.out.println("1.Display All Account Details");
					System.out.println("2.Print All Account Details ");  
					System.out.println("3.Exit From Here");
					choice3= sc.nextInt();
					if(choice3==1) //to display all details
					{
						acc.display(); //calling display() function of Accounts class
					}
                                        //FILE HANDLING CONCEPT 
					else if(choice3==2) //to print in file
					{ 
						acc.gtr(); //calling gtr() function of Accounts class  
                                                System.out.println("Check your data entry in file"); 
					}
					else if(choice3 == 3)
						System.out.println("Exiting .... ");
					else
						System.out.println("Invalid Option 1 !\n");         
				}
				
				
				
			}
			
		}
	}
}