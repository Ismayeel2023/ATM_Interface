import java.util.Scanner;

class BankAccount{
	float balance;
	
	public BankAccount(float initialBalance) {
		this.balance = initialBalance;
	}
	float getBalance() {
		return balance;
	}
	void deposit(float amount) {
		if(amount<=0) {
			System.out.println("\nThe amount should be greater than 0 to be deposited\n");

			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println("Error occured while waiting"+e);
		
			}

		}else {
			balance+=amount;
			System.out.println("\n ₹"+amount+" deposited Successfully.");
			System.out.println("Your current balance is "+"₹"+balance+"\n");

			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println("Error occured while waiting"+e);
		
			}
			
		}
	}
	
	boolean withdraw(float amount) {
		if(balance<amount) {
			System.out.println("Insufficient Amount. Withdraw Failed\n");

			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println("Error occured while waiting"+e);
		
			}

			return false;
			
		}else {
			balance-=amount;
			System.out.println("\n₹"+amount+" Withdrawed Successfully.");
			System.out.println("Your current balance is "+"₹"+balance+"\n");

			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println("Error occured while waiting"+e);
		
			}

			return true;
		}
	}
}

class ATMMachine {
	BankAccount account;
	Scanner sc;
	
	public ATMMachine(BankAccount account) {
		this.account=account;
		this.sc=new Scanner(System.in);
	}
	
	void deposit() {
		System.out.println("Enter amount to be deposied: ");
		float amount = sc.nextFloat();
		account.deposit(amount);
	}
	
	void withdraw() {
		System.out.println("Enter amount to withdraw");
		float amount = sc.nextFloat();
		account.withdraw(amount);
	}
	
	void checkBalance() {
		System.out.println("Your current balance is ₹"+account.getBalance()+"\n");
	}
	

	
	public void display() {
		System.out.println("ENTER OPTION: ");
		System.out.println("1. DEPOSIT");
		System.out.println("2. WITHDRAW");
		System.out.println("3. CHECKBALANCE");
		System.out.println("4. QUIT");
	}
}



public class ATMInterface{
	public static void main(String[] args) {
		BankAccount account = new BankAccount(1000);
		ATMMachine atm = new ATMMachine(account);
		Scanner sc = new Scanner(System.in);
		while (true){
			atm.display();
			System.out.println("Enter Your Choice: ");
			int option = sc.nextInt();

			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println("Error occured while waiting"+e);
	
			}

			if(option==1) {
				atm.deposit();
			}else if(option==2) {
				atm.withdraw();
			}else if(option == 3) {
				atm.checkBalance();
			}else if(option == 4) {
				System.out.println("THANK YOU. VISIT AGAIN");
				break;
			}else {
				System.out.println("Invalid Option. Please enter the correct option"+"\n");
			}
			
		}
		sc.close();

		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			System.out.println("Error occured while waiting"+e);

		}
	}
}

