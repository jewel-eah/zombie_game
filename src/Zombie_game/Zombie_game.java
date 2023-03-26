package Zombie_game;

import java.util.Scanner;

class Zombie_game {

	public static final Hero HERO = new Hero(200, "힘순찐보석", 200, 1);
//							int hp / string name / int max / int po , shield
	Boss boss = new Boss(400, "죽지도않고또나타난세린느발록", 400, 15, 150);
	public Zombie monster;

	private Scanner scan;
	private int pos;

	public Zombie_game() {
		this.scan = new Scanner(System.in);
		init();
	}

//							int hp / String name / int max / int pos
	private void startSet() {
		System.out.println(HERO.toString());
		System.out.println(boss.toString());
	}

	private void monsterSet() {
		monster = new Zombie(50, "앙증맞은 파란 버섯", 50, 0);
	}

	private void move() {
		System.out.println("뚜벅뚜벅 - ~ 여전히 평화로운 마을 ~");
		pos++;
	}

	private void init() {
		startSet();
		monsterSet();
	}

	private int inputNumber() {
		System.out.print("당신의 선택은 ? : ");
		String input = scan.next();
		int select = -1;

		try {
			select = Integer.parseInt(input);
			if (select >= 1 && select < 3) {
				return select;
			}
		} catch (Exception e) {
			System.err.println("잘못된 입력입니다.");
		}
		return select;
	}

	private void fightOrRun() {
		System.out.println("1. 결투신청");
		System.out.println("2. 못본척하기");
		int select = inputNumber();

		if (select == 1) {
			if (this.pos == 5) {
				fight();
			} else if (this.pos == 15) {
				fight();
			}

		} else if (select == 2) {
			System.out.println("---------------------------------------------");
			System.out.printf("[ SYSTEM ] 나약한 %s은 그렇게 땅만 보고 걸어갔다 ..\n", HERO.getName());
			System.out.println("---------------------------------------------");
		} else {
			System.out.println("---------------------------");
			System.out.println("둘 중에 하나만 골라 yes or no ~ ");
			System.out.println("---------------------------");
		}

	}

	private void printHp() {
		System.out.printf("%s [HP :%d/%d]\n", HERO.getName(), HERO.getHp(), HERO.getMax());
		if (this.pos == 5) {
			System.out.printf("%s [HP :%d/%d]\n", monster.getName(), monster.getHp(), monster.getMax());
		} else if (this.pos == 15) {
			System.out.printf("%s [HP :%d/%d]\n", boss.getName(), boss.getHp(), boss.getMax());

		}
	}

	private void fightOrRecovoery() {
		printHp();
		System.out.println("1. 공격");
		System.out.println("2. 포션");
		System.out.print("선택 : ");
		int select = scan.nextInt();
		if (this.pos == 5) {
			if (select == 1) {
				HERO.attack(monster);
			} else if (select == 2) {
				HERO.recovery();
				HERO.attack(monster);
			}
		} else if (this.pos == 15) {
			if (select == 1) {
				HERO.attack(boss);
			} else if (select == 2) {
				HERO.recovery();
				HERO.attack(boss);
			}
		}
	}

	private void fight() {
		if (HERO instanceof Hero) {
			System.out.println("-------------------");
			System.out.println("[ ⚔️ 결투장 입장 ⚔️ ]");

			// 보스몹
			if (this.pos == 15) {
				while (true) {
					printHp();
					if(HERO.getHp() > 0) {
						boss.attack(HERO);
						if(HERO.getHp() == 0) {
							printHp();
							break;
						}
					}
					if(boss.getHp() > 0) {
						fightOrRecovoery();
						if(boss.getHp() == 0) {
							printHp();
							break;
						}
					}
				}
				System.err.println(" -- 결투 종료 -- ");
				HERO.setHp(HERO.getMax());
			}

			// 일반 몬스터
			else if (this.pos == 5) {
				while (true) {
					printHp();
					if(HERO.getHp() > 0) {
						monster.attack(HERO);
						if(HERO.getHp() == 0) {
							printHp();
							break;
						}
					}
					if(monster.getHp() > 0) {
						fightOrRecovoery();
						if(monster.getHp() == 0) {
							printHp();
							break;
						}
					}
				}
				System.err.println(" -- 결투 종료 -- ");
				HERO.setHp(HERO.getMax());
			}
		}
	}

	public void run() {
		while (true) {
			System.out.println("이동하기 : 1 ㅣ 종료 : 0 ");
			System.out.print("선택 : ");
			int select = scan.nextInt();

			if (select == 1) {
				move();
				System.out.println(this.pos);
				if (this.pos == 5) {
					System.err.println(monster.toString());
					fightOrRun();
				} else if (this.pos == 15) {
					System.err.println(boss.toString());
					fightOrRun();

				}
			} else if (select == 0) {
				System.out.println(" [ 게임이 종료되었습니다. ]");
				break;
			}
		}
	}
}
