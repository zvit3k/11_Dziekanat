package pawlak.witold.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.xml.crypto.Data;

import pawlak.witold.classes.Student;
import pawlak.witold.database.Database;

public class MainPanelStudent extends JPanel implements ActionListener {

	private JButton btnLeft;
	private JButton btnRight;
	private JTextField pole;

	private JLabel imie;
	private JTextField pole_imie;
	private JLabel nazwisko;
	private JTextField pole_nazwisko;
	private JLabel wiek;
	private JTextField pole_wiek;
	private JLabel rokStudiow;
	private JTextField pole_rokStudiow;

	private JLabel labFoto;
	
	private JButton insert;
	private JButton delete;
	private JButton update;
	
	private List<Student> lista;
	private int idx;

	public MainPanelStudent() {
		super(new BorderLayout());
		
		JPanel top = new JPanel();
		JPanel center = new JPanel(new GridLayout(5, 2, 5, 5));
		JPanel bottom = new JPanel();

		btnLeft = new JButton("<<");
		btnLeft.addActionListener(this);

		pole = new JTextField();
		pole.setPreferredSize(new Dimension(30, 27));

		btnRight = new JButton(">>");
		btnRight.addActionListener(this);

		imie = new JLabel("Imiê:");
		pole_imie = new JTextField();

		nazwisko = new JLabel("Nazwisko: ");
		pole_nazwisko = new JTextField();

		wiek = new JLabel("Wiek: ");
		pole_wiek = new JTextField();

		rokStudiow = new JLabel("Rok studiów: ");
		pole_rokStudiow = new JTextField();

		labFoto = new JLabel();
		
		insert = new JButton("Insert");
		insert.addActionListener(this);
		delete = new JButton("Delete");
		delete.addActionListener(this);
		update = new JButton("Update");
		update.addActionListener(this);

		top.add(btnLeft);
		top.add(pole);
		top.add(btnRight);

		add(top, BorderLayout.PAGE_START);

		center.add(imie);
		center.add(pole_imie);
		center.add(nazwisko);
		center.add(pole_nazwisko);
		center.add(wiek);
		center.add(pole_wiek);
		center.add(rokStudiow);
		center.add(pole_rokStudiow);
		center.add(labFoto);
		center.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray), "STUDENT",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 14)));
		
	
		add(center, BorderLayout.CENTER);

		bottom.add(insert);
		bottom.add(delete);
		bottom.add(update);

		add(bottom, BorderLayout.PAGE_END);
		
		lista = Database.selectStudent();
		idx = 0;
		fillPanel();
	}

	public void setLastIdx()
	{
		lista = Database.selectStudent();
		idx = lista.size() - 1;
	}
	public void fillPanel()
	{	
		lista = Database.selectStudent();
		if(lista == null || lista.isEmpty()){
			pole.setText("");
			pole_imie.setText("");
			pole_nazwisko.setText("");
			pole_wiek.setText("");
			pole_rokStudiow.setText("");
		}
		
		pole.setText(lista.get(idx).getId() + "");
		pole_imie.setText(lista.get(idx).getImie());
		pole_nazwisko.setText(lista.get(idx).getNazwisko());
		pole_wiek.setText(lista.get(idx).getWiek() + "");
		pole_rokStudiow.setText(lista.get(idx).getRokStudiow()+"");
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insert) {
			JFrame frame = new JFrame("Nowy student");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocation(270, 200);
			Insert insert = new Insert(this);
			insert.setVisible(true);
			frame.setContentPane(insert);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(false);
			
		}
		
		else if (e.getSource() == delete) {
			Database.deleteStudent(lista.get(idx).getId());
			idx = 0;
			lista = Database.selectStudent();
			fillPanel();
		}
		else if (e.getSource() == update) {
			JFrame frame = new JFrame("Edycja");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocation(770, 200);
			Update update = new Update(lista.get(idx), this);
			update.setVisible(true);
			frame.setContentPane(update);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(false);
			
			
		}
		else if(e.getSource() == btnLeft)
		{
			lista = Database.selectStudent();
			idx--;
			if (idx < 0)
			{
				idx = lista.size() - 1;
			}
			fillPanel();
		}
		else if (e.getSource() == btnRight)
		{
			lista = Database.selectStudent();
			idx++;
			if (idx >= lista.size())
			{
				idx = 0;
			}
			fillPanel();
		}
	}
}
