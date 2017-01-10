package prototype2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class App extends JFrame implements ActionListener {

	static JButton balanceButton;
	JButton viewBalanceButton;
	static JButton logTransButton;
	static JButton viewTransButton;
	static JButton viewBreakButton;
	static JButton logOutButton;
	static JButton mainButton;
	static JButton logInButton;
	static JButton logOut;
	JButton addBalanceButton;
	static JPanel menuPanel;
	static JPanel mainPanel;
	JPanel balanceCard;
	JPanel logTransCard;
	JPanel viewTransCard;
	JPanel viewBreakCard;
	JPanel logOutCard;
	JPanel logInCard;
	Font font = new Font("Arial", Font.BOLD, 17);
	String[] transactionTypes = { "Rent", "Electricity", "Gas", "Food", "Drink", "Other" }; // Add more 

	final static String LOGINPANEL = "Log In";
	final static String BALANCEPANEL = "Balance";
	final static String LOGTRANSPANEL = "Log Transaction";
	final static String VIEWTRANSPANEL = "View Transactions";
	final static String VIEWBREAKPANEL = "View Breakdown";
	final static String LOGOUTPANEL = "Log Out";
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new App();
	}

	public App() {
		generateButtons();
		generatePanel();
		setLayout(new BorderLayout());
		add(menuPanel, BorderLayout.WEST);
		add(mainPanel, BorderLayout.CENTER);

		setSize(600, 500);
		setVisible(true);
		setTitle("MyBudget");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void generateButtons() {
		// Generate the buttons here
		balanceButton = new JButton("Balance");
		balanceButton.addActionListener(new GetCardListener());
		balanceButton.setPreferredSize(new Dimension(150, 300));
		balanceButton.setEnabled(false);

		logTransButton = new JButton("Log Transaction");
		logTransButton.addActionListener(new GetCardListener());
		logTransButton.setPreferredSize(new Dimension(150, 300));
		logTransButton.setEnabled(false);

		viewTransButton = new JButton("View Transactions");
		viewTransButton.addActionListener(new GetCardListener());
		viewTransButton.setPreferredSize(new Dimension(150, 300));
		viewTransButton.setEnabled(false);

		viewBreakButton = new JButton("View Breakdown");
		viewBreakButton.addActionListener(new GetCardListener());
		viewBreakButton.setPreferredSize(new Dimension(150, 300));
		viewBreakButton.setEnabled(false);

		logOutButton = new JButton("Log Out");
		logOutButton.addActionListener(new GetCardListener());
		logOutButton.setPreferredSize(new Dimension(150, 300));
		logOutButton.setEnabled(false);
	}

	public void generatePanel() {
		// Generates the menu panel and adds buttons
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(0, 1));
		menuPanel.add(balanceButton);
		menuPanel.add(logTransButton);
		menuPanel.add(viewTransButton);
		menuPanel.add(viewBreakButton);
		menuPanel.add(logOutButton);

		// Card creation
		logInCard = new JPanel();
		logInCard.setLayout(new GridLayout(0, 1));
		balanceCard = new JPanel();
		balanceCard.setLayout(new GridLayout(0, 1));
		logTransCard = new JPanel();
		logTransCard.setLayout(new GridLayout(0, 1));
		viewTransCard = new JPanel();
		viewTransCard.setLayout(new GridLayout(0, 1));
		viewBreakCard = new JPanel();
		viewBreakCard.setLayout(new GridLayout(0, 1));
		logOutCard = new JPanel();
		
		logInCardSetUp();
		balanceCardSetUp();
		logTransCardSetUp();
		viewTransCardSetUp();
		viewBreakCardSetUp();
		logOutCardSetUp();
	
		

		// Panel that contains the cards
		mainPanel = new JPanel(new CardLayout());
		mainPanel.add(logInCard, LOGINPANEL);
		mainPanel.add(balanceCard, BALANCEPANEL);
		mainPanel.add(logTransCard, LOGTRANSPANEL);
		mainPanel.add(viewTransCard, VIEWTRANSPANEL);
		mainPanel.add(viewBreakCard, VIEWBREAKPANEL);
		mainPanel.add(logOutCard, LOGOUTPANEL);
	}
	
	public void logInCardSetUp(){
		// Setting up log in card
		// This will include what Seb has written
		JPanel userNameEntrySpace = new JPanel();
		JLabel userNameEntry = new JLabel("Username: ");
		userNameEntry.setFont(font);
		JTextArea userNameField = new JTextArea(1, 20);
		userNameEntrySpace.add(userNameEntry);
		userNameEntrySpace.add(userNameField);
		
		
		JPanel passwordEntrySpace = new JPanel();
		JLabel passwordEntry = new JLabel("Password: ");
		passwordEntry.setFont(font);
		JTextArea passwordField = new JTextArea(1, 20);
		passwordEntrySpace.add(passwordEntry);
		passwordEntrySpace.add(passwordField);
		
		JPanel logInButtonSpace = new JPanel();
		logInButton = new JButton("Log In");
		logInButton.addActionListener(new LogInListener());
		logInButtonSpace.add(logInButton);
		
		logInCard.add(userNameEntrySpace);
		logInCard.add(passwordEntrySpace);
		logInCard.add(logInButtonSpace);
		
	}

	public void balanceCardSetUp(){
		// Setting up Balance card
		JPanel userNameSpace = new JPanel();
		JLabel userName = new JLabel("Current user:"); // find a way to get username from database								
		userName.setFont(font);
		userNameSpace.add(userName);

		JPanel currentBalanceSpace = new JPanel();
		JLabel currentBalance = new JLabel("Current balance:"); // find a way to get balance from database																							 
		currentBalance.setFont(font);
		currentBalanceSpace.add(currentBalance);

		JPanel buttonBalanceSpace = new JPanel();
		addBalanceButton = new JButton("Add to Balance"); // Find out how to add balance to database												
		buttonBalanceSpace.add(addBalanceButton);

		balanceCard.add(userNameSpace);
		balanceCard.add(currentBalanceSpace);
		balanceCard.add(buttonBalanceSpace);
		// End of Balance card
}

	// This still needs work
	public void logTransCardSetUp(){
		// Setting up Log Transaction card
		JPanel transactionNameSpace = new JPanel();
		JLabel transactionName = new JLabel("Transaction Name: ");
		transactionName.setFont(font);
		JTextArea transNameField = new JTextArea(1, 20);
		transactionNameSpace.add(transactionName);
		transactionNameSpace.add(transNameField);
		
		
		JPanel transactionTypeSpace = new JPanel();
		JLabel transactionType = new JLabel("Transaction Type: ");
		transactionType.setFont(font);
		
		JComboBox typeList = new JComboBox(transactionTypes);
		transactionTypeSpace.add(transactionType);
		transactionTypeSpace.add(typeList);
		// Drop down box here
		
		JPanel transactionInfoSpace = new JPanel();
		JLabel transactionInfo = new JLabel("Transaction Info: ");
		transactionInfo.setFont(font);
		transactionInfoSpace.add(transactionInfo);
		// Big text box here
		
		JPanel transactionDateSpace = new JPanel();
		JLabel transactionDate = new JLabel("Transaction Date: ");
		transactionDate.setFont(font);
		transactionDateSpace.add(transactionDate);
		// Date function here
		
		JPanel transactionButtonSpace = new JPanel();
		JButton transactionButton = new JButton("Submit");
		transactionButtonSpace.add(transactionButton);
		

		logTransCard.add(transactionNameSpace);
		logTransCard.add(transactionTypeSpace);
		logTransCard.add(transactionInfoSpace);
		logTransCard.add(transactionDateSpace);
		logTransCard.add(transactionButtonSpace);
		// End of Log Transaction Card
		
	}
	
	
	
	

	public void viewTransCardSetUp() {
		
	}
	

	public void viewBreakCardSetUp() {
	
	}
	
	
	
	public void logOutCardSetUp() {
		// Setting up log out card
				logOut = new JButton("Log Out");
				logOut.addActionListener(new LogOutListener());
				logOutCard.add(logOut);
	}

	
	
	// If you addActionListener(this) then this is what will action.
	@Override
	public void actionPerformed(ActionEvent e1) {
		/*
		 * CardLayout c1 = (CardLayout)(mainPanel.getLayout());
		 * c1.show(mainPanel, e1.getActionCommand());
		 */
	}
}
