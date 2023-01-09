package com.prospecta.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.entity.Entry;

@Repository
public interface entityDao extends JpaRepository<Entry, Integer> {

}
