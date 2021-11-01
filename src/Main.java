import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import java.awt.Label;
import java.awt.Font;

public class Main extends JFrame {

   private JPanel contentPane;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Main frame = new Main();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public Main() {
   	setTitle("JF-Dodging");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 400, 400);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      
      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.CENTER);
      panel.setLayout(null);
      
      JButton btnNewButton = new JButton("Hard mode");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HardFrame frame = new HardFrame();
            Thread thread = new Thread(frame);
            thread.start();
            
         }
      });
      btnNewButton.setBounds(81, 183, 111, 23);
      panel.add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton(" Exit");
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      btnNewButton_1.setBounds(208, 183, 91, 23);
      panel.add(btnNewButton_1);
      
      JButton btnNewButton_2 = new JButton("Easy mode");
      btnNewButton_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		EasyFrame frame = new EasyFrame();
            Thread thread = new Thread(frame);
            thread.start();
      	}
      });
      btnNewButton_2.setBounds(81, 90, 111, 23);
      panel.add(btnNewButton_2);
      
      JButton btnNewButton_3 = new JButton("Nomal mode");
      btnNewButton_3.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		NomalFrame frame = new NomalFrame();
            Thread thread = new Thread(frame);
            thread.start();
      	}
      });
      btnNewButton_3.setBounds(81, 140, 111, 23);
      panel.add(btnNewButton_3);
      
      JButton btnNewButton_4 = new JButton("VeryHard mode");
      btnNewButton_4.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		VeryHardFrame frame = new VeryHardFrame();
            Thread thread = new Thread(frame);
            thread.start();
      	}
      });
      btnNewButton_4.setBounds(81, 232, 111, 23);
      panel.add(btnNewButton_4);
      
      JButton btnNewButton_5 = new JButton("Rule");
      btnNewButton_5.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new Rule();
           
      	}
      });
      btnNewButton_5.setBounds(208, 140, 91, 23);
      panel.add(btnNewButton_5);
      
      JButton btnNewButton_6 = new JButton("2P Mode");
      btnNewButton_6.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new P2mode();
      	}
      });
      btnNewButton_6.setBounds(81, 277, 111, 23);
      panel.add(btnNewButton_6);
      
      Label label = new Label("  Dodging Game");
      label.setFont(new Font("Dialog", Font.PLAIN, 22));
      label.setBounds(81, -12, 195, 96);
      panel.add(label);
   }
	        
}