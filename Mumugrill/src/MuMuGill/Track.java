package MuMuGill;
/************
 * 
 * Track class keeping data for once game. 
 * This class can set data and get data.
 *
 ************/
public class Track {
	/**********
	 * Set all values for once game.
	 **********/
	private String titleImage;
	private String startImage;
	private String gameImage;
	private String charImage;
	private String startMusic;
	private String gameMusic;
	private String titleName;
	
	/*********
	 * Method for get and set each values.
	 **********/
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	
	public String getCharImage() {return charImage;}
	public void setCharImage(String charImage) {this.charImage = charImage;}
	
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	/**********
	 * This constructor to make it easier to set values.
	 * @param titleImage
	 * @param startImage
	 * @param gameImage
	 * @param charImage
	 * @param startMusic
	 * @param gameMusic
	 * @param titleName
	 */
	public Track(String titleImage, String startImage, String gameImage,String charImage, String startMusic, String gameMusic, String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.charImage = charImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}
	
}
