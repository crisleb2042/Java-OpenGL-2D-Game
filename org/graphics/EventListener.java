package org.graphics;

import org.resource.ImageResource;
import org.world.World;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener{
	
	public static GL2 gl = null;
	public static ImageResource image = null;

	@Override
	public void display(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		
		// clears screen
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

		World.render();
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		// background color
		gl.glClearColor(0, 0, 0, 1);
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		
		image = new ImageResource("/res/OIP.jpg");
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		float unitsTall = Renderer.getWindowHeight() / (Renderer.getWindowWidth() / Renderer.unitsWide);
		
		// screen units (x = 640, y = 360)
		// sets the units for the pixels on screen
		gl.glOrthof(-Renderer.unitsWide/2, Renderer.unitsWide/2, -unitsTall / 2, unitsTall/2, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		
		
	}

}
