package pawlak.witold.panels;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener{
	private MainPanelStudent mainPanelStudent;
	private MainPanelUczelnia mainPanelUczelnia;
	private PanelAll panelAll;
	
	private JMenuItem menuItemStudent;
	private JMenuItem menuItemUczelnia;
	private JMenuItem menuItemPanelAll;
	
	public MainPanel()
	{
		super(new CardLayout());
		mainPanelStudent = new MainPanelStudent();
		mainPanelUczelnia = new MainPanelUczelnia();
		panelAll = new PanelAll();
		
		menuItemStudent = new JMenuItem("STUDENT");
		menuItemStudent.addActionListener(this);
		menuItemUczelnia = new JMenuItem("UCZELNIA");
		menuItemUczelnia.addActionListener(this);
		menuItemPanelAll = new JMenuItem("LACZONY");
		menuItemPanelAll.addActionListener(this);
		
		add(mainPanelStudent, "ps");
		add(mainPanelUczelnia, "pu");
		add(panelAll, "pa");
	}
	
	public JMenuBar createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu1 = new JMenu("PANELE");
		menu1.add(menuItemStudent);
		menu1.add(menuItemUczelnia);
		menu1.add(menuItemPanelAll);
		
		menuBar.add(menu1);
		
		return menuBar;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==menuItemStudent)
		{
			CardLayout cl = (CardLayout)getLayout();
			cl.show(this, "ps");
		}
		else if (e.getSource()==menuItemUczelnia)
		{
			CardLayout cl = (CardLayout)getLayout();
			cl.show(this, "pu");
		}
		else if (e.getSource()==menuItemPanelAll)
		{
			CardLayout cl = (CardLayout)getLayout();
			cl.show(this, "pa");
		}
		
	}
}
