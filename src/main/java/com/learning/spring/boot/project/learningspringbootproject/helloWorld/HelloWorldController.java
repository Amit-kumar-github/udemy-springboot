package com.learning.spring.boot.project.learningspringbootproject.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource)
	{
		this.messageSource=messageSource;
	}
	
	@GetMapping(path="/bye")
	public String helloworld()
	{
		return "bye";
	}
	
	@GetMapping(path="/hello-world")
	public String helloworld1()
	{
		return "Hello world";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello world");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean("Hello world Bean" + " " + name);
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloworldInternationalized()
	{
		Locale locale= LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message", locale);
		
		//return "Hello world v2";
	}
}
