/*
 * TextAreaDefaults.java - Encapsulates default values for various settings
 * Copyright (C) 1999 Slava Pestov
 *
 * You may use and modify this package for any purpose. Redistribution is
 * permitted, in both source and binary form, provided that this notice
 * remains intact in all source distributions of this package.
 */

package org.syntax.jedit;

import javax.swing.JPopupMenu;

import java.awt.Color;

/**
 * テキストエリアの各種設定値。キャレットの点滅や行数、列数、選択時の色やブラケットの色などがある。
 * このクラスは、シングルトン・デザインパターンで作れていて、設定値はpublicにしてアクセスしやすくしている。 Encapsulates default
 * settings for a text area. This can be passed to the constructor once the
 * necessary fields have been filled out. The advantage of doing this over
 * calling lots of set() methods after creating the text area is that this
 * method is faster.
 */
public class TextAreaDefaults {
	// Singleton Design Pattern.
	private static TextAreaDefaults instance;

	public InputHandler inputHandler;
	public SyntaxDocument document;
	public boolean editable;

	public boolean caretVisible;
	public boolean caretBlinks;
	public boolean blockCaret;
	public int electricScroll;

	public int cols;
	public int rows;
	public SyntaxStyle[] styles;
	public Color caretColor;
	public Color selectionColor;
	public Color lineHighlightColor;
	public boolean lineHighlight;
	public Color bracketHighlightColor;
	public boolean bracketHighlight;
	public Color eolMarkerColor;
	public boolean eolMarkers;
	public boolean paintInvalid;

	public JPopupMenu popup;

	private TextAreaDefaults() {
		inputHandler = new DefaultInputHandler();
		inputHandler.addDefaultKeyBindings();
		document = new SyntaxDocument();
		editable = true;

		blockCaret = false;
		caretVisible = true;
		caretBlinks = true;
		electricScroll = 3;

		cols = 80;
		rows = 25;
		styles = SyntaxUtilities.getDefaultSyntaxStyles();
		caretColor = Color.red;
		selectionColor = new Color(0xccccff);
		lineHighlightColor = new Color(0xe0e0e0);
		lineHighlight = true;
		bracketHighlightColor = Color.pink;
		bracketHighlight = true;
		// EOL = EndOfLine
		eolMarkerColor = Color.orange; // new Color(0x009999);
		eolMarkers = true; // true;
		// チルダーの表示
		paintInvalid = true; // true;
	}

	/**
	 * Returns a new TextAreaDefaults object with the default values filled in.
	 */
	public static synchronized TextAreaDefaults getInstance() {
		if (instance == null) {
			instance = new TextAreaDefaults();
		}
		return instance;
	}
}
