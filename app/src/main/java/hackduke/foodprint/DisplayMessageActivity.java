package hackduke.foodprint;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity {

    private Spinner vendor_menu;
    private Button finalSubmit;
    public final static String vendCode = "vendor";
    public final static String orderCode = "order";
    private String order;
    private String restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        restaurant = message;
        createMenu(message);

        addButtonListener();

    }

    public void createMenu(String vendor) {
        vendor_menu = (Spinner)findViewById(R.id.menu);
        List<String> list;
        if (vendor.equals("McDonald\'s")) {
            String array[] = getResources().getStringArray(R.array.mcDs_menu);
            list  = new ArrayList<String>(Arrays.asList(array));
        }
        else if (vendor.equals("Tandoor")) {
            String array[] = getResources().getStringArray(R.array.tandoor_menu);
            list  = new ArrayList<String>(Arrays.asList(array));
        }
        else {
            String array[] = getResources().getStringArray(R.array.farmstead_menu);
            list  = new ArrayList<String>(Arrays.asList(array));
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vendor_menu.setAdapter(dataAdapter);
    }

    public void addButtonListener() {
        finalSubmit = (Button)findViewById(R.id.finalSubmit);
        finalSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackground();
            }
        });
    }

    public void changeBackground() {
        Intent intent = new Intent(this, ColorBackground.class);
        //int rgb = Color.RED;
        order = String.valueOf(vendor_menu.getSelectedItem());
        intent.putExtra(vendCode,restaurant);
        intent.putExtra(orderCode,order);
        startActivity(intent);
    }

}
