import java.util.*;

public class TTTGame extends BaseGame{
	private Player playerX;
	private Player playerO;
	private Team teamA;
	private Team teamB;
	private TTTBoard theBoard;
	private int round;
	private int decideWho;
	private boolean isStop;
	private int mode;
	public TTTGame()
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Choose the mode (2 for team mode, other for single mode :");
		mode=in.nextInt();
		if(mode==2)
		{
			System.out.print("How many players in each team : ");
			int number=in.nextInt();
			teamA=new Team("X ",number);
			teamB=new Team("O ",number);
		}
		else 
		{
			playerX=new Player("X ",0);
			playerO=new Player("O ",0);
		}
		round=0;
	}
	public void newRound()
	{
		Scanner in=new Scanner(System.in);
		int size;
		do
			{
				System.out.print("Enter the size of the board(>=3): ");
				size=in.nextInt();
			}while(size<3);
		theBoard=new TTTBoard(size);
		round++;
		decideWho=new Random().nextInt();
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
					int number=new Random().nextInt(teamA.getPlayers().length);
					System.out.print("Player "+number+" in Team A Enter your move:");
				}
				else
					System.out.print("Player O Enter your move:");
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
					int number=new Random().nextInt(teamB.getPlayers().length);
					System.out.print("Player "+number+" in Team B Enter your move:");
				}
				else
					System.out.print("Player X Enter your move:");
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
			isStop=true;
			System.out.println("The board is full but there is no winner!");
		}
		else if(mode==2&&mark.equals(teamA.getPlayers()[0].getMark()))
		{
			teamA.setScore(teamA.getScore()+1);
			isStop=true;
			System.out.println("In round "+round+", the winner is Team A");
		}
		else if(mode==2&&mark.equals(teamB.getPlayers()[0].getMark()))
		{
			teamB.setScore(teamB.getScore()+1);
			isStop=true;
			System.out.println("In round "+round+", the winner is Team B");
		}
		else if(mode!=2&&mark.equals(playerX.getMark()))
		{
			playerX.setScore(playerX.getScore()+1);
			isStop=true;
			System.out.println("In round "+round+", the winner is Player X");
		}
		else if(mode!=2&&mark.equals(playerO.getMark()))
		{
			playerO.setScore(playerO.getScore()+1);
			isStop=true;
			System.out.println("In round "+round+", the winner is Player O");
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
				if(mode==2&&teamA.getScore()>teamB.getScore())
					System.out.println("The final winner is Team A");
				else if (mode==2&&teamA.getScore()<teamB.getScore())
					System.out.println("The final winner is Team B");
				else if(mode!=2&&playerX.getScore()>playerO.getScore())
					System.out.println("The final winner is Player X");
				else if (mode!=2&&playerX.getScore()<playerO.getScore())
					System.out.println("The final winner is Player O");
				else
					System.out.println("The game ends in a draw");
			}
		}
	}
}