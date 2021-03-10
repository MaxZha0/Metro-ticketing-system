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
	List<Integer> NO_list = new ArrayList<Integer>(); // <E>���Ͷ������Ϊ�գ����ǻ�������int����Ϊ�գ���װ��Integer
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
				BufferedReader br = new BufferedReader(isr); // ���л�����ַ��������Է���Ķ�ȡһ������

				String str = br.readLine();
				String[] num = str.split("\\s+");
				user_sum = Integer.parseInt(num[0]);
				MAX = Integer.parseInt(num[1]);
				String line;
				while ((line = br.readLine()) != null) { // ��ȡһ������

					String[] sp = line.split("\\s+");
					NO_list.add((Integer) Integer.parseInt(sp[0])); // ǿ��ת����Integer
					name_list.add(sp[1]);
					balance_list.add(Float.parseFloat(sp[2]));

				}
				br.close();
				isr.close();
				fis.close();

				System.out.println("�û���Ϣ���سɹ���");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.err.println("�ļ������ڣ�����ʧ�ܣ�");
	}

	public void printUser() {
		if (file.exists()) {

			try {
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw); // ���л�����ַ��������Է���Ķ�ȡһ������

				bw.write(user_sum + " " + MAX + "\r\n");
				for (int i = 0; i < user_sum; i++) {
					bw.write(NO_list.get(i) + " ");
					bw.write(name_list.get(i) + " ");
					bw.write(balance_list.get(i) + "\r\n");
				}

				bw.flush(); // Ϊ�˷�ֹ���ݶ�ʧ��ǿ��ȫ�����.
				bw.close();
				osw.close();
				fos.close();

				System.out.println("�û�������سɹ���");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.err.println("�ļ������ڣ�����ʧ�ܣ�");
	}

	public void showUser() {
		int i;
		System.out.println("�ܹ���" + user_sum + "�ˡ�");
		for (i = 0; i < user_sum; i++) {
			System.out.println("���:" + NO_list.get(i) + " ����:" + name_list.get(i) + " ��ǰ���:" + balance_list.get(i));
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

	public void removeUser(Integer NO) { // ͨ�����ɾ���û�
		if (NO_list.contains(NO)) {
			name_list.remove(NO_list.indexOf(NO));
			balance_list.remove(NO_list.indexOf(NO));
			NO_list.remove(NO);
			user_sum--;
			System.out.println("�û�ע���ɹ���");
		} else
			System.err.println("���û���Ϣ�����ڣ�");

	}

	public void removeUser(String name) { // ͨ������ɾ���û�
		if (name_list.contains(name)) {
			NO_list.remove(name_list.indexOf(name));
			balance_list.remove(name_list.indexOf(name));
			name_list.remove(name);
			user_sum--;
			System.out.println("�û�ע���ɹ���");
		} else
			System.err.println("���û���Ϣ�����ڣ�");

	}

	public void inqBalance(String name) { // ͨ��������ѯ���
		if (name_list.contains(name)) {
			System.out.println("��ѯ���:\n" + "���:" + NO_list.get(name_list.indexOf(name)) + " ����:" + name + " ��ǰ���:"
					+ balance_list.get(name_list.indexOf(name)));
		} else
			System.err.println("���û������ڣ�");

	}

	public StringBuffer inqBalance(Integer NO) { // ͨ����Ų�ѯ���

		StringBuffer sb = new StringBuffer();
		sb.append("��ѯ���:\n");
		sb.append("���:" + NO);
		sb.append("\n����:" + name_list.get(NO_list.indexOf(NO)));
		sb.append("\n��ǰ���:" + balance_list.get(NO_list.indexOf(NO)));
		System.out.println("��ѯ���:\n" + "���:" + NO + " ����:" + name_list.get(NO_list.indexOf(NO)) + " ��ǰ���:"
				+ balance_list.get(NO_list.indexOf(NO)));
		this.tempbalance = balance_list.get(NO_list.indexOf(NO));
		return sb;

	}

	public void rechargeBalance(String name, float newmoney) { // ͨ��������ֵ
		if (newmoney >= 0) {
			float newbalance = balance_list.get(name_list.indexOf(name)) + newmoney;
			balance_list.set(name_list.indexOf(name), newbalance);
			System.out.println("�û���ֵ�ɹ���\n" + "���:" + NO_list.get(name_list.indexOf(name)) + " ����:" + name + " ��ǰ���:"
					+ balance_list.get(name_list.indexOf(name)));
		} else
			System.err.println("��������ȷ����ֵ��");

	}

	public StringBuffer rechargeBalance(Integer NO, float newmoney) { // ͨ����ų�ֵ
		
			float newbalance = balance_list.get(NO_list.indexOf(NO)) + newmoney;
			balance_list.set(NO_list.indexOf(NO), newbalance);
			StringBuffer sb = new StringBuffer();
			sb.append("�û���ֵ�ɹ���\n" + "���:" + NO + "\n����:" + name_list.get(NO_list.indexOf(NO)) + "\n��ǰ���:"
					+ balance_list.get(NO_list.indexOf(NO)));
			System.out.println("�û���ֵ�ɹ���\n" + "���:" + NO + " ����:" + name_list.get(NO_list.indexOf(NO)) + " ��ǰ���:"
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
