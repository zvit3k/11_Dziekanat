package pawlak.witold.main;

import javax.swing.JFrame;

import pawlak.witold.classes.Access;
import pawlak.witold.database.Database;
import pawlak.witold.panels.PanelLogin;
import pawlak.witold.panels.MainPanel;
import pawlak.witold.panels.PanelUczelnia;
import pawlak.witold.panels.PanelAll;

public class Main {

	public static void createAndShowGui() {
		JFrame frame = new JFrame("Main Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 40);
		MainPanel mainPanel = new MainPanel();
		mainPanel.setVisible(true);
		frame.setContentPane(mainPanel);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setJMenuBar(mainPanel.createMenuBar());
	}

	public static void main(String[] args) {

		Database.connect();
		//Database.createTables();
		
		//Database.insertUser("Witek", "paw87", "user");
		
		//for(Access s : Database.selectAccess()){
		//	System.out.println(s);
		//}
		
		// Database.createTables();

		// Database.createTableUczelnia();
		//Database.insertUczelnia("UL", "Lodz", 1930, "Stefan Zaborski");
		/*
		 */ 
		
		/*Database.insertUczelnia("PL", "Lodz", 1950, "Mietek Szczesniak");
		Database.insertUczelnia("SWPS", "Warszawa", 1730, "Karol Sobczyk");
		Database.insertUczelnia("PWSTJ", "Warszawa", 1800, "Anna Milek");
		Database.insertUczelnia("AGH", "Krakow", 1900, "Bozena Dykiel");
		

		Database.insertStudent("Witek", "Pawlak", 20, 3, "c:/foto/s1");
		Database.insertStudent("Adam", "Nowak", 24, 34, "c:/foto/s2");
		Database.insertStudent("Mietek", "Mango", 22, 2, "c:/foto/s3");
*/		
		//Database.insertWpis(1, 3);
		//Database.insertWpis(2, 2);
		//Database.insertWpis(2, 1);
		//Database.insertWpis(1, 4);
		//Database.insertWpis(3, 4);
		//Database.deleteUczelnia(4);
		//System.out.println(Database.selectWpis());
		//System.out.println(Database.selectStudent());
		//System.out.println(Database.selectUczelnia());
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		}); 

		
		//System.out.println(Database.selectInnerJoin());
		// for (Uczelnia u : Database.selectUczelnia()) {
		// System.out.println(u);
		// }

		/*
		 * Database.deleteStudent(2); for (Student s : Database.selectStudent())
		 * { System.out.println(s); }
		 */

	}

}
