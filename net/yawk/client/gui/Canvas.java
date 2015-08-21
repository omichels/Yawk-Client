package net.yawk.client.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import net.yawk.client.utils.GuiUtils;

public class Canvas implements IRectangle{
	
	private IScalerPosition pos;
	private int width, height;
	protected List<AbstractComponent> components = new CopyOnWriteArrayList<AbstractComponent>();
	
	public Canvas(IScalerPosition pos, int width) {
		this.pos = pos;
		this.width = width;
	}
	
	public void draw(int x, int y){
		
		int posX = pos.getX();
		int posY = pos.getY();
		
		GuiUtils.drawRect(posX, posY, posX+width, posY+height, 0x5F5F5F5F);
		
		for(AbstractComponent comp : components){
			comp.draw(x, y);
		}
	}
	
	public void mouseClicked(int x, int y) {
						
		for (AbstractComponent comp : components){
			comp.mouseClicked(x, y);
		}
	}
	
	public void keyPress(char c, int key) {
				
		for(AbstractComponent comp : components){
			comp.keyPress(key, c);
		}
	}
	
	public void mouseReleased(int x, int y, int state) {
				
		for(AbstractComponent comp : components){
			comp.mouseReleased(x, y, state);
		}
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	public void addComponent(AbstractComponent c){
		this.components.add(c);
		c.setRectangle(this);
		c.init();
		updateHeight();
	}
	
	public void clearComponents(){
		this.components.clear();
		height = 0;
	}
	
	public void updateHeight(){
		
		height = 0;
		
		for(AbstractComponent component : components){
			height += component.getHeight();
			component.setY(height);
		}
	}
	
	@Override
	public int getRectX() {
		return pos.getX();
	}

	@Override
	public int getRectY() {
		return pos.getY();
	}
}
