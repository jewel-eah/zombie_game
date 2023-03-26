package Zombie_game;

class Boss extends Zombie {

	private int power;
	private int critical;
	private int shield;

	public Boss(int hp, String name, int max, int pos, int shield) {
		super(hp, name, max, pos);
		this.shield = shield;
	}

	@Override
	public String toString() {
		return String.format("[ WARNING BOSS !!!] [ %s ]이(가) 출몰했다 . . ", super.getName());
	}

	public int getShield() {
		return this.shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	
	@Override
	public void attack(Unit hero) {
		this.power = ran.nextInt(hero.getMax()+ 20)+10;
		this.critical = ran.nextInt((hero.getMax()/5)*2)+10;
		
		int ranAttack = ran.nextInt(5) +1;
		if(ranAttack == 1) {
			System.err.printf("⚠️ [ CRITIACAL ] %s(이/가) [ 데미지 %d ] 로 공격 ! \n", this.getName(), this.critical);
			hero.setHp(hero.getHp() - this.critical);
		}
		else {
			System.err.printf("⚔️ %s(이/가) [ 데미지 %d ] 로 공격 ! \n", this.getName(), this.power);
			hero.setHp(hero.getHp() - this.power);
			
		}
		
		if (hero.getHp() < 0) {
			hero.setHp(0);
			System.out.println(hero.getName() + "의 패배 ");
		}
	}
}
