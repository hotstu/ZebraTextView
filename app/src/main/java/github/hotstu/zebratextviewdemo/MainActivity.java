package github.hotstu.zebratextviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //手动设置颜色
//        ZebraTextView zebraText = findViewById(R.id.text);
//        zebraText.setEvenLineColor(Color.WHITE);
//        zebraText.setEvenLineColor(Color.BLUE);
    }
}
