package com.sms.SmsSender.smsRequest;//package com.bank.E_Bank_App.service.twilio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sms.SmsSender.utilities.SmsSenderUtils;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.sms.SmsSender.utilities.SmsSenderUtils.MESSAGE_REGEX;
import static com.sms.SmsSender.utilities.SmsSenderUtils.PHONE_NUMBER_REGEX;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SmsRequest {
    @JsonProperty("phone_number")
    @NotNull(message = "field recipient phone number cannot be null")
    @NotBlank(message = "field recipient phone number cannot be blank")
    @NotEmpty(message = "field recipient phone number cannot be empty")
    @Pattern(message = "phone number must be a Nigeria phone number starting with +234", regexp = PHONE_NUMBER_REGEX)
    @Size(min = 14, max = 14, message = "Phone number must not be less or more than 14")
    private String recipientPhoneNumber;

    @JsonProperty("message")
//    @Size(min = 1, max = 500, message = "Message character must be between 1 and 500")
    @NotBlank(message = "field message cannot be blank")
    @NotEmpty(message = "field message cannot be empty")
    @Pattern(regexp = MESSAGE_REGEX)
    private String message;
}
