package com.synphoo.java.test.designPattern.producerConsumer;

import org.eclipse.jdt.internal.compiler.parser.TerminalTokens;

/**
 * 
 * @author wangmingfeng
 *
 */
public abstract class AbstractTerminatableThread extends Thread implements Terminatable{

	public AbstractTerminatableThread(){
		
	}
	
	protected void doTerminate() {
		//
	}
}
