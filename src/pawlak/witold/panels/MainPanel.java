package pawlak.witold.panels;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import pawlak.witold.classes.InnerJoin;
import pawlak.witold.classes.Settings;
import pawlak.witold.classes.Student;
import pawlak.witold.classes.Uczelnia;
import pawlak.witold.database.Database;

public class MainPanel extends JPanel implements ActionListener {
	private PanelStudent panelStudent;
	private PanelUczelnia panelUczelnia;
	private PanelAll panelRegister;
	private PanelFiltr panelFiltruj;

	private JMenuItem menuItemStudent;
	private JMenuItem menuItemUczelnia;
	private JMenuItem menuItemRegister;
	private JMenuItem menuItemFiltrowanie;

	private JMenuItem menuItemFont16;
	private JMenuItem menuItemFont24;

	public MainPanel() {
		super(new CardLayout());
		panelStudent = new PanelStudent();
		panelUczelnia = new PanelUczelnia();
		panelRegister = new PanelAll();
		panelFiltruj = new PanelFiltr();

		menuItemStudent = new JMenuItem("STUDENT");
		menuItemStudent.setIcon(new ImageIcon("student.png"));
		menuItemStudent.setMnemonic('S');
		menuItemStudent.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
		menuItemStudent.addActionListener(this);

		menuItemUczelnia = new JMenuItem("UCZELNIA");
		menuItemUczelnia.setIcon(new ImageIcon("uczelnia.jpg"));
		menuItemUczelnia.setMnemonic('U');
		menuItemUczelnia.setAccelerator(KeyStroke.getKeyStroke('U', KeyEvent.CTRL_MASK));
		menuItemUczelnia.addActionListener(this);

		menuItemRegister = new JMenuItem("REGISTER");
		menuItemRegister.setIcon(new ImageIcon("rejestr.png"));
		menuItemRegister.setMnemonic('R');
		menuItemRegister.setAccelerator(KeyStroke.getKeyStroke('R', KeyEvent.CTRL_MASK));
		menuItemRegister.addActionListener(this);

		menuItemFiltrowanie = new JMenuItem("RESULT");
		menuItemFiltrowanie.setIcon(new ImageIcon("plan.png"));
		menuItemFiltrowanie.setMnemonic('T');
		menuItemFiltrowanie.setAccelerator(KeyStroke.getKeyStroke('T', KeyEvent.CTRL_MASK));
		menuItemFiltrowanie.addActionListener(this);

		menuItemFont16 = new JMenuItem("SIZE 16");
		menuItemFont16.addActionListener(this);

		menuItemFont24 = new JMenuItem("SIZE 24");
		menuItemFont24.addActionListener(this);

		add(panelStudent, "ps");
		add(panelUczelnia, "pu");
		add(panelRegister, "pa");
		add(panelFiltruj, "pi");

	}

	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu menu1 = new JMenu("PANELE");
		menu1.setMnemonic(KeyEvent.VK_ALT);

		JMenu menu2 = new JMenu("OPCJE");
		menu2.setMnemonic(KeyEvent.VK_ALT);

		menu1.add(menuItemStudent);
		menu1.add(menuItemUczelnia);
		menu1.add(menuItemRegister);
		menu1.add(menuItemFiltrowanie);

		menu2.add(menuItemFont16);
		menu2.add(menuItemFont24);

		menuBar.add(menu1);
		menuBar.add(menu2);

		return menuBar;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItemStudent) {
			CardLayout cl = (CardLayout) getLayout();
			cl.show(this, "ps");
		} else if (e.getSource() == menuItemUczelnia) {
			CardLayout cl = (CardLayout) getLayout();
			cl.show(this, "pu");
			
		} else if(e.getSource()==menuItemFiltrowanie){
			CardLayout cl = (CardLayout) getLayout();
			cl.show(this, "pi");
		} else if (e.getSource() == menuItemRegister) {
			List<Student> helpList = Database.selectStudent();
			List<String> listaStr1 = new ArrayList<>();
			for (Student s : helpList) {
				listaStr1.add(s.getId() + "");
			}

			panelRegister.getCbModelStudentBottom().updateList(listaStr1);

			List<Uczelnia> helpListU = Database.selectUczelnia();
			List<String> listaStr2 = new ArrayList<>();
			for (Uczelnia u : helpListU) {
				listaStr2.add(u.getId() + "");
			}
			panelRegister.getCbModelUczelniaBottom().updateList(listaStr2);
			SwingUtilities.updateComponentTreeUI((JFrame) this.getRootPane().getParent()); // odswieza
																							// wszystkie
			// komponenty gui

			CardLayout cl = (CardLayout) getLayout();
			cl.show(this, "pa");

		} else if (e.getSource() == menuItemFont16) {
			Settings.fontSize=16;
			
			panelStudent.updateFont(Settings.fontSize);
			panelUczelnia.updateFont(Settings.fontSize);
			panelRegister.updateFont(Settings.fontSize);

			SwingUtilities.updateComponentTreeUI((JFrame) this.getRootPane().getParent());
			JFrame frame = (JFrame) this.getRootPane().getParent();
			frame.pack();

		} else if (e.getSource() == menuItemFont24) {
			Settings.fontSize=24;
			
			panelStudent.updateFont(Settings.fontSize);
			panelUczelnia.updateFont(Settings.fontSize);
			panelRegister.updateFont(Settings.fontSize);

			SwingUtilities.updateComponentTreeUI((JFrame) this.getRootPane().getParent());
			JFrame frame = (JFrame) this.getRootPane().getParent();
			frame.pack();
		}

	}
}
