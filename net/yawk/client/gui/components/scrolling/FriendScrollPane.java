package net.yawk.client.gui.components.scrolling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import net.yawk.client.gui.Window;
import net.yawk.client.gui.components.TextDisplay;
import net.yawk.client.gui.components.buttons.FriendChangerButton;
import net.yawk.client.gui.components.selectors.FriendSelectorButton;
import net.yawk.client.gui.components.selectors.SelectorButton;
import net.yawk.client.gui.components.selectors.SelectorSystem;

public class FriendScrollPane extends PlayerScrollPane{
	
	private FriendChangerButton changerButton;
	
	public FriendScrollPane(int height, SelectorSystem system, FriendChangerButton changerButton) {
		super(height, system);
		this.changerButton = changerButton;
	}

	@Override
	protected void addPlayer(String p) {
		addComponent(system.add(new FriendSelectorButton(p, system, changerButton)));
	}
}
