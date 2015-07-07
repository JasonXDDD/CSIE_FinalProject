package Data.Project.G13;

import java.util.ArrayList;

//singleton:new�X�Ӫ��F��u�|���@��
public class VariableStorage {
	private static VariableStorage instance=null;
    private ArrayList<String> numscore;//�ʺA�t�m
    private ArrayList<String> numname;
	private VariableStorage(){  //����new
		numscore=new ArrayList<String>();
		numname=new ArrayList<String>();
	}
	public static VariableStorage getInstance(){
		if(instance==null)
			instance=new VariableStorage();
		return instance;
	}
	public ArrayList<String> getNumscore() {
		return numscore;
	}
	public void addNumscore(String score) {
		numscore.add(score);
	}
	public ArrayList<String> getNumname() {
		return numname;
	}
	public void addNumname(String name) {
		numname.add(name);
	}
	
	

}
