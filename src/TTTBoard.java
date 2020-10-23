public class TTTBoard extends BaseBoard{
	private String[][] chess;
	private String boardView;
	public TTTBoard(int size)
	{
		super(size);
		chess=new String[size][size];
		boardView=new String("");
		for(String[] i :chess)
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
		for(int i=1;i<getSize()-1;i++)
		{
			if(chess[0][i-1].equals("X ")&&chess[0][i].equals("X ")&&chess[0][i+1].equals("X ")
					||chess[getSize()-1][i-1].equals("X ")
					&&chess[getSize()-1][i].equals("X ")&&chess[getSize()-1][i+1].equals("X ")
					||chess[i-1][0].equals("X ")&&chess[i][0].equals("X ")&&chess[i+1][0].equals("X ")
					||chess[i-1][getSize()-1].equals("X ")
					&&chess[i][getSize()-1].equals("X ")&&chess[i+1][getSize()-1].equals("X "))
				return "X ";
			if(chess[0][i-1].equals("O ")&&chess[0][i].equals("O ")&&chess[0][i+1].equals("O ")
					||chess[getSize()-1][i-1].equals("O ")
					&&chess[getSize()-1][i].equals("O ")&&chess[getSize()-1][i+1].equals("O ")
					||chess[i-1][0].equals("O ")&&chess[i][0].equals("O ")&&chess[i+1][0].equals("O ")
					||chess[i-1][getSize()-1].equals("O ")
					&&chess[i][getSize()-1].equals("O ")&&chess[i+1][getSize()-1].equals("O "))
				return "O ";
		}
		for(int i=1;i<getSize()-1;i++)
		{
			for(int j=1;j<getSize()-1;j++)
			{
				if(chess[i][j-1].equals("X ")&&chess[i][j-1].equals("X ")&&chess[i][j+1].equals("X ")
						||chess[i-1][j].equals("X ")
						&&chess[i][j].equals("X ")&&chess[i+1][j].equals("X ")
						||chess[i-1][j-1].equals("X ")
						&&chess[i][j].equals("X ")&&chess[i+1][j+1].equals("X ")
						||chess[i-1][j+1].equals("X ")
						&&chess[i][j].equals("X ")&&chess[i+1][j-1].equals("X "))
					return "X ";
				if(chess[i][j-1].equals("O ")&&chess[i][j-1].equals("O ")&&chess[i][j+1].equals("O ")
						||chess[i-1][j].equals("O ")
						&&chess[i][j].equals("O ")&&chess[i+1][j].equals("O ")
						||chess[i-1][j-1].equals("O ")
						&&chess[i][j].equals("O ")&&chess[i+1][j+1].equals("O ")
						||chess[i-1][j+1].equals("O ")
						&&chess[i][j].equals("O ")&&chess[i+1][j-1].equals("O "))
					return "O ";
			}
		}
		if(isFull())
			return "full";
		else 
			return "ok";
	}
}