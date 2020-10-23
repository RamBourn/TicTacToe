
public class Team {
	private int totalScore;
	private Player[] teamMembers;
	public Team(String mark,int size)
	{
		totalScore=0;
		teamMembers=new Player[size];
		for(int i=0;i<teamMembers.length;i++)
			teamMembers[i]=new Player(mark,0);
	}
	public void setScore(int score)
	{
		totalScore=score;
	}
	public int getScore()
	{
		return totalScore;
	}
	public Player[] getPlayers()
	{
		return teamMembers;
	}
}
