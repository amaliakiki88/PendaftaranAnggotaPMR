package id.sch.smktelkom_mlg.tugas01.xiirpl10008.formpendaftaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    Button Bok;
    TextView tvHasil;
    RadioGroup rgJK;
    CheckBox cbPP, cbSJ, cbPK, cbDD;
    Spinner spKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        Bok = (Button) findViewById(R.id.buttonOK);
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        cbSJ = (CheckBox) findViewById(R.id.checkBoxSJ);
        cbPP = (CheckBox) findViewById(R.id.checkBoxPP);
        cbPK = (CheckBox) findViewById(R.id.checkBoxPK);
        cbDD = (CheckBox) findViewById(R.id.checkBoxDD);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);

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
        }

        String JK = null;
        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            JK = rb.getText().toString();
        }

        String materi = "Materi yang dimengerti : \n";
        int startlen = materi.length();
        int ygDicentang = 0;
        if (cbSJ.isChecked()) {
            materi += cbSJ.getText() + "\n";
            ygDicentang++;
        }
        if (cbPP.isChecked()) {
            materi += cbPP.getText() + "\n";
            ygDicentang++;
        }
        if (cbPK.isChecked()) {
            materi += cbPK.getText() + "\n";
            ygDicentang++;
        }
        if (cbDD.isChecked()) {
            materi += cbDD.getText() + "\n";
            ygDicentang++;
        }

        if (materi.length() == startlen) materi += "Tidak ada pada pilihan";

        if (ygDicentang >= 2) {
            StringBuilder builder = new StringBuilder();
            builder.append("Selamat Anda Diterima! \n \n");
            builder.append("Nama : " + etNama.getText().toString() + "\n");
            builder.append("Kelas :" + spKelas.getSelectedItem().toString() + "\n");
            builder.append("Jenis Kelamin :" + JK + "\n");
            builder.append(materi + "\n");

            tvHasil.setText(builder);
        } else {
            tvHasil.setText("Maaf anda tidak diterima");
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
