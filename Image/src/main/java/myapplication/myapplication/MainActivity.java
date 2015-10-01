package myapplication.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import myapplication.myapplication.R;

public class MainActivity extends Activity {


    Switch swt;
    RadioGroup rg;
    ImageView img;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swt = (Switch)findViewById(R.id.swt);
        rg = (RadioGroup)findViewById(R.id.radioGrp);
        tv = (TextView)findViewById(R.id.android);
        img = (ImageView)findViewById(R.id.img);


        switchOff();

        swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) switchOn();

                else switchOff();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                img.setVisibility(View.VISIBLE);

                switch (group.getCheckedRadioButtonId()) {

                    case R.id.rb1:
                        img.setImageResource(R.drawable.jelly);
                        break;

                    case R.id.rb2:
                        img.setImageResource(R.drawable.kitkat);
                        break;

                    case R.id.rb3:
                        img.setImageResource(R.drawable.lolly);
                        break;
                }

            }
        });

        findViewById(R.id.exit).setOnClickListener(butListener);
        findViewById(R.id.init).setOnClickListener(butListener);

    }

    private void switchOff() {
        tv.setVisibility(View.GONE);
        rg.setVisibility(View.GONE);
        rg.clearCheck();
        img.setVisibility(View.GONE);
        swt.setChecked(false);

    }

    private void switchOn() {
        tv.setVisibility(View.VISIBLE);
        rg.setVisibility(View.VISIBLE);
    }

    Button.OnClickListener butListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.exit:
                    finish();

                case R.id.init:
                    switchOff();
                    break;

                default:
                    return;

            }
        }
    };
}
