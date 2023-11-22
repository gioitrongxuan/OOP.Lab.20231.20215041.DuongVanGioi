package hust.soict.hedspi.lab01;
import java.lang.Math;
import java.util.Scanner;
public class ex2_2_6 {

    public void linear(){
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.println("             ax + b = 0 ");
	        	
        System.out.println("Input a:");
        double a1;
        do {
            a1 = scanner.nextDouble();
            if(a1==0) System.out.println("Invalid a");
        } while(a1 == 0);
        
        System.out.println("Input b:");
        double b1;
        b1 = scanner.nextDouble();
        double result1 = (double) (- b1)/a1;
        
        System.out.println("Result: " + result1);
    }
    @SuppressWarnings("resource")
	public void linerSystem( ){
        Scanner scanner = new Scanner(System.in);
        System.out.println("             a11.x1 + a12.x2 = b1 ");
	        	System.out.println("             a21.x1 + a22.x2 = b2 ");
	        	
	        	System.out.println("Input a11:");
	        	double a11;
	        	a11 = scanner.nextDouble();
	        	System.out.println("Input a12:");
	        	double a12;
	        	a12 = scanner.nextDouble();
	        	System.out.println("Input b1:");
	        	double be1;
	        	be1 = scanner.nextDouble();
	        	System.out.println("Input a21:");
	        	double a21;
	        	a21 = scanner.nextDouble();
	        	System.out.println("Input a22:");
	        	double a22;
	        	a22 = scanner.nextDouble();
	        	System.out.println("Input b2:");
	        	double be2;
	        	be2 = scanner.nextDouble();
	        	double D  = a11*a22 - a12*a21;
	        	double D1 = be1*a22  -  be2*a12;
	        	double D2 = a11*be2  -  a21*be1;
	        	double resultx1 = (double) D1/D;
	        	double resultx2 = (double) D2/D;
	        	System.out.println("Result: x1 = " + resultx1 + "x2 = " + resultx2);


    }

    public void equation(){
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.println("             a.x^2 + b.x + c = 0");
	        	System.out.println("Input a:");
	        	double a;
	        	a = scanner.nextDouble();
	        	System.out.println("Input b:");
	        	double b;
	        	b = scanner.nextDouble();
	        	System.out.println("Input c:");
	        	double c;
	        	c = scanner.nextDouble();
	        	double result;
	        	if(a==0) {
	        		result = (double) (-c)/b;
	        		System.out.println("Result: x = " + result);
	        	} else {
	        		double delta = b*b-4*a*c;
	        		if( delta<0 ) System.out.println("No solution!");
	        		if( delta==0 ) {
	        			result = (-b)/(2*a);
	        			System.out.println("Result: x1 = x2 = " + result);
	        		}
	        		if( delta > 0 ) {
	        			double sqrtdelta = Math.sqrt(delta);
	        			double x1 = (double) ((-b)+sqrtdelta)/(2*a);
	        			double x2 = (double) ((-b)-sqrtdelta)/(2*a);
	        			System.out.println("Result: x1 = " + x1 + "x2 = " + x2);
	        		}
	        	}
    }

	public static void main(String[] args) {	
        short   choice;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        ex2_2_6 ans =new ex2_2_6();
		do {
	        System.out.println("MENU");
	        System.out.println("1. The first-degree equation (linear equation) with one variable");
	        System.out.println("2. The system of first-degree equations (linear system) with two variables");
	        System.out.println("3. The second-degree equation with one variable\r\n");
	        System.out.println("CHOICE: ");
            choice = scanner.nextShort();
	        //if(choice == 1 || choice == 2 || choice == 3) continue;
	        switch (choice) {
	        case 1:
                ans.linear();
	        	break;
	        	
	        	
	        case 2:         	
	        	ans.linerSystem();
	        	break;	        
	        case 3: 
	        	ans.equation();
	        	break;
	        default: System.exit(0);
	        }
		} 
		while(true);
	}
}