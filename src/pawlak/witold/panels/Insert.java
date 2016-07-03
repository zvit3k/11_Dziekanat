package pawlak.witold.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pawlak.witold.database.Database;

public class Insert extends JPanel implements ActionListener {

	private JLabel imie;
	private JTextField pole_imie;
	private JLabel nazwisko;
	private JTextField pole_nazwisko;
	private JLabel wiek;
	private JTextField pole_wiek;
	private JLabel rokStudiow;
	private JTextField pole_rokStudiow;
	private JLabel zdjecie;
	private JTextField pole_zdjecie;

	private JButton btnInsert;
	private JButton btnCancel;
	private JPanel panelInsert;

	public Insert(JPanel panelInsert) {
		super(new BorderLayout());
		
		this.panelInsert=panelInsert;
		JPanel top = new JPanel(new GridLayout(5, 2, 5, 5));
		JPanel bottom = new JPanel();

		imie = new JLabel("Imie: ");
		pole_imie = new JTextField();

		nazwisko = new JLabel("Nazwisko: ");
		pole_nazwisko = new JTextField();

		wiek = new JLabel("Wiek: ");
		pole_wiek = new JTextField();

		rokStudiow = new JLabel("Rok studiów: ");
		pole_rokStudiow = new JTextField();

		zdjecie = new JLabel("Zdjêcie: ");
		pole_zdjecie = new JTextField();

		top.add(imie);
		top.add(pole_imie);
		top.add(nazwisko);
		top.add(pole_nazwisko);
		top.add(wiek);
		top.add(pole_wiek);
		top.add(rokStudiow);
		top.add(pole_rokStudiow);
		top.add(zdjecie);
		top.add(pole_zdjecie);

		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);

		bottom.add(btnInsert);
		bottom.add(btnCancel);

		add(top, BorderLayout.CENTER);
		add(bottom, BorderLayout.PAGE_END);

		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnInsert == e.getSource())
		{
			String imie = pole_imie.getText();
			String nazwisko = pole_nazwisko.getText();
			int wiek = Integer.parseInt(pole_wiek.getText());
			int rokStudiow = Integer.parseInt(pole_rokStudiow.getText());
			String zdjecie = pole_zdjecie.getText();
			Database.insertStudent(imie, nazwisko, wiek, rokStudiow, zdjecie);
			((MainPanelStudent)panelInsert).setLastIdx();
			((MainPanelStudent)panelInsert).fillPanel();
		}
		else if (btnCancel == e.getSource())
		{
			((JFrame)this.getRootPane().getParent()).dispose();
		}

	}

}
