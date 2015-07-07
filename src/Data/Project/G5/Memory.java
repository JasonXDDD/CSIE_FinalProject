package Data.Project.G5;

public class Memory {
	
	int count = 0;
	
	String name;
	String song;
	
	int score = 0;
	String time;
	
	public Memory (){
		
	}
	
	public void setCount (int count){
		this.count = count ;
	}
	
	public int getCheck (){
		return count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
