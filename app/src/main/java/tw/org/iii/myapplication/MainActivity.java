package tw.org.iii.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private View click;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //findViewById回傳是view 只要是誤鍵就是view 但宣告為button
        //因此要轉型回傳 透過findViewById找出關聯 is-a
        click = findViewById(R.id.click);
        tv = (TextView) findViewById(R.id.tv);
        //只要是view 都可以被按 add很多個  set只能一個  後面蓋前面
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLottery();
            }
        });
    }
    private void showLottery(){
        HashSet<Integer> set = new HashSet<>();
        while (set.size()<6){
            set.add((int)(Math.random()*49+1));
        }
        tv.setText(set.toString());
    }

}
