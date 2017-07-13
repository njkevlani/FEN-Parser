import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter out = new PrintWriter(outputStream);
        TaskG solver = new TaskG();
        //call solv(int testNumber, InputReader in, PrintWriter out)
        String inStr = in.readLine();
        int board[][] = solver.FEN2Matrix(inStr);
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++)
                out.print(board[i][j] + " ");
            out.println();
        }
        out.close();
    }

    static class TaskG {        
        public int[][] FEN2Matrix(String inStr) {
            //code logic
            //bw contains black or white
            //temp2 contains all the rank positions.
            String strg[] = inStr.split(" ");           
            String temp = strg[0];
            String tp = strg[1];
            char bw = tp.charAt(0);                        
            String temp2[] = temp.split("/");
            
            int board[][] = new int[8][8];            
            for(int i=0;i<8;i++){
                String str = temp2[i];
                int k = 0;
                for(int j=0;j<str.length();j++){                   
                    int code = getCode(str.charAt(j));                                                                               
                    
                    if(code == 0){
                        int num = Integer.parseInt(""+str.charAt(j));
                        for(int ii=0;ii<num;ii++){
                            board[7-i][k] = 0;
                            k++;
                        }                          
                    }                       
                    else{                        
                        board[7-i][k] = code;
                        k++;
                    }
                }                
            }
            return board;                                                
        }       
    }
       
    static int getCode(char t){
        int ans=0;
        switch(t){
            case 'r':
                ans = -2;
                break;
            case 'n':
                ans = -3;
                break;
            case 'q':
                ans = -5;
                break;
            case 'k':
                ans = -6;
                break;
            case 'p':
                ans = -1;
                break;
            case 'b':
                ans = -4;
                break;
            case 'R':
                ans = 2;
                break;
            case 'N':
                ans = 3;
                break;
            case 'Q':
                ans = 5;
                break;
            case 'K':
                ans = 6;
                break;
            case 'P':
                ans = 1;
                break;
            case 'B':
                ans = 4;
                break;
        }
        
        return ans;
    }    
}