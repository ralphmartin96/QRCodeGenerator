package qrcodegenerator.example.user.qrcodegenerator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //DatabaseHelper myDb;

    Button generateBtn;
    EditText input;
    String encryptedData;

    public final static int WIDTH=500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateBtn = (Button) findViewById(R.id.generateBtn);
        input = (EditText) findViewById(R.id.input);

        generateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this, input.getText(), Toast.LENGTH_SHORT).show();

                try {
                    encryptedData = AESencryption.encrypt(input.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, QRGenerator.class);
                intent.putExtra("encryptedInput", encryptedData);
                startActivity(intent);
            }
        });
    }

}
