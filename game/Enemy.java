package game;

public class Enemy extends Unit {

	//instance variables: none
	
	//class constructors
	public Enemy(String name, int maxhp, int hit, int atk, int def) {
		//enemy can only move two tiles per turn
		super(name,maxhp,hit,atk,def);
	}
}