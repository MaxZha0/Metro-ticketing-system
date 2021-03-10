package CODE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LineInfo {
	File file1 = new File("res/1.txt");
	File file2 = new File("res/2.txt");
	File file3 = new File("res/3.txt");
	File file5 = new File("res/5.txt");
	File file6 = new File("res/6.txt");
	File file9 = new File("res/9.txt");
	List<String> line1 = new ArrayList<String>();
	List<String> line2 = new ArrayList<String>();
	List<String> line3 = new ArrayList<String>();
	List<String> line5 = new ArrayList<String>();
	List<String> line6 = new ArrayList<String>();
	List<String> line9 = new ArrayList<String>();

	public LineInfo() {
		this.initLine(file1, line1);
		this.initLine(file2, line2);
		this.initLine(file3, line3);
		this.initLine(file5, line5);
		this.initLine(file6, line6);
		this.initLine(file9, line9);
	}

	public void initLine(File file,List<String> line) {

		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr); // 带有缓冲的字符流，可以方便的读取一行数据

			String str = br.readLine();
			line.add(str);
			String l;
			while ((l = br.readLine()) != null) { // 读取一行数据
				line.add(l); 
			}
			br.close();
			isr.close();
			fis.close();

			System.out.println("站点信息加载成功！");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void showLines() {
		showLine(1);
		showLine(2);
		showLine(3);
		showLine(5);
		showLine(6);
		showLine(9);
	}
	
	public void showLine(int n) {
		List<String> line = null;
		int sum = 0;
		
		switch(n) {
		case 1:
			line=line1;               
			break;
		case 2:
			line=line2;
			break;
		case 3:
			line=line3;
			break;
		case 5:
			line=line5;
			break;
		case 6:
			line=line6;
			break;
		case 9:
			line=line9;
			break;
		default:
			//********************************************待判定
			break;
		}
		sum=Integer.parseInt(line.get(0));
		System.out.println("地铁第"+n+"号线,共"+sum+"站，线路信息如下:");
		System.out.print("始发站: ");
		for(int i=1;i<sum;i++) {
			System.out.print(line.get(i)+"==>");
		}
		System.out.println("终点站:"+line.get(sum)+"\n");
	}

}
