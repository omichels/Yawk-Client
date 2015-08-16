package net.yawk.client.cameras;

import net.minecraft.client.Minecraft;
import net.yawk.client.Client;

public class RearviewCamera extends Camera{
	
	private Minecraft mc;
	
	public RearviewCamera(){
		super();
		mc = Minecraft.getMinecraft();
	}
	
	@Override
    protected void setCapture(boolean capture){
		
    	if(capture){
    		
    		cameraPosX = mc.thePlayer.posX;
    		cameraPosY = mc.thePlayer.posY;
    		cameraPosZ = mc.thePlayer.posZ;
    		
    		cameraRotationYaw = mc.thePlayer.rotationYaw+180;
    		cameraRotationPitch = mc.thePlayer.rotationPitch;
    	}
    	
    	super.setCapture(capture);
    }
	
}
