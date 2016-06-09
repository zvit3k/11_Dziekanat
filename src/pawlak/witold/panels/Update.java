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
import javax.swing.SwingUtilities;

import pawlak.witold.classes.Student;
import pawlak.witold.database.Database;

public class Update extends JPanel implements ActionListener {

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

	private JButton btnUpdate;
	private JButton btnCancel;

	private Student s;
	private JPanel panel;

	public Update(Student s, JPanel panel) {
		super(new BorderLayout());

		this.s = s;
		this.panel = panel;

		JPanel top = new JPanel(new GridLayout(5, 2, 5, 5));
		JPanel bottom = new JPanel();

		imie = new JLabel("Imie: ");
		pole_imie = new JTextField(s.getImie());

		nazwisko = new JLabel("Nazwisko: ");
		pole_nazwisko = new JTextField(s.getNazwisko());

		wiek = new JLabel("Wiek: ");
		pole_wiek = new JTextField(s.getWiek() + "");

		rokStudiow = new JLabel("Rok studiów: ");
		pole_rokStudiow = new JTextField(s.getRokStudiow() + "");

		zdjecie = new JLabel("Zdjêcie: ");
		pole_zdjecie = new JTextField(s.getZdjecie());

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

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);

		bottom.add(btnUpdate);
		bottom.add(btnCancel);

		add(top, BorderLayout.CENTER);
		add(bottom, BorderLayout.PAGE_END);

		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate) {
			String imie = pole_imie.getText();
			String nazwisko = pole_nazwisko.getText();
			int wiek = Integer.parseInt(pole_wiek.getText());
			int rokStudiow = Integer.parseInt(pole_rokStudiow.getText());
			String zdjecie = pole_zdjecie.getText();
			Database.updateStudent(s.getId(), imie, nazwisko, wiek, rokStudiow, zdjecie);
			((MainPanelStudent) panel).fillPanel();
		} else if (e.getSource() == btnCancel) {
			((JFrame) this.getRootPane().getParent()).dispose();
		}

	}

}
