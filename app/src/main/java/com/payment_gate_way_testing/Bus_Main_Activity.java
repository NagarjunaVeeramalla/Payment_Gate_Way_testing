package com.payment_gate_way_testing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

import bank.com.model_2_sdk.Base_Activity;
import bank.com.model_2_sdk.buses.Buses_MainActivity;
import bank.com.model_2_sdk.travel.Travel_SDK_CallBack;
import bank.com.model_2_sdk.travel.Travel_Sdk;
import bank.com.model_2_sdk.travel.Travel_User_Params;

/**
 * Created by Nagarjuna on 2/16/2018.
 */

public class Bus_Main_Activity extends AppCompatActivity {

    String TEST="TEST";
    String TEST_CONSUMER_KEY="E35E00C9B3B94A9E2C6177021E0899348DD1EF5A";
    String TEST_CONSUMER_SECRET="83E502394A01566C0B83BE5A1ECC44E398B872AC";

    String LIVE="LIVE";
    String LIVE_CONSUMER_KEY="AB2F5B6EB9CBCDE9D281074CD50F03FB72BA1573";
    String LIVE_CONSUMER_SECRET="A885CF494D724C06CAF23DB2183C240F63EA718C";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startmode();

    }

    private void startmode(){

        final Travel_Sdk Service =Travel_Sdk.getServiceType(TEST,TEST_CONSUMER_KEY,TEST_CONSUMER_SECRET);

        HashMap<String,String> hmap=new HashMap<>();

        hmap.put("USER_NAME","NAG");
        hmap.put("USER_ID","1");
        hmap.put("USER_TYPE","USER");

        Travel_User_Params params=new Travel_User_Params(hmap);
        Service.initialize(params);

        Service.start_travel_service(this,"1", new Travel_SDK_CallBack() {
            @Override
            public void onBlockResponse(Bundle var1) {

                HashMap<String,String> user_params= (HashMap<String, String>) var1.get("USER_PARAMS");
                HashMap<String,String> Block_request_Params= (HashMap<String, String>) var1.get("BLOCK_REQUEST_PARAMS");
                HashMap<String,String> Block_response_Params= (HashMap<String, String>) var1.get("BLOCK_RESPONSE_PARAMS");

                assert Block_request_Params != null;
                String Amount = Block_request_Params.get("TOTAL_AMOUNT");
                String Trip_Type=Block_request_Params.get("TripType");
                assert Block_response_Params != null;
                String Onward_RefNo  = Block_response_Params.get("ONWARD_REF_NUM");
                String Ret_Ref_No=Block_response_Params.get("RETURN_REF_NUM");
                String Booking_Status=Block_response_Params.get("BookingStatus");
                String Booking_Type=Block_response_Params.get("SERVICE_TYPE");

                assert user_params != null;
                String USERTYPE=user_params.get("USER_TYPE");

                System.out.println("USERTYPE--- "+USERTYPE);

                if (Booking_Status.equals("1")){
                    sendtopaymentgateway(Amount,Onward_RefNo,Ret_Ref_No,Booking_Type);
                }

            }
            @Override
            public void onBackPressedCancel() {
                Intent ip=new Intent(Bus_Main_Activity.this,Bus_Main_Activity.class);
                startActivity(ip);
            }

            @Override
            public void clientAuthenticationFailed(String var1) {

            }

            @Override
            public void onBookingResponse(Bundle var2) {

            }
        });
    }

    private void sendtopaymentgateway(String amount,
                                      String refNo,
                                      String ret_Ref_No,
                                      String booking_Type){
        Intent ip=new Intent(Bus_Main_Activity.this,Razor_PaymentGateway.class);

        ip.putExtra("AMOUNT", amount);
        ip.putExtra("REFERENCE_NUMBER", refNo);
        ip.putExtra("RETURN_TICKET_REFERNCE_NUMBER", ret_Ref_No);
        ip.putExtra("BOOKING_TYPE", booking_Type);
        startActivity(ip);
    }
}
