package com.example.xiaoyuliang.foodie;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xiaoyuliang.foodie.Adapter.RecommandAdapter;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xiaoyuliang on 5/8/17.
 */
public class UserProfile extends AppCompatActivity {

    private ImageView profile;
    private TextView name, description,label1,label2,label3,label4;
    private Context context;
    public static final HashMap<String, Integer> LABEL_COLORS = new HashMap<String, Integer>()
    {{

        put("Suchi", com.example.xiaoyuliang.foodie.R.color.Suchi);
        put("Mexico", com.example.xiaoyuliang.foodie.R.color.Mexico);
        put("Chinese", com.example.xiaoyuliang.foodie.R.color.Chinese);
        put("India", com.example.xiaoyuliang.foodie.R.color.India);
        put("Greece", com.example.xiaoyuliang.foodie.R.color.Greece);
        put("Englian", com.example.xiaoyuliang.foodie.R.color.Englian);
        put("Italy", com.example.xiaoyuliang.foodie.R.color.Italy);
        put("El_Salvador", com.example.xiaoyuliang.foodie.R.color.El_Salvador);
    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPref sharedPref = new SharedPref(this);

        Log.v("skip status2", "" + sharedPref.getLoginSkipStatus());
        Log.v("login status2", "" + sharedPref.getLoginStatus());

        setContentView(R.layout.new_activity_user_profile);
        context = this;
        final ArrayList<Recommendation> resList = Recommendation.getRecipesFromFile("restaurant.json", this);
        RecommandAdapter adapter = new RecommandAdapter(this, resList);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        name = (TextView) findViewById(R.id.name);
        profile = (ImageView) findViewById(R.id.profile);
        description = (TextView) findViewById(R.id.description);
        label1 = (TextView) findViewById(R.id.label1);
        label2 = (TextView) findViewById(R.id.label2);
        label3 = (TextView) findViewById(R.id.label3);
        label4 = (TextView) findViewById(R.id.label4);
        loadHomePage();
    }
    private void loadHomePage() {

        Picasso.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .resize(128, 128)
                .transform(new CircleTransform())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(profile);
        name.setText("Customer name");
        description.setText("Description");
        label1.setText("Suchi");
        label2.setText("Mexico");
        label3.setText("Chinese");
        label4.setText("India");
        label1.setBackgroundColor(android.support.v4.content.ContextCompat.getColor(context, LABEL_COLORS
                .get("Suchi")));
        label2.setBackgroundColor(android.support.v4.content.ContextCompat.getColor(context, LABEL_COLORS.get("Mexico")));
        label3.setBackgroundColor(android.support.v4.content.ContextCompat.getColor(context, LABEL_COLORS.get("Chinese")));
        label4.setBackgroundColor(android.support.v4.content.ContextCompat.getColor(context, LABEL_COLORS.get("India")));

    }
}
//        if(!sharedPref.getLoginStatus() || sharedPref.getLoginSkipStatus()){
//            Intent i=new Intent(UserProfile.this, LoginActivity.class);
//            i.putExtra("skip_visible",false);
//            startActivity(i);
//            finish();
//        }

//        setContentView(R.layout.activity_user_profile);
//        nameUser = (TextView)findViewById(R.id.nameUser);
//
//        emailUser= (TextView)findViewById(R.id.emailUser);
//        bar      = (ProgressBar)findViewById(R.id.progress1);
//        r1       = (LinearLayout)findViewById(R.id.layout1);
//        imageUser= (ImageView)findViewById(R.id.imageUser);
        /*
        SharedPref s1 = new SharedPref(UserProfile.this);
        id = s1.getUserKey();

//        Toast.makeText(this,id+"",Toast.LENGTH_LONG).show();
        */
//        logout = (Button)findViewById(R.id.logoutbutton);
//
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LoginManager.getInstance().logOut();
//
//                SharedPref s= new SharedPref(UserProfile.this);
//                s.setLoginStatus(false);
//                s.setLoginSkipStatus(false);
//                s.setUserKey(null);
//
//                Intent i = new Intent(UserProfile.this, LoginActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(i);
//            }
//        });
//
//        retrofit();

//    }

//    public void retrofit(){
//
//        ApiInterFace apiservice= Utils.getRetrofitService();
//        Call<UserProfile_model> call=apiservice.getUserInfo(id);
//
//
//        call.enqueue(new Callback<UserProfile_model>() {
//            @Override
//            public void onResponse(Call<UserProfile_model> call, Response<UserProfile_model> response) {
//                bar.setVisibility(View.GONE);
//
//                UserProfile_model model=response.body();
//                int status=response.code();
//
//                bar.setVisibility(View.GONE);
//                r1.setVisibility(View.VISIBLE);
//
//                if(model==null){
//                    finish();
//
//                    LoginManager.getInstance().logOut();
//                    SharedPref s= new SharedPref(UserProfile.this);
//                    s.setLoginStatus(false);
//                    s.setLoginSkipStatus(false);
//                    s.setUserKey(null);
//
//                    return;
//                }
//
//                picUrl=model.getPicUrl();
//
//                if(model.getNameUser()!=null)
//                {
//                    nameUser.setText(model.getNameUser());
//                    logout.setVisibility(View.VISIBLE);
//                }else
//                {
//                    nameUser.setText("No name Found!!");
//                }
//
//                if(model.getEmailuser()!=null) {
//                    emailUser.setText(model.getEmailuser());
//                }else{
//                    emailUser.setText("No email found!!");
//                }
//
//                if(picUrl!=null) {
//                    //temp
//                    Glide.with(UserProfile.this).load(picUrl).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(imageUser);
//                }
//
//                // bar.setVisibility(View.GONE);
//
//            }
//
//            @Override
//            public void onFailure(Call<UserProfile_model> call, Throwable t) {
//
//                //bar.setVisibility(View.GONE);
//                Toast.makeText(UserProfile.this,"Some error occurred!!",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}
