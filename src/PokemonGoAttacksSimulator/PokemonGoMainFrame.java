package PokemonGoAttacksSimulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import Damn.DamnTextBox;
import Damn.Frame;

public class PokemonGoMainFrame extends Frame{
	
	ArrayList<Attack> attaks = new ArrayList<Attack>();
	ArrayList<SuperAttack> superAttacks = new ArrayList<SuperAttack>();
	ArrayList<AttackCombo> attacksCombo = new ArrayList<AttackCombo>();
	
	DamnTextBox attackName = new DamnTextBox(100,100,150,40,new Color(0xffffffff));
	DamnTextBox dps = new DamnTextBox(270,100,100,40,new Color(0xffffffff));
	DamnTextBox eps = new DamnTextBox(390,100,100,40,new Color(0xffffffff));
	DamnTextBox superAttackName = new DamnTextBox(100,200,200,40,new Color(0xffffffff));
	DamnTextBox needEnergy = new DamnTextBox(320,200,100,40,new Color(0xffffffff));
	DamnTextBox Time = new DamnTextBox(440,200,100,40,new Color(0xffffffff));
	DamnTextBox damage = new DamnTextBox(560,200,100,40,new Color(0xffffffff));
	DamnTextBox pokemonName = new DamnTextBox(225,60,250,40,new Color(0xffffffff));

	public PokemonGoMainFrame() {
		super("PokemonGoMainFrame");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onFirstCall() {

		addToKeyListenerComponent(attackName);
		addToMouseListenerComponent(attackName);

		addToKeyListenerComponent(dps);
		addToMouseListenerComponent(dps);

		addToKeyListenerComponent(eps);
		addToMouseListenerComponent(eps);

		addToKeyListenerComponent(superAttackName);
		addToMouseListenerComponent(superAttackName);

		addToKeyListenerComponent(needEnergy);
		addToMouseListenerComponent(needEnergy);

		addToKeyListenerComponent(Time);
		addToMouseListenerComponent(Time);

		addToKeyListenerComponent(damage);
		addToMouseListenerComponent(damage);
		
		addToKeyListenerComponent(pokemonName);
		addToMouseListenerComponent(pokemonName);

		attackName.setName("attackName");
		dps.setName("dps");
		eps.setName("eps");
		superAttackName.setName("superAttackName");
		needEnergy.setName("needEnergy");
		Time.setName("Time");
		damage.setName("damage");
		pokemonName.setName("pokemonName");
		
		
	}

	@Override
	public void onCall() {
		setTimerSettings(240,60);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SetTextures() {
		// TODO Auto-generated method stub
		
	}

	public void draw(Graphics g) {

		Graphics2D gg = (Graphics2D) g;

		gg.setBackground(new Color(0xff0000ff));

		gg.clearRect(0, 0, 990, 990);

		attackName.draw(g);
		dps.draw(g);
		eps.draw(g);
		superAttackName.draw(g);
		needEnergy.draw(g);
		Time.draw(g);
		damage.draw(g);
		pokemonName.draw(g);
		
		g.drawString("Number of attacks: " + attaks.size(), 200, 300);
		g.drawString("Number of superattacks: " + superAttacks.size(), 450, 300);
		

	}
}
