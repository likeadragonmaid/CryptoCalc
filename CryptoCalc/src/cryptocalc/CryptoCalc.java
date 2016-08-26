/*****************************************************************************
 * src/CryptoCalc.java: Main application JFrame for CryptoCalc
 *****************************************************************************
 * Copyright (C) 2016 Karanvir Singh
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *****************************************************************************/

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
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class CryptoCalc extends JFrame {

	JTextArea CalculatedCrypto, InputCrypto, MultiModeMD5, MultiModeSHA1, MultiModeSHA256, MultiModeSHA384,
			MultiModeSHA512;
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
		setBounds(100, 100, 791, 508);

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

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 778, 454);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Calculate and Compare", null, panel, null);
		panel.setLayout(null);

		JButton btnClearCalculatedCrypto = new JButton("Clear");
		btnClearCalculatedCrypto.setBounds(12, 22, 220, 75);
		panel.add(btnClearCalculatedCrypto);
		btnClearCalculatedCrypto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatedCrypto.setText("");
				InputCrypto.setText("");
			}
		});
		btnClearCalculatedCrypto.setToolTipText("Clear the calculated sum");

		JButton btnMD5 = new JButton("MD5");
		btnMD5.setBounds(269, 22, 220, 75);
		panel.add(btnMD5);
		btnMD5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatedCrypto.setText("");
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					CalculatedCrypto.setText(DigestUtils.md5Hex(file.getAbsolutePath()));
				}
			}
		});
		btnMD5.setToolTipText("Calculate MD5 sum of a file");

		JButton btnSHA1 = new JButton("SHA-1");
		btnSHA1.setBounds(528, 22, 220, 75);
		panel.add(btnSHA1);
		btnSHA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatedCrypto.setText("");
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					CalculatedCrypto.setText(DigestUtils.sha1Hex(file.getAbsolutePath()));
				}
			}
		});
		btnSHA1.setToolTipText("Calculate SHA-1 sum of a file");

		JButton btnSHA256 = new JButton("SHA-256");
		btnSHA256.setBounds(12, 161, 220, 75);
		panel.add(btnSHA256);
		btnSHA256.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatedCrypto.setText("");
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					CalculatedCrypto.setText(DigestUtils.sha256Hex(file.getAbsolutePath()));
				}
			}
		});
		btnSHA256.setToolTipText("Calculate SHA-256 sum of a file");

		JButton btnSHA384 = new JButton("SHA-384");
		btnSHA384.setBounds(269, 161, 220, 75);
		panel.add(btnSHA384);
		btnSHA384.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatedCrypto.setText("");
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					CalculatedCrypto.setText(DigestUtils.sha384Hex(file.getAbsolutePath()));
				}
			}
		});
		btnSHA384.setToolTipText("Calculate SHA-384 sum of a file");

		JButton btnSHA512 = new JButton("SHA-512");
		btnSHA512.setBounds(528, 161, 220, 75);
		panel.add(btnSHA512);
		btnSHA512.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatedCrypto.setText("");
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					CalculatedCrypto.setText(DigestUtils.sha512Hex(file.getAbsolutePath()));
				}
			}
		});
		btnSHA512.setToolTipText("Calculate SHA-512 sum of a file");

		JLabel label = new JLabel("Calculated Sum :");
		label.setBounds(12, 293, 259, 17);
		panel.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 310, 586, 34);
		panel.add(scrollPane);

		CalculatedCrypto = new JTextArea();
		scrollPane.setViewportView(CalculatedCrypto);
		CalculatedCrypto.setToolTipText("Calclated sum");
		CalculatedCrypto.setEditable(false);

		JLabel label_1 = new JLabel("Input Sum to be compared :");
		label_1.setBounds(12, 364, 259, 15);
		panel.add(label_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 391, 586, 28);
		panel.add(scrollPane_1);

		InputCrypto = new JTextArea();
		scrollPane_1.setViewportView(InputCrypto);
		InputCrypto.setToolTipText("Input sum to be compared with calculated sum");

		JButton btnCompare = new JButton("Compare");
		btnCompare.setBounds(610, 310, 134, 109);
		panel.add(btnCompare);
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

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Multi Calculator", null, panel_1, null);
		panel_1.setLayout(null);

		JButton btnClearMultiMode = new JButton("Clear");
		btnClearMultiMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MultiModeMD5.setText("");
				MultiModeSHA1.setText("");
				MultiModeSHA256.setText("");
				MultiModeSHA384.setText("");
				MultiModeSHA512.setText("");
			}
		});
		btnClearMultiMode.setBounds(12, 12, 360, 48);
		panel_1.add(btnClearMultiMode);

		JLabel lblMd = new JLabel("MD5");
		lblMd.setBounds(12, 73, 145, 15);
		panel_1.add(lblMd);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 89, 749, 40);
		panel_1.add(scrollPane_2);

		MultiModeMD5 = new JTextArea();
		scrollPane_2.setViewportView(MultiModeMD5);
		MultiModeMD5.setToolTipText("Calclated sum");
		MultiModeMD5.setEditable(false);

		JLabel lblSha = new JLabel("SHA-1");
		lblSha.setBounds(12, 141, 145, 15);
		panel_1.add(lblSha);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 157, 748, 40);
		panel_1.add(scrollPane_3);

		MultiModeSHA1 = new JTextArea();
		scrollPane_3.setViewportView(MultiModeSHA1);
		MultiModeSHA1.setToolTipText("Calclated sum");
		MultiModeSHA1.setEditable(false);

		JLabel lblSha_1 = new JLabel("SHA-256");
		lblSha_1.setBounds(12, 209, 145, 15);
		panel_1.add(lblSha_1);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(12, 227, 748, 40);
		panel_1.add(scrollPane_4);

		MultiModeSHA256 = new JTextArea();
		scrollPane_4.setViewportView(MultiModeSHA256);
		MultiModeSHA256.setToolTipText("Calclated sum");
		MultiModeSHA256.setEditable(false);

		JLabel lblSha_2 = new JLabel("SHA-384");
		lblSha_2.setBounds(12, 279, 145, 15);
		panel_1.add(lblSha_2);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(12, 298, 748, 40);
		panel_1.add(scrollPane_5);

		MultiModeSHA384 = new JTextArea();
		scrollPane_5.setViewportView(MultiModeSHA384);
		MultiModeSHA384.setToolTipText("Calclated sum");
		MultiModeSHA384.setEditable(false);

		JLabel lblSha_3 = new JLabel("SHA-512");
		lblSha_3.setBounds(12, 350, 145, 15);
		panel_1.add(lblSha_3);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(14, 368, 747, 40);
		panel_1.add(scrollPane_6);

		MultiModeSHA512 = new JTextArea();
		scrollPane_6.setViewportView(MultiModeSHA512);
		MultiModeSHA512.setToolTipText("Calclated sum");
		MultiModeSHA512.setEditable(false);

		JButton btnSelectFileFor2ndMode = new JButton("Select a file");
		btnSelectFileFor2ndMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MultiModeMD5.setText("");
				MultiModeSHA1.setText("");
				MultiModeSHA256.setText("");
				MultiModeSHA384.setText("");
				MultiModeSHA512.setText("");
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File("");
					MultiModeMD5.setText(DigestUtils.md5Hex(file.getAbsolutePath()));
					MultiModeSHA1.setText(DigestUtils.sha1Hex(file.getAbsolutePath()));
					MultiModeSHA256.setText(DigestUtils.sha256Hex(file.getAbsolutePath()));
					MultiModeSHA384.setText(DigestUtils.sha384Hex(file.getAbsolutePath()));
					MultiModeSHA512.setText(DigestUtils.sha512Hex(file.getAbsolutePath()));
				}
			}
		});
		btnSelectFileFor2ndMode.setBounds(401, 12, 360, 48);
		panel_1.add(btnSelectFileFor2ndMode);
	}
}