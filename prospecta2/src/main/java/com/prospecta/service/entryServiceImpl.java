package com.prospecta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.prospecta.Dao.entityDao;
import com.prospecta.Exception.entryException;
import com.prospecta.entity.Entry;

@Service
public class entryServiceImpl implements entryService {

	@Autowired
	private entityDao adao;
	
	
	
	@Override
	public Entry addEntry(Entry entry) {
		// TODO Auto-generated method stub
		
		return adao.save(entry);
		
	}
	
	
	@Override
	public List<Entry>getByHealth() throws entryException {
		List<Entry> list= adao.findAll();
		
		List<Entry> hlist= new ArrayList<>();
		
		for(Entry i:list) {
			if(i.getCategory().equals("health"))
			{
				hlist.add(i);
			}
		}
		if(list.size()==0 || hlist.size()==0) {
			throw new entryException("No Heath Category found");
		}
		
		return hlist;
	}
	
	@Override
	public Entry getByRandom() throws entryException {
		
		List<Entry> list= adao.findAll();
		
		if(list.size()==0) {
			throw new entryException("Nothing found in list");
		}
		int max= list.size()-1;
		int min=0;	
		Integer rand=(int) ((Math.random() * (max - min)) + min);
		
		return list.get(rand);
	}




	

}
