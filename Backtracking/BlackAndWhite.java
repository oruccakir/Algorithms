
public class BlackAndWhite {

    public int[][] board;
    public int row_len;
    public int col_len;

    public BlackAndWhite(int [][]board){
        this.board = board;
        this.row_len = board.length;
        this.col_len = board[0].length;
    }

    public int findFays(){

        int count = 0;

        for(int i=0; i<row_len; i++){
            for(int k=0; k<col_len; k++){
                count+=(row_len * col_len - whereCanBePlaced(i, k)-1);
            }
        }
    
        return count;
    }

    public int whereCanBePlaced(int host_x,int host_y){

        int count = 0;

        int dest_x = host_x+2;
        int dest_y = host_y+1;

        if(inFrontier(dest_x, dest_y))
            count++;
        
        dest_x = host_x +2; dest_y = host_y-1;

        if(inFrontier(dest_x, dest_y))
            count++;
        
        dest_x = host_x+1; dest_y = host_y+2;
        
        if(inFrontier(dest_x, dest_y))
            count++;
        
        dest_x = host_x+1; dest_y = host_y-2;

        if(inFrontier(dest_x, dest_y))
            count++;
        
        dest_x = host_x-1; dest_y = host_y+2;

        if(inFrontier(dest_x, dest_y))
            count++;

        dest_x = host_x-1; dest_y = host_y-2;

        if(inFrontier(dest_x, dest_y))
            count++;
        
        dest_x = host_x-2; dest_y = host_y-1;

        if(inFrontier(dest_x, dest_y))
            count++;
        
        dest_x = host_x-2; dest_y = host_y+1;

        if(inFrontier(dest_x, dest_y))
            count++;

        
        return count;

    }

    public boolean inFrontier(int dest_x,int dest_y){
        return dest_x >=0 && dest_x < row_len && dest_y >= 0 && dest_y< col_len;
    }

    public static void main(String[] args) {
        
        int row = 2;
        int col = 3;
        int [][]board = new int[row][col];
        BlackAndWhite bw = new BlackAndWhite(board);
        System.out.println(bw.findFays());

    }
    
}
