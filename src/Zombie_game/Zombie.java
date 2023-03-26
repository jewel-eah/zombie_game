package Zombie_game;

class Zombie extends Unit {

	private int power;

//	int hp, String name, int max, int pos
	public Zombie() {
		super(200, "어딘가찌릿지은좀비", 200, 5);
	}

	public Zombie(int hp, String name, int max, int pos) {
		super(hp, name, max, pos);
	}

	@Override
	public String toString() {
		return String.format("[ WARNING !! ] '%s'의 등장 \n", super.getName());
	}

	public int getPower() {
		return this.power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void recovery() {

	}

	@Override
	public void attack(Unit hero) {
		this.power = ran.nextInt(hero.getMax()) + 1;
		System.err.printf("⚔️ %s(이/가) [ 데미지 %d ] 로 공격 ! \n", this.getName(), this.power);
		hero.setHp(hero.getHp() - power);

		if (hero.getHp() < 0) {
			hero.setHp(0);
			System.out.println(hero.getName() + "의 패배 ");
		}
	}
}
