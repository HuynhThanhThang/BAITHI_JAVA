package customlistviewcustomlistview.cheng.com.baithuchanhso3;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private FloatingActionButton floatingActionButton;
    private EditText edtName;
    private EditText edtNumber;
    private EditText edtdate;
    private EditText edtemail;
    private ImageView btnAddContact, b1;
    private ListView lvContact;
    private ImageView imageView ;
    private ArrayList<Contact> arrayContact;
    private ContactAdapter adapter;
    Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setWidget();
        checkAndRequestPermissions();

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getBundleExtra("data");
            Toast.makeText(this, bundle.getString("date") + "", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
        }
    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.tooo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Contacts");
        edtName = (EditText) findViewById(R.id.editnhap);
        edtNumber = (EditText) findViewById(R.id.editphone);
        edtdate = (EditText) findViewById(R.id.editdate);
        edtemail = (EditText) findViewById(R.id.editemail);
        lvContact = (ListView) findViewById(R.id.lv_contact);
        btnAddContact = (ImageView) findViewById(R.id.donee);
        imageView = ( ImageView)findViewById(R.id.imageVieww) ;
        typeface = Typeface.createFromAsset(getAssets(), "RobotoThinItalic.ttf");
        edtName.setTypeface(typeface);
        edtNumber.setTypeface(typeface);
        edtdate.setTypeface(typeface);
        edtemail.setTypeface(typeface);
        b1 = (ImageView) findViewById(R.id.cancell);
        arrayContact = new ArrayList<>();
        adapter = new ContactAdapter(MainActivity.this, R.layout.item_contact_listview, arrayContact);
        lvContact.setAdapter(adapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialogConfirm(position);
            }
        });
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName.setText("");
                edtdate.setText("");
                edtNumber.setText("");
                edtemail.setText("");
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialoghinh();
            }
        });
//        arrayContact.add(new Contact(bundle.getString("date").toString().trim(),bundle.getString("name"),bundle.getString("phone"),bundle.getString("email")));
    }
    private void showdialoghinh(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_contacts2);
        ImageView i1 = (ImageView)dialog.findViewById(R.id.i1);
        ImageView i2 = (ImageView)dialog.findViewById(R.id.i2);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
    private void checkAndRequestPermissions() {
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS
        };
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
        }
    }

    public void setWidget() {


    }

    public void addContact() {
        arrayContact.add(new Contact(edtdate.getText().toString(), edtName.getText().toString(), edtNumber.getText().toString(), edtemail.getText().toString()));
        edtName.setText("");
        edtdate.setText("");
        edtNumber.setText("");
        edtemail.setText("");
        adapter.notifyDataSetChanged();
    }

    public void showDialogConfirm(final int position) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        ImageView btnCall = (ImageView) dialog.findViewById(R.id.btn_call);
        ImageView btnSendMessage = (ImageView) dialog.findViewById(R.id.btn_send_message);
        ImageView btnedt = (ImageView) dialog.findViewById(R.id.btn_edit);
        ImageView btndelte = (ImageView) dialog.findViewById(R.id.bt_delete);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentCall(position);
                dialog.dismiss();
            }
        });
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentSendMesseage(position);
                dialog.dismiss();
            }
        });
        btnedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog(position);
                dialog.dismiss();
            }
        });
        btndelte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayContact.remove(position);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();

    }
private void showdialog(final int pos){
    final Dialog dialog = new Dialog(this);
    dialog.setContentView(R.layout.activity_favorite);
    final EditText e1,e2,e3,e4;
    ImageView i1,i2;
    e1=(EditText)dialog.findViewById(R.id.editnhapp);
    e2=(EditText)dialog.findViewById(R.id.editphonee);
    e3=(EditText)dialog.findViewById(R.id.editdatee);
    e4=(EditText)dialog.findViewById(R.id.editemaill);
    i1=(ImageView)dialog.findViewById(R.id.cancelll) ;
    i2=(ImageView)dialog.findViewById(R.id.doneee) ;
    i1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    });
    i2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            arrayContact.add(pos,new Contact(e3.getText().toString(), e1.getText().toString(), e2.getText().toString(), e4.getText().toString()));
            dialog.dismiss();
        }
    });
    dialog.show();
}
    private void intentSendMesseage(int position) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + arrayContact.get(position).getmNumber()));
        startActivity(intent);
    }

    private void intentCall(int position) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + arrayContact.get(position).getmNumber()));
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && action != null && action.equals(Intent.ACTION_MAIN)) {
                finish();
                return;
            }
        }
    }
}


