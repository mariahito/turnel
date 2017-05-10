//Maria Hito (mh4wt)
//Homework 5
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class travelExpenses extends JFrame{
	private JPanel panel;
	private JPanel buttonPanel;
	// Labels
	private JLabel numDays;
	private JLabel amountAirfair;
	private JLabel carRental;
	private JLabel milesDriven;
	private JLabel parkingFees;
	private JLabel taxiFees;
	private JLabel conferenceReg;
	private JLabel lodgingCharges;
	// Text Fields
	private JTextField daysTrip;
	private JTextField amountAirfairTextField;
	private JTextField rental;
	private JTextField milesCar;
	private JTextField carParking;
	private JTextField taxiCharge;
	private JTextField registration;
	private JTextField lodgingFee;
	// Button
	private JButton calcButton;
	//Size of screen
	private final int WINDOW_WIDTH = 500;  
	private final int WINDOW_HEIGHT = 400;
	
	//Reimbursed by company per day.
	private double mealsAmount = 37.00;
	private double parkingFeesReimbursed = 10.00;
	private double taxiChargesReimbursed = 20.00;
	private double lodgingChargesReimbursed = 95.00;
	private double prVechiclePerMileReimbursed = 0.27;
	
	public travelExpenses(){
		setTitle("Travel Expenses");
		// Set the main window
		setLocationRelativeTo(null);
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create a BorderLayout manager for the content pane.
		setLayout(new BorderLayout());
		// Build the TravelInfo and Buttons panels
		buildPanel();
		buildButtonPanel();
		// Add the panels to the frame's content pane
		add(panel);
		add(buttonPanel, BorderLayout.SOUTH);
		//set size of window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// Display the window.
		setVisible(true);
	}
	
	private void buildPanel(){
		numDays = new JLabel("Number of days on trip: ");
		amountAirfair = new JLabel("Amount of airfair: ");
		carRental = new JLabel("Enter car rental fees: ");
		milesDriven = new JLabel("Enter Number of miles driven: ");
		parkingFees = new JLabel("Enter parking fees: ");
		taxiFees = new JLabel("Enter taxi charges: ");
		conferenceReg = new JLabel("Enter Conference registration fees: ");
		lodgingCharges = new JLabel("Lodging charges per night: ");
		// Create the text boxes for travelExpenses user input
		daysTrip = new JTextField(3);
		amountAirfairTextField = new JTextField(8);
		rental = new JTextField(8);
		milesCar = new JTextField(4);
		carParking = new JTextField(6);
		taxiCharge = new JTextField(6);
		registration = new JTextField(8);
		lodgingFee = new JTextField(6);
		// Create a panel to hold labels and text fields.
		panel = new JPanel();
		// Create GridLayout manager
		panel.setLayout(new GridLayout(10, 2));
		// Add the labels and text fields to this panel.
		panel.add(numDays);
		panel.add(daysTrip);
		panel.add(amountAirfair);
		panel.add(amountAirfairTextField);
		panel.add(carRental);
		panel.add(rental);
		panel.add(milesDriven);
		panel.add(milesCar);
		panel.add(parkingFees);
		panel.add(carParking);
		panel.add(taxiFees);
		panel.add(taxiCharge);
		panel.add(conferenceReg);
		panel.add(registration);
		panel.add(lodgingCharges);
		panel.add(lodgingFee);
		// Add an empty border around the panel for spacing.
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 1, 10));
	}
	
	private void buildButtonPanel(){
		// Create the calcButton.
		calcButton = new JButton("Calculate Expenses");
		
		calcButton.addActionListener(new CalcButtonListener());
		
		// Create the Buttons panels.
		buttonPanel = new JPanel();
		// Create BorderLayout manager.
		buttonPanel.setLayout(new BorderLayout(50, 5));
		// Add the two buttons to the buttonPanel.
		
		buttonPanel.add(calcButton, BorderLayout.CENTER);
		// Add an empty border around the panel for spacing.
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
	}
	
	private class CalcButtonListener implements ActionListener{
		String input;
		int days;
		double air;
		double carRental;
		double miles;
		double parking;
		double taxi;
		double conferenceFee;
		double lodging;
		double mealsAmount;
		public void actionPerformed(ActionEvent e){
			double actualExpenses;
			double milesExpenses;
			double allowableExpenses;
			double amountSaved=0;
			double paidBackAmount=0;
			// Decimal format 
			DecimalFormat dollar = new DecimalFormat("$#,##0.00");
			// Get Input Data the user entered in the text fields.
			days = Integer.parseInt(daysTrip.getText());
			air = Double.parseDouble(amountAirfairTextField.getText());
			carRental = Double.parseDouble(rental.getText());
			miles = Double.parseDouble(milesCar.getText());
			parking = Double.parseDouble(carParking.getText());
			taxi = Double.parseDouble(taxiCharge.getText());
			conferenceFee = Double.parseDouble(registration.getText());
			lodging = Double.parseDouble(lodgingFee.getText());
			// Determine actualExpenses method.
			milesExpenses = miles * prVechiclePerMileReimbursed;
			actualExpenses = (carRental + parking + taxi + lodging +mealsAmount)
					*days+air+milesExpenses+ conferenceFee;
			// Calculate allowable expenses.
			allowableExpenses=(mealsAmount+parkingFeesReimbursed+taxiChargesReimbursed+lodgingChargesReimbursed)*days+milesExpenses+air+conferenceFee;
			// Calculate the paid back
			if(actualExpenses > allowableExpenses)
				paidBackAmount=actualExpenses-allowableExpenses;
			else
				amountSaved=allowableExpenses-actualExpenses;
			
			if(paidBackAmount > 0)
				JOptionPane.showMessageDialog(null, "Total expenses: "
						+ dollar.format(actualExpenses) +"\n" +"Allowable expenses: "
						+ dollar.format(allowableExpenses)+"\n" +"\n" + "Amount to paid back: "
						+dollar.format(paidBackAmount));
			else if(amountSaved > 0)
				JOptionPane.showMessageDialog(null, "Total expenses: " + dollar.format(actualExpenses)
				+"\n" +"Allowable expenses: " + dollar.format(allowableExpenses)+"\n" +
				"\n" + "Amount Saved: "+dollar.format(amountSaved));
			else
				JOptionPane.showMessageDialog(null, "Total expenses: " + dollar.format(actualExpenses)
				+"\n" +"Allowable expenses: " + dollar.format(allowableExpenses)+"\n" );
		}
	}
	
	public static void main(String[] args){
		new travelExpenses();
	}
}