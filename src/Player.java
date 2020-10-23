public class Player{
	private String mark;
	private int score;
	public Player(String mark)
	{
		setMark(mark);
	}
	public Player(String mark,int score)
	{
		setMark(mark);
		setScore(score);
	}
	public String getMark()
	{
		return mark;
	}
	public void setMark(String mark)
	{
		this.mark=mark;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score=score;
	}
}