package com.odc.datastorage.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.odc.datastorage.R;
import com.odc.datastorage.entities.Article;
import com.odc.datastorage.utils.Utilities;


public class ArticleAdapter extends ArrayAdapter<Article> {
	
  public final static String TAG = "Article";
  private int resourceId = 0;
  private LayoutInflater inflater;

  public ArticleAdapter(Context context, int resourceId, List<Article> articles) {
    super(context, 0, articles);
    this.resourceId = resourceId;
    inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }
  
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    View view;
    ImageView imgLogo;
    TextView textName, textDesc;

    view = inflater.inflate(resourceId, parent, false);

    try {
      textName = (TextView)view.findViewById(R.id.titleItem);
      textDesc = (TextView)view.findViewById(R.id.descItem);
      imgLogo = (ImageView) view.findViewById(R.id.imgItem);
    } catch( ClassCastException e ) {
      throw e;
    }
    
    Article item = getItem(position);
    
    
    textName.setText(item.getTitle());
    textDesc.setText("Description : "+item.getDesc());
    imgLogo.setImageBitmap(Utilities.getImage(item.getLogo()));

    return view;
  }

}
