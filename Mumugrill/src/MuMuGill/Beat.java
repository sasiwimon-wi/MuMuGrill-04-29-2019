package MuMuGill;
/*********
 * 
 * Beat class for keep data to build 1 note.
 *
 *********/
public class Beat {
	/****
	 * @param time : this value to set time of origin.
	 * @param noteName : this value to set type note 
	 * (type note is image note for example pork note image and vegetable note image).
	 * @param x,y : this two values to set position of origin.
	 * 
	 * @param isGameOver : this values for manage stop game.
	****/
	private int time;
	private int noteName;
	private int x,y;
	private boolean isGameOver;
	
	/*********
	 * Method for get and set each values.
	 **********/
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getNoteName() {
		return noteName;
	}
	public void setNoteName(int noteName) {
		this.noteName = noteName;
	}
	
	public boolean getisGameOver() {
		return isGameOver;
	}
	public void setisGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	/**********
	 * This constructor to make it easier to set values.
	 *********/
	public Beat(int x,int y,int time, int noteName, boolean isGameOver) {
		super();
		this.time = time;
		this.noteName = noteName;
		this.x = x;
		this.y = y;
		this.isGameOver = isGameOver;
	}
}
