package Frame;


import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fpay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Fpay j;
	int n;
	

	public Fpay(String end,String start,int n) {
		this.j=this;
		this.n=n;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u5929\u6D25\u5730\u94C1\u81EA\u52A8\u8D2D\u7968\u7CFB\u7EDF");
		setResizable(false);
		setBounds(200, 100, 1000, 700);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(56, 54, 577, 370);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\u51FA\u53D1\u7AD9:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lblNewLabel_3);
		
		JLabel lb_start = new JLabel("");
		lb_start.setText(start);
		lb_start.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lb_start);
		
		JLabel lblNewLabel_5 = new JLabel("\u76EE\u7684\u7AD9:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lblNewLabel_5);
		
		JLabel lb_end = new JLabel("");
		lb_end.setText(end);
		lb_end.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lb_end);
		
		JLabel label_1 = new JLabel("\u7AD9\u6570:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(label_1);
		
		JLabel lb_stationnum = new JLabel("");
		if(n>0) 
			lb_stationnum.setText(n+"");
		else {
			lb_stationnum.setText("无");
			if(n==-1) 
				this.n=1;
			else if(n==-2) 
				this.n=6;
			else if(n==-3)
				this.n=11;
			else if(n==-4)
				this.n=16;
		}
		lb_stationnum.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lb_stationnum);
		
		JLabel lblNewLabel_7 = new JLabel("\u7968\u6570:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lblNewLabel_7);
		
		JLabel lb_num = new JLabel("\u672A\u9009\u62E9");
		lb_num.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lb_num);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fmap();
				j.dispose();
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.focus"));
		btnNewButton.setIcon(new ImageIcon(Fmap.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnNewButton.setBounds(14, 13, 35, 36);
		contentPane.add(btnNewButton);
		
		JLabel lb_pay = new JLabel("");
		lb_pay.setText("未选择数量");
		lb_pay.setFont(new Font("宋体", Font.PLAIN, 40));
		lb_pay.setBounds(287, 467, 311, 59);
		contentPane.add(lb_pay);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(736, 54, 224, 245);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 1, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u9009\u62E9\u8D2D\u4E70\u7684\u7968\u6570:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("1\u5F20");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lb_num.setText("1");
				lb_pay.setText((j.n/5+1)*2*1+"");
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("2\u5F20");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lb_num.setText("2");
				lb_pay.setText((j.n/5+1)*2*2+"");
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("3\u5F20");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lb_num.setText("3");
				lb_pay.setText((j.n/5+1)*2*3+"");
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("4\u5F20");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lb_num.setText("4");
				lb_pay.setText((j.n/5+1)*2*4+"");
			}
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("5\u5F20");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lb_num.setText("5");
				lb_pay.setText((j.n/5+1)*2*5+"");
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("\u5F85\u652F\u4ED8\uFF1A");
		lblNewLabel.setFont(new Font("幼圆", Font.ITALIC, 40));
		lblNewLabel.setBounds(114, 467, 183, 47);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblMa = new JLabel("二维码购票");
		lblMa.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMa.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon myali=new ImageIcon("res/myali.jpg");
		ImageIcon myvx=new ImageIcon("res/myvx.png");
		
		lblMa.setBounds(730, 402, 250, 250);
		contentPane.add(lblMa);
		
		JButton aliB = new JButton("");
		aliB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMa.setIcon(myali);
			}
		});
		ImageIcon ali=new ImageIcon("res/ali.jpg");
		aliB.setIcon(ali);
		aliB.setBounds(816, 312, 75, 75);
		contentPane.add(aliB);
		
		JButton vxB = new JButton("");
		vxB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMa.setIcon(myvx);
			}
		});
		ImageIcon vx=new ImageIcon("res/wechat.jpg");
		vxB.setIcon(vx);
		vxB.setBounds(905, 312, 75, 75);
	
		contentPane.add(vxB);
		
		JLabel label = new JLabel("\u626B\u7801\u652F\u4ED8\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(707, 326, 110, 47);
		contentPane.add(label);
		
		JButton button = new JButton("\u786E\u8BA4\u652F\u4ED8");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lb_pay.getText().equals("未选择数量")) {
					new Fpayend();
					j.dispose();
				}
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 22));
		button.setBounds(269, 572, 138, 36);
		contentPane.add(button);
		
		
		
		setVisible(true);
	}
}
