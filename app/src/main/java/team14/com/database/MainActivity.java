package team14.com.database;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private BluetoothAdapter adapter;
    private DatabaseManager databaseManager;
    private Button connect_button;

    private boolean butStatus = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothManager manager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE );
        adapter = manager.getAdapter();
        if (adapter == null){
            Log.e(TAG, "Bluetooth Adapter not available");
            return;
        }
        if (!adapter.isEnabled()){
            Log.d(TAG, "onCreate: Bluetooth is not turned on, turning on bluetooth");
            adapter.enable();
        }
        connect_button = (Button) findViewById(R.id.connection);

        connect_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (butStatus==false){
                    databaseManager.startService(); //Perform action on click
                    connect_button.setText("Connecting...");
                    Toast.makeText(getApplicationContext(),"Connecting...",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseManager.stopService();
                    connect_button.setText("CONNECT TO THE WEATHER SERVICE");
                    butStatus=false;
                }
            }

        });
        
        //TODO : CREATE NEW FUNCTIONS FOR WRITE AND READ (IN DATABASEMANAGER FILE!!!!) AND INVOCATE THEM FROM HERE VIA BUTTONS
 ;

    }
}
