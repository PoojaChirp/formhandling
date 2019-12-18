package com.twilio.formhandling.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SMSCallback {

    @JsonProperty("SmsSid")
    private String smsSid;
    @JsonProperty("SmsStatus")
    private  String smsStatus;
    @JsonProperty("MessageStatus")
    private String messageStatus;
    @JsonProperty("To")
    private String to;
    @JsonProperty("MessageSid")
    private String messageSid;
    @JsonProperty("AccountSid")
    private String accountSid;
    @JsonProperty("From")
    private String from;
    @JsonProperty("ApiVersion")
    private String apiVersion;

    public String getSmsSid() {
        return smsSid;
    }

    public void setSmsSid(String smsSid) {
        this.smsSid = smsSid;
    }

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessageSid() {
        return messageSid;
    }

    public void setMessageSid(String messageSid) {
        this.messageSid = messageSid;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public String toString() {
        return "SMSCallback{" +
                "smsSid='" + smsSid + '\'' +
                ", smsStatus='" + smsStatus + '\'' +
                ", messageStatus='" + messageStatus + '\'' +
                ", to='" + to + '\'' +
                ", messageSid='" + messageSid + '\'' +
                ", accountSid='" + accountSid + '\'' +
                ", from='" + from + '\'' +
                ", apiVersion='" + apiVersion + '\'' +
                '}';
    }
}
