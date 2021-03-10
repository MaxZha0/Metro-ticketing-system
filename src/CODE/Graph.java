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



public class Graph {
	File file1 = new File("res/stations.txt");
	File file2 = new File("res/graph.txt");
	List<String> line = new ArrayList<String>();
	int vexnum;
	int edgenum=150;
	int max=200;

	public class VexNode{
			int adjvex;
			int data;
	}
	
	VexNode[] vexNodes;
	int[] thevexs; //顶点集合
	int[][] edges = new int[max][max]; //边集合


	public Graph(){
		this.initStations();
		this.initEdges();
	}
	
	public void initEdges() {
		
		for(int i = 1;i<=edgenum;i++) {    //边矩阵初始化
			for(int j = 0;j<=edgenum;j++) {
				if(i==j)
					edges[i][j]=0;
				else 
					edges[i][j]=Integer.MAX_VALUE;
				
			}
		}
		
		try {
			FileInputStream fis = new FileInputStream(file2);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr); // 带有缓冲的字符流，可以方便的读取一行数据

			String l;
			while ((l = br.readLine()) != null) { // 读取一行数据
				String []str = l.split("\\s+");          //得到两个站点，分别找出位置
				int isigh = this.getPosition(str[0]);
				int jsigh = this.getPosition(str[1]);     //  响应的边矩阵中记录下来可以互通
				this.edges[isigh][jsigh]=1;
				this.edges[jsigh][isigh]=1;
			}
			br.close();
			isr.close();
			fis.close();

			System.out.println("所有站点信息录入成功！");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initStations() {
		try {
			FileInputStream fis = new FileInputStream(file1);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr); // 带有缓冲的字符流，可以方便的读取一行数据

			String str = br.readLine();
			line.add(str);
			this.vexnum = Integer.parseInt(str);
			String l;
			while ((l = br.readLine()) != null) { // 读取一行数据
				line.add(l); 
			}
			br.close();
			isr.close();
			fis.close();

			System.out.println("所有站点信息录入成功！");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getPosition(String station) {
		if(line.contains(station)) {
			return line.indexOf(station);
		}
		else 
			return -1;                           //返回-1表示没有找到该站
	}

}
