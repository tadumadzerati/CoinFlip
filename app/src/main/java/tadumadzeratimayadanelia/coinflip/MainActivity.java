package tadumadzeratimayadanelia.coinflip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b;
    ImageView iv;

    Random r;

    int side;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.flip);
        iv = (ImageView) findViewById(R.id.coin);

        r = new Random();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                side = r.nextInt(2);

                if (side == 0) {
                    iv.setImageResource(R.drawable.heads);
                    Toast.makeText(MainActivity.this, "საფასური!", Toast.LENGTH_SHORT).show();

                }else if(side == 1){
                    iv.setImageResource(R.drawable.tails);
                    Toast.makeText(MainActivity.this, "გერბი!", Toast.LENGTH_SHORT).show();
                }

                //FOR ROTATION

                RotateAnimation rotate = new RotateAnimation(0, 360,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(500);

                iv.startAnimation(rotate);
            }
        });

    }
}
