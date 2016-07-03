package pawlak.witold.panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import pawlak.witold.database.Database;

public class Login extends JPanel implements ActionListener {

	private JLabel labLogin;
	private JTextField tfLogin;

	private JLabel labPassword;
	private JPasswordField tfPassword;
	private JRadioButton rbUser;
	private JRadioButton rbAdmin;

	private JButton btnLog;
	private JButton btnCancel;

	public Login() {

		super(new GridLayout(4, 2, 10, 10));

		labLogin = new JLabel("Login:");
		tfLogin = new JTextField();

		labPassword = new JLabel("Has³o:");
		tfPassword = new JPasswordField();
		
		rbUser = new JRadioButton("User");
		rbAdmin = new JRadioButton("Admin");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbUser);
		bg.add(rbAdmin);
		
		btnLog = new JButton("Log In");
		btnLog.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);

		add(labLogin);
		add(tfLogin);
		add(labPassword);
		add(tfPassword);

		add(rbUser);
		add(rbAdmin);
		
		add(btnLog);
		add(btnCancel);

		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLog) {
			
			JFrame frame = new JFrame("Dziekanat");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocation(500, 200);
			MainPanelStudent main = new MainPanelStudent();
			main.setVisible(true);
			frame.setContentPane(main);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(false);
			((JFrame)this.getRootPane().getParent()).dispose();

		}

		if (e.getSource() == btnCancel) {
			((JFrame)this.getRootPane().getParent()).dispose();
		}

	}

}
