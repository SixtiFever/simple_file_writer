import java.io.*;

/**
 * a program that takes console input and appends it to an external .txt file
 * */
public class FileWriter {
    public static void main(String[] args) throws IOException {
        // create an input and output byte streams to connect to the file
        // write to the file via keyboard input to console
        // press chosen key to clear file of data
        // EXTRA: create function to read file to the console

        char c; // character to store bytes in when reading and writing
        String line;

        try(FileInputStream fin = new FileInputStream(args[0]); FileOutputStream fout = new FileOutputStream(args[0], true)){

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int i;
            int j = 0;


            do {
                // take input ==> keyboard input to console. Read by buffered reader and stored in line variable
                System.out.print("Line " + ++j +": ");
                line = br.readLine();

                // if sequence is entered, exit function and reset file
                if(line.equalsIgnoreCase("XXX")) {
                    PrintWriter pw = new PrintWriter(args[0]);
                    pw.write("");
                    pw.close();
                    return;
                }

                if(line.equalsIgnoreCase("#")){
                    return;
                }

                // iterate line and print to file
                for( i = 0; i < line.length(); i++ ){
                    c = line.charAt(i);
                    fout.write(c);
                }
                fout.write('\n'); // new line after each input

            } while( !line.equalsIgnoreCase("XXX") );



        } catch(IOException e){
            System.out.println(e);
        }
    }
}
