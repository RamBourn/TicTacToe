
public class OACBoard extends BaseBoard{
	private String[][] chess;
	private String boardView;
	public OACBoard()
	{
		super(6);
		chess=new String[6][6];
		for(String[] i:chess)
			for(int j=0;j<i.length;j++)
				i[j]="  ";
		updateBoard();	
	}
	public void updateBoard()
	{
		boardView=new String("");
		for(int i=0;i<getSize();i++)
		{
			for(int j=0;j<getSize();j++)
			{
				boardView+="+--";
			}
			boardView+="+\n";
			for(int j=0;j<getSize();j++)
			{
				boardView+="|"+chess[i][j];
			}
			boardView+="|\n";
		}
		for(int j=0;j<getSize();j++)
		{
			boardView+="+--";
		}
		boardView+="+\n";
		System.out.println(boardView);
	}
	public boolean chessIn(int m,int n,String mark)
	{
		if(m<1||m>getSize()||n<1||n>getSize())
		{
			System.out.println("The input is out the scope, input again");
			return false;
		}
		if(chess[m-1][n-1].equals("  "))
		{
			chess[m-1][n-1]=mark;
			updateBoard();
			return true;
		}
		else 
		{
			System.out.println("This ceil has been already taken, input again");
			return false;
		}
	}
	public boolean isFull()
	{
		for(String[] i:chess)
			for(int j=0;j<i.length;j++)
			{
				if(i[j].equals("  "))
					return false;
			}
		return true;
	}
	public String checkWin()
	{
		for(int i=0;i<6;i++)
			for(int j=0;j<2;j++)
			{
				if(chess[i][j].equals("O ")&&chess[i][j+1].equals("O ")&&chess[i][j+2].equals("O ")
						&&chess[i][j+3].equals("O ")&&chess[i][j+4].equals("O ")
						||chess[j][i].equals("O ")&&chess[j+1][i].equals("O ")&&chess[j+2][i].equals("O ")
						&&chess[j+3][i].equals("O ")&&chess[j+4][i].equals("O "))
					return "O ";
			}
		for(int i=0;i<2;i++)
		{
			if(chess[i][i].equals("O ")&&chess[i+1][i+1].equals("O ")&&chess[i+2][i+2].equals("O ")
					&&chess[i+3][i+3].equals("O ")&&chess[i+4][i+4].equals("O ")
					||chess[i][5-i].equals("O ")&&chess[i+1][4-i].equals("O ")
					&&chess[i+2][3-i].equals("O ")&&chess[i+3][2-i].equals("O ")
					&&chess[i+4][1-i].equals("O "))
				return "O ";
		}
		if(isFull())
			return "full";
		else 
			return "ok";
	}
}
