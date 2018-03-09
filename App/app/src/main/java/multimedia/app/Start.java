package multimedia.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Start extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);
        tv = (TextView) findViewById(R.id.start_text);
        iv = (ImageView) findViewById(R.id.start_image);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.start_transaction);
        tv.startAnimation(anim);
        iv.startAnimation(anim);

        final Intent intent = new Intent(this, Index.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    Toast.makeText(null, "Unexpected Thread Error", Toast.LENGTH_LONG);
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }

    private TextView tv;
    private ImageView iv;
}
