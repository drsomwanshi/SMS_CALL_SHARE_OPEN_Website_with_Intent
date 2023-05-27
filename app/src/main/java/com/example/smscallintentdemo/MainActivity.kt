package com.example.smscallintentdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fun1(view: View) {
        var txt1=findViewById(R.id.txt1) as EditText
        var add=txt1.text.toString();
        var i= Intent(Intent.ACTION_VIEW)
        i.setData(Uri.parse(add))
        startActivity(i)
    }
    fun fun2(view: View) {
        var txt2=findViewById(R.id.txt2) as EditText
        var mob=txt2.text.toString();
        var i= Intent(Intent.ACTION_DIAL)
        i.setData(Uri.parse("tel:"+mob))
        startActivity(i)
    }
    fun fun3(view: View) {
        var txt3=findViewById(R.id.txt3) as EditText
        var data=txt3.text.toString();
        var i= Intent(Intent.ACTION_SEND)
        i.putExtra(Intent.EXTRA_TEXT,data)
        i.type="text/plain"
        startActivity(Intent.createChooser(i,"Send To"));

    }
    fun fun4(view: View) {
        var txt2=findViewById(R.id.txt2) as EditText
        var mob=txt2.text.toString();

        var txt3=findViewById(R.id.txt3) as EditText
        var msg=txt3.text.toString();

        var i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse("smsto:")
        i.type = "vnd.android-dir/mms-sms"
        i.putExtra("address", mob)
        i.putExtra("sms_body", msg)
        startActivity(i)
    }

}