    package com.yusufsinan.a12mart;
    import android.content.Intent;
    import android.graphics.Color;
    import android.os.Bundle;
    import android.os.Handler;
    import android.widget.Toast;

    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.constraintlayout.widget.ConstraintLayout;

    import java.util.Random;
    import java.util.Timer;
    import java.util.TimerTask;

    public class DigerSayfa extends AppCompatActivity {

        private Timer timer;
        private Random random = new Random();
        private Handler handler = new Handler();
        private int sayac;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.diger_sayfa);

            Intent intent = getIntent();
            int enDusuk = intent.getIntExtra("enDusuk", 0);
            int enYuksek = intent.getIntExtra("enYuksek", 0);


             int randomDeger = random.nextInt(enYuksek-enDusuk+1)+enDusuk;
             sayac = randomDeger;
            Toast.makeText(getApplicationContext(), "random sayı : " + randomDeger, Toast.LENGTH_LONG).show();

            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            int rastgeleRenk = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                            ConstraintLayout layout = findViewById(R.id.constraintLayout);
                            layout.setBackgroundColor(rastgeleRenk);

                            sayac--;
                            if (sayac<0){
                                timer.cancel();
                                Toast.makeText(getApplicationContext(),"İşlem tamamlandı",Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
            }, 0, 3000);
        }


    }
