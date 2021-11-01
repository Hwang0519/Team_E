import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class P2mode extends JFrame {
	private JPanel contentPane;
	
	public P2mode() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 456, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("     2\uC778\uC6A9 \uBAA8\uB4DC");
		lblNewLabel.setBounds(158, 36, 144, 43);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nomal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P2Frame frame = new P2Frame();
	            Thread thread = new Thread(frame);
	            thread.start();
	            dispose();
			}
		});
		btnNewButton.setBounds(77, 145, 95, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hard");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P2HardFrame frame = new P2HardFrame();
	            Thread thread = new Thread(frame);
	            thread.start();
	            dispose();
			}
		});
		btnNewButton_1.setBounds(247, 145, 95, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uBA54\uC778\uC73C\uB85C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main();
			}
		});
		btnNewButton_2.setBounds(158, 228, 95, 23);
		panel.add(btnNewButton_2);
	}
}



