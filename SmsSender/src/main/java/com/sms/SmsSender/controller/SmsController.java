package com.sms.SmsSender.controller;

import com.sms.SmsSender.smsRequest.SmsRequest;
import com.sms.SmsSender.twilio.SmsSender;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms_sender/")
@AllArgsConstructor
public class SmsController {
    private final SmsSender smsSender;


    @PostMapping("send_sms")
    public ResponseEntity<?> sendSms(@Valid @RequestBody SmsRequest smsRequest){
        String response = smsSender.sendSms(smsRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
