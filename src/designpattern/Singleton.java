package designpattern;
/**
 * ClassName: Singleton
 * Description: A class that reliaze singleton pattern
 * Date: 2017-4-30
 * 
 * Update history:
 * 
 * @author: Steve Shao
 * @version 1.0
 */
public class Singleton {
/*
 * The Singleton pattern requires that at most one instance of the logging class exists at any given time.
The easiest way to do this is to make the constructor private and initialize the single instance within
the class
 */
	// Implements a simple logging class using a singleton.
	public static class Logger {
		// Create and store the singleton.
		private static final Logger instance = new Logger();
		// Prevent anyone else from creating this class.
		private Logger(){
		}
		// Return the singleton instance.
		public static Logger getInstance() { return instance; }
		// Log a string to the console.
		//
		// example: Logger.getInstance().log("this is a test");
		//
		public void log( String msg ){
			System.out.println( System.currentTimeMillis() + ": " + msg );
		}
	}
}
