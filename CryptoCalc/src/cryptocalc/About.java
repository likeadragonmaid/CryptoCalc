/*****************************************************************************
 * src/About.java: About JFrame for CryptoCalc
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

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class About extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public About() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 284, 175);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGitHub = new JButton("GitHub");
		btnGitHub.setToolTipText("Access Droid PC Suite github repository");
		btnGitHub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URL("https://kvsjxd.github.io/CryptoCalc/").toURI());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnGitHub.setBounds(12, 96, 252, 25);
		contentPane.add(btnGitHub);

		JLabel lblVersionInfo = new JLabel("Version: 1.2");
		lblVersionInfo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVersionInfo.setBounds(12, 12, 252, 18);
		contentPane.add(lblVersionInfo);

		JLabel lblDeveloper = new JLabel("Developer");
		lblDeveloper.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeveloper.setBounds(12, 36, 252, 24);
		contentPane.add(lblDeveloper);

		JLabel lblMyname = new JLabel("Karanvir Singh");
		lblMyname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://twitter.com/iamkaranvir/").toURI());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblMyname.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMyname.setForeground(Color.RED);
			}
		});
		lblMyname.setForeground(Color.RED);
		lblMyname.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblMyname.setBounds(12, 60, 252, 24);
		contentPane.add(lblMyname);
	}
}
