package com.prospecta.entity;

import java.util.List;

import javax.persistence.Entity;


public class Data {
	
	
	private int count;
	
	private List<Entry> entries;
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public List<Entry> getEntries() {
		return entries;
	}
	
	
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
	
	
	@Override
	public String toString() {
		return "Data [count=" + count + ", entries=" + entries + "]";
	}
	
	

}
