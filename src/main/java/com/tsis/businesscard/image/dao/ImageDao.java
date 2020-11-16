package com.tsis.businesscard.image.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsis.businesscard.vo.EmployeeVO;
import com.tsis.businesscard.vo.ImageVO;

@Repository
public class ImageDao  {

	@Autowired
	private SqlSessionTemplate session;

	public int hasBusinessCardBySeq(EmployeeVO insertVO) {
     	 return session.selectOne("image.hasBusinessCardBySeq",insertVO);
     }
	
	public ImageVO getBusinessCardImageBySeq(EmployeeVO insertVO) {
      	 return session.selectOne("image.getBusinessCardImageBySeq",insertVO);
      }

	public int insertImageInfo(ImageVO insertVO) {
		return session.insert("image.insertImageInfo",insertVO);
	}
}
