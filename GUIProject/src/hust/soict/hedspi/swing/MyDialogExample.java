package hust.soict.hedspi.swing;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDialogExample {
    public static void main(String[] args) {
        // Tạo JFrame (cửa sổ chính)
        JFrame frame = new JFrame("JDialog Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo button
        JButton button = new JButton("Show Dialog");

        // Thêm ActionListener cho button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi button được click, hiển thị JDialog
                showDialog(frame);
            }
        });

        // Thêm button vào JFrame
        frame.getContentPane().add(button);

        // Hiển thị JFrame
        frame.setVisible(true);
    }

    // Phương thức để hiển thị JDialog
    private static void showDialog(JFrame frame) {
        // Tạo JDialog với JFrame làm owner
        JDialog dialog = new JDialog(frame, "My Dialog", true);
        dialog.setSize(200, 100);

        // Thêm nội dung vào JDialog
        dialog.getContentPane().add(new JButton("OK"));

        // Đặt vị trí của JDialog tương đối với JFrame
        dialog.setLocationRelativeTo(frame);

        // Hiển thị JDialog
        dialog.setVisible(true);
    }
}
