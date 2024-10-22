package com.kh.testpro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckEmailController {
	
	@ResponseBody
	@RequestMapping(value = "CheckEmail", produces = "text/plain; charset=utf-8")
	public String CheckEmail(String email) {
		MemberDao dao = new MemberDao();
		boolean result = dao.isEmailExist(email);
		if(result) {
			return "이미 사용중인 email 입니다.";
		}else {
			return "사용 가능한 email 입니다.";
		}
	}
}
