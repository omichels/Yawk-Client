package net.yawk.client.utils;

public class MillisecondTimer {
	
	private int delay;
	private int lastTime;
	
	public MillisecondTimer(){
		this.delay = 1000;
		reset();
	}
	
	public MillisecondTimer(int delay){
		this.delay = delay;
	}
	
	public boolean finished(){
		return elapsedTime() >= delay;
	}
	
	public void reset(){		
		lastTime = getCurrentTime();
	}
	
	public boolean output(){
		
		boolean done = elapsedTime() >= delay;
		
		if(done){
			lastTime = getCurrentTime();
		}
		
		return done;
	}
	
	public int elapsedTime(){
		return getCurrentTime() - lastTime;
	}
	
	public int getDelay() {
		return delay;
	}
	
	public MillisecondTimer setDelay(int delay) {
		this.delay = delay;
		return this;
	}
	
	public int getCurrentTime(){
		return (int) System.currentTimeMillis();
	}
}