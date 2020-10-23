import java.util.Random;
import java.util.Scanner;

public class OACGame extends BaseGame {
	private Player playerO;
	private Player playerC;
	private Team teamO;
	private Team teamC;
	private OACBoard theBoard;
	private int round;
	private int decideWho;
	private boolean isStop;
	private int mode;
	public OACGame()
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Choose the mode (2 for team mode, other for single mode :");
		mode=in.nextInt();
		if(mode==2)
		{
			System.out.print("How many players in each team : ");
			int number=in.nextInt();
			teamC=new Team("X ",number);
			teamO=new Team("O ",number);
		}
		else 
		{
			playerC=new Player("X ",0);
			playerO=new Player("O ",0);
		}
		round=0;
	}
	public void newRound()
	{
		theBoard=new OACBoard();
		round++;
		decideWho=0;
		isStop=false;
		while(!isStop)
			chessIn();

	}

	public void chessIn() 
	{
		Scanner in=new Scanner(System.in);
		int m,n;
		if(decideWho%2==0)
		{
			do 
			{
				if(mode==2)
				{
					int number=new Random().nextInt(teamO.getPlayers().length);
					System.out.print("Player "+number+" in Team Order, Enter your move:");
				}
				else
					System.out.print("Player Order, Enter your move:");
				m=in.nextInt();
				n=in.nextInt();
			}while(!theBoard.chessIn(m, n, "O "));
			checkWin();
			decideWho++;
		}
		else
		{
			do
			{
				if(mode==2)
				{
					int number=new Random().nextInt(teamC.getPlayers().length);
					System.out.print("Player "+number+" in Team Chaos, Enter your move:");
				}
				else
					System.out.print("Player Chaos, Enter your move:");
				m=in.nextInt();
				n=in.nextInt();
			}while(!theBoard.chessIn(m, n, "X "));
			checkWin();
			decideWho++;
		}

	}


	public void checkWin()
	{
		String mark=theBoard.checkWin();
		if(mark.equals("full"))
		{
			if(mode==2)
			{
				teamC.setScore(teamC.getScore()+1);
				isStop=true;
				System.out.println("in round "+ round+", the winner is Team Chaos");
			}
			else
			{
				playerC.setScore(playerC.getScore()+1);
				isStop=true;
				System.out.println("in round "+round+" , the winner is Player Chaos");
			}
		}
		else if(mark.equals("O "))
		{
			if(mode==2)
			{
				teamO.setScore(teamO.getScore()+1);
				isStop=true;
				System.out.println("in round "+ round+", the winner is Team Order");
			}
			else
			{
				playerO.setScore(playerO.getScore()+1);
				isStop=true;
				System.out.println("in round "+round+" , the winner is Player Order");
			}
		}
		checkStop();
	}
	
	public void checkStop()
	{
		if(isStop)
		{
			Scanner in=new Scanner(System.in);
			System.out.print("Do you want to play another round? (Y/N): ");
			String answer=in.next();
			if(answer.equals("Y")||answer.equals("y"))
				newRound();
			else if(answer.equals("N")||answer.equals("n"))
			{
				System.out.println("The game is over, total rounds is "+round);
				if(mode==2&&teamO.getScore()>teamC.getScore())
					System.out.println("The final winner is Team Order");
				else if (mode==2&&teamO.getScore()<teamC.getScore())
					System.out.println("The final winner is Team Chaos");
				else if(mode!=2&&playerO.getScore()>playerC.getScore())
					System.out.println("The final winner is Player Order");
				else if (mode!=2&&playerO.getScore()<playerC.getScore())
					System.out.println("The final winner is Player Chaos");
				else
					System.out.println("The game ends in a draw");
			}
		}
	}

}
