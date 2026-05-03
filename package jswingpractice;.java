//Import necessary libraries for GUI, events, tables, and date/time
import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.event.TableModelListener;
import javax.swing.event.*;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableCellRenderer;

public class DentalClinic extends JFrame {

	private static final long serialVersionUID = 1L;

	// Main container panel
	private JPanel contentPane;
	// Textfields for patient info
	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfNum;
	// Tables for selected services and transaction logs
	private JTable serviceTable;
	private JTable logTable;

	// auto Increment ID
	int id = 1;

	// Text field for total amount
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DentalClinic frame = new DentalClinic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DentalClinic() {
		setTitle("Dental Clinic Billing System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 775);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// SERVICES PANEL

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(13, 271, 341, 196);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		// CONSULTATION CHECKBOX

		JCheckBox cbConsultation = new JCheckBox("Consultation – ₱300");
		cbConsultation.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Adds the selected services to the panel
				if (e.getStateChange() == ItemEvent.SELECTED) {
					DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
					model.addRow(new Object[] { "Consultation", "300" });
				} else {
					// Removes the selected service if unchecked
					removeMethod("Consultation");
				}
			}
		});
		cbConsultation.setBounds(6, 31, 279, 23);
		panel_2.add(cbConsultation);

		// TOOTH EXTRACTION CHECKBOX

		JCheckBox cbToothExtract = new JCheckBox("Tooth Extraction – ₱500");
		cbToothExtract.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Adds the selected services to the panel
				if (e.getStateChange() == ItemEvent.SELECTED) {
					DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
					model.addRow(new Object[] { "Tooth Extraction", "500" });
				} else {
					// Removes the selected service if unchecked
					removeMethod("Tooth Extraction");
				}
			}
		});
		cbToothExtract.setBounds(6, 57, 279, 23);
		panel_2.add(cbToothExtract);

		// TEETH CLEANING CHECKBOX

		JCheckBox cbTeethClean = new JCheckBox("Teeth Cleaning – ₱800");
		cbTeethClean.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Adds the selected services to the panel
				if (e.getStateChange() == ItemEvent.SELECTED) {
					DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
					model.addRow(new Object[] { "Teeth Cleaning", "800" });
				} else {
					// Removes the selected service if unchecked
					removeMethod("Teeth Cleaning");
				}
			}
		});
		cbTeethClean.setBounds(6, 83, 279, 23);
		panel_2.add(cbTeethClean);

		// TEETH WHITENING CHECKBOX

		JCheckBox cbTeethWhitening = new JCheckBox("Teeth Whitening – ₱2,000");
		cbTeethWhitening.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Adds the selected services to the panel
				if (e.getStateChange() == ItemEvent.SELECTED) {
					DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
					model.addRow(new Object[] { "Teeth Whitening", "2000" });
				} else {
					// Removes the selected service if unchecked
					removeMethod("Teeth Whitening");
				}
			}
		});
		cbTeethWhitening.setBounds(6, 109, 279, 23);
		panel_2.add(cbTeethWhitening);

		// ORTHODONTIC BRACES CHECKBOX

		JCheckBox cbOrthodonticBraces = new JCheckBox("Orthodontic Braces – ₱35,000");
		cbOrthodonticBraces.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Adds the selected services to the panel
				if (e.getStateChange() == ItemEvent.SELECTED) {
					DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
					model.addRow(new Object[] { "Orthodontic Braces", "35000" });
				} else {
					// Removes the selected service if unchecked
					removeMethod("Orthodontic Braces");
				}
			}
		});
		cbOrthodonticBraces.setBounds(6, 135, 279, 23);
		panel_2.add(cbOrthodonticBraces);

		// DENTA FILLING CHECKBOX

		JCheckBox cbDentalFilling = new JCheckBox("Dental Filling – ₱600");
		cbDentalFilling.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Adds the selected services to the panel
				if (e.getStateChange() == ItemEvent.SELECTED) {
					DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
					model.addRow(new Object[] { "Dental Filling", "600" });
				} else {
					// Removes the selected service if unchecked
					removeMethod("Dental Filling");
				}
			}
		});
		cbDentalFilling.setBounds(6, 161, 279, 17);
		panel_2.add(cbDentalFilling);
		
		JLabel lblServices = new JLabel("SELECT SERVICES");
		lblServices.setForeground(new Color(0, 0, 128));
		lblServices.setFont(new Font("Arial", Font.BOLD, 14));
		lblServices.setBounds(10, 11, 200, 25);
		panel_2.add(lblServices);

		// SERVICES TO AVAIL TABLE

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(367, 108, 609, 313);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		// Add a scroll pane so the content can be scrolled
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 40, 593, 262);
		panel_1.add(scrollPane);

		// TABLE FOR SELECTED SERVICES

		serviceTable = new JTable();
		// Adds column headers
		serviceTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Service", "Fee" }) {
			//Disables editing of cells
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane.setViewportView(serviceTable);
		
		JLabel lblAvailable = new JLabel("SERVICES TO AVAIL");
		lblAvailable.setForeground(new Color(0, 0, 128));
		lblAvailable.setFont(new Font("Arial", Font.BOLD, 14));
		lblAvailable.setBounds(6, 12, 252, 17);
		panel_1.add(lblAvailable);
		// Update total automatically if rows change
		serviceTable.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				updateTotalAmount();
			}
		});
		serviceTable.getTableHeader().setReorderingAllowed(false);

		// LOGS PANEL

		JPanel panel = new JPanel();
		panel.setBounds(192, 477, 784, 228);
		contentPane.add(panel);
		panel.setLayout(null);

		// Add a scroll pane so the content can be scrolled
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 43, 764, 174);
		panel.add(scrollPane_1);
		
		// Transaction log table
		
		logTable = new JTable();
		logTable.setModel(new DefaultTableModel(new Object[][] {},
				// Adds column headers
				new String[] { "#", "Patient Name", "Age", "Contact No.", "Date", "Services", "Total" }) {

			// Method to disable editing of cells
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		});
		logTable.getColumnModel().getColumn(1).setPreferredWidth(173);
		logTable.getColumnModel().getColumn(3).setPreferredWidth(102);
		logTable.getColumnModel().getColumn(4).setPreferredWidth(91);
		logTable.getColumnModel().getColumn(5).setPreferredWidth(273);
		scrollPane_1.setViewportView(logTable);
		
		JLabel lblTable2 = new JLabel("BILL / TRANSACTION RECORD");
		lblTable2.setForeground(new Color(0, 0, 128));
		lblTable2.setFont(new Font("Arial", Font.BOLD, 14));
		lblTable2.setBounds(10, 7, 300, 25);
		panel.add(lblTable2);
		logTable.getTableHeader().setReorderingAllowed(false);

		// Double click to view details
		logTable.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {

				if (e.getClickCount() == 2) {

					int selectedRow = logTable.getSelectedRow();

					if (selectedRow != -1) {

						showTransactionDetails(selectedRow);
					}
				}
			}
		});

		// Create popup menu for log table
		JPopupMenu popupMenu = new JPopupMenu();
		
		// Menu items
		JMenuItem viewItem = new JMenuItem("View Details");
		JMenuItem removeItem = new JMenuItem("Remove Log");
		
		// Add items to popup menu
		popupMenu.add(viewItem);
		popupMenu.add(removeItem);
		
		// View selected transaction details
		viewItem.addActionListener(e -> {
			int selectedRow = logTable.getSelectedRow();
			if (selectedRow != -1) {

				showTransactionDetails(selectedRow);
			}
		});
		
		// Remove selected transaction log
		removeItem.addActionListener(e -> {
			int selectedRow = logTable.getSelectedRow();
			if (selectedRow != -1) {

				removeLog(selectedRow);
			}
		});
		
		// Add mouse listener to detect right-click
		logTable.addMouseListener(new java.awt.event.MouseAdapter() {

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				showPopup(e);
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				showPopup(e);
			}
			
			// Show popup menu when right-click is triggered
			private void showPopup(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger()) {
					int row = logTable.rowAtPoint(e.getPoint());
					
					// Ensure a valid row is selected before showing menu
					if (row >= 0 && row < logTable.getRowCount()) {
						logTable.setRowSelectionInterval(row, row);

						popupMenu.show(e.getComponent(), e.getX(), e.getY());
					}
				}
			}
		});
		
		//LABELS
		JLabel lblPatient = new JLabel("PATIENT INFORMATION");
		lblPatient.setForeground(new Color(0, 0, 128));
		lblPatient.setFont(new Font("Arial", Font.BOLD, 14));
		lblPatient.setBounds(26, 108, 160, 17);
		contentPane.add(lblPatient);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(13, 93, 341, 167);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
				// PATIENT INFORMATION FIELDS
		
				tfName = new JTextField();
				tfName.setBounds(146, 49, 185, 27);
				panel_4.add(tfName);
				tfName.setColumns(10);
				
						tfAge = new JTextField();
						tfAge.setBounds(146, 87, 185, 27);
						panel_4.add(tfAge);
						tfAge.setColumns(10);
						
								tfNum = new JTextField();
								tfNum.setBounds(146, 125, 185, 27);
								panel_4.add(tfNum);
								tfNum.setColumns(10);
								
								// Label for Patient Name input
								JLabel lblName = new JLabel("Patient Name:");
								lblName.setBounds(10, 55, 126, 14);
								panel_4.add(lblName);
								
								// Label for Age input
								JLabel lblAge = new JLabel("Age:");
								lblAge.setBounds(10, 93, 79, 14);
								panel_4.add(lblAge);
								
								// Label for Contact Number input
								JLabel lblContactNum = new JLabel("Contact No.");
								lblContactNum.setBounds(10, 131, 79, 14);
								panel_4.add(lblContactNum);
		
		// ================= CALCULATE BUTTON =================

		
		JButton btnCalculate = new JButton("Calculate Bill");
		btnCalculate.setForeground(Color.WHITE);
		btnCalculate.setBackground(new Color(0, 0, 128));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Get table models
				DefaultTableModel serviceModel = (DefaultTableModel) serviceTable.getModel();
				DefaultTableModel transactionModel = (DefaultTableModel) logTable.getModel();
				
				// Gets current date and time
				LocalDateTime currentDateTime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
				String formattedDateTime = currentDateTime.format(formatter);
				
				// Get user inputs
				String userName = tfName.getText().trim();
				String Age = tfAge.getText().trim();
				String contact = tfNum.getText().trim();

				// Check if name is empty
				if (userName.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Name is Required!");
    return;
}
 
