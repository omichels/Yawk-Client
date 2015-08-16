package net.yawk.client.cameras;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.projectile.EntityArrow;

public class ArrowCamera extends Camera{
	
	private EntityArrow currentArrow;
	private Minecraft mc;
	
	public ArrowCamera() {
		super();
		mc = Minecraft.getMinecraft();
	}

	@Override
	public void updateFramebuffer() {
		
		if(isArrowAlive()){
			
			setToEntityPosition(currentArrow);
			cameraRotationYaw = currentArrow.rotationYaw+90;
			cameraRotationPitch = currentArrow.rotationPitch+180;
			
		}else{
			
			for(Object obj : mc.theWorld.loadedEntityList){
				if(obj != null && obj instanceof EntityArrow){
					EntityArrow arrow = (EntityArrow)obj;
					if(arrow.shootingEntity == mc.thePlayer){
						currentArrow = arrow;
					}
				}
			}
			
			cameraPosX = mc.thePlayer.posX;
			cameraPosY = mc.thePlayer.posY;
			cameraPosZ = mc.thePlayer.posZ;
			
			cameraRotationYaw = mc.thePlayer.rotationYaw;
			cameraRotationPitch = mc.thePlayer.rotationPitch;
		}
		
		super.updateFramebuffer();
	}

	private boolean isArrowAlive(){
		return currentArrow != null 
				&& !currentArrow.inGround
				&& !currentArrow.isCollided
				&& !currentArrow.isDead
				&& currentArrow.getDistanceToEntity(mc.thePlayer) < 350
				&& mc.theWorld.loadedEntityList.contains(currentArrow);
	}
}