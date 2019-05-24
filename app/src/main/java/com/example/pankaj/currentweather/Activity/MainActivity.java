package com.example.pankaj.currentweather.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pankaj.currentweather.Database.AppDatabase;
import com.example.pankaj.currentweather.Model.MyModel;
import com.example.pankaj.currentweather.R;
import com.example.pankaj.currentweather.Rest.ApiClient;
import com.example.pankaj.currentweather.Rest.ApiInterface;
import com.example.pankaj.currentweather.entity.User;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_temp)
    TextView temp;
    @BindView(R.id.tv_region)
    TextView city;
    @BindView(R.id.et_city)
    EditText et_cityname;
    @BindView(R.id.btn_temp)
    Button btn_show;
    @BindView(R.id.lastupdated)
    TextView lastupdated;
    @BindView(R.id.condition)
    TextView condition;
    @BindView(R.id.country)
    TextView country;
    @BindView(R.id.region)
    TextView region;
    @BindView(R.id.humidity)
    TextView humidity;
    @BindView(R.id.wind)
    TextView wind;
    @BindView(R.id.cl)
    ConstraintLayout constraintLayout;
    boolean connected = false;

    private static final String API_KEY = "23f8d0450ac946e58ae155120192803";
    String category = "current.json";
    //String q="";


    private static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;
    private String TAG=this.getClass().getSimpleName();
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //final String q=et_cityname.getText().toString();
        userViewModel=ViewModelProviders.of(this).get(UserViewModel.class);

        try {


            userViewModel.getalldata().observe(this, new Observer<User>() {
                @Override
                public void onChanged(User user) {
                    if (user != null) {
                        String s = user.getCountry();
                        temp.setText(user.getTemp() + " " + "C");
                        city.setText(user.getName());
                        lastupdated.setText("LastUpdate" + ":" +user.getLastupdated());
                        condition.setText("Condition" + ":" + user.getCondition());
                        country.setText(user.getCountry());
                        region.setText(user.getRegion());
                        humidity.setText("Humidity" + ":" + user.getHumidity());
                        wind.setText("WindDegree" + ":" + user.getWind());
                        // notifyDatasetChanged();
                    }
                }
            });
        }catch (Exception e){
            retriveData();
        }
        //if(!isConnected()) {
    if (API_KEY.isEmpty()) {
        Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
        return;
    }

    btn_show.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          //  if (!isConnected()) {

                ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<MyModel> call = apiInterface.getData(category, API_KEY, et_cityname.getText().toString());
            et_cityname.setText("");

                call.enqueue(new Callback<MyModel>() {
                    @Override
                    public void onResponse(Call<MyModel> call, Response<MyModel> response) {
                        MyModel myModel = response.body();
                        String s = myModel.getCurrent().getTemp_c();
                        adddatatoRoom(myModel);
                        temp.setText(myModel.getCurrent().getTemp_c() + " " + "C");
                        city.setText(myModel.getLocaltion().getName());
                        lastupdated.setText("LastUpdate" + ":" + myModel.getCurrent().getLast_updated());
                        condition.setText("Condition" + ":" + myModel.getCurrent().getConditn().getText());
                        country.setText(myModel.getLocaltion().getCountry());
                        region.setText(myModel.getLocaltion().getRegion());
                        humidity.setText("Humidity" + ":" + myModel.getCurrent().getHumidity());
                        wind.setText("WindDegree" + ":" + myModel.getCurrent().getWind_degree());
                    }

                    @Override
                    public void onFailure(Call<MyModel> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            /*}else{
                Snackbar snackbar = Snackbar.make(constraintLayout,"Please check Internet",Snackbar.LENGTH_SHORT);
                snackbar.show();
            }*/
        }
    });
/*}else {
    Snackbar snackbar = Snackbar.make(constraintLayout,"Please check Internet",Snackbar.LENGTH_SHORT);
    snackbar.show();
}*/

    }
    void adddatatoRoom(MyModel model){
     try {
         final String note_id = UUID.randomUUID().toString();
         User user = new User(note_id,model.getCurrent().getTemp_c(),model.getCurrent().getLast_updated(),
                 model.getCurrent().getConditn().getText(),model.getCurrent().getHumidity(),model.getCurrent().getWind_degree(),model.getLocaltion().getName(), model.getLocaltion().getCountry(),
                 model.getLocaltion().getRegion());

            userViewModel.insert(user);

         Toast.makeText(getApplicationContext(), "SAVED", Toast.LENGTH_LONG).show();
     }catch (Exception e){
         e.printStackTrace();
     }
    }

    void retriveData(){
        try {
            userViewModel.getalldata().observe(this, new Observer<User>() {
                @Override
                public void onChanged(User user) {
                    String s = user.getCountry();
                    temp.setText(user.getTemp() + " " + "C");
                    city.setText(user.getName());
                    lastupdated.setText("LastUpdate" + ":" + user.getLastupdated());
                     condition.setText("Condition" + ":" + user.getCondition());
                    country.setText(user.getCountry());
                    region.setText(user.getRegion());
                    humidity.setText("Humidity" + ":" +user.getHumidity());
                    wind.setText("WindDegree" + ":" + user.getWind());
                     //notifyDatasetChanged();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

   public boolean isConnected() {
       ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        }

          return false;
    }

}


