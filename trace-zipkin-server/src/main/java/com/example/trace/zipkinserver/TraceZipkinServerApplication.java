package com.example.trace.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class TraceZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraceZipkinServerApplication.class, args);
	}
}
