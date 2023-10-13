
import java.util.Scanner;
public class Array {
    int A[];

    public Array(int n){
        A=new int[n];
    }
    public void show() {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public  void sortASC() {
        for (int i = 0 ; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                }
            }
        }
    }

    public int sumArray() {
    	int sum=0;
    	for(int i = 0; i < A.length; i++) {
    		sum+=A[i];
    	}
    	return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Array Arr=new Array(n);
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            Arr.A[i] = sc.nextInt();
        }
        Arr.sortASC();
        Arr.show();
        int sum=Arr.sumArray();
        System.out.println("Sum: " + sum);
        double average = sum/n;
        System.out.print("Avarege: " + average);
    }
    
}