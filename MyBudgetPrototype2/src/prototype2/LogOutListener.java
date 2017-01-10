package prototype2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LogOutListener implements ActionListener {
	public void actionPerformed(ActionEvent e1) {
		// Disables buttons once logged in
		App.balanceButton.setEnabled(false);
		App.logTransButton.setEnabled(false);
		App.viewTransButton.setEnabled(false);
		App.viewBreakButton.setEnabled(false);
		App.logOutButton.setEnabled(false);
		
		// This sends user to log in screen when log out is clicked.
		CardLayout c1 = (CardLayout)(App.mainPanel.getLayout());
		c1.show(App.mainPanel, "Log In");

	}
}