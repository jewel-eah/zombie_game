package Zombie_game;

import java.util.Random;

// 수퍼클래스 ( 부모 ) 

abstract class Unit {

	private final int MAX_HP;
	private int hp;
	private int pos;
	private String name;
	public Random ran;
	
	public String toString() {
		return String.format("[ 룰루 랄라 ~ ] 오늘도 [ %s ]은 여행을 떠나는데 . . ", this.name);
	}
	
	
	public Unit (int hp, String name, int max, int pos) {
		MAX_HP = max;
		this.hp = hp;
		this.name = name;
		ran = new Random();
	}
	

	public int getPos() {
		return this.pos;
	}
	
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getMax() {
		return this.MAX_HP;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	
	abstract void attack (Unit unit);
	
}
