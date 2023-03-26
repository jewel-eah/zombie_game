package Zombie_game;

class Hero extends Unit {

	private int power;
	private int count;

	public Hero(int hp, String name, int max, int pos) {
		super(hp, name, max, pos);
		this.count = 3;
	}

	@Override
	public void attack(Unit unit) {
		if (unit instanceof Boss) {
			Boss boss = (Boss) unit;
			this.power = ran.nextInt(boss.getMax() + 10);
			System.err.printf("⚔️ %s의 반격 ! [ 데미지 %d ]\n", super.getName(), this.power);
			
			
			if(boss.getShield() > 0) {
				int maxShield = boss.getShield();
				if(boss.getShield() > this.power) {
					boss.setShield(boss.getShield()-this.power);
					System.err.printf("[ %s의 실드 : %d / %d ]\n", boss.getName(), boss.getShield(),maxShield);
				}
				else {
					boss.setShield(0);
					System.err.printf("[ %s의 실드 : %d / %d ]\n", boss.getName(), boss.getShield(),maxShield);
					System.err.printf("[ %s의 실드가 파괴되었다 ! ]\n", boss.getName());
					boss.setHp(boss.getHp()-(this.power-maxShield));
				}
			}
			else  {
				boss.setHp(boss.getHp()-this.power);
			}

			if (boss.getHp() < 0) {
				boss.setHp(0);
				System.err.println(boss.getName() + "를 쓰러트렸다 !");
			}
			System.err.printf("[ %s의 HP : %d / %d ]\n",boss.getName(), boss.getHp() , boss.getMax());
		}
		else {
			this.power = ran.nextInt(unit.getMax()) + 1;
			System.err.printf("⚔️ %s의 반격 ! [ 데미지 %d ]\n", super.getName(), this.power);
			unit.setHp(unit.getHp() - this.power);
			
			if (unit.getHp() < 0) {
				unit.setHp(0);
				System.err.println(unit.getName() + "의 패배 ");
			}
		}
	}

	public void recovery() {
		if (count > 0) {
			this.setHp(this.getHp() + 100);
			if (this.getHp() > this.getMax()) {
				this.setHp(this.getMax());
			}
			count--;
			System.err.printf("남은 포션 [ %d개 ]\n", this.count);
		} else {
			System.err.printf("포션을 모두 사용하였습니다. [%d개]", this.count);
		}
	}

	public int getPower() {
		return this.power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
