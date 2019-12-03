package Damn;

//класс реализующий вызова отрисовки и обновления Frame ровно x раз в секунду

public class Timer extends Thread {

	Display d;
	int Mustups;
	double needupdates = 1;
	double Second = 1000000000;
	double UpdateTime;
	long count = 0;
	double fpsCount = 0;
	int fps = 0;
	int ups = 0;
	int upl = 0;
	
	//v2
	
	double renderTime;
	

	Timer(Display _d, int _mustups) {

		d = _d;
		Mustups = _mustups;
		UpdateTime = Second / Mustups;
		renderTime = UpdateTime;
		
	}
	
	public void setSettings(double mustups){
		
		UpdateTime = Second / mustups;
		renderTime = UpdateTime;	
	}
	
	public void setSettings(double mustups,double mustfps){
		
		UpdateTime = Second / mustups;
		renderTime = Second / mustfps;;		
	}
	

	public void run() {
		boolean updated = false;
		long pastTime = 0;
		long lastTime = System.nanoTime();
		long currientTime = 0;

		while (!isInterrupted()) {
			currientTime = System.nanoTime();
			pastTime = currientTime - lastTime;
			lastTime = currientTime;

			needupdates += pastTime / UpdateTime;
			
			count += pastTime;
			fpsCount += pastTime;
			
			while (needupdates > 1) {

				d.update();
				ups++;

				if (updated) {

					upl++;

				}

				updated = true;
				needupdates--;

			}

			if (updated && fpsCount / renderTime >= 1) {
				fpsCount -= renderTime;
				d.render();
				fps++;
			} else {

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			updated = false;

			if (count >= Second) {

				count -= Second;
				
				d.setTitle("fps : " + fps + " | " + "ups : " + ups + " | " + "upl : " + upl );
				
				fps = 0;
				ups = 0;
				upl = 0;

			}

		}

	}

}
