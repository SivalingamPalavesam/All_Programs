package com.java.emailcontroller;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

public class CustomHealthIndicator extends AbstractHealthIndicator
{

	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception 
	{
		builder.up()
		.withDetail("app", "Alive and Kicking")
        .withDetail("error", "Nothing! I'm good.");
	}

}
