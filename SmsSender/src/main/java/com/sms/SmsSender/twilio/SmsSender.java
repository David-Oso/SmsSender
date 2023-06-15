package com.sms.SmsSender.twilio;

import com.sms.SmsSender.smsRequest.SmsRequest;

public interface SmsSender {
    String sendSms(SmsRequest smsRequest);
}
