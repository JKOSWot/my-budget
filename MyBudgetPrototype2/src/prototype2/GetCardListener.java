package prototype2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// This goes to the panel of the button you have clicked on 
class GetCardListener implements ActionListener {
	public void actionPerformed(ActionEvent e1) {
		CardLayout c1 = (CardLayout)(App.mainPanel.getLayout());
		c1.show(App.mainPanel, e1.getActionCommand());

	}
}