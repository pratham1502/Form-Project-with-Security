//package com.example.FormProject.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.example.FormProject.dto.CaptchResponse;
//
//@Service
//public class CaptcaService {
//	
//	@Value("${google.recaptcha.secret-key}")
//    private String secretKey; // Secret key from application.properties
//
//	
//	private static final String RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
//
//	private Object captchaResponse;
//	
//	public boolean verifyCaptcha(String captchaResponse) {
//		RestTemplate restTemplate = new RestTemplate();
//	
//	
//	String url = UriComponentsBuilder.fromHttpUrl(RECAPTCHA_VERIFY_URL)
//			.queryParam("secret",secretKey)
//			.queryParam("response",captchaResponse)
//			.toUriString();
//	
//	// Send the POST request and parse the response into CaptchaResponse
//	
//	CaptchaResponse response = restTemplate.postForObject(url, null, CaptchaResponse.class);
//	
//	return response !=null && response.isSuccess();
//}
//}
