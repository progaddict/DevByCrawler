package bsu.rfct.devbycrawler.core;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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

    private static Log logger = LogFactory.getLog(ConfigManager.class);

    private static final String DEFAULT_POSITIONS_CONFIG_FILE_NAME = "positions.ini";
    private static final String DEFAULT_PLATFORMS_CONFIG_FILE_NAME = "platforms.ini";
    private static final int EXPECTED_ARRAY_LENGTH = 25;
    
    
    
    /**
     * Read position list from file.
     */
    public static ArrayList<String> readPositionsConfig()
    {
        logger.info("reading positions list.");
        return readStringsFromFile(DEFAULT_POSITIONS_CONFIG_FILE_NAME);
    }
    
    
    
    /**
     * Read platforms list from file
     */
    public static ArrayList<String> readPlatformsConfig()
    {
        logger.info("reading platforms list.");
        return readStringsFromFile(DEFAULT_PLATFORMS_CONFIG_FILE_NAME);
    }
    
    
    
    /**
     * Write platforms to config file.
     */
    public static void writePlatformsConfig( ArrayList<String> platforms )
    {
        assert platforms != null;
        assert platforms.size() > 0;
        if( platforms == null ) {
            logger.error("platforms list is null!");
            return;
        }
        if( platforms.size() == 0 ) {
            logger.warn("platforms list is empty. nothing to write.");
            return;
        }
        writeStringsToFile( DEFAULT_PLATFORMS_CONFIG_FILE_NAME, platforms );
        logger.info("platforms list was written.");
    }
    
    
    
    /**
     * Write positions to config file.
     */
    public static void writePositionsConfig( ArrayList<String> positions )
    {
        assert positions!= null;
        assert positions.size() > 0;
        if( positions == null ) {
            logger.error("positions list is null!");
            return;
        }
        if( positions.size() == 0 ) {
            logger.warn("positions list is empty. nothing to write.");
            return;
        }
        writeStringsToFile( DEFAULT_POSITIONS_CONFIG_FILE_NAME, positions );
        logger.info("positions list was written.");
    }
    
    
    // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH this utility method should be moved to separate utility class. Besides you are reinventing the wheel. There are number of libraries to deal with config files (e.g. java.util.Properties, ini4j, and others). To read array you might store property in predefined format like JSON and then you can use existing libraries to parse/write array data to properties.
    // read text data from a file
    private static ArrayList<String> readStringsFromFile( String fileName )
    {
        assert fileName != null;
        assert fileName.length() > 0;
        if( fileName == null ) {
            logger.error("filename is null! returning empty list.");
            return new ArrayList<String>();
        }
        if( fileName.length() == 0 ) {
            logger.error("filename is an empty string! returning empty list.");
            return new ArrayList<String>();
        }
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
            logger.error("some IO trouble has occurred. returning empty list.");
            return new ArrayList<String>();
        }
        finally
        {
            if( input != null )
            {
                input.close();
            }
        }
        logger.info("strings were successfully read. returning list with them.");
        return stringList;
    }
    
    
    
    // write string to a file
    private static void writeStringsToFile( String fileName, ArrayList<String> stringsToWrite )
    {
        assert fileName != null;
        assert fileName.length() > 0;
        if( fileName == null ) {
            logger.error("filename is null! returning.");
            return;
        }
        if( fileName.length() == 0 ) {
            logger.error("filename is an empty string! returning.");
            return;
        }
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
            logger.error("file wasn't found! returning.");
            return;
        }
        catch( IOException ioTrouble )
        {
            logger.error("some IO trouble has occurred. returning.");
            return;
        }
        finally
        {
            if( output != null )
            {
                output.close();
            }
        }
        logger.info("strings were successfully written.");
    }
    
}
