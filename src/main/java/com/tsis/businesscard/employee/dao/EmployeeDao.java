package com.tsis.businesscard.employee.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsis.businesscard.vo.EmployeeVO;

@Repository
public class EmployeeDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public EmployeeVO getEmployeeBySeq(int seq) {
      	 return session.selectOne("employee.getEmployeeBySeq",seq);
      }
	
}
