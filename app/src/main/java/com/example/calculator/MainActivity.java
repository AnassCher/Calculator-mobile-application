package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         text = (EditText) findViewById(R.id.text);

    }
    EditText text;
    /*Button btn1 = (Button) findViewById(R.id.button);
    Button btn2 = (Button) findViewById(R.id.button2);
    Button btn3 = (Button) findViewById(R.id.button3);
    Button btn4 = (Button) findViewById(R.id.button5);
    Button btn5 = (Button) findViewById(R.id.button6);
    Button btn6 = (Button) findViewById(R.id.button7);
    Button btn7 = (Button) findViewById(R.id.button9);
    Button btn8 = (Button) findViewById(R.id.button10);
    Button btn9 = (Button) findViewById(R.id.button11);
    Button btn0 = (Button) findViewById(R.id.button13);

    Button btnPlus = (Button) findViewById(R.id.button4);
    Button btnMoins = (Button) findViewById(R.id.button8);
    Button btnMulti = (Button) findViewById(R.id.button12);
    Button btnDivis = (Button) findViewById(R.id.button16);
    Button btnEgal = (Button) findViewById(R.id.button17);
    /*
    Button btnPoint = (Button) findViewById(R.id.button14);
    Button btn = (Button) findViewById(R.id.button15);
*/
    Double first, second, res;

    String OP;
    String msg;
    int cpt =0;
    int counter =0;

    public void afficher(View view){
        String d = ((Button)view).getText().toString();

        String concat = null;
        if(view.getId()!=R.id.button14) {
            if (text.getText().toString().equals("0")) {
                concat = d;
            } else {
                concat = text.getText() + d;
            }
        }
        else if(view.getId()==R.id.button14){
            cpt++;
            if(cpt==1){
                concat = text.getText() + d;

            }else{
                concat = text.getText().toString();
            }

        }
        text.setText(concat);
    }

    public void setOp(View v){
        counter++;
        String op;
        if(text.getText().toString().equals("0")){
            op = ((TextView) v).getText().toString();
            if(op.equals("-")){
                text.setText("-");
                counter =0;
            }
        }
        if(counter == 1){
            OP = ((TextView) v).getText().toString();
            first = Double.valueOf(text.getText().toString());
            text.setText("0");
        }else if(counter>1){
            op = ((TextView) v).getText().toString();
            if((OP.equals("*") || OP.equals("/")) && op.equals("-")){
                text.setText(op);
            }else{
                OP = ((TextView) v).getText().toString();
            }

        }
        cpt =0;

    }



    public void reset(View view){
        text.setText("0");
    }
    public void egale(View view){
        if(!first.isNaN()){
            second = Double.parseDouble(text.getText().toString());
            switch(OP){
                case "+": res = first + second ;
                          msg = ""+res;
                          break;
                case "-": res = first - second ;
                          msg = ""+res;
                          break;
                case "*": res = first * second ;
                          msg = ""+res;
                          break;
                case "/": if(second == 0){
                              msg = "Division par 0";
                              break;
                          }
                          res = first / second;
                          msg= ""+res;
                          break;
            }
            text.setText(msg);
            counter =0;
            cpt=0;
        }


    }


}