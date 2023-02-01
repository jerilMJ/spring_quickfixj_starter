package com.jerilmj.executor;

import com.jerilmj.executor.executor.Executor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickfixjServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(QuickfixjServerApplication.class, args);
	}

	@Override
	public void run( String... args ) throws Exception {
		Executor.main( args );
	}

}
