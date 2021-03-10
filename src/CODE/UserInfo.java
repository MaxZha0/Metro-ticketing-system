package CODE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class UserInfo {
	File file = new File("res/userlist.txt");
	File file2 = new File("res/test.txt");
	List<String> name_list = new ArrayList<String>();
	List<Integer> NO_list = new ArrayList<Integer>(); // <E>泛型对象可以为空，但是基本类型int不能为空，封装成Integer
	List<Float> balance_list = new ArrayList<Float>();
	int user_sum;
	int MAX;
	public float tempbalance;

	public UserInfo() {
		this.initUser();
	}

	public boolean inqName(String name) {
		if (name_list.contains(name))
			return true;
		else
			return false;
	}

	public int NametoNO(String name) {
		if (name_list.contains(name))
			return NO_list.get(name_list.indexOf(name));
		else
			return -1;
	}

	public boolean inqNO(int NO) {
		if (NO_list.contains(NO))
			return true;
		else
			return false;
	}

	public int inq(String NO, String name) {

		if (NO.length() < 1 && name.length() < 1) {
			return 0;
		} else if (NO.length() < 1 && inqName(name)) {
			return NametoNO(name);
		} else if (name.length() < 1 && inqNO(Integer.parseInt(NO))) {

			return Integer.parseInt(NO);
			}
		else if(NO.length() < 1&&!inqName(name)) {
			return 0;
		}
		 else if (NametoNO(name) != Integer.parseInt(NO)) {
			return 0;
		} else if (NametoNO(name) == Integer.parseInt(NO))
			return Integer.parseInt(NO);
		else
			return 0;
	}

	public void initUser() {
		if (file.exists()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr); // 带有缓冲的字符流，可以方便的读取一行数据

				String str = br.readLine();
				String[] num = str.split("\\s+");
				user_sum = Integer.parseInt(num[0]);
				MAX = Integer.parseInt(num[1]);
				String line;
				while ((line = br.readLine()) != null) { // 读取一行数据

					String[] sp = line.split("\\s+");
					NO_list.add((Integer) Integer.parseInt(sp[0])); // 强制转换成Integer
					name_list.add(sp[1]);
					balance_list.add(Float.parseFloat(sp[2]));

				}
				br.close();
				isr.close();
				fis.close();

				System.out.println("用户信息加载成功！");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.err.println("文件不存在，加载失败！");
	}

	public void printUser() {
		if (file.exists()) {

			try {
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw); // 带有缓冲的字符流，可以方便的读取一行数据

				bw.write(user_sum + " " + MAX + "\r\n");
				for (int i = 0; i < user_sum; i++) {
					bw.write(NO_list.get(i) + " ");
					bw.write(name_list.get(i) + " ");
					bw.write(balance_list.get(i) + "\r\n");
				}

				bw.flush(); // 为了防止数据丢失，强制全部输出.
				bw.close();
				osw.close();
				fos.close();

				System.out.println("用户保存加载成功！");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.err.println("文件不存在，加载失败！");
	}

	public void showUser() {
		int i;
		System.out.println("总共有" + user_sum + "人。");
		for (i = 0; i < user_sum; i++) {
			System.out.println("序号:" + NO_list.get(i) + " 姓名:" + name_list.get(i) + " 当前余额:" + balance_list.get(i));
		}
	}

	public int addUser(String name, float balance) {

		name_list.add(name);
		NO_list.add(1000 + MAX);
		balance_list.add(balance);
		MAX++;
		user_sum++;
		return NO_list.get(name_list.indexOf(name));
	}

	public void removeUser(Integer NO) { // 通过序号删除用户
		if (NO_list.contains(NO)) {
			name_list.remove(NO_list.indexOf(NO));
			balance_list.remove(NO_list.indexOf(NO));
			NO_list.remove(NO);
			user_sum--;
			System.out.println("用户注销成功！");
		} else
			System.err.println("该用户信息不存在！");

	}

	public void removeUser(String name) { // 通过姓名删除用户
		if (name_list.contains(name)) {
			NO_list.remove(name_list.indexOf(name));
			balance_list.remove(name_list.indexOf(name));
			name_list.remove(name);
			user_sum--;
			System.out.println("用户注销成功！");
		} else
			System.err.println("该用户信息不存在！");

	}

	public void inqBalance(String name) { // 通过姓名查询余额
		if (name_list.contains(name)) {
			System.out.println("查询结果:\n" + "序号:" + NO_list.get(name_list.indexOf(name)) + " 姓名:" + name + " 当前余额:"
					+ balance_list.get(name_list.indexOf(name)));
		} else
			System.err.println("该用户不存在！");

	}

	public StringBuffer inqBalance(Integer NO) { // 通过序号查询余额

		StringBuffer sb = new StringBuffer();
		sb.append("查询结果:\n");
		sb.append("序号:" + NO);
		sb.append("\n姓名:" + name_list.get(NO_list.indexOf(NO)));
		sb.append("\n当前余额:" + balance_list.get(NO_list.indexOf(NO)));
		System.out.println("查询结果:\n" + "序号:" + NO + " 姓名:" + name_list.get(NO_list.indexOf(NO)) + " 当前余额:"
				+ balance_list.get(NO_list.indexOf(NO)));
		this.tempbalance = balance_list.get(NO_list.indexOf(NO));
		return sb;

	}

	public void rechargeBalance(String name, float newmoney) { // 通过姓名充值
		if (newmoney >= 0) {
			float newbalance = balance_list.get(name_list.indexOf(name)) + newmoney;
			balance_list.set(name_list.indexOf(name), newbalance);
			System.out.println("用户充值成功！\n" + "序号:" + NO_list.get(name_list.indexOf(name)) + " 姓名:" + name + " 当前余额:"
					+ balance_list.get(name_list.indexOf(name)));
		} else
			System.err.println("请输入正确的数值！");

	}

	public StringBuffer rechargeBalance(Integer NO, float newmoney) { // 通过序号充值
		
			float newbalance = balance_list.get(NO_list.indexOf(NO)) + newmoney;
			balance_list.set(NO_list.indexOf(NO), newbalance);
			StringBuffer sb = new StringBuffer();
			sb.append("用户充值成功！\n" + "序号:" + NO + "\n姓名:" + name_list.get(NO_list.indexOf(NO)) + "\n当前余额:"
					+ balance_list.get(NO_list.indexOf(NO)));
			System.out.println("用户充值成功！\n" + "序号:" + NO + " 姓名:" + name_list.get(NO_list.indexOf(NO)) + " 当前余额:"
					+ balance_list.get(NO_list.indexOf(NO)));
			return sb;

	}

	public int getUser_sum() {
		if (NO_list.size() == user_sum)
			return NO_list.size();
		else
			return -1;
	}

}
