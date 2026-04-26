public class package jswingpractice; {
    package jswingPractice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;

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
        chkConsultation.setBounds(300, 50, 200, 20);
        contentPane.add(chkConsultation);

        chkExtraction = new JCheckBox("Tooth Extraction (₱500)");
        chkExtraction.setBounds(300, 80, 200, 20);
        contentPane.add(chkExtraction);

        chkCleaning = new JCheckBox("Teeth Cleaning (₱800)");
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
		
		
	}
	
	private void calculateBill() {
		
	}
	
	private void clearFields() {
		
	}
}

}
