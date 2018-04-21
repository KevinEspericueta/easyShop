package com.example.rga_c.easyshop;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends AppCompatActivity {
    // Declare Variables
    ImageView imgImg;
    //this var contains the product title
    TextView txtTitle;
    TextView txtContenido;
    View itemView = null;
    Context context;
    LayoutInflater inflater;

    public ListViewAdapter(Context context){
        this.context = context;
    }



    public View getRegistro(String nombre, String precio){
        /*********************************/
        /**             Alexander       **/
        /*********************************/

        try {
            //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            itemView = inflater.inflate(R.layout.producto_view, null, false);

            // Locate the TextViews in listview_item.xml
            //imgImg = (ImageView) itemView.findViewById(R.id.imagen);
            txtTitle = (TextView) itemView.findViewById(R.id.Titulo_Nombre);
            txtContenido = (TextView) itemView.findViewById(R.id.Titulo_Price);

            txtTitle.setText(nombre);
            txtContenido.setText(precio);
        }catch (Exception e){
            e.printStackTrace();
        }
        return itemView;

    }
}
