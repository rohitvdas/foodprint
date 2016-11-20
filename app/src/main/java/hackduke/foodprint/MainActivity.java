package hackduke.foodprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button submitBtn;
    public final static String EXTRA_MESSAGE = "hackduke.foodprint.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        addListenerOnVendorSelection();
    }

    public void addListenerOnVendorSelection() {
        spinner = (Spinner) findViewById(R.id.spinner);
        //spinner.setOnItemSelectedListener(new CustomListener());
    }

    public void addListenerOnButton() {

        spinner = (Spinner) findViewById(R.id.spinner);
        submitBtn = (Button)findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMenu(view);
            }
        });

    }

    public void displayMenu(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String vendor = String.valueOf(spinner.getSelectedItem());
        intent.putExtra(EXTRA_MESSAGE, vendor);
        startActivity(intent);
    }



}
