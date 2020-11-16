package com.tsis.businesscard.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsis.businesscard.employee.dao.EmployeeDao;
import com.tsis.businesscard.vo.EmployeeVO;

@Service 
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired 
	EmployeeDao employeeDao; 
	
	@Override
	public EmployeeVO getEmployeeBySeq(int seq){
		return employeeDao.getEmployeeBySeq(seq);
	}

}