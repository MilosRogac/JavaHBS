package main;

public class Player {
	
	private int id;
	private String firstName;
	private String lastName;
	private String position;
	private double pointsPerGame;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getPointsPerGame() {
		return pointsPerGame;
	}
	public void setPointsPerGame(double pointsPerGame) {
		this.pointsPerGame = pointsPerGame;
	}
	public Player(int id, String firstName, String lastName, String position, double pointsPerGame) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.pointsPerGame = pointsPerGame;
	}
	
	
	

}
