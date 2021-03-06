package com.tsis.businesscard.employee.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.tsis.businesscard.employee.service.EmployeeService;
import com.tsis.businesscard.image.service.ImageService;
import com.tsis.businesscard.message.service.MessageService;
import com.tsis.businesscard.vo.EmployeeVO;
import com.tsis.businesscard.vo.ImageVO;
import com.tsis.businesscard.vo.SendHistoryVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BusinessCardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BusinessCardController.class);
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	MessageService messageService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws JsonProcessingException 
	 */
	@ResponseBody
	@RequestMapping(value = "/employee/info",produces="application/json;charset=UTF-8", method = RequestMethod.GET)
	public String getEmployeeBySeq(@RequestParam int seq,
			HttpSession session)  {
	
		EmployeeVO employeeVO = employeeService.getEmployeeBySeq(seq);
		Gson gson = new Gson();
		return gson.toJson(employeeVO);
	}
	
	// 세션 테스트
	@ResponseBody
	@RequestMapping(value = "/test/session",produces="application/json;charset=UTF-8", method = RequestMethod.GET)
	public HttpServletResponse testSession( 
			HttpServletRequest req,
			HttpServletResponse res,
			HttpSession session)  {
		
		String data = "server data";
		
		session.setAttribute("data", data);
		System.out.println(req.getSession().getId());
		System.out.println(session.getId());
		
		
//		for(Cookie c : req.getCookies()) {
//			
//			System.out.println(c.toString());
//		}
		
		
		return res;
	}
	
	@ResponseBody
	@RequestMapping(value = "/employee/businessCard", method = RequestMethod.POST)
	public String saveBusinessCardTest( HttpServletRequest req,
			HttpServletResponse res,
			@RequestParam String seq,
			@RequestParam MultipartFile file ) {
		if( imageService.uploadImage(req, Integer.parseInt(seq), "BC", file)) {
			res.setStatus(HttpServletResponse.SC_OK);
			return "true";
		}else {
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "false";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/employee/hasBusinessCard", method = RequestMethod.GET)
	public String hasBusinessCard( @RequestParam String seq ) {
		if (seq == "" ) {
			return "false";
		}
		
		EmployeeVO vo = new EmployeeVO();
		vo.setSeq(Integer.parseInt(seq));
		
		if( imageService.hasBusinessCardBySeq(vo)) {
			return "true";
		}else {
			return "false";
		}
	}
			
	
	@ResponseBody
	@RequestMapping(value = "/employee/businessCard/{seq}", method = RequestMethod.GET)
	public void getBusinessCard(HttpServletResponse response, @PathVariable("seq") String seq) {
		// 사원정보 VO 생성
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setSeq(Integer.parseInt(seq));
		
		// 명함VO 가져오기
		
		ImageVO imageVO = imageService.getBusinessCardImageBySeq(employeeVO);
		if (imageVO == null) {
			return;
		} else {
			System.out.println(imageVO);
		}
		
		// VO정보로 Byte생성
		InputStream imageStream = null;
		try {
			imageStream = new FileInputStream(imageVO.getPath() + imageVO.getFileName());
			byte[] imageByteArray = IOUtils.toByteArray(imageStream);
			response.setStatus(HttpServletResponse.SC_OK);
			response.getOutputStream().write(imageByteArray);
			
		    response.getOutputStream().flush();
		    response.getOutputStream().close();
			imageStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {               
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "/send/businessCard", method = RequestMethod.POST)
	public String sendBusinessCard(@RequestBody String requestJson) {
		Gson gson = new Gson();
		SendHistoryVO sendInfo = gson.fromJson(requestJson, SendHistoryVO.class);
		
		System.out.println(requestJson.toString());
		if( messageService.sendMessage(sendInfo)) {
			return "true";
		}else {
			return "false";
		}
	}
	
}
