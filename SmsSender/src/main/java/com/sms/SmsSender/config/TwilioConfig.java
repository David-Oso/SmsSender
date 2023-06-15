package com.sms.SmsSender.config;

import com.sms.SmsSender.smsRequest.SmsRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@ConfigurationProperties("twilio")
@Getter
@Setter
public class TwilioConfig {
    @Value("${twilio.phone_number}")
    private String twilioPhoneNumber;
    @Value("${twilio.sid}")
    private String twilioSid;
    @Value("${twilio.token}")
    private String twilioToken;

}
