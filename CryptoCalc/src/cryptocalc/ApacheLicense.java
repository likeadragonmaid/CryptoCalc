/*****************************************************************************
 * src/ApacheLicense.java: Apache License 2.0 Viewer JFrame for CryptoCalc
 *****************************************************************************
 * Copyright (C) 2017 Karanvir Singh
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

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ApacheLicense extends JFrame {
	JTextArea LicenseViewer;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApacheLicense frame = new ApacheLicense();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ApacheLicense() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ApacheLicense.class.getResource("/graphics/Icon.png")));
		setResizable(false);
		setTitle("Open source licenses");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 698, 468);
		contentPane.add(scrollPane);

		LicenseViewer = new JTextArea();
		LicenseViewer.setEditable(false);
		scrollPane.setViewportView(LicenseViewer);
		try {
			InputStreamReader reader = new InputStreamReader(
					getClass().getResourceAsStream("/licenses/Apache License 2.0.txt"));
			LicenseViewer.read(reader, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
