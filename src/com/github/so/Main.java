package com.github.so;


import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.syntax.jedit.JEditTextArea;
import org.syntax.jedit.tokenmarker.JavaTokenMarker;

public class Main extends JFrame {
	JEditTextArea textarea;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2815306746474592239L;

	public Main(String title) {	
		setTitle(title);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 400));

		

		textarea = new JEditTextArea();
		textarea.setTokenMarker(new JavaTokenMarker());
		textarea.setText("public class Test {\n"
		 + "    public static void main(String[] args) {\n"
		 + "        System.out.println(\"Hello World\");\n"
		 + "    }\n"
		 + "}");
		
		getContentPane().add(textarea);
		
		pack();

	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(()-> {
				JFrame frame = new Main("jEdit-221-syntax");
				frame.setVisible(true);
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}

