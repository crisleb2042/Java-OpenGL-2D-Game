package org.graphics;

import org.input.KeyInput;
import org.input.MouseInput;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Renderer {
	
	private static GLProfile profile = null;
	
	public static int screenWidth = 640;
	public static int screenHeight = 360;
	
	// 10 units fit in the width of the screen
	public static float unitsWide = 10;
	
	private static GLWindow window = null;
	
	public static void init () {
		GLProfile.initSingleton();
		profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		
		window = GLWindow.create(caps);
		window.setSize(screenWidth, screenHeight);
		window.setResizable(false);
		window.addGLEventListener(new EventListener());
		window.addMouseListener(new MouseInput());
		window.addKeyListener(new KeyInput());
		
		
		// Rendering Loop to keep the window continuously rendering
		//FPSAnimator animator = new FPSAnimator(window, 60);
		//animator.start();
		
		// Sets the Screen to full
		window.setFullscreen(true);
		window.setVisible(true);
		window.requestFocus();
		
	}

	public static void renderer() {
		if (window == null) {
			return;
		}
		window.display();
	}
	public static int getWindowWidth( ) {
		return window.getWidth();
	}
	
	public static int getWindowHeight() {
		return window.getHeight();
	}
	
	public static GLProfile getProfile() {
		return profile;
	}

}
