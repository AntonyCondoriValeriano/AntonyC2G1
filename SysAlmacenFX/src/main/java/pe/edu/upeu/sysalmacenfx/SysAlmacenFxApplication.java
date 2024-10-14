package pe.edu.upeu.sysalmacenfx;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
<<<<<<< HEAD
import pe.edu.upeu.sysalmacenfx.pruebas.MainX;
=======
import pe.edu.upeu.sysalmacenfx.repositorio.MainX;
>>>>>>> f8f5c08cc55d09348cbe8d3bb2bcbcc5e3873faf

@SpringBootApplication
public class SysAlmacenFxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysAlmacenFxApplication.class, args);
	}
<<<<<<< HEAD

	@Bean
	public CommandLineRunner run(ApplicationContext context) { return args -> {
		MainX mx = context.getBean(MainX.class);
		mx.menu();
		};
=======
	@Bean
	public CommandLineRunner run(ApplicationContext context) { return args -> {
		MainX mx = context.getBean(MainX.class);
		mx.registro();
		mx.menu();
	};
>>>>>>> f8f5c08cc55d09348cbe8d3bb2bcbcc5e3873faf
	}

}
