package com.tsis.businesscard.image.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.tsis.businesscard.vo.EmployeeVO;
import com.tsis.businesscard.vo.ImageVO;

public interface ImageService {

	public ImageVO getBusinessCardImageBySeq(EmployeeVO vo);

	public boolean uploadImage( HttpServletRequest req, int empSeq, String fileCd, MultipartFile multipartFile);

}