package com.example.FormProject.Controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.FormProject.Entity.User;
//import com.example.FormProject.Service.CaptcaService;
import com.example.FormProject.Service.UserService;
import com.example.FormProject.dto.UserDto;

@Controller
public class UserController {

 @Autowired
 private UserDetailsService userDetailsService;
@Autowired
 private UserService userService;

//@Autowired
//private CaptcaService captcaService;

//Google reCAPTCHA secret key
//private static final String RECAPTCHA_SECRET_KEY = "6LfJQuwqAAAAAHLLy3q8X2PXa-cz71DwRqbnVcuY";
 
//@Value("${google.recaptcha.secret-key}")
//private String recaptchaSecretKey;



 @GetMapping("/home")
 public String home(Model model, Principal principal) {
	
	   if (principal == null) {
	        // If principal is null, handle appropriately (e.g., redirect to login or show an error)
	        return "redirect:/login";  // Redirect to login page if not authenticated
	    }
	 
	 
  UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
  model.addAttribute("userdetail", userDetails);
  return "home";
 }

 @GetMapping("/login")
 public String login(Model model, UserDto userDto) {

  model.addAttribute("user", userDto); 
  return "login";
 }

 @GetMapping("/register")
 public String register(Model model, UserDto userDto) {
  model.addAttribute("user", userDto); 
  return "register";
 }

 @PostMapping("/register")
 public String registerSave(@ModelAttribute("user") UserDto userDto, Model model) {  
	// public String registerSave(@ModelAttribute("user") UserDto userDto,@RequestParam("g-recaptcha-response") String recaptchaResponse, Model model) {--- Here the g-recaptcha code is used so commented. 
//	 //Verify Recaptcha response
//	 	if(!verifyRecaptcha(recaptchaResponse)) {
//	 		model.addAttribute("recaptchError","Please complete the recatcha.");
//	 		return "register";
//	 	}
//	 
  User user = userService.findByUsername(userDto.getUsername());
  if (user != null) {
   model.addAttribute("Userexist", "User already exists with this username. ");
   return "register";
  }
  userService.save(userDto);
  return "redirect:/register?success";
 }
 
// @GetMapping("/profile")
// public String showprofile(Model model) {
//	 
//	 model.addAttribute("username","User name");
//	return "profile";
// }
 
//Example method to simulate fetching the authenticated user (replace with your logic)
 private User getAuthenticatedUser() {
     // Replace with actual logic to fetch the authenticated user
     return new User("John Doe", "johndoe@example.com", "2021-01-01");
 }
 
 //Method to verify reCAPTCHA verification
// private boolean verifyRecaptcha(String recaptchaResponse) {
//	 
//	 RestTemplate restTemplate = new RestTemplate();
//	 	
//	 //Parameter for recaptchh verifiaction
//	 Map<String,String> param=new HashMap<>();
//	 param.put("secret", recaptchaSecretKey);
//	 param.put("response", recaptchaResponse);
//	 
//	 //Send Post request to google Recaptcha sever
//	 String verifyUrl = "https://www.google.com/recaptcha/api/siteverify";
//	 ResponseEntity<String> response=restTemplate.postForEntity(verifyUrl, param, String.class);
//	 
//	// Parse the response to check if reCAPTCHA was successful
//	 String responseBody = response.getBody();
//     if (responseBody != null && responseBody.contains("\"success\": true")) {
//         return true;
//     }
//	 
//	 
//	return false;
//	 
// }
 
}