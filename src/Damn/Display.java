 package Damn;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;


//класс хранящий список Frame,и реализующий перключение между фреймами ,их обновление и отрисовку

public class Display {

	ArrayList<Frame> frameList = new ArrayList<Frame>();
	Frame currientFrame;

	JFrame window;
	Canvas content;

	BufferStrategy bufferStrategy;
	
	DamnMouseListener mListener = new DamnMouseListener();
	DamnMouseMoutionListener mMListener = new DamnMouseMoutionListener();
	DamnKeyListener kListener = new DamnKeyListener();
	
	//v2
	Timer timer = new Timer(this,120);
	
	public  Display(String name, int width, int height, int numBuffers) {

		window = new JFrame(name);
		window.setSize(width, height);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setResizable(false);
		

		content = new Canvas();
		content.setBounds(0, 0, width, height);
		window.add(content);
		
		content.addMouseListener(mListener);
		content.addMouseMotionListener(mMListener);
		content.addKeyListener(kListener);
		
		window.setVisible(true);
		content.createBufferStrategy(numBuffers);
		bufferStrategy = content.getBufferStrategy();

	}

	
	public void start(){
		timer.start();
		
	}
	
	public void setTimerSettings(double mustups){
		
		timer.setSettings(mustups);
	}
	
	public void setTimerSettings(double mustups,double mustfps){
		
		timer.setSettings(mustups, mustfps);
	}

	public void addFrame(Frame f) {

		f.link(this);
		frameList.add(f);

	}

	 void update() {

		currientFrame.update();

	}

	 void render() {
		Graphics g = bufferStrategy.getDrawGraphics();
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.clearRect(0, 0, content.getWidth(), content.getHeight());
		currientFrame.draw(g);
		bufferStrategy.show();

	}


	 public void setCurrientFrame(String _name) {

		for (Frame f : frameList) {

			if (f.name.equals(_name)) {

				currientFrame = f;
				mListener.changeList(currientFrame.mComponents);
				mMListener.changeList(currientFrame.mMComponents);
				kListener.changeList(currientFrame.kComponents);
				currientFrame.settingsOnSetCurrient();
				break;

			}

		}

	}
	
	public void setTitle(String s){
		
		window.setTitle(s);
		
	}
	
	public void addComponentToKeyListener(DamnComponent c){
		kListener.addComponent(c);

	}
	
	public void addComponentToMouseListener(DamnComponent c){
		mListener.addComponent(c);

	}
	
	public void addComponentToMouseMoutionListener(DamnComponent c){

		mMListener.addComponent(c);
		
	}
		

//test functions
	public void addKeyListener(KeyListener l){
		content.addKeyListener(l);
	}
	
	public void RemoveKeyListeners(){
		for( KeyListener k : content.getKeyListeners()){
			content.removeKeyListener(k);
		}
	}

}
