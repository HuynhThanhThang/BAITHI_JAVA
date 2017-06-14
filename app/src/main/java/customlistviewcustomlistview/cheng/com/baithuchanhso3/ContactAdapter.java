package customlistviewcustomlistview.cheng.com.baithuchanhso3;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import customlistviewcustomlistview.cheng.com.baithuchanhso3.R;
import customlistviewcustomlistview.cheng.com.baithuchanhso3.Contact;

/**
 * Created by chien on 10/25/16.
 */

public class ContactAdapter extends ArrayAdapter<Contact>{

    private Context context;
    private int resource;
    private ArrayList<Contact> arrayContact;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context =context;
        this.resource=resource;
        this.arrayContact=objects;
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact_listview,parent,false);
            viewHolder.imgAvatar = (ImageView) convertView.findViewById(R.id.img_avatar);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvNumber = (TextView) convertView.findViewById(R.id.tv_number);
            viewHolder.t1 = (TextView)convertView.findViewById(R.id.tv_emailii);
            viewHolder.t2 =(TextView)convertView.findViewById(R.id.tv_datett) ;
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = arrayContact.get(position);

        viewHolder.tvName.setText(contact.getmName());
        viewHolder.tvNumber.setText(contact.getmNumber());
        if(contact.isM())
            viewHolder.imgAvatar.setImageResource(R.drawable.ic_male);

        else viewHolder.imgAvatar.setImageResource(R.drawable.ic_female);
        viewHolder.typeface = Typeface.createFromAsset(getContext().getAssets(), "RobotoThinItalic.ttf");
        viewHolder.tvName.setTypeface(viewHolder.typeface);
        viewHolder.tvNumber.setTypeface(viewHolder.typeface);
        viewHolder.t1.setTypeface(viewHolder.typeface);
        viewHolder.t2.setTypeface(viewHolder.typeface);
        viewHolder.t1.setText(contact.getIsdate());
        viewHolder.t2.setText(contact.getMemail());
        return convertView;
    }
    public class ViewHolder{
        ImageView imgAvatar;
        TextView tvName;
        TextView tvNumber;
        Typeface typeface;
        TextView t1,t2;
    }
}
