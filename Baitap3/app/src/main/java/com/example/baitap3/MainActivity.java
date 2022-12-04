package com.example.baitap3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDot,btnAC,btnDel,btnmodule,btnDiv,btnMinus,btnMulti,btnsum,btnEqual;
    private TextView textviewhistory,textviewresult;

    private String number = null;
    double lastnumber=0, firtnumber = 0;

    boolean operator = false;
    boolean isEquals = false;
    boolean dot=true;
    boolean del=true;

    String status = null;

    String history, result;



    String pattern = "###,###.#####";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnDot= findViewById(R.id.btnDot);
        btnDel= findViewById(R.id.btnDel);
        btnAC= findViewById(R.id.btnAC);
        btnsum= findViewById(R.id.btnsum);
        btnmodule= findViewById(R.id.btnmodule);
        btnMulti= findViewById(R.id.btnMulti);
        btnMinus= findViewById(R.id.btnMinus);
        btnEqual= findViewById(R.id.btnEqual);
        btnDiv= findViewById(R.id.btnDiv);

        textviewhistory= findViewById(R.id.textviewhistory);
        textviewresult = findViewById(R.id.textviewresult);

        btn0.setOnClickListener(view -> numberclick("0"));
        btn1.setOnClickListener(view -> numberclick("1"));
        btn2.setOnClickListener(view -> numberclick("2"));
        btn3.setOnClickListener(view -> numberclick("3"));
        btn4.setOnClickListener(view -> numberclick("4"));
        btn5.setOnClickListener(view -> numberclick("5"));
        btn6.setOnClickListener(view -> numberclick("6"));
        btn7.setOnClickListener(view -> numberclick("7"));
        btn8.setOnClickListener(view -> numberclick("8"));
        btn9.setOnClickListener(view -> numberclick("9"));
