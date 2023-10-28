import java.util.Scanner;
import java.util.Objects;
public class DaysOfMonth {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input Month:");
		String month = keyboard.nextLine();
		int yearInInt;
		String year;
		do {
			System.out.println("Input Year:");
			year = keyboard.nextLine();
			yearInInt = Integer.parseInt(year);
			if(yearInInt<0)System.out.println("Invalid year input!!");
		} while(yearInInt<0);
        
		switch (month) {
			case "January":
			case "Jan.":
			case "Jan":
			case "1":
				System.out.println(month + "/" + year + ": 31 days" );
				break;
			case "February":
			case "Feb.":
			case "Feb":
			case "2":
				if( (yearInInt%4 == 0 && yearInInt%100 != 0 ) || ( yearInInt % 400 == 0 )) {
					System.out.println(month + "/" + year + ": 29 days" );
				} else {System.out.println(month + "/" + year + ": 28 days" );}
				break;
			case "March":
			case "Mar.":
			case "Mar":
			case "3":
				System.out.println(month + "/" + year + ": 31 days" );
				break;
			case "April":
			case "Apr.":
			case "Apr":
			case "4":
				System.out.println(month + "/" + year + ": 30 days" );
				break;
			case "May":
			case "5":
				System.out.println(month + "/" + year + ": 31 days" );
				break;
			case "June":
			case "Jun":
			case "6":
				System.out.println(month + "/" + year + ": 30 days" );
				break;
			case "July":
			case "Jul":
			case "7":
				System.out.println(month + "/" + year + ": 31 days" );
				break;
			case "August":
			case "Aug.":
			case "Aug":
			case "8":
				System.out.println(month + "/" + year + ": 31 days" );
				break;
			case "September":
			case "Sep.":
			case "Sep":
			case "9":
				System.out.println(month + "/" + year + ": 30 days" );
				break;
			case "October":
			case "Oct.":
			case "Oct":
			case "10":
				System.out.println(month + "/" + year + ": 31 days" );
				break;
			case "November":
			case "Nov.":
			case "Nov":
			case "11":
				System.out.println(month + "/" + year + ": 30 days" );
				break;
			case "December":
			case "Dec.":
			case "Dec":
			case "12":
				System.out.println(month + "/" + year + ": 31 days" );
				break;
			default: 
				System.out.println("Invalid month!!!" );
				System.exit(0);
				break;
		}	
	}
} 
    

