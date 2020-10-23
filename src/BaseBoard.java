
public abstract class BaseBoard {
	private int size;
	public abstract void updateBoard();
	public abstract boolean chessIn(int m,int n,String mark);
	public abstract boolean isFull();
	public abstract String checkWin();
	public BaseBoard()
	{
		size=0;
	}
	public BaseBoard(int size)
	{
		setSize(size);
	}
	public int getSize()
	{
		return size;
	}
	public void setSize(int size)
	{
		this.size=size;
	}
}
