package com.example.firebasepractise;
import android.app.*;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PojoClassesActivity extends AppCompatActivity {
    private EditText inputID, inputName;
    private Button btnRead, btnSave;
    TextView textViewID,textViewName;
    private DatabaseReference UserRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pojo_classes);


        // Adding our Outlets in Database now:

      ItalianFoodOutlet italiTaste= new ItalianFoodOutlet("Itali Taste","Chandigarh");
        italiTaste.enterPizzaInMenu("Magretta Pizza",150.00f);
        italiTaste.enterPizzaInMenu("Cheese Overloaded Pizza",370.00f);
        italiTaste.enterPizzaInMenu("Fresh Farm Pizza",280.00f);
        italiTaste.enterBurgerInMenu("Aalo Tikki Burger",70.00f);
        italiTaste.enterBurgerInMenu("Maharaja Mac Burger",180.00f);
        italiTaste.enterBurgerInMenu("Jai-Veeru Burger",210.00f);
        // storing data in realtime database in firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Outlets");
        databaseReference.child("italiTaste").setValue(italiTaste);


        // storing data in firestore

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> italiTasteMap = new HashMap<>();
        italiTasteMap.put("name", italiTaste.getName());
        italiTasteMap.put("location", italiTaste.getLocation());
        //italiTasteMap.put("Menu Card",italiTaste.showMenu());

        // Menu
        Map<String, Object> menuMap = new HashMap<>();
        menuMap.put("Pizza", italiTaste.getPizzas());
        menuMap.put("Burger", italiTaste.getBurgers());
        italiTasteMap.put("Menu Card", menuMap);


        // Store the data in Firestore
        db.collection("outlets")
                .document("ItalianFoodOutlets") // Assuming "ItalianFoodOutlets" is the new layer
                .collection("Italic Taste")       // Add a new collection for the specific Italian food outlet
                .document("Italic Taste")          // Use the same document ID as before
                .set(italiTasteMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data successfully written
                    }
                });

        //  Creating Outlets

        SouthIndianFoodOutlet uniqueSouth=new SouthIndianFoodOutlet("Unique South Taste","Kerla");
        uniqueSouth.enterDosaInMenu("Masala Dosa",200);
        uniqueSouth.enterDosaInMenu("Cheese Panner Dosa",320);
        uniqueSouth.enterDosaInMenu("Special Dosa",350);
        uniqueSouth.enterIdliInMenu("Special Idli",50);
        uniqueSouth.enterVadaPawInMenu("Ultimate Vada",40);

        NorthIndianFoodOutlet spicyNorth= new NorthIndianFoodOutlet("Spicy North","Chandigarh");
        spicyNorth.enterVegThaliInMenu("North Special Veg",200);
        spicyNorth.enterVegThaliInMenu(" 3 Makki Di Roti + Sarso Ka Saag",300);
        spicyNorth.enterNonVegThaliInMenu("Butter Chicken+ 6 Roti",350);
        spicyNorth.enterSpecialThaliInMenu("Special North Thali",380);

        ChineseFoodOutlet yoChinese= new ChineseFoodOutlet("Yo Chinese","Delhi");
        yoChinese.enterNoodlesInMenu("Haqqa Noodles",70);
        yoChinese.enterNoodlesInMenu("Masala Noodles",70);
        yoChinese.enterMomooseInMenu("Steam Momoose",40);
        yoChinese.enterMomooseInMenu("Veg Momoose",30);
        yoChinese.enterMomooseInMenu("Non Veg Momoose",50);
        yoChinese.enterSpringRoleInMenu("Yo yo special Spring Roll",50);


        db = FirebaseFirestore.getInstance();
        Map<String, Object> uniqueSouthMap = new HashMap<>();
        uniqueSouthMap.put("name", uniqueSouth.getName());
        uniqueSouthMap.put("location", uniqueSouth.getLocation());

        // Menu
        Map<String, Object> MenuMap = new HashMap<>();
        MenuMap.put("Dosa", uniqueSouth.getDosas());
        MenuMap.put("Idli", uniqueSouth.getIdlis());
        MenuMap.put("Vada Paw", uniqueSouth.getVadaPaws());
        uniqueSouthMap.put("Menu Card", MenuMap);


        // Store the data in Firestore
        db.collection("outlets")
                .document("SouthIndianOutlets") // Assuming "ItalianFoodOutlets" is the new layer
                .collection("Unique South")
                .document("Unique South")
                .set(uniqueSouthMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data successfully written
                    }
                });


        // Storing NorthIndianFoodOutlets- spicyNorth
        db = FirebaseFirestore.getInstance();
        Map<String, Object> spicyNorthMap = new HashMap<>();
        spicyNorthMap.put("name", spicyNorth.getName());
        spicyNorthMap.put("location", spicyNorth.getLocation());

        // Menu
        Map<String, Object> spicyNorthMenuMap = new HashMap<>();
        spicyNorthMenuMap.put("VegThali", spicyNorth.getVegThalis());
        spicyNorthMenuMap.put("Non Veg Thali",  spicyNorth.getNonVegThalis());
        spicyNorthMenuMap.put("Special Thali",  spicyNorth.getSpecialThalis());
        spicyNorthMap.put("Menu Card", spicyNorthMenuMap);
        db.collection("outlets")
                .document("NorthIndianFoodOutlets") // Assuming "ItalianFoodOutlets" is the new layer
                .collection("SpicyNorth")
                .document("Spicy North")
                .set(spicyNorthMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data successfully written
                    }
                });


        // Storing ChineseFoodOutlet - Yo Chinese
        db = FirebaseFirestore.getInstance();
        Map<String, Object> YoChineseMap = new HashMap<>();
        spicyNorthMap.put("name", spicyNorth.getName());
        spicyNorthMap.put("location", spicyNorth.getLocation());

        // Menu
        Map<String, Object> YoChineseMenuMap = new HashMap<>();
        YoChineseMenuMap.put("Noodles", yoChinese.getNoodles());
        YoChineseMenuMap.put("Momoose",  yoChinese.getMomoose());
        YoChineseMenuMap.put("Spring Rolls",  yoChinese.getSpringRolls());
        YoChineseMap.put("Menu Card", YoChineseMenuMap);
        db.collection("outlets")
                .document("ChineseFoodOutlets") // Assuming "ItalianFoodOutlets" is the new layer
                .collection("Yo Chinese")
                .document("Yo Chinese")
                .set(YoChineseMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data successfully written
                    }
                });























        // Additional
        // Adding pojo Objects Manually.

       Person Gurmeet=new Person(25,"Gurmeet Singh");
        Person Sahib= new Person(22,"Sahib");
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");


        databaseReference.child("Gurmeet").setValue(Gurmeet);
        databaseReference.child("Sahib").setValue(Sahib);



        databaseReference.child("users").child(Gurmeet.getName()).setValue(Gurmeet);
        databaseReference.child("users").child(Sahib.getName()).setValue(Sahib);

        // Taking Input from User

        inputID=findViewById(R.id.inputID);
        inputName=findViewById(R.id.inputName);
        btnSave=findViewById(R.id.btnSave);


        UserRef= databaseReference.child("User");

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int id =Integer.parseInt(inputID.getText().toString());
                String name=inputName.getText().toString();
                Person person =new Person(id,name);
                UserRef.setValue(person).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(PojoClassesActivity.this,"Data is added",Toast.LENGTH_SHORT).show();
                        // Handle success here
                    }
                });
            }
        });

    }


}
