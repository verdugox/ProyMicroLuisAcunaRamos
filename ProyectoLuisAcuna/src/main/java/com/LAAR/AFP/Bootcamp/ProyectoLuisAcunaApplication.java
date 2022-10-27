package com.LAAR.AFP.Bootcamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

import java.lang.invoke.MethodHandles;


@SpringBootApplication
public class ProyectoLuisAcunaApplication {

	//SLF4J's Se logea e instancia la clase
	//private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	//this is what SLF4J uses to bind to a specific loggin umple
	public static void main(String[] args)
	{
		SpringApplication.run(ProyectoLuisAcunaApplication.class, args);
	}

}
