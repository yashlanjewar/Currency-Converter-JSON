package com.example.currencyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,bclr,equals;
    private String fromCurr;
    private String toCurr;
    double initRate,targetRate,first_input ;
    String t,resultFinal;
    int countp;
    String date;
    Spinner spinner1,spinner2;
    HashMap<String, String> hm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = textView1.getText().toString();
                if (t.length() == 1 && t.equals("0"))
                    textView1.setText(btn0.getText());
                else
                    textView1.append(btn0.getText());
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = textView1.getText().toString();
                if (t.length() == 1 && t.equals("0"))
                    textView1.setText(btn1.getText());
                else
                    textView1.append(btn1.getText());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = textView1.getText().toString();
                if (t.length() == 1 && t.equals("0"))
                    textView1.setText(btn2.getText());
                else
                    textView1.append(btn2.getText());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = textView1.getText().toString();
                if (t.length() == 1 && t.equals("0"))
                    textView1.setText(btn3.getText());
                else
                    textView1.append(btn3.getText());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = textView1.getText().toString();
                if (t.length() == 1 && t.equals("0"))
                    textView1.setText(btn4.getText());
                else
                    textView1.append(btn4.getText());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = textView1.getText().toString();
                if (t.length() == 1 && t.equals("0"))
                    textView1.setText(btn5.getText());
                else
                    textView1.append(btn5.getText());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = textView1.getText().toString();
                if (t.length() == 1 && t.equals("0"))
                    textView1.setText(btn6.getText());
                else
                    textView1.append(btn6.getText());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = textView1.getText().toString();
                if (t.length() == 1 && t.equals("0"))
                    textView1.setText(btn7.getText());
                else
                    textView1.append(btn7.getText());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = textView1.getText().toString();
                if (t.length() == 1 && t.equals("0"))
                    textView1.setText(btn8.getText());
                else
                    textView1.append(btn8.getText());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = textView1.getText().toString();
                if (t.length() == 1 && t.equals("0"))
                    textView1.setText(btn9.getText());
                else
                    textView1.append(btn9.getText());
            }
        });
        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(" ");
                countp = 0;
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainActivity.this, Main2Activity.class);
                int1.putExtra("Value1",resultFinal);

                int1.putExtra("Value2",first_input);
                System.out.println(resultFinal+" "+first_input);
                startActivity(int1);
            }
        });

        hm.clear();
        hm.put("USD", "1");
        hm.put("BDT", "85.45");

        String url = "https://api.exchangeratesapi.io/latest?base=USD";

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("Tag", response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object

                    date = response.getString("date");
                    JSONObject phone = response.getJSONObject("rates");
                    String BGN = phone.getString("BGN");
                    String BRL = phone.getString("BRL");
                    String CAD = phone.getString("CAD");
                    String CHF = phone.getString("CHF");
                    String INR = phone.getString("INR");

                    hm.put("BGN", BGN);
                    hm.put("BRL", BRL);
                    hm.put("CAD", CAD);
                    hm.put("CHF", CHF);
                    hm.put("INR", INR);


                   // TextView_date.setText("Last updated on " + date);



                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        // Adding request to request queue
        queue.add(jsonObjReq);
        //another method not in use
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("USD");
        arrayList.add("EUR");
        arrayList.add("INR");
        arrayList.add("BGN");
        arrayList.add("BRL");
        arrayList.add("CAD");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tut1 = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tut1,  Toast.LENGTH_LONG).show();
                calculateAndSetResult();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tut2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tut2,  Toast.LENGTH_LONG).show();
                calculateAndSetResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initialize(){
        btn1 = findViewById(R.id.one);
        btn2 = findViewById(R.id.two);
        btn3 = findViewById(R.id.three);
        btn4 = findViewById(R.id.four);
        btn5 = findViewById(R.id.five);
        btn6 = findViewById(R.id.six);
        btn7 = findViewById(R.id.seven);
        btn8 = findViewById(R.id.eight);
        btn9 = findViewById(R.id.nine);
        btn0 = findViewById(R.id.zero);
        bclr = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);
        textView1 = findViewById(R.id.textView5);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        // fromCurr = spinner1.getSelectedItem().toString();
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        // toCurr = spinner2.getSelectedItem().toString();
        hm = new HashMap<String, String>();
        spinner1.setSelection(0);
        spinner2.setSelection(1);
        countp = 0;
    }
    private void calculateAndSetResult() {
  // if (textView1.getText().toString().equals("")) {
     //       textView1.setText("0");
    //    }

        if (!textView1.getText().toString().equals("") || !textView1.getText().toString().equals("")) {

            String inititCurrency = spinner1.getSelectedItem().toString();
            String targetCurrency = spinner2.getSelectedItem().toString();


            try {
               // double baseRate = Double.valueOf(hm.get("USD"));
                initRate = Double.valueOf(hm.get(inititCurrency));
                targetRate = Double.valueOf(hm.get(targetCurrency));
                first_input = Double.valueOf(textView1.getText().toString());
                resultFinal = String.valueOf(String.format("%.2f", ((targetRate * first_input) / initRate)));
              //  edt_secondCountry.setText(resultFinal);
               // txtview_result.setText(edt_firstCountry.getText().toString() + " "+ inititCurrency + " = " + resultFinal + " " + targetCurrency);

            } catch (Exception e) {


            }

            //edt_secondCountry.setText(String.valueOf(((targetRate*first_input)/initRate)));

            // Toast.makeText(this, currency1+"---"+currency2, Toast.LENGTH_SHORT).show();
            // txtview_result.setText(currency1+"="+currency2);

        }

    }
}
