package com.prospecta.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.hibernate.boot.model.source.spi.SecondaryTableSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prospecta.entity.Data;
import com.prospecta.entity.Entry;
import com.prospecta.entity.ResultDTO;
import com.prospecta.service.entryService;

@RestController
public class MyController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private entryService e1;
	
	
	@GetMapping("/entries/{category}")
	public List<ResultDTO> getEntriesHandler(@PathVariable("category") String category){
		
		
		Data d= restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		
		List<Entry> entries= d.getEntries();
	
		List<ResultDTO> list = new ArrayList<>();
		
		for(Entry en:entries) {
			
			if(en.getCategory().equals(category))
				list.add(new ResultDTO(en.getApi(), en.getDescription()));
		}
		
		
		//List<ResultDTO> list= entries.stream().filter(e -> e.getCategory().equals(category)).map(e -> new ResultDTO(e.getApi(), e.getDescription())).toList();
		
		
		
		
		 
		return list;
		
	}
	
	
	@GetMapping("/entries/getCategories")
	public List<String> getallCategoriessHandler(){
		
		
		Data d= restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		
		List<Entry> entries= d.getEntries();
	
		List<String> list = new ArrayList<>();
		
		for(Entry en:entries) {
			
			list.add(en.getCategory());
			System.out.println(en.getCategory());
		}
		
	return list;
		
	}
	
	
	
//	@PostMapping("/entries/add")
//	public ResponseEntity<Entry> saveEntriesHandler(@RequestBody Entry entry) {
//		
//		
//		
////		Data d= restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
////		
////		
////		List<Entry> entries= d.getEntries();
//	     Entry entry2 = e1.addEntry(entry);
//	//  entries.add(entry);
//		return new ResponseEntity<Entry>(entry2,HttpStatus.ACCEPTED);
//		
//	}
	
	
}
