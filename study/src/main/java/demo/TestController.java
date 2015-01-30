package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class TestController {
	
	@Autowired private UserRepository userRepository;
	
	private Logger logger = LoggerFactory.getLogger("logback.test");
	
	/*@RequestMapping("/")
	@ResponseBody
	public User helloworld() {
		 logger.info(" 로그백 파일로그 테스트");
		 
		 return userRepository.(1l);
	}*/
	
	@RequestMapping("/user")
	@ResponseBody
	public List<User> helloworld2() {
		
		return userRepository.findByAgeAndName("2", "3");
	}
	
	@RequestMapping("/user2")
	@ResponseBody
	public List<User> getUser() {
		
		return userRepository.findAll();
	}
	
	
	
	
	@RequestMapping(value="/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("userName1", "이돈일");
		modelAndView.addObject("userName2", "이지훈");
		
		List<Map<String,String>> messagesList = new ArrayList<Map<String,String>>();
		Map<String, String> messagesMap = new HashMap<String, String>();
		messagesMap.put("name", "이돈일");
		messagesMap.put("email", "test@naver.com");
		messagesMap.put("phone", "0101234567");
		messagesMap.put("website", "naver.com");
		messagesList.add(messagesMap);
		
		messagesMap = new HashMap<String, String>();
		messagesMap.put("name", "이지훈");
		messagesMap.put("email", "test2@naver.com");
		messagesMap.put("phone", "0102234567");
		messagesMap.put("website", "naver2.com");
		messagesList.add(messagesMap);
		
		
		
	
		
		modelAndView.addObject("messages", messagesList);
		return modelAndView;
	}
}
