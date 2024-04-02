package com.fortech.academy.library.configuration;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendGridConfig {
    @Value("${app.sendgrid.key}")
    private String appKey;

    public SendGridConfig() {
    }

    @Bean
    public SendGrid getSendGrid() {
        return new SendGrid(this.appKey);
    }
}