//        btnmodule.setOnClickListener(view -> numberclick("%"));



        btnsum.setOnClickListener(view -> {
            if (isEquals){
                history=textviewhistory.getText().toString();
                result= textviewresult.getText().toString();
                textviewhistory.setText((history+"+"));
            }else {
                history=textviewhistory.getText().toString();
                result= textviewresult.getText().toString();
                textviewhistory.setText((history+result+"+"));
            }
            if (operator){
                if (status=="multi"){
                    Multi();
                }else {
                    if (status=="div"){
                        Div();
                    }else {
                        if (status=="minus"){
                            Minus();
                        }else {
                            Plus();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status= "sum";
            isEquals=false;
        });

        btnMinus.setOnClickListener(view -> {
            if (isEquals){
                history=textviewhistory.getText().toString();
                result= textviewresult.getText().toString();
                textviewhistory.setText((history+"-"));
            }else {
                history=textviewhistory.getText().toString();
                result= textviewresult.getText().toString();
                textviewhistory.setText((history+result+"-"));
            }
            if (operator){
                if (status=="multi"){
                    Multi();
                }else {
                    if (status=="div"){
                        Div();
                    }else {
                        if (status=="sum"){
                            Plus();
                        }else {
                            Minus();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status= "minus";
            isEquals = false;
        });
        btnMulti.setOnClickListener(view -> {
            if (isEquals){
                history= textviewhistory.getText().toString();
                result= textviewresult.getText().toString();
                textviewhistory.setText((history+"*"));
            }else {
                history=textviewhistory.getText().toString();
                result= textviewresult.getText().toString();
                textviewhistory.setText((history+result+"*"));
            }

            if (operator){
                if (status=="sum"){
                    Plus();
                }else {
                    if (status=="div"){
                        Div();
                    }else {
                        if (status=="minus"){
                            Minus();
                        }else {
                            Multi();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status= "multi";
            isEquals = false;

        });
        btnDiv.setOnClickListener(view -> {

            if (isEquals){
                history=textviewhistory.getText().toString();
                result= textviewresult.getText().toString();
                textviewhistory.setText((history+"÷"));
            }else {
                history=textviewhistory.getText().toString();
                result= textviewresult.getText().toString();
                textviewhistory.setText((history+result+"÷"));
            }


            if (operator){
                if (status=="multi"){
                    Multi();
                }else {
                    if (status=="sum"){
                       Plus();
                    }else {
                        if (status=="minus"){
                            Minus();
                        }else {
                            Div();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status= "div";
            isEquals = false;

        });

        btnmodule.setOnClickListener(view -> {

            if (isEquals){
                history=textviewhistory.getText().toString();
                result= textviewresult.getText().toString();
                textviewhistory.setText((history+"%"));
            }else {
                history=textviewhistory.getText().toString();
                result= textviewresult.getText().toString();
                textviewhistory.setText((history+result+"%"));
            }


            if (operator){
                if (status=="multi"){
                    Multi();
                }else {
                    if (status=="sum"){
                        Plus();
                    }else {
                        if (status=="minus"){
                            Minus();
                        }else {
                            Div();
                        }
                    }
                }
            }
            operator = false;
            number = null;
//            status= "div";
            isEquals = false;

        });

        btnEqual.setOnClickListener(view -> {

            history=textviewhistory.getText().toString();
            result= textviewresult.getText().toString();
            textviewhistory.setText((history+result));

            if (operator){
                if (status=="multi"){
                    Multi();
                }else {
                    if (status=="sum"){
                        Plus();
                    }else {
                        if (status=="minus"){
                            Minus();
                        }else
                            if(status=="div") {
                                Div();
                            }else {
                                firtnumber=Double.parseDouble(textviewresult.getText().toString());
                            }
                        }
                    }
                }

            operator = false;
            isEquals=true;
            dot=false;

        });
        btnAC.setOnClickListener(view -> {
            number=null;
            operator=false;
            textviewresult.setText("0");
            textviewhistory.setText("");
            firtnumber=0;
            lastnumber=0;
            dot=true;
            del=true;
        });

        btnDel.setOnClickListener(view -> {
            if (del){
                textviewresult.setText("0");
            }else {
                number = number.substring(0, number.length() - 1);
                if (number.length() == 0) {
                    btnDel.setClickable(false);
                } else {
                    if (number.contains(".")) {
                        dot = false;
                    } else {
                        dot = true;
                    }
                }
            }
            textviewresult.setText(number);
        });

        btnDot.setOnClickListener(view -> {
            if (dot){
                if (number==null){
                    number="0.";
                }else {
                    number= number+".";
                }
                dot=false;
                textviewresult.setText(number);
            }
        });

    }
    public void numberclick (String view){
        if(number==null){
            number=view;
        }else {
            number = number+view;
        }

        textviewresult.setText(number);
        operator = true;
        del= false;
        btnDel.setClickable(true);
    }

    public void Minus(){
        if (firtnumber == 0){
            firtnumber = Double.parseDouble(textviewresult.getText().toString());
        }else {
            lastnumber = Double.parseDouble(textviewresult.getText().toString());
            firtnumber = firtnumber-lastnumber;
        }
        textviewresult.setText(decimalFormat.format(firtnumber));
        dot=true;
    }
    public void Plus(){
        lastnumber = Double.parseDouble(textviewresult.getText().toString());
        firtnumber = firtnumber+lastnumber;
        textviewresult.setText(decimalFormat.format(firtnumber));
        dot=true;
    }
    public void Multi(){

        if (firtnumber==0){
            firtnumber=1;
        }
        lastnumber = Double.parseDouble(textviewresult.getText().toString());
        firtnumber = firtnumber*lastnumber;
        textviewresult.setText(decimalFormat.format(firtnumber));
        dot=true;
    }
    public void Div(){
        if (firtnumber==0){
           lastnumber = Double.parseDouble(textviewresult.getText().toString());
        }else {
            lastnumber = Double.parseDouble(textviewresult.getText().toString());
            firtnumber = firtnumber / lastnumber;
        }
        textviewresult.setText(decimalFormat.format(firtnumber));
        dot=true;
    }
    public void Module(){
        if (firtnumber==0){
            lastnumber = Double.parseDouble(textviewresult.getText().toString());
        }else {
            lastnumber = Double.parseDouble(textviewresult.getText().toString());
            firtnumber = firtnumber % lastnumber;
        }
        textviewresult.setText(decimalFormat.format(firtnumber));
        dot=true;
    }
}