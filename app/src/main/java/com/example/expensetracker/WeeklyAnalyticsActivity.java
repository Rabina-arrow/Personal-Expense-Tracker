package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.anychart.AnyChartView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WeeklyAnalyticsActivity extends AppCompatActivity {
    private Toolbar settingsToolbar;

    private FirebaseAuth mAuth;
    private String onlineUserId= "";
    private DatabaseReference expensesRef,personalRef;

    private TextView totalBudgetAmountTextView,analyticsTransportAmount,analyticsFoodAmount,analyticsHouseAmount,analyticsEntertainmentAmount,analyticsEducationAmount,analyticsCharityAmount,analyticsClothingAmount,analyticsHealthAmount,analyticsLendAmount,analyticsOthersAmount,monthSpentAmount;
    private RelativeLayout linearLayoutTransport,linearLayoutFood,linearLayoutHouse,linearLayoutEntertainment,linearLayoutEducation,linearLayoutCharity,linearLayoutClothing,linearLayoutHealth,linearLayoutLend,linearLayoutOthers,linearLayoutAnalysis;

    private AnyChartView anyChartView;
    private TextView progress_ratio_transport,progress_ratio_food,progress_ratio_house,progress_ratio_entertainment,progress_ratio_education,progress_ratio_charity,progress_ratio_clothing,progress_ratio_health,progress_ratio_lend,progress_ratio_others,monthRatioSpending;
    private ImageView transport_status,food_status,house_status,entertainment_status,education_status,charity_status,clothing_status,health_status,lend_status,others_status,monthRatioSpending_Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_analytics);



        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Weekly Analytics");

        mAuth= FirebaseAuth.getInstance();
        onlineUserId = mAuth.getCurrentUser().getUid();
        expensesRef = FirebaseDatabase.getInstance().getReference("expenses").child(onlineUserId);
        personalRef = FirebaseDatabase.getInstance().getReference("personal").child(onlineUserId);

        totalBudgetAmountTextView= findViewById(R.id.totalBudgetAmountTextView);

        monthSpentAmount = findViewById(R.id.monthSpentAmount);
        linearLayoutAnalysis = findViewById(R.id.linearLayoutAnalysis);
        monthRatioSpending = findViewById(R.id.monthRatioSpending);
        monthRatioSpending_Image = findViewById(R.id.monthRatioSpending_Image);

        analyticsTransportAmount= findViewById(R.id.analyticsTransportAmount);
        analyticsFoodAmount= findViewById(R.id.analyticsFoodAmount);
        analyticsHouseAmount= findViewById(R.id.analyticsHouseAmount);
        analyticsEntertainmentAmount= findViewById(R.id.analyticsEntertainmentAmount);
        analyticsEducationAmount = findViewById(R.id.analyticsEducationAmount);
        analyticsCharityAmount = findViewById(R.id.analyticsCharityAmount);
        analyticsHealthAmount = findViewById(R.id.analyticsHealthAmount);
        analyticsLendAmount = findViewById(R.id.analyticsLendAmount);
        analyticsClothingAmount = findViewById(R.id.analyticsClothingAmount);
        analyticsOthersAmount = findViewById(R.id.analyticsOthersAmount);

        linearLayoutCharity = findViewById(R.id.linearLayoutCharity);
        linearLayoutClothing = findViewById(R.id.linearLayoutClothing);
        linearLayoutEducation = findViewById(R.id.linearLayoutEducation);
        linearLayoutEntertainment = findViewById(R.id.linearLayoutEntertainment);
        linearLayoutFood = findViewById(R.id.linearLayoutFood);
        linearLayoutHealth = findViewById(R.id.linearLayoutHealth);
        linearLayoutHouse = findViewById(R.id.linearLayoutHouse);
        linearLayoutLend = findViewById(R.id.linearLayoutLend);
        linearLayoutOthers = findViewById(R.id.linearLayoutOthers);
        linearLayoutTransport = findViewById(R.id.linearLayoutTransport);


        progress_ratio_charity = findViewById(R.id.progress_ratio_charity);
        progress_ratio_clothing = findViewById(R.id.progress_ratio_clothing);
        progress_ratio_education = findViewById(R.id.progress_ratio_education);
        progress_ratio_entertainment = findViewById(R.id.progress_ratio_entertainment);
        progress_ratio_health = findViewById(R.id.progress_ratio_health);
        progress_ratio_house = findViewById(R.id.progress_ratio_house);
        progress_ratio_food= findViewById(R.id.progress_ratio_food);
        progress_ratio_lend = findViewById(R.id.progress_ratio_lend);
        progress_ratio_others = findViewById(R.id.progress_ratio_others);
        progress_ratio_transport = findViewById(R.id.progress_ratio_transport);


        food_status = findViewById(R.id.food_status);
        charity_status = findViewById(R.id.charity_status);
        clothing_status = findViewById(R.id.clothing_status);
        education_status = findViewById(R.id.education_status);
        entertainment_status = findViewById(R.id.entertainment_status);
        health_status = findViewById(R.id.health_status);
        house_status = findViewById(R.id.house_status);
        lend_status = findViewById(R.id.lend_status);
        others_status = findViewById(R.id.others_status);
        transport_status = findViewById(R.id.transport_status);

        anyChartView = findViewById(R.id.anyChartView);





    }
}