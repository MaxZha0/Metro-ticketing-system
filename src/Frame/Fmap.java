package Frame;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import CODE.Dijkstra;
import CODE.Graph;
import CODE.LineInfo;


import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;


public class Fmap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Fmap j;
	  
	  public static LineInfo line = new LineInfo();
	  public static Graph graph = new Graph();
	  public static Dijkstra dijk=new Dijkstra();
	  String start="鞍山道",end="鞍山道",ans;
	  int distance;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Fmap() {
		this.j=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u5929\u6D25\u5730\u94C1\u81EA\u52A8\u8D2D\u7968\u7CFB\u7EDF");
		setResizable(false);
		setBounds(200, 100, 1000, 700);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblNewLabel.setBounds(57, 13, 586, 639);
		ImageIcon logo=new ImageIcon("res/map.jpg");
		lblNewLabel.setIcon(logo);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5F53\u524D\u7AD9:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label.setBounds(657, 31, 148, 36);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u76EE\u7684\u7AD9:");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label_1.setBounds(657, 105, 96, 36);
		contentPane.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(657, 155, 323, 201);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setAutoscrolls(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setText("线路信息");
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				start=comboBox.getSelectedItem().toString();
				if (end.equals(start)) {
					textArea.setText("请选择正确站点");
				} else {
					ans = dijk.getShortWay(graph,start, end).toString();
					distance = dijk.distance;
					textArea.setText(ans);
				}
			}
		});
		comboBox.setFont(new Font("宋体", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u978D\u5C71\u9053", "\u978D\u5C71\u897F\u9053", "\u5317\u8FB0\u9053", "\u5317\u8FB0\u79D1\u6280\u56ED\u5317", "\u5317\u5B81\u516C\u56ED", "\u5317\u7AD9", "\u5317\u7AF9\u6797", "\u672C\u6EAA\u8DEF", "\u535E\u5174", "\u6EE8\u6D77\u56FD\u9645\u673A\u573A", "\u8D22\u7ECF\u5927\u5B66", "\u66F9\u5E84", "\u660C\u51CC\u8DEF", "\u9648\u5858\u5E84", "\u6210\u6797\u9053", "\u7FE0\u961C\u65B0\u6751", "\u5927\u6BD5\u5E84", "\u5927\u738B\u5E84", "\u5927\u5B66\u57CE", "\u4E39\u6CB3\u5317\u9053", "\u767B\u5DDE\u8DEF", "\u4E1C\u6D77\u8DEF", "\u4E1C\u4E3D\u5F00\u53D1\u533A", "\u4E1C\u5357\u89D2", "\u4E1C\u5174\u8DEF", "\u6D1E\u5EAD\u8DEF", "\u4E8C\u53F7\u6865", "\u4E8C\u7EAC\u8DEF", "\u4E30\u4EA7\u6CB3", "\u590D\u5174\u8DEF", "\u590D\u5174\u95E8", "\u94A2\u7BA1\u516C\u53F8", "\u9AD8\u65B0\u533A", "\u9F13\u697C", "\u5E7F\u5F00\u56DB\u9A6C\u8DEF", "\u56FD\u5C71\u8DEF", "\u6D77\u5149\u5BFA", "\u548C\u5E73\u8DEF", "\u9ED1\u725B\u57CE\u9053", "\u7EA2\u65D7\u5357\u8DEF", "\u6D2A\u6E56\u91CC", "\u80E1\u5BB6\u56ED", "\u534E\u5317\u96C6\u56E2", "\u534E\u5C71\u91CC", "\u534E\u82D1", "\u6DEE\u6CB3\u9053", "\u4F1A\u5C55\u4E2D\u5FC3", "\u4F73\u56ED\u91CC", "\u5C16\u5C71\u8DEF", "\u5EFA\u660C\u9053", "\u5EFA\u56FD\u9053", "\u89E3\u653E\u5357\u8DEF", "\u82A5\u56ED\u897F\u9053", "\u91D1\u72EE\u6865", "\u91D1\u949F\u6CB3\u5927\u8857", "\u91D1\u949F\u8857", "\u6D25\u6E2F\u5E7F\u573A", "\u6D25\u5858\u8DEF", "\u9756\u6C5F\u8DEF", "\u519B\u7CAE\u57CE", "\u7A7A\u6E2F\u7ECF\u6D4E\u533A", "\u4E50\u56ED\u9053", "\u674E\u697C", "\u8FBD\u6CB3\u5317\u9053", "\u51CC\u5BBE\u8DEF", "\u5218\u56ED", "\u6885\u6C5F\u9053", "\u6885\u6C5F\u516C\u56ED", "\u6885\u6C5F\u4F1A\u5C55\u4E2D\u5FC3", "\u6885\u6797\u8DEF", "\u6C11\u6743\u95E8", "\u5357\u7FE0\u5C4F", "\u5357\u6CB3\u5E84", "\u5357\u697C", "\u5357\u5B59\u5E84", "\u5357\u7AD9", "\u52E4\u4FED\u9053", "\u4EBA\u6C11\u533B\u9662", "\u745E\u666F\u65B0\u82D1", "\u5341\u4E00\u7ECF\u8DEF", "\u5E02\u6C11\u5E7F\u573A", "\u53CC\u6797", "\u6C34\u4E0A\u516C\u56ED\u4E1C\u8DEF", "\u987A\u9A70\u6865", "\u601D\u6E90\u8DEF", "\u592A\u6E56\u8DEF", "\u6CF0\u8FBE", "\u5858\u6CBD", "\u4F53\u80B2\u4E2D\u5FC3", "\u5929\u6D25\u5BBE\u9986", "\u5929\u6D25\u7AD9", "\u5929\u79E6\u8DEF", "\u5929\u58EB\u529B", "\u5929\u5854", "\u5929\u62D6", "\u94C1\u4E1C\u8DEF", "\u571F\u57CE", "\u5916\u9662\u9644\u4E2D", "\u738B\u9876\u5824", "\u6587\u5316\u4E2D\u5FC3", "\u5434\u5BB6\u7A91", "\u897F\u5317\u89D2", "\u897F\u5EB7\u8DEF", "\u897F\u5357\u89D2", "\u897F\u5357\u697C", "\u897F\u7AD9", "\u4E0B\u74E6\u623F", "\u54B8\u9633\u8DEF", "\u5C0F\u767D\u697C", "\u5C0F\u6DC0", "\u5C0F\u4E1C\u5E84", "\u65B0\u5F00\u6CB3", "\u65B0\u7ACB", "\u5E78\u798F\u516C\u56ED", "\u5F90\u5E84\u5B50", "\u5BA3\u5174\u57E0", "\u5BA3\u5174\u57E0\u5317", "\u5B66\u5E9C\u5DE5\u4E1A\u56ED", "\u6768\u4F0D\u5E84", "\u4E00\u53F7\u6865", "\u4E00\u4E2D\u5FC3\u533B\u9662", "\u5B9C\u5BBE\u9053", "\u8FCE\u98CE\u9053", "\u8425\u53E3\u9053", "\u5C7F\u4E1C\u57CE", "\u8FDC\u6D0B\u56FD\u9645\u4E2D\u5FC3", "\u6708\u7259\u6CB3", "\u5F20\u8D35\u5E84", "\u5F20\u5174\u5E84", "\u957F\u8679\u516C\u56ED", "\u76F4\u6CBD", "\u804C\u4E1A\u5927\u5B66", "\u5FD7\u6210\u8DEF", "\u4E2D\u5C71\u8DEF", "\u4E2D\u5C71\u95E8", "\u4E2D\u533B\u4E00\u9644\u9662", "\u80BF\u7624\u533B\u9662", "\u5468\u9093\u7EAA\u5FF5\u9986", "\u5DE6\u6C5F\u9053"}));
		comboBox.setBounds(743, 32, 237, 36);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				end=comboBox_1.getSelectedItem().toString();
				if(end.equals(start)) {
					textArea.setText("请选择正确站点");
				}
				else {
					ans = dijk.getShortWay(graph,start, end).toString();
					distance = dijk.distance;
					textArea.setText(ans);
				}
				
			}
		});
		
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 22));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u978D\u5C71\u9053", "\u978D\u5C71\u897F\u9053", "\u5317\u8FB0\u9053", "\u5317\u8FB0\u79D1\u6280\u56ED\u5317", "\u5317\u5B81\u516C\u56ED", "\u5317\u7AD9", "\u5317\u7AF9\u6797", "\u672C\u6EAA\u8DEF", "\u535E\u5174", "\u6EE8\u6D77\u56FD\u9645\u673A\u573A", "\u8D22\u7ECF\u5927\u5B66", "\u66F9\u5E84", "\u660C\u51CC\u8DEF", "\u9648\u5858\u5E84", "\u6210\u6797\u9053", "\u7FE0\u961C\u65B0\u6751", "\u5927\u6BD5\u5E84", "\u5927\u738B\u5E84", "\u5927\u5B66\u57CE", "\u4E39\u6CB3\u5317\u9053", "\u767B\u5DDE\u8DEF", "\u4E1C\u6D77\u8DEF", "\u4E1C\u4E3D\u5F00\u53D1\u533A", "\u4E1C\u5357\u89D2", "\u4E1C\u5174\u8DEF", "\u6D1E\u5EAD\u8DEF", "\u4E8C\u53F7\u6865", "\u4E8C\u7EAC\u8DEF", "\u4E30\u4EA7\u6CB3", "\u590D\u5174\u8DEF", "\u590D\u5174\u95E8", "\u94A2\u7BA1\u516C\u53F8", "\u9AD8\u65B0\u533A", "\u9F13\u697C", "\u5E7F\u5F00\u56DB\u9A6C\u8DEF", "\u56FD\u5C71\u8DEF", "\u6D77\u5149\u5BFA", "\u548C\u5E73\u8DEF", "\u9ED1\u725B\u57CE\u9053", "\u7EA2\u65D7\u5357\u8DEF", "\u6D2A\u6E56\u91CC", "\u80E1\u5BB6\u56ED", "\u534E\u5317\u96C6\u56E2", "\u534E\u5C71\u91CC", "\u534E\u82D1", "\u6DEE\u6CB3\u9053", "\u4F1A\u5C55\u4E2D\u5FC3", "\u4F73\u56ED\u91CC", "\u5C16\u5C71\u8DEF", "\u5EFA\u660C\u9053", "\u5EFA\u56FD\u9053", "\u89E3\u653E\u5357\u8DEF", "\u82A5\u56ED\u897F\u9053", "\u91D1\u72EE\u6865", "\u91D1\u949F\u6CB3\u5927\u8857", "\u91D1\u949F\u8857", "\u6D25\u6E2F\u5E7F\u573A", "\u6D25\u5858\u8DEF", "\u9756\u6C5F\u8DEF", "\u519B\u7CAE\u57CE", "\u7A7A\u6E2F\u7ECF\u6D4E\u533A", "\u4E50\u56ED\u9053", "\u674E\u697C", "\u8FBD\u6CB3\u5317\u9053", "\u51CC\u5BBE\u8DEF", "\u5218\u56ED", "\u6885\u6C5F\u9053", "\u6885\u6C5F\u516C\u56ED", "\u6885\u6C5F\u4F1A\u5C55\u4E2D\u5FC3", "\u6885\u6797\u8DEF", "\u6C11\u6743\u95E8", "\u5357\u7FE0\u5C4F", "\u5357\u6CB3\u5E84", "\u5357\u697C", "\u5357\u5B59\u5E84", "\u5357\u7AD9", "\u52E4\u4FED\u9053", "\u4EBA\u6C11\u533B\u9662", "\u745E\u666F\u65B0\u82D1", "\u5341\u4E00\u7ECF\u8DEF", "\u5E02\u6C11\u5E7F\u573A", "\u53CC\u6797", "\u6C34\u4E0A\u516C\u56ED\u4E1C\u8DEF", "\u987A\u9A70\u6865", "\u601D\u6E90\u8DEF", "\u592A\u6E56\u8DEF", "\u6CF0\u8FBE", "\u5858\u6CBD", "\u4F53\u80B2\u4E2D\u5FC3", "\u5929\u6D25\u5BBE\u9986", "\u5929\u6D25\u7AD9", "\u5929\u79E6\u8DEF", "\u5929\u58EB\u529B", "\u5929\u5854", "\u5929\u62D6", "\u94C1\u4E1C\u8DEF", "\u571F\u57CE", "\u5916\u9662\u9644\u4E2D", "\u738B\u9876\u5824", "\u6587\u5316\u4E2D\u5FC3", "\u5434\u5BB6\u7A91", "\u897F\u5317\u89D2", "\u897F\u5EB7\u8DEF", "\u897F\u5357\u89D2", "\u897F\u5357\u697C", "\u897F\u7AD9", "\u4E0B\u74E6\u623F", "\u54B8\u9633\u8DEF", "\u5C0F\u767D\u697C", "\u5C0F\u6DC0", "\u5C0F\u4E1C\u5E84", "\u65B0\u5F00\u6CB3", "\u65B0\u7ACB", "\u5E78\u798F\u516C\u56ED", "\u5F90\u5E84\u5B50", "\u5BA3\u5174\u57E0", "\u5BA3\u5174\u57E0\u5317", "\u5B66\u5E9C\u5DE5\u4E1A\u56ED", "\u6768\u4F0D\u5E84", "\u4E00\u53F7\u6865", "\u4E00\u4E2D\u5FC3\u533B\u9662", "\u5B9C\u5BBE\u9053", "\u8FCE\u98CE\u9053", "\u8425\u53E3\u9053", "\u5C7F\u4E1C\u57CE", "\u8FDC\u6D0B\u56FD\u9645\u4E2D\u5FC3", "\u6708\u7259\u6CB3", "\u5F20\u8D35\u5E84", "\u5F20\u5174\u5E84", "\u957F\u8679\u516C\u56ED", "\u76F4\u6CBD", "\u804C\u4E1A\u5927\u5B66", "\u5FD7\u6210\u8DEF", "\u4E2D\u5C71\u8DEF", "\u4E2D\u5C71\u95E8", "\u4E2D\u533B\u4E00\u9644\u9662", "\u80BF\u7624\u533B\u9662", "\u5468\u9093\u7EAA\u5FF5\u9986", "\u5DE6\u6C5F\u9053"}));
		comboBox_1.setBounds(743, 106, 237, 36);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u8D2D\u7968");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(end.equals(start))
					textArea.setText("请选择正确站点");
				else {
					new Fpay(end,start,distance);
					j.dispose();
				}
					
				
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton_1.setBounds(761, 369, 135, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel label_2 = new JLabel("\u5FEB\u901F\u8D2D\u7968\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(657, 409, 119, 36);
		contentPane.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("宋体", Font.PLAIN, 22));
		panel.setBounds(692, 458, 245, 178);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 2, 30, 30));
		
		JButton btnNewButton_2 = new JButton("2\u5143");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fpay("无","无",-1);
				j.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 22));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4\u5143");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fpay("无","无",-2);
				j.dispose();
			}
		});
		
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 22));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("6\u5143");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fpay("无","无",-3);
				j.dispose();
			}
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 22));
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("8\u5143");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Fpay("无","无",-4);
				j.dispose();
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 22));
		panel.add(btnNewButton_4);
		setVisible(true);
	}
}
