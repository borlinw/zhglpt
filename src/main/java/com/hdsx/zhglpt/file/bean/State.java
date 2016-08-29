package com.hdsx.zhglpt.file.bean;

public class State {
	private Long readedBytes=0L;
	private long totalBytes = 0L;
	private int currentItem = 0;
	private int rate=0;//����
	public Long getReadedBytes() {
		return readedBytes;
	}
	public void setReadedBytes(Long readedBytes) {
		this.readedBytes = readedBytes;
	}
	public long getTotalBytes() {
		return totalBytes;
	}
	public void setTotalBytes(long totalBytes) {
		this.totalBytes = totalBytes;
	}
	public int getCurrentItem() {
		return currentItem;
	}
	public void setCurrentItem(int currentItem) {
		this.currentItem = currentItem;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
