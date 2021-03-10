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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import CODE.UserInfo;

import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;

public class Fcard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Fcard j;
	private JTextField t_NO;
	private JTextField t_name;
	private JTextField t_charge;
	public static UserInfo user = new UserInfo();
	public String NO,name,balance;
	private JTextArea txt;
	StringBuffer tempsb;
	
	
	public Fcard(int n) {
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
				new Fvip();
				j.dispose();
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.focus"));
		btnNewButton.setIcon(new ImageIcon(Fmap.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnNewButton.setBounds(14, 13, 35, 36);
		contentPane.add(btnNewButton);
	
		
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(60, 61, 448, 338);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16    \u53F7:");
		lblNewLabel_1.setBounds(7, 5, 203, 49);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lblNewLabel_1);
		
		t_NO = new JTextField();
		t_NO.setFont(new Font("宋体", Font.PLAIN, 25));
		t_NO.setBounds(224, 5, 203, 49);
		panel.add(t_NO);
		t_NO.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u59D3    \u540D:");
		lblNewLabel_5.setBounds(1, 90, 203, 49);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lblNewLabel_5);
		
		t_name = new JTextField();
		t_name.setFont(new Font("宋体", Font.PLAIN, 25));
		t_name.setBounds(224, 90, 203, 49);
		panel.add(t_name);
		t_name.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u4F59\u989D(\u5143):");
		lblNewLabel_4.setBounds(1, 179, 203, 49);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lblNewLabel_4);
		
		JLabel t_balance = new JLabel("");
		t_balance.setBounds(224, 179, 203, 49);
		t_balance.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		t_balance.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(t_balance);
		
		JLabel lblNewLabel_6 = new JLabel("\u5145\u503C\u91D1\u989D(\u5143):");
		lblNewLabel_6.setBounds(1, 268, 203, 49);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lblNewLabel_6);
		
		t_charge = new JTextField();
		t_charge.setToolTipText("\u6700\u5927\u5145\u503C1000\u5143");
		t_charge.setFont(new Font("宋体", Font.PLAIN, 25));
		t_charge.setBounds(224, 268, 203, 49);
		panel.add(t_charge);
		t_charge.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fwelcome();
				j.dispose();
			}
		});
		
		txt = new JTextArea();
		txt.setFont(new Font("宋体", Font.PLAIN, 25));
		txt.setEditable(false);
		txt.setBounds(522, 61, 430, 338);
		contentPane.add(txt);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 40));
		btnNewButton_1.setBounds(434, 520, 171, 64);
		contentPane.add(btnNewButton_1);
		
		JButton bt_yes = new JButton("\u786E\u8BA4");
		bt_yes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(n==1) {
					if(Integer.parseInt(t_charge.getText())>0&&Integer.parseInt(t_charge.getText())<=1000) {
						int NO = user.addUser(name, Float.parseFloat(t_charge.getText()));
						bt_yes.setEnabled(false);
						
						txt.setText("注册成功！\n"
								+ "欢迎您，新VIP用户，您的信息如下:\n"
								+ "编号:"+NO
								+ "\n姓名:"+name
								+ "\n余额:"+ Float.parseFloat(t_charge.getText()));
					}
					else{
						txt.setText("充值金额错误，请重新输入");
					}
				}
				else if(n==2) {
					if(Integer.parseInt(t_charge.getText())>0&&Integer.parseInt(t_charge.getText())<=1000) {
						bt_yes.setEnabled(false);
						j.tempsb = user.rechargeBalance((Integer)user.inq(t_NO.getText(), t_name.getText()), Float.parseFloat(t_charge.getText()));
						
						
						txt.setText(j.tempsb.toString());
					}
					else{
						txt.setText("充值金额错误，请重新输入");
					}
				}
				else if(n==3) {
				
				}
				else if(n==4) {
					bt_yes.setEnabled(false);
					user.removeUser( user.inq(t_NO.getText(), t_name.getText()));
					txt.setText("用户已注销，谢谢您的使用。\n"
							+ "如有宝贵的意见与建议请致电：\n"
							+ "宋沂昭 13032992248");
				}
				
				user.printUser();
			}
		});
		bt_yes.setFont(new Font("宋体", Font.PLAIN, 30));
		bt_yes.setBounds(291, 412, 128, 36);
		contentPane.add(bt_yes);
		
		JButton bt_inq = new JButton("\u67E5\u8BE2");
		bt_inq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(n==1) {
					name = t_name.getText();
					if(user.inqName(name)) {
						txt.setText("该用户已经注册！\n请重新输入");
					}
					else {
						t_name.setEditable(false);
						t_charge.setEditable(true);
						bt_yes.setEnabled(true);
						txt.setText("用户名检测通过，请充值金额。");
						
					}
				}
				else if(n==2) {
					//name = t_name.getText();
					//NO=t_NO.getText();
					int flag = user.inq(t_NO.getText(), t_name.getText());
					if(flag==0) {
						txt.setText("请重新输入。");
					}
					else {
						
						j.tempsb=user.inqBalance(flag);
						txt.setText(j.tempsb.toString());
						t_balance.setText(user.tempbalance+"");
						t_charge.setEditable(true);
						t_NO.setEditable(false);
						t_name.setEditable(false);
						bt_inq.setEnabled(false);
						bt_yes.setEnabled(true);
					}
				}
				else if(n==3) {
					int flag = user.inq(t_NO.getText(), t_name.getText());
					if(flag==0) {
						txt.setText("请重新输入。");
					}
					else {
						StringBuffer sb=new StringBuffer();
						sb=user.inqBalance(flag);
						txt.setText(sb.toString());
						t_NO.setEditable(false);
						t_name.setEditable(false);
						t_balance.setText(user.tempbalance+"");
					}
				}
				else if(n==4) {
					int flag = user.inq(t_NO.getText(), t_name.getText());
					if(flag==0) {
						txt.setText("请重新输入。");
					}
					else {
						StringBuffer sb=new StringBuffer();
						sb=user.inqBalance(flag);
						txt.setText(sb.toString());
						t_balance.setText(user.tempbalance+"");
						bt_yes.setEnabled(true);
						t_NO.setEditable(false);
						t_name.setEditable(false);
					}
				}
			}
		});
		bt_inq.setFont(new Font("宋体", Font.PLAIN, 30));
		bt_inq.setBounds(126, 412, 128, 36);
		contentPane.add(bt_inq);
		
		
		
		if(n==1) {
			t_NO.setEditable(false);
			bt_yes.setEnabled(false);
			t_charge.setEditable(false);
			txt.setText("欢迎使用新VIP注册服务！");
		}
		else if(n==2) {
			bt_yes.setEnabled(false);
			t_charge.setEditable(false);
			txt.setText("欢迎使用VIP充值服务！\n"
					+ "请输入要查询的编号或者姓名");
		}
		else if(n==3) {
			t_charge.setEditable(false);
			bt_yes.setEnabled(false);
			txt.setText("欢迎使用VIP查询服务！");
		}
		else if(n==4) {
			t_charge.setEditable(false);
			bt_yes.setEnabled(false);
			txt.setText("欢迎使用VIP注销服务！");
		}
		
		
		setVisible(true);
	}
}
