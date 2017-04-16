package com.example.nguyen.mlpost;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nguyen on 4/15/2017.
 */

public class sendDataUCI extends StringRequest {
    private static final String SEND_UCI_REQUEST_URL = "http://node34.ecs.fullerton.edu/processInput.php";
    private Map<String,String> params;

    public sendDataUCI(int in1, int in2, int in3, int in4, int in5, int in6, int in7, int in8, int in9, int in10, Response.Listener<String> listener){
        super(Method.POST, SEND_UCI_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("input1", in1 + "");
        params.put("input2", in2 + "");
        params.put("input3", in3 + "");
        params.put("input4", in4 + "");
        params.put("input5", in5 + "");
        params.put("input6", in6 + "");
        params.put("input7", in7 + "");
        params.put("input8", in8 + "");
        params.put("input9", in9 + "");
        params.put("input10", in10 + "");

    }

    @Override
    public  Map<String, String> getParams() {return params;}

}
