package project.test.DTO;

public class Block {
	
	private String room; //호실, 복도, 비상구 표시
	private int areaNumber; //고유값 
	private String color;
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getAreaNumber() {
		return areaNumber;
	}
	public void setAreaNumber(int areaNumber) {
		this.areaNumber = areaNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
