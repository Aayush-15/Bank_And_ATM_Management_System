package Project;
public class Atm_Bank_Interface1 extends Person
{
	   void withdraw(int val) {
		int choice = 0;
		System.out.println("Fixed Account = 1 , Savings Account = 2");
		System.out.println("Option : "); 
		choice=sc.nextInt();
		System.out.println();
		  
		if(choice == 1) //FIXED ACCOUNT        
		{
                    //checking whether the amount to be withdrawn is greater than it's balance 
			if(val >= super.curr)  
			{
				System.out.println("You cannot withdraw more than your Current balance !\n");
				return; //if yes then return 
			}
			  
			super.curr-=val;
		}
		else if(choice == 2) //SAVING'S ACCOUNT                                    
		{
                    //to validate that Savings Account should have minimum balance of 5000 
			if(val >= super.save-5000)       
			{
				System.out.println("You have to keep a minimum balance of 5000 in your Savings account , you cannot withdraw more than that !\n");
				return;
			}
			super.save-=val;  //this much value is withdrawn from saving's account 
			super.returns=0.1*super.save;     //profit returns 
		}
		else
		{
			System.out.println("Invalid Option !\n");
			return;
		}
		
		System.out.println("Transaction Successful !\n");
	}
	//Function to check the balance 
	void balance() {
		System.out.println("Name : "+super.name);
		System.out.println("Current Balance : "+this.curr);
		System.out.println("Savings Balance : "+this.save+"\n");   
	}

}
