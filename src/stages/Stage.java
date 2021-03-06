/**
 * 
 */
package stages;

import org.jbox2d.common.Vec2;

import model.FinishFlag;
import model.Launcher;
import model.MainBall;
import controller.WorldController;

/**
 * @author bilal
 *
 */
public class Stage {
	
	protected WorldController world;
	protected MainBall mb;
	protected FinishFlag ff;
	protected Vec2 mbPos;
	protected Launcher haveLauncher;


	public Stage(Vec2 mbPos) {
		world = new WorldController();
		this.mbPos = mbPos;

		try {
			ff = new FinishFlag(new Vec2(0,0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public MainBall getMainBall() {
		return mb;
	}
	
	public FinishFlag getFlag() {
		return ff;
	}
	
	public WorldController getWorldController() 
	{ 
		return world; 
	}

	public void destroyWorld() {
		WorldController.destroy();
		
	}
	
	public void destroyOutside() {
		//destroy the object when it is outside of the screen
		boolean mb = false;
		for (int i = 0; i < world.getObjects().size(); i++){
			if (!world.getObjects().get(i).isInside()){
				
				//if the object is main ball, respawn it
				if ( world.getObjects().get(i).isMain() && !mb){
					world.getWorld().destroyBody(world.getObjects().get(i).body);
					WorldController.deleteObject(world.getObjects().get(i));
					addMainBall();
					mb = true;
				}
				else {
					world.getWorld().destroyBody(world.getObjects().get(i).body);
					WorldController.deleteObject(world.getObjects().get(i));
				}
				

			}
		}
	}
	
	public void keepInside(MainBall mb) {
		if (!mb.isInside()) {
			world.getWorld().destroyBody(mb.body);
			addMainBall();
		}
			
	}
	
	public Vec2 getMainBallPos() {
		return mbPos;
	}
	
	public void setMainBallPos(Vec2 v) {
		mbPos = v;
	}
	
	public void addMainBall() {
		//add main ball to its initial position

		mb = new MainBall(new Vec2(mbPos.x, mbPos.y));
		WorldController.addObject(mb);
	}
	
	
	public Launcher haveLauncher() {
		return haveLauncher;
	}
	

}
