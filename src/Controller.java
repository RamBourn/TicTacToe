import java.util.*;

public class Controller {
	public static void main(String[] args)
	{
		int choose;
		do
		{
			Scanner in=new Scanner(System.in);
			String introduction="Welcome to Board Game!\n"
					+ "Choose to play (1 for TicTacToe, 2 for Order and Chaos, 3 to quit) :";
			System.out.print(introduction);
			choose=in.nextInt();
			if(choose==1)
			{
				TTTGame theGame=new TTTGame();
				theGame.newRound();
			}
			else if(choose==2)
			{
				OACGame theGame=new OACGame();
				theGame.newRound();
			}
		}while(choose!=3);
	}
}
