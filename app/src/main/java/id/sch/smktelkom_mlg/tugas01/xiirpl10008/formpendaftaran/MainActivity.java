package id.sch.smktelkom_mlg.tugas01.xiirpl10008.formpendaftaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    Button Bok;
    TextView tvHasil;
    RadioGroup rgJK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        Bok = (Button) findViewById(R.id.buttonOK);
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        Bok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });

    }

    private void doClick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            tvHasil.setText("Nama :" + nama);
        }

        String JK = null
        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            JK = rb.getText().toString();
        }


    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 4) {
            etNama.setError("Nama minimal 4 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }

}
