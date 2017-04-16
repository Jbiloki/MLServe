package com.example.nguyen.mlpost;

import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UCIInterface extends Fragment {

    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private EditText edit4;
    private EditText edit5;
    private EditText edit6;
    private EditText edit7;
    private EditText edit8;
    private EditText edit9;
    public String sendRequest;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View mView = inflater.inflate(R.layout.activity_uciinterface, container,false);
        Button UCIRequest = (Button) mView.findViewById(R.id.Request);
        edit1 = (EditText) mView.findViewById(R.id.thickness);
        edit2 = (EditText) mView.findViewById(R.id.size);
        edit3 = (EditText) mView.findViewById(R.id.shape);
        edit4 = (EditText) mView.findViewById(R.id.adhesion);
        edit5 = (EditText) mView.findViewById(R.id.singlesize);
        edit6 = (EditText) mView.findViewById(R.id.nuclei);
        edit7 = (EditText) mView.findViewById(R.id.chromatin);
        edit8 = (EditText) mView.findViewById(R.id.nucleoli);
        edit9 = (EditText) mView.findViewById(R.id.mitosis);
        //fix parsing to allow double digits

        UCIRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sendRequest = edit1.getText().toString() + edit2.getText().toString()+ edit3.getText().toString() + edit4.getText().toString() + edit5.getText().toString() + edit6.getText().toString() + edit7.getText().toString() + edit8.getText().toString() + edit9.getText().toString();
                    new WebProcess(getActivity().getApplicationContext(), mView).execute("http://node34.ecs.fullerton.edu/processInput.php",sendRequest).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return mView;
    }
}
