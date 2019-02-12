import java.util.Arrays;
public class QueenBoard {
  private int[][]board;
  private static int n;
  public QueenBoard(int size){
	board=new int[size][size];
  n=size*5;
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
	if(ary[i]==n)r+="Q";
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
  board[r][c]=n;
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
	for(int i=0;i<16;i++){
    QueenBoard f = new QueenBoard(i);
    System.out.println("A Board of Size " +i+ " has "+ f.countSolutions()+ " solutions" );}
  }
  public String toString(){
    String r="";
    for(int row=0;row<board.length;row++){
      for(int col=0;col<board[row].length;col++){
        if(board[row][col]==n)r+="Q ";
        else r+="_ ";
      }
      r+="\n";
    }
    return r;
  }
  public boolean solve() throws IllegalStateException{
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]!=0){ throw new IllegalStateException(); }
      }
    }
    return actualSolve(0);
  }
  private boolean actualSolve(int queens){
   if(queens==board.length)return true;
   for(int row=0;row<board.length;row++){
     if(board[row][queens]==0){
       addQueen(row,queens);
       if(actualSolve(queens+1)==true){return true;}
       else removeQueen(row,queens);
     }
     else if(row==board.length-1)return false;
   }
   return false;
  }
  private int actualcountSolutions(int queens){
    int count=0;
    if(queens==board.length)return 1;
    for(int row=0;row<board.length;row++){
      if(board[row][queens]==0){
        addQueen(row,queens);
        count+=actualcountSolutions(queens+1);
        removeQueen(row,queens);
      }
      else if(row==board.length-1)return count;
    }
    return count;
  }
  public int countSolutions() throws IllegalStateException{
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]!=0){ throw new IllegalStateException(); }
      }
    }
    int s=actualcountSolutions(0);
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        board[i][j]=0;
      }
    }
    return s;
  }
}
