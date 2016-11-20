package hackduke.foodprint;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ColorBackground extends AppCompatActivity {

    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_background);

        Intent intent = getIntent();
        String rest = intent.getStringExtra(DisplayMessageActivity.vendCode);
        String order = intent.getStringExtra(DisplayMessageActivity.orderCode);
        Transaction t = new Transaction(rest);
        double totalCO2 = t.eqCO2(order,rest);
        //String toPrint = Double.toString(totalCO2);
        double score = calcScore(totalCO2);
        //String toPrint = Double.toString(score);
        double carVal = totalCO2*2.33;

        TextView co2Display = (TextView)findViewById(R.id.co2);
        co2Display.setText("CO2 Emissions: " + Double.toString(totalCO2) + "kg" +
                "\n\nEquivalent Car Miles: "+ Double.toString(carVal) + "mi" +
                "\n\nYour Foodprint Grade: " + Double.toString(score));



        double green = (255*score)/((2*score)-100);
        double red = 255-green;
        double blue = 0;

        /*
        if(0<=score && score <50){
            green = 100;
            red = 2*score;
        }
        if(50<=score && score<=100) {
            red=100;
            green = 100 - 2*(score-50);
        }
        */
        int color = Color.argb(1,(int)red,(int)green,(int)blue);
        setBackground(color);

    }

    public double calcScore(double co2) {
        double out = (100/30)*co2;
        return 100-out;
    }

    public void setBackground(int rgb) {
        //RelativeLayout rl = (RelativeLayout)findViewById(R.id.activity_color_background);
        //System.out.println("Before " + rgb);
        View v = findViewById(R.id.activity_color_background);
        v.setBackgroundColor(rgb);
        //System.out.println("After " + rgb);
        //ColorBackground.this.runOnUiThread(new Runnable() {
          //  public void run() {
          //      findViewById(R.id.activity_color_background).setBackgroundColor(Color.parseColor(rgb));
          //  }
        //});
    }

}
