package com.sms.SmsSender.twilio;
import com.sms.SmsSender.config.TwilioConfig;
import com.sms.SmsSender.exception.SmsSenderException;
import com.sms.SmsSender.smsRequest.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("twilio")
@AllArgsConstructor
public class SmsSenderImpl implements SmsSender{
    private final TwilioConfig config;
    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioConfig.class);
    @Override
    public String sendSms(SmsRequest request) {
        validateMessage(request.getMessage());
        PhoneNumber to = new PhoneNumber(request.getRecipientPhoneNumber());
        PhoneNumber from = new PhoneNumber(config.getTwilioPhoneNumber());
        MessageCreator creator = Message.creator(
                to,
                from,
                request.getMessage());
        creator.create();
        LOGGER.info("sms sent{}", request);
        return "Sms Sent Successfully";
    }

    private void validateMessage(String message) {
        if(message.length() < 2)throw new SmsSenderException("Message length cannot be less than two");
        else if (message.length() > 500)throw new SmsSenderException("Message length cannot be greater than 500");
    }
}
