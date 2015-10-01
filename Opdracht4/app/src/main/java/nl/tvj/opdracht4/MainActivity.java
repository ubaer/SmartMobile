package nl.tvj.opdracht4;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //variablen
    List<Product> allProducts = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FillProducten();
        FillListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void FillProducten(){
        allProducts.clear();
        Context context = this;
        AssetManager am = context.getAssets();
        File file ;
        try {
            InputStream in = am.open("test.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                int mark = line.indexOf("!");
                String naam = line.substring(0, mark);
                String prijs = line.substring(mark +1);
                Product p = new Product(naam,prijs);

                allProducts.add(p);
                Log.d("Producten", p.toString());
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public void FillListView()
    {
        ArrayAdapter<Product> productArrayAdapter = new ArrayAdapter<Product>(this, R.layout.support_simple_spinner_dropdown_item, allProducts);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(productArrayAdapter);
    }

    public void btnAdd(View view) {

    }
}
