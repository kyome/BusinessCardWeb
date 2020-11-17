package com.tsis.businesscard.image.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tsis.businesscard.image.dao.ImageDao;
import com.tsis.businesscard.vo.EmployeeVO;
import com.tsis.businesscard.vo.ImageVO;

@Service
public class ImageServiceImpl implements ImageService {
	private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);
	
	@Resource(name= "uploadPath")
	String FILE_PATH;
	//private static final String FILE_PATH = "D:\\dev\\file\\";
	
	@Autowired
	ImageDao imageDao;
	
	@Override
	public ImageVO getBusinessCardImageBySeq(EmployeeVO vo) {
		return imageDao.getBusinessCardImageBySeq(vo);
	}

	@Override
	public boolean uploadImage( HttpServletRequest req, int empSeq, String fileCd, MultipartFile multipartFile) {
		ImageVO insertVO = getFileVO(multipartFile);
		insertVO.setEmpSeq(empSeq);
		insertVO.setFileCd(fileCd);	
		if(imageDao.insertImageInfo(insertVO) > 0) {
			try {
				multipartFile.transferTo(new File(insertVO.getPath() + insertVO.getFileName()));
				return true;
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private ImageVO getFileVO(MultipartFile multipartFile) {
        // 저장 디렉토리 생성
		File dir = new File(FILE_PATH); 
        if (!dir.isDirectory()) { 
            dir.mkdirs(); 
        } 
        
		// 파일 정보
		String originFilename = multipartFile.getOriginalFilename();
		String extName = "";
		if ( originFilename.lastIndexOf(".") > 0 ) {
			extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
		}
		Long size = multipartFile.getSize();
		// 서버에서 저장 할 파일 이름
		String saveFileName = UUID.randomUUID().toString().replaceAll("-", "")+extName;
		
		// 확인
		logger.debug("originFilename : " + originFilename);
		logger.debug("extensionName : " + extName);
		logger.debug("size : " + size);
		logger.debug("saveFileName : " + saveFileName);
		
		ImageVO insertVO = new ImageVO(); 
		insertVO.setOriginalName(originFilename);
		insertVO.setFileName(saveFileName);
		insertVO.setPath(FILE_PATH);
		
		return insertVO;
		
	}

	@Override
	public boolean hasBusinessCardBySeq(EmployeeVO insertVO) {
		if(imageDao.hasBusinessCardBySeq(insertVO) > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	

//	private void saveFile(MultipartFile multipartFile, String saveFileName) throws IOException {
//		boolean result = false;
//		byte[] data = multipartFile.getBytes();
//		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
//		fos.write(data);
//		fos.close();
//			
//	}

}
