package jswingPractice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class DentalSystem extends JFrame {


    private JPanel contentPane;
    private JTextField txtName, txtAge, txtContactNum;

    private JTable serviceTable, transactionTable;

    private DefaultTableModel serviceModel;
    private DefaultTableModel transactionModel;

    // Checkboxes
    private JCheckBox chkConsultation, chkExtraction, chkCleaning;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DentalSystem frame = new DentalSystem();
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
    public DentalSystem() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Dental Guy");
        lblTitle.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 32));
        lblTitle.setBounds(10, 0, 300, 40);
        contentPane.add(lblTitle);

        // ================= INPUT =================
        contentPane.add(new JLabel("Name:")).setBounds(20, 50, 100, 20);
        txtName = new JTextField();
        txtName.setBounds(120, 50, 150, 20);
        contentPane.add(txtName);

        contentPane.add(new JLabel("Age:")).setBounds(20, 80, 100, 20);
        txtAge = new JTextField();
        txtAge.setBounds(120, 80, 150, 20);
        contentPane.add(txtAge);

        contentPane.add(new JLabel("Contact:")).setBounds(20, 110, 100, 20);
        txtContactNum = new JTextField();
        txtContactNum.setBounds(120, 110, 150, 20);
        contentPane.add(txtContactNum);

        // ================= CHECKBOX =================
        chkConsultation = new JCheckBox("Consultation (₱300)");
        //Item State Changed 
        chkConsultation.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    serviceModel.addRow(new Object[]{"Consultation", 300});
                } else {
                    removeService("Consultation");
                }
            }
        });
        chkConsultation.setBounds(300, 50, 200, 20);
        contentPane.add(chkConsultation);

        chkExtraction = new JCheckBox("Tooth Extraction (₱500)");
        //Item State changed 
        chkExtraction.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                serviceModel.addRow(new Object[]{"Tooth Extraction", 500});
            } else {
                removeService("Tooth Extraction");
            }
        });
        chkExtraction.setBounds(300, 80, 200, 20);
        contentPane.add(chkExtraction);

        chkCleaning = new JCheckBox("Teeth Cleaning (₱800)");
        chkCleaning.addItemListener(new ItemListener() {
        	//XXX Item state Change
        	public void itemStateChanged(ItemEvent e) {
        		chkCleaning.addItemListener(new ItemListener() {
        		    public void itemStateChanged(ItemEvent e) {

        		        if (e.getStateChange() == ItemEvent.SELECTED) {
        		            // Add service when checked
        		            serviceModel.addRow(new Object[]{"Teeth Cleaning", 800});
        		        } else {
        		            // Remove service when unchecked
        		            removeService("Teeth Cleaning");
        		        }
        		    }
        		});
        	}
        });
        chkCleaning.setBounds(300, 110, 200, 20);
        contentPane.add(chkCleaning);

        // ================= SERVICE TABLE =================
        serviceModel = new DefaultTableModel(new String[]{"Service", "Fee"}, 0);
        serviceTable = new JTable(serviceModel);
        JScrollPane scroll1 = new JScrollPane(serviceTable);
        scroll1.setBounds(20, 150, 350, 150);
        contentPane.add(scroll1);

        // ================= TRANSACTION TABLE =================
        transactionModel = new DefaultTableModel(
                new String[]{"Name", "Age", "Contact", "Services", "Total"}, 0);

        transactionTable = new JTable(transactionModel);
        JScrollPane scroll2 = new JScrollPane(transactionTable);
        scroll2.setBounds(400, 150, 450, 200);
        contentPane.add(scroll2);

        // ================= BUTTONS =================
        JButton btnAdd = new JButton("Add Service");
        btnAdd.setBounds(550, 50, 120, 25);
        contentPane.add(btnAdd);

        JButton btnCalc = new JButton("Calculate Bill");
        btnCalc.setBounds(550, 80, 150, 25);
        contentPane.add(btnCalc);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(550, 110, 100, 25);
        contentPane.add(btnClear);

        // ================= EVENTS =================
        btnAdd.addActionListener(e -> addService());
        btnCalc.addActionListener(e -> calculateBill());
        btnClear.addActionListener(e -> clearFields());
    }
	
    private void addService() {
    	//Service Table
    	serviceModel.setRowCount(0);
    	
    	if(chkConsultation.isSelected()) {
    		 serviceModel.addRow(new Object[]{"Consultation", 300});
    	}

    	if(chkExtraction.isSelected()) {
   		 serviceModel.addRow(new Object[]{"Tooth Extraction", 300});
   	}

    	if(chkCleaning.isSelected()) {
   		 serviceModel.addRow(new Object[]{"Tooth Cleaning", 300});
   	}
    	//Validations
    	if (serviceModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Please select at least one service.");
        }

    }
	
	private void calculateBill() {
		//Transaction Table Here
		String userName = txtName.getText();
		String Age = txtAge.getText();

		//Validations of requirments
		if (userName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Name is Required!");
			return;
		}

		if (Age.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Age is Required!");
			return;
		}
	}

	//XXX clear fields
	private void clearFields() {
		
		//validations again
		
		
	}
	//Remove Service 
	private void removeService(String serviceName) {
	    for (int i = 0; i < serviceModel.getRowCount(); i++) {
	        if (serviceModel.getValueAt(i, 0).equals(serviceName)) {
	            serviceModel.removeRow(i);
	            break;
	        }
	    }
	}
	
	
	
}
