package com.ssafy.mvc.dto;

public class BTC implements Comparable<BTC>{
	String shop, name;
	int level, rvCnt;
	double grade;
	
	public BTC(String shop, String name, int level, int rvCnt, double grade) {
		this.shop = shop;
		this.name = name;
		this.level = level;
		this.rvCnt = rvCnt;
		this.grade = grade;
	}
	
	@Override
	public int compareTo(BTC o) {
		return Double.compare(o.grade, this.grade);
	}
	
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getRvCnt() {
		return rvCnt;
	}
	public void setRvCnt(int rvCnt) {
		this.rvCnt = rvCnt;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "BTC [shop=" + shop + ", name=" + name + ", level=" + level + ", rvCnt=" + rvCnt + ", grade=" + grade
				+ "]";
	}
	
	
	
}
