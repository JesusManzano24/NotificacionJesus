package com.jesusmanzano.notificacion;

import android.app.NotificationManager;
import android.content.ContentResolver;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_layout_root));


                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);


                ImageView icon = layout.findViewById(R.id.icon);
                icon.setImageResource(R.drawable.tolove);


                TextView text = layout.findViewById(R.id.text);
                text.setText("¡Hola desde el botón 1 con icono!");

                toast.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "¡Hola desde el botón 2!", Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea y muestra la notificación expandible
                showExpandableNotification("Holaaaaa", "Como estas?");
            }

            private void showExpandableNotification(String title, String message) {
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                String channelId = "NOTIFICATION_URGENT_ID";

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelId)
                        .setSmallIcon(R.drawable.dharma)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.dharma))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                        .setPriority(NotificationCompat.PRIORITY_HIGH);


                int notificationId = 1; // Puedes elegir cualquier ID único para la notificación
                notificationManager.notify(notificationId, builder.build());
            }
        });

    }
}