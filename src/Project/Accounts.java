package Project;
public class Accounts {
	Atm_Bank_Interface2 account[] = new Atm_Bank_Interface2[10]; //creating an array of object for Atm_Bank_Interface2 class 
	int n=0; //Initially this variable is 0 and it will increment as no. of account holder increases
	
	void add() {
		if(n==10)  //Setting a maximum limit upto 10 is set for Account Holder    
		{
			System.out.println("Maximum account limit reached, no accounts can be created further!\n");
			return;
		}
		
		account[n]=new Atm_Bank_Interface2();         
		
		System.out.println("Enter Detalis for Account "+(n+1));
		account[n++].scan(n);  //calling scan() function to scan details from user  
		System.out.println();
	}
	
	void display() {
		if(this.n == 0)
		{
			System.out.println("No Accounts Available !\n");
			return;
		}
		//loop to call display function in Person class through Atm_Bank_Interface2 object 
		for(int i=0;i<n;i++)
		{
			System.out.println("|| Account "+(i+1)+" Details ||");
			account[i].display(i+1);
		}
		System.out.println();     
	}
        void gtr() //function where calling of write() function of Person class is called in loop
	{
		for(int i=0;i<n;i++)
		{
			//System.out.println("|| Account "+(i+1)+" Details ||");
			account[i].write(i+1);  
			
		}
	} 
	
        //Function to transfer money
	void transfer(int a,int b,int val) {
            //again validating that account no are coorect or not
		if(a>n || b>n || a<1 || b<1)
		{
			System.out.println("Invalid Account Nos. !\n");
			return;
		}
		
		a--;b--;
		
                //checking whether amount to be transferred is greater than person's balance
		if(val > account[a].curr)
		{
			System.out.println("Value to be transferred is greater than Current Account Balance of "+(a+1)+" !\n");
			return; //of yes then return
		}
		//or else money transfer is being done  
		account[a].curr-=val;
		account[b].curr+=val;
		
		System.out.println("Money Transfer Successful from Account "+a+"to Account "+b+" !\n");
	}
}