// Check if it contains numbers or invalid characters
	if (!userName.matches("[a-zA-Z ]+")) {
    JOptionPane.showMessageDialog(null, "Name must contain letters only!");
    return;
}

				// Check if age is empty
				if (Age.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Age is required!", "Validation Error",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				// Check if age contains only numbers
         if (!Age.matches("\\d+")) {
            JOptionPane.showMessageDialog(contentPane, "Age must contain numbers only!", "Validation Error",
            JOptionPane.WARNING_MESSAGE);
                    return;
                }
				int userAge;
				try {
					userAge = Integer.parseInt(Age);
					// Validate realistic age range
					if (userAge <= 0 || userAge > 120) {
						JOptionPane.showMessageDialog(contentPane, "Please enter a valid realistic age (1-120).",
								"Validation Error", JOptionPane.WARNING_MESSAGE);
						return;
					}
				} catch (NumberFormatException ex) {
					// Age must be a number
					JOptionPane.showMessageDialog(contentPane, "Age must be a valid whole number.", "Validation Error",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				// Check if contact number is empty
				if (contact.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Contact Number is required!", "Validation Error",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (!contact.matches("\\d+")) {
                     JOptionPane.showMessageDialog(null, "Contact must contain numbers only!");
                     return;
                }
				
				// Validate Philippine mobile number format
				if (!contact.matches("^09\\d{9}$")) {
					JOptionPane.showMessageDialog(contentPane,
							"Contact Number must be exactly 11 digits and start with '09' (e.g., 09123456789).",
							"Validation Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				// Check if no services are selected
				if (serviceModel.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "No services selected!");
					return;
				}

				// Calculate
				int total = 0;
				String services = "";
				
				// Loop through selected services
				for (int i = 0; i < serviceModel.getRowCount(); i++) {
					String serviceName = serviceModel.getValueAt(i, 0).toString();
					int fee = Integer.parseInt(serviceModel.getValueAt(i, 1).toString());

					total += fee; // Add fee to total

					services += serviceName;// Build services string
					
					// Add comma if not last item
					if (i < serviceModel.getRowCount() - 1) {
						services += ", ";
					}

				}
				// Add transaction to log table
				transactionModel
						.addRow(new Object[] { id, userName, Age, contact, formattedDateTime, services, total });
				
				// Show details of the newly added transaction
				int thisRowIndex = transactionModel.getRowCount() - 1;
				showTransactionDetails(thisRowIndex);
				// Increment transaction ID
				id++;
			}

		});
		btnCalculate.setBounds(26, 502, 154, 34);
		contentPane.add(btnCalculate);
		
		// ================= CLEAR BUTTON =================

		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(Color.WHITE);
		btnClear.setBackground(new Color(0, 0, 128));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear all input fields
				tfName.setText("");
				tfAge.setText("");
				tfNum.setText("");
				
				// Uncheck all service checkboxes
				cbConsultation.setSelected(false);
				cbToothExtract.setSelected(false);
				cbTeethClean.setSelected(false);
				cbTeethWhitening.setSelected(false);
				cbOrthodonticBraces.setSelected(false);
				cbDentalFilling.setSelected(false);
				
				// Clear all rows in the service table
				DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
				model.setRowCount(0);

			}
		});
		btnClear.setBounds(26, 557, 154, 34);
		contentPane.add(btnClear);
		
		// Top panel (header design)
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 205));
		panel_3.setBounds(0, 0, 993, 82);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		// Main title
		JLabel lblNewLabel_3 = new JLabel("DENTAL CLINIC BILLING SYSTEM");
		lblNewLabel_3.setBounds(301, 11, 418, 43);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 25));
		
		// Subtitle
		JLabel lblNewLabel_4 = new JLabel("— Quality Care, Healthy Smile —");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(430, 57, 170, 14);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		
		// Textfield to display total amount 
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(803, 432, 162, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Label for total amount
		JLabel lblNewLabel_5 = new JLabel("TOTAL AMOUNT:");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(377, 432, 209, 34);
		contentPane.add(lblNewLabel_5);
		
		// Create menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Create Options menu
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		// Menu items
		JMenuItem mntmClearLogs = new JMenuItem("Clear All Logs");
		JMenuItem mntmExit = new JMenuItem("Exit");
		
		// Add items to menu
		mnOptions.add(mntmClearLogs);
		mnOptions.addSeparator();
		mnOptions.add(mntmExit);
		
		// Exit application with confirmation
		mntmExit.addActionListener(e -> {

			int confirm = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to exit the application?",
					"Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		});
		
		// Clear all logs with confirmation
		mntmClearLogs.addActionListener(e -> {

			DefaultTableModel model = (DefaultTableModel) logTable.getModel();
			// Check if there are logs
			if (model.getRowCount() == 0) {
				JOptionPane.showMessageDialog(contentPane, "There are no logs to clear.", "Info",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			// Confirm before clearing all logs
			int confirm = JOptionPane.showConfirmDialog(contentPane,
					"Are you sure you want to permanently clear ALL transaction logs?", "Confirm Clear All",
					JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

			if (confirm == JOptionPane.YES_OPTION) {
				// Remove all rows
				model.setRowCount(0);
				
				// Reset ID counter
				id = 1;

				JOptionPane.showMessageDialog(contentPane, "All logs have been cleared successfully.");
			}
		});

		// Custom renderer to format numbers with peso sign
		DefaultTableCellRenderer pesoRenderer = new DefaultTableCellRenderer() {
			@Override
			public void setValue(Object value) {
				if (value != null) {
					try {
						// Convert value to integer and format with peso sign
						int amount = Integer.parseInt(value.toString());
						setText(String.format("₱ %,d", amount));
					} catch (NumberFormatException e) {
						// If not a number, display as-is
						setText(value.toString());
					}
				} else {
					setText("");
				}
			}
		};
		// Align values to the right
		pesoRenderer.setHorizontalAlignment(JLabel.RIGHT);
		
		// Apply renderer to fee column (service table) and total column (log table)
		serviceTable.getColumnModel().getColumn(1).setCellRenderer(pesoRenderer);
		logTable.getColumnModel().getColumn(6).setCellRenderer(pesoRenderer);

	}
		
	//Method that Removes a specific service from the table
	private void removeMethod(String item) {
		DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 0).equals(item)) {
				model.removeRow(i);
				break;
			}
		}
	}
	
	//Method that Calculates and updates total amount automatically
	private void updateTotalAmount() {
		DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
		int total = 0;

		for (int i = 0; i < model.getRowCount(); i++) {
			try {
				total += Integer.parseInt(model.getValueAt(i, 1).toString());
			} catch (NumberFormatException ex) {
				System.out.println("Error parsing fee at row " + i);
			}
		}
		// Display formatted total
		textField.setText(String.format("₱ %,d", total));
	}
	
	//Method that Displays full details of a selected transaction
	private void showTransactionDetails(int rowIndex) {
		DefaultTableModel model = (DefaultTableModel) logTable.getModel();

		String logId = model.getValueAt(rowIndex, 0).toString();
		String logName = model.getValueAt(rowIndex, 1).toString();
		String logAge = model.getValueAt(rowIndex, 2).toString();
		String logContact = model.getValueAt(rowIndex, 3).toString();
		String logDate = model.getValueAt(rowIndex, 4).toString();
		String logServices = model.getValueAt(rowIndex, 5).toString();

		int logTotal = Integer.parseInt(model.getValueAt(rowIndex, 6).toString());
		
		// Build transaction summary message
		String detailsMessage = "DENTAL TRANSACTION SUMMARY\n\n" + "Transaction ID: " + logId + "\n" + "Patient Name: "
				+ logName + "\n" + "Age: " + logAge + "\n" + "Contact No.: " + logContact + "\n" + "Date & Time: "
				+ logDate + "\n\n" + "Services Availed:\n" + logServices + "\n\n" + "TOTAL AMOUNT: "
				+ String.format("₱ %,d", logTotal) + "\n\n";

		JOptionPane.showMessageDialog(contentPane, detailsMessage, "Transaction Details",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Method that Removes a selected transaction log
	private void removeLog(int rowIndex) {
		int confirm = JOptionPane.showConfirmDialog(contentPane,
				"Are you sure you want to remove this transaction record?", "Confirm Delete",
				JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			DefaultTableModel model = (DefaultTableModel) logTable.getModel();
			model.removeRow(rowIndex);
			
			// Update numbering after deletion
			updateLogNumbers();
		}
	}
	
	//Method that Updates row numbers after deleting logs
	private void updateLogNumbers() {
		DefaultTableModel model = (DefaultTableModel) logTable.getModel();

		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
		
		// Reset ID to next available number
		id = model.getRowCount() + 1;
	}
}
