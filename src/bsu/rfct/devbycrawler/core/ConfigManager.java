package bsu.rfct.devbycrawler.core;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



/**
 * Configuration manager.
 */
public class ConfigManager {
    
    private static final String DEFAULT_POSITIONS_CONFIG_FILE_NAME = "positions.ini";
    private static final String DEFAULT_PLATFORMS_CONFIG_FILE_NAME = "platforms.ini";
    private static final int EXPECTED_ARRAY_LENGTH = 25;
    
    
    
    /**
     * Read position list from file.
     */
    public static ArrayList<String> readPositionsConfig()
    {
        return readStringsFromFile(DEFAULT_POSITIONS_CONFIG_FILE_NAME);
    }
    
    
    
    /**
     * Read platforms list from file
     */
    public static ArrayList<String> readPlatformsConfig()
    {
        return readStringsFromFile(DEFAULT_PLATFORMS_CONFIG_FILE_NAME);
    }
    
    
    
    /**
     * Write platforms to config file.
     */
    public static void writePlatformsConfig( ArrayList<String> platforms )
    {
        assert platforms != null;
        assert platforms.size() > 0;
        writeStringsToFile( DEFAULT_PLATFORMS_CONFIG_FILE_NAME, platforms );
    }
    
    
    
    /**
     * Write positions to config file.
     */
    public static void writePositionsConfig( ArrayList<String> positions )
    {
        assert positions!= null;
        assert positions.size() > 0;
        writeStringsToFile( DEFAULT_POSITIONS_CONFIG_FILE_NAME, positions );
    }
    
    
    
    // read text data from a file
    private static ArrayList<String> readStringsFromFile( String fileName )
    {
        assert fileName != null;
        assert fileName.length() > 0;
        // TODO think whether to throw exceptions
        Scanner input = null;
        ArrayList<String> stringList = new ArrayList<String>( EXPECTED_ARRAY_LENGTH );
        try
        {
            input = new Scanner( new File(fileName) );
            while( input.hasNext() )
            {
                String line = input.nextLine();
                stringList.add( line );
            }
        }
        catch( IOException ioTrouble )
        {
            // TODO logging
            return new ArrayList<String>();
        }
        finally
        {
            if( input != null )
            {
                input.close();
            }
        }
        return stringList;
    }
    
    
    
    // write string to a file
    private static void writeStringsToFile( String fileName, ArrayList<String> stringsToWrite )
    {
        assert fileName != null;
        assert fileName.length() > 0;
        assert stringsToWrite != null;
        assert stringsToWrite.size() > 0;
        // TODO think whether to throw exceptions
        PrintWriter output = null;
        try
        {
            output = new PrintWriter( new File(fileName) );
            Iterator<String> iterator = stringsToWrite.iterator();
            while( iterator.hasNext() ) {
                output.println(iterator.next());
            }
        }
        catch( FileNotFoundException ioTrouble )
        {
            // TODO logging
        }
        catch( IOException ioTrouble )
        {
            // TODO logging
        }
        finally
        {
            if( output != null )
            {
                output.close();
            }
        }
    }
    
}
