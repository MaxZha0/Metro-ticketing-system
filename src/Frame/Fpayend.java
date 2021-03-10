package Frame;


import java.awt.Color;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Fpayend extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Fpayend j;



	/**
	 * Create the frame.
	 */
	public Fpayend() {
		this.j=this;
		setTitle("\u5929\u6D25\u5730\u94C1\u81EA\u52A8\u8D2D\u7968\u7CFB\u7EDF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbtitle = new JLabel("\u8BF7\u4E8E\u53D6\u7968\u53E3\u53D6\u8D70\u60A8\u7684\u8F66\u7968");
		lbtitle.setBounds(19, 165, 956, 82);
		lbtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbtitle.setFont(new Font("华文楷体", Font.PLAIN, 75));
		lbtitle.setBackground(Color.WHITE);

		
		contentPane.setLayout(null);
		contentPane.add(lbtitle);
		
		JLabel label = new JLabel("\u8C22\u8C22\u4F7F\u7528");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("华文楷体", Font.PLAIN, 70));
		label.setBackground(Color.WHITE);
		label.setBounds(19, 270, 956, 82);
		contentPane.add(label);
		
		JButton buyButton = new JButton("\u8FD4\u56DE\u9996\u9875");
		buyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new  Fwelcome();		
				j.dispose();
			}
		});
		buyButton.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		buyButton.setFont(new Font("宋体", Font.PLAIN, 30));
		buyButton.setBounds(405, 475, 193, 55);
		contentPane.add(buyButton);
		buyButton.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		setVisible(true);
	}

}
