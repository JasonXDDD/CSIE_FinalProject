package Data.Project.G5;

import javax.swing.*;
import javax.swing.table.*;

import java.text.*;
import java.util.*;
import java.awt.*;

public class RankPanel extends JPanel{
	
	JLabel background;
	JLabel title;
	JTable listtable;
	JPanel listPanel;
	JPanel titlePanel;
	JScrollPane sp;
	
	String colname[];
	String data[][];
	
	int count;
	
	Memory memory[];
	
	Icon bg = new ImageIcon (getClass().getResource("rank.jpg"));
	
	public RankPanel (Memory memory[],int count){
		super ();
		setLayout(new BorderLayout());
		
		this.memory = memory;
		this.count = count;
		
		titlePanel = new JPanel();
		title = new JLabel("RANK");
		title.setFont(new Font("Buxton Sketch", Font.BOLD ,60));
		title.setPreferredSize(new Dimension(300,70));
		title.setForeground(Color.WHITE);

		titlePanel.setOpaque(false);
		titlePanel.setBounds(450, 60, 500, 70);
		
		titlePanel.add(title);
		
		colname = new String[]{
				"�W��","����","����","�ɶ�"
		};
				
		listtable = new JTable(new TableData(memory,count));
		listtable.setFont(new Font("�з���" , Font.PLAIN , 16));
		
		sp = new JScrollPane(listtable);
		sp.setPreferredSize(new Dimension(640,360));
		
		listPanel = new JPanel();
		listPanel.setBounds(320, 190, 640, 365);
		listPanel.add(sp);
		listPanel.setOpaque(false);
		
		DefaultTableCellRenderer cdr = (DefaultTableCellRenderer)listtable.getDefaultRenderer(Integer.class);
		cdr.setHorizontalAlignment(SwingConstants.CENTER);
		listtable.getColumnModel().getColumn(0).setCellRenderer(cdr);
		listtable.getColumnModel().getColumn(2).setCellRenderer(cdr);
		
		background = new JLabel (bg);
		
		add (listPanel);
		add (titlePanel);
		add (background);
	}
	
	class TableData extends AbstractTableModel{
		
		Memory memory[];
		int count;
		int current = 0;
		
		public TableData(Memory[] memory,int count) {
			this.memory = memory;
			this.count = count;
		}

		public int getRowCount() {
			return count+1;
		}
		
		public int getColumnCount() {
			return 4;
		}
		
		public Object getValueAt(int row, int column) {
			switch (column){
			case 0:
				return memory[current].getName();
			case 1:
				return memory[current].getSong();
			case 2:
				return memory[current].getScore();
			case 3:
				return memory[current++].getTime();
			default:
				return "";
			}			
		}
		
		public String getColumnName(int column){
			switch (column){
			case 0:
				return "�W��";
			case 1:
				return "����";
			case 2:
				return "����";
			case 3:
				return "�ɶ�";
			default:
				return "";
			}
		}
	}
	
	public void setMemory(Memory memory[],int count) {
		this.memory = memory;
		this.count = count;
		this.updateUI();
		listtable.setModel(new TableData(memory,count));
	}
	
}
