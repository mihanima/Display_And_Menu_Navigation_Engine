package PokemonGoAttacksSimulator;

public class AttackCombo {
	Attack attack;
	SuperAttack superAttack;
	int damage;
	int energy;
	int SuperAttackActivated;
	int timeLeft;
	public void tick(int time){
		
		if(superAttack.currientEnergy >= superAttack.needEnergy && SuperAttackActivated == 0){
			superAttack.currientEnergy -= superAttack.needEnergy;
			SuperAttackActivated = 1;
			timeLeft = superAttack.Time;
		}
		
		if(timeLeft > 0)
			timeLeft --;
		else if(SuperAttackActivated == 1 ){
			damage += superAttack.damage;
			SuperAttackActivated = 0;
		}else{
			damage += attack.dps;
			energy += attack.eps;
			superAttack.currientEnergy += attack.eps;
			
		}
		
	}
}
