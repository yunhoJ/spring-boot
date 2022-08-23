package com.example.springboot;

import com.example.springboot.properties.Myproperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@ConfigurationPropertiesScan
@SpringBootApplication(
//		exclude = {WebMvcAutoConfiguration.class}//Auto Config를 제외시킴
//		excludeName ="org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration"
		//이름으로 제외시킴 임폴트를 사용할수 없을때 씀
//		scanBasePackages = "com.example.springboot"//베이스 패키지를 지정해 어디서부터 설정할지 선택 가능
)
public class Application {
//	@Value("${my.height}")
//	private Integer height;

	//생성자로 final 가능
	private final Integer height;
	private final Environment environment;
	private final ApplicationContext applicationContext;
	private final Myproperties myproperties;

	public Application(@Value("${my.height}")Integer height,Myproperties myproperties ,Environment environment, ApplicationContext applicationContext) {
		this.height = height;
		this.environment = environment;
		this.applicationContext = applicationContext;
		this.myproperties = myproperties;
	}



	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		/*
		SpringApplication springApplication= new SpringApplication(Application.class);
		springApplication.setBanner();//배너 설정 등 여러 설정가능
		springApplication.run(args);// 스프링 시작
		*/

	}
	/* 해당 방식은 생성자 후에 실행 되므로 null 나옴
	public void abd(){
		System.out.println("[@Value]"+height);
	}
*/
	@PostConstruct
	public void abd(){
		System.out.println("[@Value]  "+height);
		System.out.println("[@env]  "+environment.getProperty("my.height"));
		System.out.println("[@applicationContext]  "+applicationContext.getEnvironment().getProperty("my.height"));
		System.out.println("[@configProperties]  "+myproperties.getHeight());

	}

}
