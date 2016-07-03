package pawlak.witold.panels;

import java.awt.BorderLayout;
import java.awt.Font;
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

import pawlak.witold.database.Database;

public class InsertPanelS extends JPanel implements ActionListener {

	private JLabel labName;
	private JTextField tfName;
	private JLabel labSurname;
	private JTextField tfSurname;
	private JLabel labAge;
	private JTextField tfAge;
	private JLabel labStudies;
	private JTextField tfStudies;
	private JLabel labPhoto;
	private JTextField tfPhoto;

	private JButton btnInsert;
	private JButton btnCancel;
	private JPanel panelInsert;
	int fontSize;

	public InsertPanelS(JPanel panelInsert, int fontSize) {
		super(new BorderLayout());
		this.fontSize = fontSize;
		this.panelInsert = panelInsert;
		JPanel panelTop = new JPanel(new GridLayout(5, 2, 5, 5));
		JPanel panelBottom = new JPanel();

		labName = new JLabel("Imie: ");
		tfName = new JTextField();

		labSurname = new JLabel("Nazwisko: ");
		tfSurname = new JTextField();

		labAge = new JLabel("Wiek: ");
		tfAge = new JTextField();

		labStudies = new JLabel("Rok studi�w: ");
		tfStudies = new JTextField();

		labPhoto = new JLabel("Zdj�cie: ");
		tfPhoto = new JTextField();

		panelTop.add(labName);
		panelTop.add(tfName);
		panelTop.add(labSurname);
		panelTop.add(tfSurname);
		panelTop.add(labAge);
		panelTop.add(tfAge);
		panelTop.add(labStudies);
		panelTop.add(tfStudies);
		panelTop.add(labPhoto);
		panelTop.add(tfPhoto);

		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);

		panelBottom.add(btnInsert);
		panelBottom.add(btnCancel);

		add(panelTop, BorderLayout.CENTER);
		add(panelBottom, BorderLayout.PAGE_END);

		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		updateFont(fontSize);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnInsert == e.getSource()) {
			String imie = tfName.getText();
			String nazwisko = tfSurname.getText();
			int wiek = Integer.parseInt(tfAge.getText());
			int rokStudiow = Integer.parseInt(tfStudies.getText());
			String zdjecie = tfPhoto.getText();
			Database.insertStudent(imie, nazwisko, wiek, rokStudiow, zdjecie);
			((PanelStudent) panelInsert).setLastIdx();
			((PanelStudent) panelInsert).fillPanel();
		} else if (btnCancel == e.getSource()) {
			((JFrame) this.getRootPane().getParent()).dispose();
		}

	}

	public void updateFont(int newFontSize) {
		labName.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		tfName.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		labSurname.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		tfSurname.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		labAge.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		tfAge.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		labStudies.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		tfStudies.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		labPhoto.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		tfPhoto.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		btnInsert.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
	}

}
