import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Damn.DamnTextBox;
import Damn.Frame;
import java.awt.event.KeyEvent;

public class OkroshkaFrame extends Frame{
	
	KeyEvent e ;
	int  h;
	boolean start = false;
	
	DamnTextBox textBox  = new DamnTextBox(100,100,100,40,new Color(0xffffffff));
	DamnTextBox keyTExt  = new DamnTextBox(100,200,100,40,new Color(0xffffffff));
	DamnTextBox okroshkaBox  = new DamnTextBox(300,100,100,40,new Color(0xffffffff));
	DamnTextBox inverseOkroshkaBox  = new DamnTextBox(300,200,100,40,new Color(0xffffffff));
	
	public OkroshkaFrame() {
		super("OkroshkaFrame");
		
	}

	@Override
	public void update() {
					
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D gg = (Graphics2D) g;

		gg.setBackground(new Color(0xff000000));
		gg.clearRect(0, 0, 750, 500);
		
		textBox.draw(gg);
		okroshkaBox.draw(gg);
		keyTExt.draw(gg);
		inverseOkroshkaBox.draw(gg);
	}
	
	public void keyTyped(KeyEvent e){
		
		
		//System.out.println();
		if((int) e.getKeyChar() == 10)
			generateOkroska();
	}
	
	public void generateOkroska(){
		
		String keyForm = "";
		String text = textBox.getText();
		String okroshka = "";
		String key = keyTExt.getText();
		String inverseOkroshka ="";
		
		if(text.length() < 1 | key.length() < 1)
			return;
		
		while(keyForm.length() < text.length()){
			
			keyForm+=key;
		}
		
		for(int i = 0;i<text.length();i++){
			
			char res = (char) (text.charAt(i) ^ keyForm.charAt(i));
			okroshka +=res;
		}
		
		okroshkaBox.setText(okroshka + "|ThisisEnd");
		
		for(int i = 0;i<okroshka.length();i++){
			
			char res = (char) (okroshka.charAt(i) ^ keyForm.charAt(i));
			inverseOkroshka +=res;
		}
		
		inverseOkroshkaBox.setText(inverseOkroshka);
	}

	@Override
	public void SetTextures() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFirstCall() {
		
		addToKeyListenerComponent(this);
		
		addToKeyListenerComponent(textBox);
		addToMouseListenerComponent(textBox);
		
		addToKeyListenerComponent(keyTExt);
		addToMouseListenerComponent(keyTExt);
		
		addToKeyListenerComponent(inverseOkroshkaBox);
		addToMouseListenerComponent(inverseOkroshkaBox);
		
		addToKeyListenerComponent(okroshkaBox);
		addToMouseListenerComponent(okroshkaBox);
		
		textBox.setName("String");
		okroshkaBox.setName("Okroshka");
		keyTExt.setName("keyText");
		inverseOkroshkaBox.setName("inverseOkroshkaBox");
		
	}

	@Override
	public void onCall() {
		// TODO Auto-generated method stub
		
	}

}
