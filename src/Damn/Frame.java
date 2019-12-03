package Damn;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.ArrayList;

//наследуемый класс,реализованный для нормальной работы Display

public abstract class Frame extends DamnComponent{
	
	ArrayList<DamnComponent> mComponents = new ArrayList<DamnComponent>();
	ArrayList<DamnComponent> mMComponents = new ArrayList<DamnComponent>();
	ArrayList<DamnComponent> kComponents = new ArrayList<DamnComponent>();
	
	String name;
	Display d;

	public  Frame(String _name){
		
		super(0,0,0,0);
		
		name = _name;
		
	}
	
	boolean firstCall = false;
	public abstract void onFirstCall();
	
	public abstract void onCall();
	
	public abstract void update();
	
	public abstract void SetTextures();
	
	public void link(Display _d) {
		d = _d;

	}
	
	public void setTimerSettings(double mustups){
		
		d.setTimerSettings(mustups);
	}
	
	public void setTimerSettings(double mustups,double mustfps){
		
		d.setTimerSettings(mustups, mustfps);
	}

	public void change(String _name) {
		d.setCurrientFrame(_name);
		
	}
	
	public void settingsOnSetCurrient(){
		if(!firstCall){
			onFirstCall();
			firstCall = true;
		}
		
		onCall();
		SetTextures();
	}
	
	protected void addToMouseListenerComponent(DamnComponent c){
		d.addComponentToMouseListener(c);

	}
	
	protected void addToKeyListenerComponent(DamnComponent c){
		d.addComponentToKeyListener(c);


	}
	
	protected void addToMouseMoutionListenerComponent(DamnComponent c){

		d.addComponentToMouseMoutionListener(c);

	}
		
}
