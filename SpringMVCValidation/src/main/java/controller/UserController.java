package controller;

import java.util.List;

import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value =  {"/create"}, method = RequestMethod.POST)
	@ResponseBody
	public String createUser(@Valid @ModelAttribute("createUser") User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return handleError(bindingResult);
		}
		return "createuser";
	}
	
	
	@SuppressWarnings("unchecked")
	public String handleError(BindingResult bindingResult) {
		JSONArray errors = new JSONArray();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			JSONObject error = new JSONObject();
			error.put("field", fieldError.getField());
			error.put("message", fieldError.getDefaultMessage());
			errors.add(error);
		}
		return errors.toJSONString();
	}
}
