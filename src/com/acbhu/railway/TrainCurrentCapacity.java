package com.acbhu.railway;

public class TrainCurrentCapacity {
	
	private int totalBirthCount;
	private int lowerBirthCount;
	private int middleBirthCount;
	private int upperBirthCount;
	private int RACcount;
	private int waitingListCount;
	
	public TrainCurrentCapacity(int lowerBirthCount, int middleBirthCount, int upperBirthCount, int rACcount,
			int waitingListCount) {
		super();
		this.lowerBirthCount = lowerBirthCount;
		this.middleBirthCount = middleBirthCount;
		this.upperBirthCount = upperBirthCount;
		RACcount = rACcount;
		this.waitingListCount = waitingListCount;
	}
	
	public int getTotalBirthCount() {
		return totalBirthCount;
	}
	public void setTotalBirthCount(int totalBirthCount) {
		this.totalBirthCount = totalBirthCount;
	}
	public int getLowerBirthCount() {
		return lowerBirthCount;
	}
	public void setLowerBirthCount(int lowerBirthCount) {
		this.lowerBirthCount = lowerBirthCount;
	}
	public int getMiddleBirthCount() {
		return middleBirthCount;
	}
	public void setMiddleBirthCount(int middleBirthCount) {
		this.middleBirthCount = middleBirthCount;
	}
	public int getUpperBirthCount() {
		return upperBirthCount;
	}
	public void setUpperBirthCount(int upperBirthCount) {
		this.upperBirthCount = upperBirthCount;
	}
	public int getRACcount() {
		return RACcount;
	}
	public void setRACcount(int rACcount) {
		RACcount = rACcount;
	}
	public int getWaitingListCount() {
		return waitingListCount;
	}
	public void setWaitingListCount(int waitingListCount) {
		this.waitingListCount = waitingListCount;
	}
	
	

}
