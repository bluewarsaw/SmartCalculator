package pl.sebastianczarnecki.smartcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText UserInput;
    private Button SendInput, ResetInput;
    private TextView Doing;
    private TextView Output;
    private int OverallResult = 0;
    private ImageView androidguy;
    private TextView hello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     UserInput = (EditText) findViewById(R.id.user_input);
     SendInput = (Button) findViewById(R.id.send_input);
     ResetInput = (Button) findViewById(R.id.reset_input);
     Doing = (TextView) findViewById(R.id.doing);
     Output = (TextView) findViewById(R.id.output);
     androidguy = (ImageView) findViewById(R.id.android_guy);

     hello = (TextView) findViewById(R.id.hello);

        SendInput.setOnClickListener(this);
        ResetInput.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == SendInput) {

            Editable nameEditable = UserInput.getText();
            String name = nameEditable.toString();

            String[] part = name.split("[\\n\\s]");

            String apply = "Apply";
            String multiply = "Multiply";
            String divide = "Divide";
            String plus = "Plus";
            String minus = "Minus";

            int applyInt = 0;

            for (int n = 0; n <= part.length - 1; n++) {
                if (apply.contains(part[n])) {
                    int numOne = Integer.parseInt(part[n+1]);
                    OverallResult = (OverallResult + numOne);
                }
               else if (multiply.contains(part[n])) {
                    int numTwo = Integer.parseInt(part[n+1]);
                    OverallResult = (OverallResult * numTwo);
                }
                else if (divide.contains(part[n])) {
                    int numTwo = Integer.parseInt(part[n+1]);
                    OverallResult = (OverallResult / numTwo);
                }
                else if (plus.contains(part[n])) {
                    int numTwo = Integer.parseInt(part[n+1]);
                    OverallResult = (OverallResult + numTwo);
                }
                else if (minus.contains(part[n])) {
                    int numTwo = Integer.parseInt(part[n+1]);
                    OverallResult = (OverallResult - numTwo);
                }
            }

            String finalresult = String.valueOf(OverallResult);

                Output.setText(finalresult);

            TranslateAnimation animate = new TranslateAnimation(0,androidguy.getWidth(),-1500,0);
            animate.setDuration(2000);
            animate.setFillAfter(true);
            androidguy.startAnimation(animate);
                androidguy.setVisibility(View.VISIBLE);

            TranslateAnimation animateText = new TranslateAnimation(0,hello.getWidth(),-1500,0);
            animate.setDuration(2000);
            animate.setFillAfter(true);
            hello.startAnimation(animate);
            hello.setVisibility(View.VISIBLE);
                }

         else if (v == ResetInput) {

            OverallResult = 0;

            String finalresult = String.valueOf(OverallResult);

            Output.setText(finalresult);

            UserInput.getText().clear();

        }

}}