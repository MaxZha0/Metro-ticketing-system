package Frame;


import java.awt.Color;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class Fvip extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Fvip j;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Fvip() {
		this.j=this;
		setTitle("\u5929\u6D25\u5730\u94C1\u81EA\u52A8\u8D2D\u7968\u7CFB\u7EDF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fwelcome();
				j.dispose();
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.focus"));
		btnNewButton.setIcon(new ImageIcon(Fmap.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnNewButton.setBounds(14, 13, 35, 36);
		contentPane.add(btnNewButton);
		
		JLabel lbtitle = new JLabel("\u5929\u6D25\u5730\u94C1VIP\u50A8\u503C\u5361");
		lbtitle.setBounds(19, 77, 956, 82);
		lbtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbtitle.setFont(new Font("华文楷体", Font.PLAIN, 80));
		lbtitle.setBackground(Color.WHITE);
		
		contentPane.setLayout(null);
		contentPane.add(lbtitle);
		
		JLabel label = new JLabel("\u4E00\u6B21\u529E\u7406\u7EC8\u751F\u4EAB\u7528\uFF0C\u8BA9\u60A8\u4F53\u9A8C\u5FEB\u6377\u670D\u52A1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("华文楷体", Font.PLAIN, 35));
		label.setBackground(Color.WHITE);
		label.setBounds(19, 192, 956, 82);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(76, 466, 858, 75);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 25, 0));
		
		JButton addB = new JButton("\u529E\u7406\u50A8\u503C\u5361");
		addB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fcard(1);
				j.dispose();
			}
		});
		addB.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(addB);
		
		JButton chargeB = new JButton("\u5145\u503C\u50A8\u503C\u5361");
		chargeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fcard(2);
				j.dispose();
			}
		});
		chargeB.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(chargeB);
		
		JButton inqB = new JButton("\u67E5\u8BE2\u4FE1\u606F");
		inqB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fcard(3);
				j.dispose();
			}
		});
		inqB.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(inqB);
		
		JButton removeB = new JButton("\u6CE8\u9500\u7528\u6237");
		removeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fcard(4);
				j.dispose();
			}
		});
		removeB.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(removeB);
		
		JLabel label_1 = new JLabel("\u5FEB\u901F\u8D2D\u7968\u6C38\u4E45\u516B\u6298\uFF0C\u4E58\u5750\u5730\u94C1\u65E0\u9700\u7B49\u5F85");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("华文楷体", Font.PLAIN, 35));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(19, 287, 956, 82);
		contentPane.add(label_1);
		setVisible(true);
	}

}
