package Frame;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fwelcome extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Fwelcome j;

	public Fwelcome() {
		this.j=this;
		setTitle("\u5929\u6D25\u5730\u94C1\u81EA\u52A8\u8D2D\u7968\u7CFB\u7EDF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbtitle = new JLabel("\u5929\u6D25\u5730\u94C1\u81EA\u52A8\u8D2D\u7968\u7CFB\u7EDF");
		lbtitle.setBounds(19, 165, 956, 82);
		lbtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbtitle.setFont(new Font("华文楷体", Font.BOLD, 80));
		lbtitle.setBackground(Color.WHITE);
		JLabel lblNewLabel = new JLabel("");		
		ImageIcon logo=new ImageIcon("res/logo.png");
		lblNewLabel.setIcon(logo);
		lblNewLabel.setBounds(85, 81, 510, 71);
		contentPane.add(lblNewLabel);
		
		
		
		contentPane.setLayout(null);
		contentPane.add(lbtitle);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("华文楷体", Font.PLAIN, 75));
		label.setBackground(Color.WHITE);
		label.setBounds(19, 270, 956, 82);
		contentPane.add(label);
		
		JButton buyButton = new JButton("\u8D2D\u7968\u670D\u52A1");
		buyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new  Fmap();		
				j.dispose();
			}
		});
		buyButton.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		buyButton.setFont(new Font("华文琥珀", Font.PLAIN, 30));
		buyButton.setBounds(229, 493, 193, 55);
		contentPane.add(buyButton);
		
		JButton cardButton = new JButton("VIP\u670D\u52A1");
		cardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new  Fvip();		
				j.dispose();
			}
		});
		buyButton.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		cardButton.setFont(new Font("华文琥珀", Font.PLAIN, 30));
		cardButton.setBounds(601, 493, 193, 55);
		contentPane.add(cardButton);
		setVisible(true);
	}
}
