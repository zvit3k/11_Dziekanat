package pawlak.witold.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.xml.crypto.Data;

import pawlak.witold.classes.Settings;
import pawlak.witold.classes.Student;
import pawlak.witold.database.Database;

public class PanelStudent extends JPanel implements ActionListener {

	private JButton btnLeft;
	private JButton btnRight;
	private JTextField tfIndex;

	private JLabel labName;
	private JTextField tfName;
	private JLabel labSurname;
	private JTextField tfSurname;
	private JLabel labAge;
	private JTextField tfAge;
	private JLabel labStudies;
	private JTextField tfStudies;

	private JLabel labFoto;

	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnUpdate;

	private List<Student> lista;
	private int idx;
	
	public PanelStudent() {
		super(new BorderLayout());

		/*
		JPanel panelTop = new JPanel();
		JPanel panelCenter = new JPanel(new GridLayout(5, 2, 5, 5));
		JPanel panelBottom = new JPanel();

		btnLeft = new JButton("<<");
		btnLeft.addActionListener(this);

		tfIndex = new JTextField();
		tfIndex.setPreferredSize(new Dimension(30, 27));

		btnRight = new JButton(">>");
		btnRight.addActionListener(this);

		labName = new JLabel("Imiê:");
		tfName = new JTextField();

		labSurname = new JLabel("Nazwisko: ");
		tfSurname = new JTextField();

		labAge = new JLabel("Wiek: ");
		tfAge = new JTextField();

		labStudies = new JLabel("Rok studiów: ");
		tfStudies = new JTextField();

		labFoto = new JLabel();

		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);

		panelTop.add(btnLeft);
		panelTop.add(tfIndex);
		panelTop.add(btnRight);

		add(panelTop, BorderLayout.PAGE_START);

		panelCenter.add(labName);
		panelCenter.add(tfName);
		panelCenter.add(labSurname);
		panelCenter.add(tfSurname);
		panelCenter.add(labAge);
		panelCenter.add(tfAge);
		panelCenter.add(labStudies);
		panelCenter.add(tfStudies);
		panelCenter.add(labFoto);
		panelCenter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray), "STUDENT",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 14)));

		add(panelCenter, BorderLayout.CENTER);

		panelBottom.add(btnInsert);
		panelBottom.add(btnDelete);
		panelBottom.add(btnUpdate);

		add(panelBottom, BorderLayout.PAGE_END);

		lista = Database.selectStudent();
		idx = 0;
		fillPanel();

		insert = new Insert(this);
		update = new Update(lista.get(idx), this);
		*/
		
		JPanel panelTop = new JPanel(new GridBagLayout());
		JPanel panelCenter = new JPanel(new GridBagLayout());
		JPanel panelBottom = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 0;
		gbc.weighty = 0;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		btnLeft = new JButton("<<");
		btnLeft.addActionListener(this);
		panelTop.add(btnLeft, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 20;
		tfIndex = new JTextField();
		panelTop.add(tfIndex, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.ipadx = 0;
		btnRight = new JButton(">>");
		btnRight.addActionListener(this);
		panelTop.add(btnRight, gbc);


		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		labName = new JLabel("Imiê:");
		panelCenter.add(labName,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.ipadx = 50;
		tfName = new JTextField();
		panelCenter.add(tfName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipadx = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		labSurname = new JLabel("Nazwisko: ");
		panelCenter.add(labSurname, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 50;
		tfSurname = new JTextField();
		panelCenter.add(tfSurname, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.ipadx = 0;
		labAge = new JLabel("Wiek: ");
		panelCenter.add(labAge, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.ipadx = 50;
		tfAge = new JTextField();
		panelCenter.add(tfAge, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.ipadx = 0;
		labStudies = new JLabel("Rok studiów: ");
		panelCenter.add(labStudies, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.ipadx = 50;
		tfStudies = new JTextField();
		panelCenter.add(tfStudies, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.ipadx = 0;
		labFoto = new JLabel();
		panelCenter.add(labFoto, gbc);

		panelCenter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray), "STUDENT",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 14)));

		
		gbc.gridx = 0;
		gbc.gridy = 0;
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		panelBottom.add(btnInsert, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		panelBottom.add(btnDelete, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);
		panelBottom.add(btnUpdate, gbc);
		
		add(panelTop, BorderLayout.PAGE_START);
		add(panelCenter, BorderLayout.CENTER);
		add(panelBottom, BorderLayout.PAGE_END);

		lista = Database.selectStudent();
		idx = 0;
		fillPanel();

	
	}

	public void setLastIdx() {
		lista = Database.selectStudent();
		idx = lista.size() - 1;
	}

	public void fillPanel() {
		lista = Database.selectStudent();
		if (lista == null || lista.isEmpty()) {
			tfIndex.setText("");
			tfName.setText("");
			tfSurname.setText("");
			tfAge.setText("");
			tfStudies.setText("");
		}

		tfIndex.setText(lista.get(idx).getId() + "");
		tfName.setText(lista.get(idx).getImie());
		tfSurname.setText(lista.get(idx).getNazwisko());
		tfAge.setText(lista.get(idx).getWiek() + "");
		tfStudies.setText(lista.get(idx).getRokStudiow() + "");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInsert) {
			JFrame frame = new JFrame("Nowy student");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			InsertPanelS insert= new InsertPanelS(this, Settings.fontSize);
			frame.setLocation(270, 200);
			insert.setVisible(true);
			frame.setContentPane(insert);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(true);

		}

		else if (e.getSource() == btnDelete) {
			Database.deleteStudent(lista.get(idx).getId());
			idx = 0;
			lista = Database.selectStudent();
			fillPanel();
		} else if (e.getSource() == btnUpdate) {
			JFrame frame = new JFrame("Edycja");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocation(770, 200);
			UpdatePanelS update = new UpdatePanelS(lista.get(idx), this);
			update.setVisible(true);
			frame.setContentPane(update);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(true);

		} else if (e.getSource() == btnLeft) {
			lista = Database.selectStudent();
			idx--;
			if (idx < 0) {
				idx = lista.size() - 1;
			}
			fillPanel();
		} else if (e.getSource() == btnRight) {
			lista = Database.selectStudent();
			idx++;
			if (idx >= lista.size()) {
				idx = 0;
			}
			fillPanel();
		}
	}

	public void updateFont(int newFontSize) {
		Font newFont = new Font("Times New Roman", Font.PLAIN, newFontSize);
		btnLeft.setFont(newFont);
		tfIndex.setFont(newFont);
		btnRight.setFont(newFont);

		labName.setFont(newFont);
		tfName.setFont(newFont);
		labSurname.setFont(newFont);
		tfSurname.setFont(newFont);
		labAge.setFont(newFont);
		tfAge.setFont(newFont);
		labStudies.setFont(newFont);
		tfStudies.setFont(newFont);

		btnInsert.setFont(newFont);
		btnDelete.setFont(newFont);
		btnUpdate.setFont(newFont);

	}
}
