package hust.soict.hedspi.lab01;
import javax.swing.JOptionPane;
public class ex2_2_5 {

    public static void main(String[] args) {
        
        String  strNum1,strNum2;
        String strNotification="You've just entered ";
        strNum1=JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number ", JOptionPane.INFORMATION_MESSAGE);
        strNotification+=strNum1+" and ";
        strNum2=JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number",JOptionPane.INFORMATION_MESSAGE);
        strNotification+=strNum2;
        JOptionPane.showMessageDialog(null, strNotification, "Show to numbers ", JOptionPane.INFORMATION_MESSAGE);
        
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum= num1+num2;
        double dif=num1-num2;
        double pro=num1*num2;
        double quo=num1/num2;
        JOptionPane.showMessageDialog(null, "Sum:"+sum+"\n Difference:"+dif+"\n Product: "+pro+"\n Quotient: "+quo, strNotification, JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); 
    }
}
