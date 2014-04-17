package edu.nikita.lab2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.cli.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;



/**
 * Hello world!
 *
 */
public class App 
{
    private static final String CFG = "cfg";
	private static final String NUM = "num";
	private static final String SPRING_CONFIG = "springConfig";
	protected static BeanFactory factory;

	public static void main( String[] args ) throws Exception
    {
		//
		// parse command line input
		//
    	CommandLine cmd;
    	try {
			cmd = parseCommandLineArgs(args);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
    	
    	//
    	// load beans
    	// 
    	if(cmd.hasOption(SPRING_CONFIG)){
			String springConfogPath = cmd.getOptionValue(SPRING_CONFIG);
			loadBeans(springConfogPath);
    	}
    	else
    		loadBeans(null);
    	
    	//
    	// get number of command line or a config file
    	//
    	String numberAsAString = null;
    	if(cmd.hasOption(NUM)){
    		numberAsAString = cmd.getOptionValue(NUM);
    	}
    	else if(cmd.hasOption(CFG)) {
    		Properties properties = new Properties();
    		String path = cmd.getOptionValue(CFG);
    		try {
    		  properties.load(new FileInputStream(path));
    		} catch (IOException e) {
    			System.out.println("Failed to load property file " + path);
    		}
    		numberAsAString =  properties.getProperty(NUM);
		}
    	
    	//
    	// print result if defined
    	//
    	if (numberAsAString != null){
    		int num = Integer.parseInt(numberAsAString);
    		IFunction func = new Fibonacci();
    		System.out.println("Meh... " +  func.Compute(num).toString() );
    	}
    	else 
    		System.out.println("No valid args defined");
    }

	private static CommandLine parseCommandLineArgs(String[] args)
			throws ParseException {
		// create Options object
    	Options options = new Options();

    	// spring file name
    	Option spring   = OptionBuilder.withArgName( SPRING_CONFIG )
						                .hasArg()
						                .withDescription(  "spring config file path" )
						                .create( SPRING_CONFIG );
    	options.addOption(spring);
    	
    	// spring file name
    	Option number   = OptionBuilder.withArgName( NUM )
						                .hasArg()
						                .withDescription(  "number to produce for" )
						                .create( NUM );
    	options.addOption(number);
    	
    	// java Config file
    	Option cfg   = OptionBuilder.withArgName( CFG )
						                .hasArg()
						                .withDescription(  "config file path" )
						                .create( CFG );
    	options.addOption(cfg);
    	
    	
    	CommandLineParser parser = new GnuParser();
    	CommandLine cmd = parser.parse(options, args);
    	return cmd;
	}

	private static void loadBeans(String pathToConfig) {
		if(pathToConfig == null || pathToConfig.length() == 0)
			pathToConfig = "Spring-Common.xml";
			
		Resource resource = new FileSystemResource(pathToConfig);
    	factory = new XmlBeanFactory(resource);
	}
}
