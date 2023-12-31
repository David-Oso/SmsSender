package com.sms.SmsSender.twilio;

import com.sms.SmsSender.smsRequest.SmsRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmsSenderImplTest {
    @Autowired SmsSender smsSender;
    private SmsRequest smsRequest;


    @BeforeEach
    void setUp() {
        smsRequest = new SmsRequest();
        smsRequest.setRecipientPhoneNumber("+2349030400837");
        smsRequest.setMessage("Testing from twilio");
    }

    @Test
    void sendSms() {
        String response = smsSender.sendSms(smsRequest);
        assertThat(response).isEqualTo("Sms Sent Successfully");
    }
}