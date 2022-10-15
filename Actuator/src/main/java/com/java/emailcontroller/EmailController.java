package com.java.emailcontroller;


import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.java.emailserviceImpl.EmailServiceImpl;
import com.java.exception.ExceptionHandlerClass;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmailController 
{	
	static int Statuscode ;

	@Autowired 
	private EmailServiceImpl emailService;

	@Autowired
	private  RestTemplate restTemplate;

	private static Logger logger =LoggerFactory.getLogger(EmailController.class);

	static ResponseEntity<String> response;

	@Scheduled(cron=" 2 * * * * *") 
	public void run() throws ExceptionHandlerClass ,IOException
	{
		//getHttpCode1(Statuscode);
		//getHttpCode2(Statuscode);
		getHttpCode3(Statuscode);
		getHttpCode4(Statuscode);
		logger.info("Before check Status code   : "+Statuscode);

		if(Statuscode != 200)
		{			
			emailService.sendSimpleMail(Statuscode);

			logger.info("if inside Ststus code  : "+Statuscode);
			logger.info("Current time is :: " + Calendar.getInstance().getTime());
		}

	}
	@HystrixCommand(fallbackMethod="getvalue_Fallback")
	public void getHttpCode1(int statuscode) 
	{
		try
		{
			response = restTemplate.exchange("http://localhost:8083/actuator/health", HttpMethod.GET, null, String.class);
			Statuscode = response.getStatusCodeValue();
			System.out.println(response.getBody());
			System.out.println(Statuscode);
		}
		catch(Exception ex)
		{
			new Throwable(getvalue_Fallback());
		}	
	}	
	@HystrixCommand(fallbackMethod="getvalue_Fallback")
	public void getHttpCode2(int statuscode) 
	{
		try
		{
			response = restTemplate.exchange("http://localhost:8080/actuator/health", HttpMethod.GET, null, String.class);
			Statuscode = response.getStatusCodeValue();
			System.out.println(response.getBody());
			System.out.println(Statuscode);
		}
		catch(Exception ex)
		{
			new Throwable(getvalue_Fallback());
		}	
	}

	@HystrixCommand(fallbackMethod="getvalue_Fallback")
	public void getHttpCode3(int statuscode) 
	{
		//return	obj.run(()-> restTemplate.getForObject("http://localhost:8081/actuator/health",String.class),Throwable-> fallbackService());		
		//String name = restTemplate.getForObject("http://localhost:8081/actuator/health", String.class);
		try
		{
		response = restTemplate.exchange("http://localhost:8081/actuator/health", HttpMethod.GET, null, String.class);
		Statuscode = response.getStatusCodeValue();
		System.out.println(response.getBody());
		System.out.println(Statuscode);
		}
		catch(Exception ex)
		{
			new Throwable(getvalue_Fallback());
		}	


	}
	@HystrixCommand(fallbackMethod="getvalue_Fallback")
	public void getHttpCode4(int statuscode) 
	{
		try
		{
			response = restTemplate.exchange("http://localhost:8081/getData", HttpMethod.GET, null, String.class);
			Statuscode = response.getStatusCodeValue();
			System.out.println(response.getBody());
			System.out.println(Statuscode);
		}
		catch(Exception ex)
		{
			new Throwable(getvalue_Fallback());
		}	
	}
	private String getvalue_Fallback() 
	{
		System.out.println("Student service is down!! fallback route enabled..");

		return "No response from Client service at this moment."+
		"service will be back ...please try again after sometime";
	}

	/*	@RequestMapping("/Statuscode")
		public static int getHttpCode(int statuscode) throws IOException {
	
			Statuscode = ((HttpURLConnection) new URL("http://localhost:8080/actuator/health")
					.openConnection()).getResponseCode();
			
			logger.info("getHttpCode  is first instance : "+Statuscode);
			return Statuscode;
		}
		
		@RequestMapping("/Statuscode1")
		public static int getHttpCode1(int statuscode) throws IOException {
	
			Statuscode = ((HttpURLConnection) new URL("http://localhost:8083/actuator/health")
					.openConnection()).getResponseCode();
			logger.info("getHttpCode second instance is  : "+Statuscode);
			return Statuscode;
		}
		
		@RequestMapping("/Statuscode2")
		public static int getHttpCode2(int statuscode) throws IOException {
	
			Statuscode = ((HttpURLConnection) new URL("http://localhost:8081/actuator/health")
					.openConnection()).getResponseCode();
			logger.info("getHttpCode second Service is  : "+Statuscode);
			return Statuscode;
		}*/

}
