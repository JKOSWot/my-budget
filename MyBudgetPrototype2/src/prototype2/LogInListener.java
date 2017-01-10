package prototype2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class LogInListener implements ActionListener {
	public void actionPerformed(ActionEvent e1) {
		

		
		

		// Renables buttons once logged in
		App.balanceButton.setEnabled(true);
		App.logTransButton.setEnabled(true);
		App.viewTransButton.setEnabled(true);
		App.viewBreakButton.setEnabled(true);
		App.logOutButton.setEnabled(true);
		
		// This sends user to balance screen when log in is clicked.
		CardLayout c1 = (CardLayout)(App.mainPanel.getLayout());
		c1.show(App.mainPanel, "Balance");

	}
}