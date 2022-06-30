package curso.kotlin.gpsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mMap;

    String[] permissoesRequeridas = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS
    };

    public static final int APP_PERMISSOES_ID = 2022; // Pode ser qualquer número

    TextView txtValorLatitude, txtValorLongitude;
    double latitude, longitude;

    // Passo 1- Verificar se a localização está ativada

    LocationManager locationManager;

    boolean gspAtivo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorLatitude = findViewById(R.id.txtValorLatitude);
        txtValorLongitude = findViewById(R.id.txtValorLongitude);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Passo 2- Conferir os serviços disponíveis via LocationManager
        locationManager = (LocationManager) getApplication().getSystemService(Context.LOCATION_SERVICE);

        gspAtivo = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (gspAtivo) {
            obterCoordenadas();
        } else {
            latitude = longitude = 0.0;

            txtValorLatitude.setText(String.valueOf(latitude));
            txtValorLongitude.setText(String.valueOf(longitude));

            Toast.makeText(this, "Coordenadas não disponíveis", Toast.LENGTH_LONG).show();
        }
    }

    private void obterCoordenadas() {
        boolean permissaoAtiva = solicitarPermissaoParaObterLocalizacao();

        if (permissaoAtiva) {
            capturarUltimaLocalizacaoValida();
        }
    }

    private boolean solicitarPermissaoParaObterLocalizacao() {
        Toast.makeText(this, "Verificando permissões...", Toast.LENGTH_LONG).show();

        List<String> permissoesNegadas = new ArrayList<>();

        int permissaoNegada;


        for (String permissao : this.permissoesRequeridas) {
            permissaoNegada = ContextCompat.checkSelfPermission(MainActivity.this, permissao);

            if (permissaoNegada != PackageManager.PERMISSION_GRANTED) {
                permissoesNegadas.add(permissao);
            }
        }

        if (!permissoesNegadas.isEmpty()) {
            ActivityCompat.requestPermissions(MainActivity.this, permissoesNegadas.toArray(new String[permissoesNegadas.size()]), APP_PERMISSOES_ID);

            return false;
        } else {
            return true;
        }

    }

    private void capturarUltimaLocalizacaoValida() {

        @SuppressLint("MissingPermission")
        Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        @SuppressLint("MissingPermission")
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (location != null || locationGPS != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        } else {
            latitude = longitude = 0.0;
        }

        txtValorLatitude.setText(String.valueOf(formatarGeopoint(latitude)));
        txtValorLongitude.setText(String.valueOf(formatarGeopoint(longitude)));

        Toast.makeText(this, "Coordenadas obtidas com sucesso!", Toast.LENGTH_LONG).show();
    }

    private String formatarGeopoint(double valor) {
        DecimalFormat decimalFormat = new DecimalFormat("#.######");

        return decimalFormat.format(valor);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng localizacaoCelular = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(localizacaoCelular).title("Celular localizado aqui"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(localizacaoCelular));
    }
}