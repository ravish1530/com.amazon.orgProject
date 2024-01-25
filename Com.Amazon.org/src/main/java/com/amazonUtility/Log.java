package com.amazonUtility;


import org.apache.logging.log4j.LogManager;


import org.apache.logging.log4j.core.Logger;
//import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

//import com.myStoreBasePackage.BaseClass;


public class Log {
	
	// Initialize Log4j logs   
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Log.class);
    

	public static void startTestCase(String sTestCaseName){		  
		// Log.info("====================================="+sTestCaseName+" TEST START=========================================");
		 LOGGER.info("====================================="+sTestCaseName+" TEST START=========================================");
	}
	
	public static void endTestCase(String sTestCaseName){
		//Log.info("====================================="+sTestCaseName+" TEST END=========================================");
		
		 LOGGER.info("====================================="+sTestCaseName+" TEST End=========================================");

	}
	
	// Need to create below methods, so that they can be called  

	 public static void info(String message) {

			//Log.info(message);

			LOGGER.info(message);
			}

	 public static void warn(String message) {

	  //  Log.warn(message);
        LOGGER.warn(message);
		}

	 public static void error(String message) {

	    //Log.error(message);
	    LOGGER.error(message);

		}

	 public static void fatal(String message) {

	   // Log.fatal(message);
	    LOGGER.fatal(message);

		}

	 public static void debug(String message) {

	   // Log.debug(message);
	    LOGGER.debug(message);

		}
	
}

	
	

