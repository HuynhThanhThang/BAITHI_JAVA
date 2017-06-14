package customlistviewcustomlistview.cheng.com.baithuchanhso3;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Contacts extends AppCompatActivity {
    private ListView lvContact;
    private ArrayList<Contact> arrayContact;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
//        lvContact = (ListView) findViewById(R.id.lv_contact);
//        arrayContact = new ArrayList<>();
//        adapter = new ContactAdapter(Contacts.this, R.layout.item_contact_listview, arrayContact);
//        lvContact.setAdapter(adapter);
//        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Intent itent = new Intent(MainActivity.this, MainActivityA.class);
////                startActivity(itent);
//            }
//        });
    }
}
