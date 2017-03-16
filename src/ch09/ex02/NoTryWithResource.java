package ch09.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/** 
  * 
  * 練習問題1 を改善して、in.close() やout.close() によりスローされる例外を抑 
  * 制された例外として、元々の例外へ追加するようにしなさい。 
  */ 

public class NoTryWithResource {
	
	public static void main(String[] args) throws IOException {
		
		IOException exception1 = null;     
		IOException exception2 = null;     
		IOException inCloseException = null;  
		IOException outCloseException = null; 

		try {
		    BufferedReader in;
		    try {
		    	in = Files.newBufferedReader(Paths.get("C:\\wordTexst.txt"));
		    } catch (IOException ex) {
		        exception1 = ex;
		        throw ex;
		    }
		    try {
		        BufferedWriter out;
		        try {
		        	out = Files.newBufferedWriter(Paths.get("C:\\Result2.txt"));
		        } catch (IOException ex) {
		            exception1 = ex;
		            throw ex;
		        }
		        try {
		            String line;
		            while ((line = in.readLine()) != null) {
		                out.write(line.toLowerCase());
		                out.newLine();
		            }
		        } catch (IOException ex) {
		            exception2 = ex;
		            throw ex;
		        } finally {
		            try {
		                out.close();
		            } catch (IOException ex) {
		                outCloseException = ex;
		                throw ex;
		            }
		        }
		    } finally {
		        try {
		            in.close();
		        } catch (IOException ex) {
		            inCloseException = ex;
		            throw ex;
		        }
		    }
		} catch (IOException ex) {
		    if (exception1 != null) {
		        if (inCloseException != null)
		            exception1.addSuppressed(inCloseException);
		        throw exception1;
		    }
		    if (exception2 != null) {
		        if (inCloseException != null)
		            exception2.addSuppressed(inCloseException);
		        if (outCloseException != null)
		            exception2.addSuppressed(outCloseException);
		        throw exception2;
		    }
		    if (inCloseException != null && outCloseException != null) {
		        inCloseException.addSuppressed(outCloseException);
		        throw inCloseException;
		    }
		    throw ex;
		}

	}

}
