package CODE;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
	class Item {
		String endString;
		List<String> pathList = new ArrayList<String>();
		int distance;
	}
	
	public int distance;

	public StringBuffer getShortWay(Graph graph, String startpoint, String endpoint) {

		int startindex = graph.getPosition(startpoint);
		List<Item> slist = new ArrayList<Dijkstra.Item>();// S列表中存已知最短路径的对象，U列表中存未知最短路径的对象
		List<Item> ulist = new ArrayList<Dijkstra.Item>();// S列表中存已知最短路径的对象，U列表中存未知最短路径的对象
		// 初始化U列表
		for (int i = 1; i <= graph.vexnum; i++) {
			Item tItem = new Item();
			tItem.endString = graph.line.get(i);
			System.out.println(graph.line.get(i));
			tItem.pathList.add(graph.line.get(startindex));
			tItem.pathList.add(graph.line.get(i));
			tItem.distance = graph.edges[startindex][i];
			ulist.add(tItem);
		}
		while (!ulist.isEmpty()) {
			int t = 0;
			int tempdistance = ulist.get(0).distance;
			for (int i = 0; i < ulist.size(); i++) {
				if (tempdistance > ulist.get(i).distance) {
					t = i;
					tempdistance = ulist.get(i).distance;
				}
			}
			slist.add(ulist.remove(t));

			for (int i = 0; i < ulist.size(); i++) {
				int index1 = graph.line.indexOf(ulist.get(i).endString);
				for (int j = 0; j < slist.size(); j++) {
					int index2 = graph.line.indexOf(slist.get(j).pathList.get(slist.get(j).pathList.size() - 1));
					if (graph.edges[index1][index2] == Integer.MAX_VALUE)
						continue;
					else {
						int newdistance = slist.get(j).distance + graph.edges[index1][index2];
						if (newdistance < ulist.get(i).distance) {
							ulist.get(i).distance = newdistance;
							ulist.get(i).pathList = new ArrayList<String>(slist.get(j).pathList);
							ulist.get(i).pathList.add(graph.line.get(index1));
						}
					}
				}
			}

		}
		
		StringBuffer sb = new StringBuffer();
		
		
		for (int i = 0; i < slist.size(); i++) {
			if(slist.get(i).endString.equals(endpoint)) {
				System.out.print(startpoint + " 到 " + slist.get(i).endString + " 的最短路径为:\n");
				sb.append(startpoint + " 到 " + slist.get(i).endString + " 的最短路径为:\n");
				for (int j = 0; j < slist.get(i).pathList.size()-1; j++) {
					System.out.print(slist.get(i).pathList.get(j) + "-->");
					sb.append(slist.get(i).pathList.get(j) + "-->");
				}
					
				
				System.out.println(slist.get(i).pathList.get(slist.get(i).pathList.size()-1) );
				System.out.println("长度为:" + slist.get(i).distance);
				sb.append(slist.get(i).pathList.get(slist.get(i).pathList.size()-1) );
				sb.append("\n\n长度为:" + slist.get(i).distance);
				distance = slist.get(i).distance;
			}
			
		}
		return sb;
	}

}
