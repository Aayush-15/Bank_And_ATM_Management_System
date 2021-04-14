package Project;
public class Atm_Bank_Interface2 extends Atm_Bank_Interface1{
	int fd=0;
	
//Function for Deposit Operation
void deposit(int val)
{
	int choice = 0;
	System.out.println("Savings Account = 1 , Fixed Deposit = 2");                                
	System.out.println("Option : ");             
	choice=sc.nextInt();
	
	System.out.println();
	
	if(choice == 1) //Savings Account 
	{
		this.save+=val;
		this.returns+=val*0.1;     //Profit return by 10% 
	}
	
	else if(choice == 2) //Fixed Deposit
	{
		fd+=val;
		this.returns+=val*0.15;   //Profit return by 15%     
	}
	
    else   //this condition is to check invalid option if user enter another option
	{
		System.out.println("Invalid Option !\n");     
		return;
	}
	
	System.out.println("Deposit Successful !\n");
}

    //Function for Loan Operation 
     void loan(int val)
     {  
        //validating that this bank is granting loan upto 1000
	    if(val < 1000) { 
		System.out.println("Loan only valid for value >=1000 !\n");
		return; //or else return if limit exceeds
	 }
	
	this.curr+=val;   //loan is credited into account  
	this.debt+=val*1.15; //and debt is calculated based on it
	
	System.out.println("Amount transferred to your current account!");
	System.out.println("Total Current Debt : "+super.debt+"\n");    
    }          
}
