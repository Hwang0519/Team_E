import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Rule extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtHp;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtVeryHardmode;
	private JTextField textField_8;
	private JTextField txtNomal;
	private JTextField txtVeryHardmode_1;
	private JTextField txtVeryHardmode_2;
	private JButton btnNewButton;
	
	public Rule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 1034);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setText("\uAC8C\uC784 \uC124\uBA85: \uC5EC\uB7EC \uBC29\uD5A5\uC5D0\uC11C \uC624\uB294 \uC7A5\uC560\uBB3C\uC740 \uD53C\uD558\uB294 \uAC8C\uC784");
		textField.setBounds(0, 10, 606, 56);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 =new JTextField();
		textField_1.setText("\uAE30\uBCF8 \uD0A4: \uD654\uC0B4\uD45C ( \uC704 \uC544\uB798  \uC67C  \uC624\uB978)");
		textField_1.setBounds(0, 98, 606, 61);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("2\uC778\uC6A9 \uD0A4 : \uC704\uD0A4 + W \uC704 S : \uC544\uB798 A : \uC67C D : \uC624\uB978");
		textField_2.setBounds(0, 183, 606, 45);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("\uC7A5\uC560\uBB3C");
		textField_3.setBounds(12, 266, 62, 36);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		txtHp = new JTextField();
		txtHp.setText("\uAE30\uBCF8 HP = 10   \uB2E8 VERY HARDMODE\uB294 HP = 1");
		txtHp.setBounds(0, 318, 606, 45);
		panel.add(txtHp);
		txtHp.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setText("\uBE68\uAC04\uC6D0   : \uCDA9\uB3CC \uC2DC \uD53C 1\uC529 \uAC10\uC18C , \uBA74\uC801\uC774 \uACC4\uC18D \uACB9\uCE60\uC2DC \uC9C0\uC18D\uC801\uC73C\uB85C \uAC10\uC18C");
		textField_4.setBounds(0, 390, 606, 45);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText("\uAC80\uC740\uC6D0    : \uCDA9\uB3CC \uC2DC \uD53C 2\uC529 \uAC10\uC18C , \uBA74\uC801\uC774 \uACC4\uC18D \uACB9\uCE60\uC2DC \uC9C0\uC18D\uC801\uC73C\uB85C \uAC10\uC18C");
		textField_5.setBounds(0, 470, 606, 45);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText("\uC544\uC774\uD15C");
		textField_6.setBounds(0, 549, 80, 21);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setText("\uD30C\uB780\uC6D0 : \uD53C 1 \uC529 \uC99D\uAC00 , \uBA74\uC801\uC774 \uACC4\uC18D \uACB9\uCE60\uC2DC \uC9C0\uC18D\uC801\uC73C\uB85C \uC99D\uAC00 \uCD5C\uB300 20");
		textField_7.setBounds(0, 594, 594, 36);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		txtVeryHardmode = new JTextField();
		txtVeryHardmode.setText("(\uB2E8 VERY HARDMODE\uB294 \uD53C \uD68C\uBCF5 \uC5C6\uC74C)");
		txtVeryHardmode.setBounds(49, 631, 545, 36);
		panel.add(txtVeryHardmode);
		txtVeryHardmode.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setText("\uB09C\uC774\uB3C4");
		textField_8.setBounds(0, 689, 74, 21);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		txtNomal = new JTextField();
		txtNomal.setText("* nomal \uB09C\uC774\uB3C4 \uAE4C\uC9C0 \uAC80\uC740\uACF5 \uC7A5\uC560\uBB3C \uB4F1\uC7A5\uD558\uC9C0 \uC54A\uC74C");
		txtNomal.setBounds(0, 719, 594, 45);
		panel.add(txtNomal);
		txtNomal.setColumns(10);
		
		txtVeryHardmode_1 = new JTextField();
		txtVeryHardmode_1.setText(" * Very HardMode\uC5D0\uB294 \uD53C \uD68C\uBCF5\uD615 \uD30C\uB780\uC6D0 \uC544\uC774\uD15C\uC774 \uB4F1\uC7A5\uD558\uC9C0 \uC54A\uC74C ");
		txtVeryHardmode_1.setBounds(0, 776, 594, 30);
		panel.add(txtVeryHardmode_1);
		txtVeryHardmode_1.setColumns(10);
		
		txtVeryHardmode_2 = new JTextField();
		txtVeryHardmode_2.setText("* Very HardMode\uB294 \uD55C\uBC88 \uCDA9\uB3CC\uC2DC \uBC14\uB85C \uAC8C\uC784\uC774 \uB05D\uB0A8");
		txtVeryHardmode_2.setBounds(0, 816, 594, 21);
		panel.add(txtVeryHardmode_2);
		txtVeryHardmode_2.setColumns(10);
		
		btnNewButton = new JButton("\uBA54\uC778\uBA54\uB274 \uB3CC\uC544\uAC00\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main();
				
			}
		});
		btnNewButton.setBounds(246, 885, 195, 23);
		panel.add(btnNewButton);
	}
	

}
