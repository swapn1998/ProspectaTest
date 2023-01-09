package com.prospecta.service;

import java.util.List;
import com.prospecta.Exception.entryException;
import com.prospecta.entity.Entry;

public interface entryService {

	
	public Entry addEntry(Entry entry);
	
	public List<Entry> getByHealth() throws entryException;
	
	public Entry getByRandom() throws entryException;
}
