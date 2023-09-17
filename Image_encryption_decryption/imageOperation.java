import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Image;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.awt.Color;

public class imageOperation {

    public static void Operate(int key) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null); // open at center
        File file = fileChooser.getSelectedFile();
        // file FileInputStream
        try {
            FileInputStream fis = new FileInputStream(file);
            byte []data = new byte[fis.available()];
            fis.read(data);
            int i = 0;

            for (byte b : data) {
                System.out.println(b);
                data[i] = (byte)(b^key);
                i++;
                 // xor is used to increpit like 
                // int a = 7; 
                //  int key = 50; then
                //int r = a^key;
                // r^50; then it will give output as 7
            }
            FileOutputStream fos =new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"DONE");
            

        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setTitle("Image Opration"); // title
        f.setSize(400, 400); // setiing the size
        f.setLocationRelativeTo(null); // center location
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // for closing window

        Font font = new Font("Serif", Font.BOLD, 25);
        // Color black = new Color(25 ,20, 20); COLOR CLASSES
        // Color Green = new Color(30, 215, 96);
        
        JButton button = new JButton();
        button.setText("Open Image");
        // button.setBackground(Green);
        button.setFont(font);
        


        // Creating text field
        JTextField textField = new JTextField(10);
        textField.setFont(font);
        f.setLayout(new FlowLayout());

        button.addActionListener(e -> {
            System.out.println("Button is clicked");
            String text = textField.getText();

            int temp = Integer.parseInt(text);
            Operate(temp);
        });

        f.add(button);
        f.add(textField);
        f.setVisible(true);

    }
}