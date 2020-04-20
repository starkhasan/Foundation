package com.jsonstore.jsonstore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jsonstore.jsonstore.response.GetSaleTypeResponse;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SaleTypeDBHelper saleTypeDBHelper;
    ArrayList<String> arrayList;
    EditText setID,jsonID,etfetchID;
    Button fetchData,setData,btndelete,btnDeleteAll,btnFetchAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String jsonData = "{\n" +
                "  \"sale_type\": {\n" +
                "    \"data\": [\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"1\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-12%\",\n" +
                "          \"value\": \"12%\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"2\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-18%\",\n" +
                "          \"value\": \"18%\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"3\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-28%\",\n" +
                "          \"value\": \"28%\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"4\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-5%\",\n" +
                "          \"value\": \"5%\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"5\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-Exempt\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"6\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-Export(Taxable)\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"7\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-Export(ZeroRated)\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"8\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-ItemWise\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"9\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-MultiRate\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"10\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-TaxIncl.\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"11\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"I/GST-ZeroRated\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"12\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"L/GST-12%\",\n" +
                "          \"value\": \"12%\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"13\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"L/GST-18%\",\n" +
                "          \"value\": \"18\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"14\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"L/GST-28%\",\n" +
                "          \"value\": \"28%\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"15\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"L/GST-5%\",\n" +
                "          \"value\": \"5%\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"16\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"L/GST-Exempt\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"17\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"L/GST-ItemWise\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"18\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"L/GST-MultiRate\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"19\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"L/GST-StockTrf.\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"20\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"L/GST-TaxIncl.\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"sale-types\",\n" +
                "        \"id\": \"21\",\n" +
                "        \"attributes\": {\n" +
                "          \"name\": \"L/GST-ZeroRated\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"status\": 200\n" +
                "}";

        fetchData = findViewById(R.id.btnGetData);
        setData = findViewById(R.id.btnSetData);
        btndelete = findViewById(R.id.btnDelete);
        setID = findViewById(R.id.etID);
        jsonID = findViewById(R.id.etJSONID);
        etfetchID = findViewById(R.id.etfetchID);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);
        btnFetchAll = findViewById(R.id.btnFetchAll);


        saleTypeDBHelper = new SaleTypeDBHelper(this);
        saleTypeDBHelper.getWritableDatabase();


        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(setID.getText().toString().equalsIgnoreCase("")){
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Delete")
                            .setMessage("Please Enter Delete ID")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                            .show();
                }else{
                    saleTypeDBHelper.deleteData(setID.getText().toString());
                    setID.setText("");
                }
            }
        });



        setData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jsonID.getText().toString().equalsIgnoreCase("")){
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Insert Data")
                            .setMessage("Please Enter the ID")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                            .show();
                }else{
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(jsonData.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    boolean flag = saleTypeDBHelper.insertData(jsonID.getText().toString(),jsonObject.toString());
                    if(flag){
                        jsonID.setText("");
                        Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Not Inserted",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        fetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etfetchID.getText().toString().equalsIgnoreCase("")){
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Fetch Data")
                            .setMessage("Please Enter the ID")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                            .show();
                }else{
                    arrayList = saleTypeDBHelper.fetchData(etfetchID.getText().toString());
                    Toast.makeText(getApplicationContext(),String.valueOf(arrayList.size()),Toast.LENGTH_SHORT).show();
                    etfetchID.setText("");
                }
            }
        });

        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Reset")
                        .setMessage("Are you sure you want to Reset?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                saleTypeDBHelper.deleteAll();
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
            }
        });


        btnFetchAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList = saleTypeDBHelper.fetchALL();
                Toast.makeText(MainActivity.this,String.valueOf(arrayList.size()),Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void getSaleTypeResponse(String response){
        Gson g = new Gson();
        GetSaleTypeResponse p = g.fromJson(response, GetSaleTypeResponse.class);
        int str = p.getSale_type().getData().size();
        Toast.makeText(getApplicationContext(),String.valueOf(str),Toast.LENGTH_SHORT).show();
    }
}
