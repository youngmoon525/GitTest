package test;

public class JapangiDTO {
	String[] bev = new String[6];
	int[] bevCount = new int[6];
	int[] bevCost = new int[6];

	public String[] getBev() {
		return bev;
	}

	public void setBev(int bevCount, String bevName) {
		this.bev[bevCount] = bevName;
	}

	public int[] getBevCount() {
		return bevCount;
	}

	public void setBevCount(int Count, int bevCount) {
		this.bevCount[Count] = bevCount;
	}

	public int[] getBevCost() {
		return bevCost;
	}

	public void setBevCost(int Count, int bevCost) {
		this.bevCost[Count] = bevCost;
	}

}
