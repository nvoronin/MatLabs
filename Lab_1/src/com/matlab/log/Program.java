package com.matlab.log;

import org.apache.log4j.Logger;

import java.io.Console;
import java.io.ObjectInputStream.GetField;

public class Program {

	private static Logger logger;

	public static Logger getLogger() {
		return logger;
	}

	private static void setLogger(Logger logger) {
		Program.logger = logger;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Doge said wow!");
		setLogger(Logger.getLogger(Program.class.getName()));
		logger.debug("Mmmm so sweet!");
	}

	

}
