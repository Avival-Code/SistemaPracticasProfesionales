package Utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class FileCreator {

    public File CreateFile( String filename, Blob fileContent ) {
        File temp = null;
        // new File( "../Database/" + fileName );
        try {
            temp = File.createTempFile( GetNamePrefix( filename ), GetNameSuffix( filename ) );
            FileOutputStream outputStream = new FileOutputStream( temp );
            InputStream inputStream = fileContent.getBinaryStream();
            byte[] buffer = fileContent.getBytes( 1, ( int )fileContent.length() );

            while( inputStream.read( buffer ) != -1 ) {
                outputStream.write( buffer );
            }

            inputStream.close();
            outputStream.close();
        } catch( SQLException | IOException exception ) {
            exception.printStackTrace();
        }
        return temp;
    }

    private String GetNamePrefix( String filename ) {
        return filename.substring( 0, GetPeriodIndex( filename ) - 1 );
    }

    private String GetNameSuffix( String filename ) {
        return filename.substring( GetPeriodIndex( filename ) );
    }

    private int GetPeriodIndex( String filename ) {
        int periodIndex = 0;
        char[] input = filename.toCharArray();
        for( char currentChar : input ) {
            if( currentChar == '.' ) {
                break;
            }
            periodIndex++;
        }
        return periodIndex;
    }
}
