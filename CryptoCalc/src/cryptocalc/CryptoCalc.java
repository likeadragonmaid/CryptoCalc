package cryptocalc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;

@SuppressWarnings("serial")
public class CryptoCalc extends JFrame {

	JTextArea CalculatedCrypto, InputCrypto;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CryptoCalc frame = new CryptoCalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CryptoCalc() {
		setTitle("CryptoCalc");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 425);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnMenu.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About obj = new About();
				obj.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
		
		JMenu mnLegalInformation = new JMenu("Legal information");
		mnHelp.add(mnLegalInformation);
		
		JMenuItem mntmCryptocalcLicense = new JMenuItem("CryptoCalc License");
		mntmCryptocalcLicense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GPLLicense obj = new GPLLicense();
				obj.setVisible(true);
			}
		});
		mnLegalInformation.add(mntmCryptocalcLicense);
		
		JMenuItem mntmOpenSourceLicenses = new JMenuItem("Open source licenses");
		mntmOpenSourceLicenses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApacheLicense obj = new ApacheLicense();
				obj.setVisible(true);
			}
		});
		mnLegalInformation.add(mntmOpenSourceLicenses);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSHA1 = new JButton("SHA-1");
		btnSHA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					CalculatedCrypto.setText(DigestUtils.sha1Hex(file.getAbsolutePath()));
				}
			}
		});
		btnSHA1.setToolTipText("Calculate SHA-1 sum of a file");
		btnSHA1.setBounds(528, 12, 220, 75);
		contentPane.add(btnSHA1);

		JButton btnClearCalculatedCrypto = new JButton("Clear");
		btnClearCalculatedCrypto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatedCrypto.setText("");
				InputCrypto.setText("");
			}
		});
		btnClearCalculatedCrypto.setToolTipText("Clear the calculated sum");
		btnClearCalculatedCrypto.setBounds(12, 12, 220, 75);
		contentPane.add(btnClearCalculatedCrypto);

		JButton btnSHA256 = new JButton("SHA-256");
		btnSHA256.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					CalculatedCrypto.setText(DigestUtils.sha256Hex(file.getAbsolutePath()));
				}
			}
		});
		btnSHA256.setToolTipText("Calculate SHA-256 sum of a file");
		btnSHA256.setBounds(12, 116, 220, 75);
		contentPane.add(btnSHA256);

		JButton btnMD5 = new JButton("MD5");
		btnMD5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					CalculatedCrypto.setText(DigestUtils.md5Hex(file.getAbsolutePath()));
				}
			}
		});
		btnMD5.setToolTipText("Calculate MD5 sum of a file");
		btnMD5.setBounds(269, 12, 220, 75);
		contentPane.add(btnMD5);

		JButton btnSHA384 = new JButton("SHA-384");
		btnSHA384.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					CalculatedCrypto.setText(DigestUtils.sha384Hex(file.getAbsolutePath()));
				}
			}
		});
		btnSHA384.setToolTipText("Calculate SHA-384 sum of a file");
		btnSHA384.setBounds(269, 116, 220, 75);
		contentPane.add(btnSHA384);

		JButton btnSHA512 = new JButton("SHA-512");
		btnSHA512.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					CalculatedCrypto.setText(DigestUtils.sha512Hex(file.getAbsolutePath()));
				}
			}
		});
		btnSHA512.setToolTipText("Calculate SHA-512 sum of a file");
		btnSHA512.setBounds(528, 116, 220, 75);
		contentPane.add(btnSHA512);

		JLabel label = new JLabel("Calculated Sum :");
		label.setBounds(12, 217, 259, 17);
		contentPane.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 248, 586, 34);
		contentPane.add(scrollPane);

		CalculatedCrypto = new JTextArea();
		scrollPane.setViewportView(CalculatedCrypto);
		CalculatedCrypto.setToolTipText("Calclated sum");
		CalculatedCrypto.setEditable(false);

		JLabel label_1 = new JLabel("Input Sum to be compared :");
		label_1.setBounds(12, 302, 259, 15);
		contentPane.add(label_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 329, 586, 28);
		contentPane.add(scrollPane_1);

		InputCrypto = new JTextArea();
		scrollPane_1.setViewportView(InputCrypto);
		InputCrypto.setToolTipText("Input sum to be compared with calculated sum");

		JButton btnCompare = new JButton("Compare");
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (InputCrypto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please select algorithm and a file");
				}
				if (CalculatedCrypto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please input a sum to be compared");
				} else {
					if (InputCrypto.getText().equalsIgnoreCase(CalculatedCrypto.getText())) {
						JOptionPane.showMessageDialog(null, "Both sums are matched");
					} else {
						JOptionPane.showMessageDialog(null, "Sums are not matched!");
					}
				}
			}
		});
		btnCompare.setToolTipText("Click to compare calculated sum and input sum");
		btnCompare.setBounds(610, 248, 134, 109);
		contentPane.add(btnCompare);
	}
}
