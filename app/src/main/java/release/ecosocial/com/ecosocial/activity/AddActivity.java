package release.ecosocial.com.ecosocial.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;


import com.google.android.gms.maps.model.LatLng;


import java.util.Calendar;

import release.ecosocial.com.ecosocial.R;
import release.ecosocial.com.ecosocial.model.Eventos;

public class AddActivity extends AppCompatActivity {
    static Eventos eventos;

    private EditText outroEditText;
    private Button buttonAvancar;

    private RadioGroup radioGroup;
    private LatLng localizacao;
    private String      tipoevento;
    private Switch aSwitchSemlimitetempo;
    private EditText    editTextData;
    private EditText    editTextHora;
    private int         year_x,month_x,day_x,hour_x,minute_x,hora;
    static final int    DIALOG_ID_DATE = 0;
    static final int    DIALOG_ID_TIME = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        radioGroup              = findViewById(R.id.radioGroup);
        outroEditText           = findViewById(R.id.editText_outro);
        buttonAvancar           = findViewById(R.id.button_adicionar_evento);
        aSwitchSemlimitetempo   = findViewById(R.id.switch_sem_limite_tempo);
        editTextData            = findViewById(R.id.editText_data_2);
        editTextHora            = findViewById(R.id.editText_hora);

        //mascara para a data
//        SimpleMaskFormatter simpleMaskdata = new SimpleMaskFormatter( "NN/NN/NNNN" );
//        SimpleMaskFormatter simpleMaskhora = new SimpleMaskFormatter( "NN:NN" );
//        MaskTextWatcher maskData = new MaskTextWatcher(editTextData,simpleMaskdata);
//        MaskTextWatcher maskHora = new MaskTextWatcher(editTextHora,simpleMaskhora);
//        editTextData.addTextChangedListener(maskData);
//        editTextHora.addTextChangedListener(maskHora);

        //database
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//        reference.child("01").setValue("40");

        final Calendar calendar = Calendar.getInstance();
        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_MONTH);


        editTextData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID_DATE);
            }
        });

        editTextHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID_TIME);
            }
        });


        buttonAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // addEvent();
//                SelectOnMapFragment fragment = new SelectOnMapFragment();
//                android.support.v4.app.FragmentTransaction fragmentTransaction =
//                        getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.fragment_container_add_event, fragment);
//                fragmentTransaction.commit();
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("message");
//                myRef.setValue("Hello, World!");
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_button_animal_perdido){
                    tipoevento = "Animal Perdido";
                    outroEditText.setEnabled(false);
                    Toast.makeText(AddActivity.this,"Animal",Toast.LENGTH_LONG).show();
                } else if (checkedId == R.id.radio_button_coleta_de_lixo){
                    tipoevento = "Coleta de lixo";
                    outroEditText.setEnabled(false);
                    Toast.makeText(AddActivity.this,"Coleta",Toast.LENGTH_LONG).show();
                } else if (checkedId == R.id.radio_button_outro){
                    outroEditText.setEnabled(true);
                    tipoevento = outroEditText.getText().toString();
                }
            }
        });




//        aSwitchSemlimitetempo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (aSwitchSemlimitetempo.isActivated()){
//                    Log.i("if",String.valueOf( aSwitchSemlimitetempo.isActivated()));
//                    editTextHora.setEnabled(false);
//                    hora = 0000;
//                    editTextData.setText(hora);
//                }else {
//                    Log.i("else",String.valueOf( aSwitchSemlimitetempo.isActivated()));
//                    editTextHora.setEnabled(true);
//                    editTextHora.setText("0000");
//                    hora = Integer.parseInt(editTextHora.getText().toString().replace("/",""));
//                }
//            }
//        });
    }
}
