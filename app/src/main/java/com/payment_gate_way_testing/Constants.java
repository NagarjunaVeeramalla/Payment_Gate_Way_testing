package com.payment_gate_way_testing;

/**
 * Created by Nagarjuna on 3/13/2018.
 */

public class Constants {

    /// SMS provider identification
    // It should match with your SMS gateway origin
    // You can use  MSGIND, TESTER and ALERTS as sender ID
    // If you want custom sender Id, approve MSG91 to get one
    public static final String SMS_ORIGIN = "TICKET";

    // special character to prefix the otp. Make sure this character appears only once in the sms
    public static final String OTP_DELIMITER = ":";
}
