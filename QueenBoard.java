import java.util.Arrays;
public class QueenBoard {
  private int[][]board;
  public QueenBoard(int size){
	board=new int[size][size];
	for(int i=0;i<board.length;i++){
  	for(int j=0;j<board[0].length;j++){
    	board[i][j]=0;
  	}
	}
  }
//j is rows i is columns
public static void printArray(int[]ary)/*0a*/{
  String r = "";
  for(int i=0;i<ary.length;i++){
	if(ary[i]==-1)r+="Q";
	else
	r+=ary[i];
	if(!(ary.length-i==1))r+="  ";
  }
  r+="";
  System.out.println(r);
}
public static void printArray(int[][]ary)/*0b*/{
  System.out.println("");
  for(int i=0;i<ary.length;i++){
	printArray(ary[i]);
  }
  System.out.println("");
}
// i is r j is c
private boolean addQueen(int r,int c){
  board[r][c]=-1;
  for(int i=0;i<board.length;i++){
	for(int j=c+1;j<board[0].length;j++){
  	if(i==r)board[i][j]+=1;
  	else if((i-r)-(j-c)==0)board[i][j]+=1;
  	else if((i-r)+(j-c)==0)board[i][j]+=1;
	}
  }
  return true;
}
private boolean removeQueen(int r,int c){
  board[r][c]=0;
  for(int i=0;i<board.length;i++){
	for(int j=c+1;j<board[0].length;j++){
  	if(i==r)board[i][j]-=1;
  	else if((i-r)-(j-c)==0)board[i][j]-=1;
  	else if((i-r)+(j-c)==0)board[i][j]-=1;
	}
  }
  return true;
}
public void print(){
  printArray(this.board);
  this.addQueen(0,0);
  printArray(this.board);
  this.addQueen(1,3);
  printArray(this.board);
  this.removeQueen(1,3);
  printArray(this.board);
  this.removeQueen(0,0);
  printArray(this.board);

}
  public static void main(String[] args) {
	QueenBoard f =new QueenBoard(8);
	f.print();
  }
}
