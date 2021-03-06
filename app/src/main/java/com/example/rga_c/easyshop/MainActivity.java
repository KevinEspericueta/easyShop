package com.example.rga_c.easyshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout llvResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        llvResultados = (LinearLayout) this.findViewById((R.id.llvResultados));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            mostrar();

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void mostrar() {
        String nombre;
        String precio;
        String image;
        View view;

        //ListViewAdapter es la pantalla que se reutilizara
        ListViewAdapter lvAdapter = new ListViewAdapter(this.getApplicationContext());

        try {
            final ArrayList products;
            for (int i = 0; i < 10; i++) {
                nombre = "Articulo: " + i;
                precio = "$" + Integer.toString(i);
                image = "https://http2.mlstatic.com/camara-nikon-coolpix-b500-zoom40x-fullhd-memoria-garantia-D_NQ_NP_941664-MLA26262625784_102017-F.jpg";

                switch (i) {
                    case 0:
                        image = "https://http2.mlstatic.com/camara-nikon-coolpix-b500-zoom40x-fullhd-memoria-garantia-D_NQ_NP_941664-MLA26262625784_102017-F.jpg";
                        break;
                    case 1:
                        image = "https://www.anipedia.net/imagenes/que-comen-los-perros.jpg";
                        break;
                    case 2:
                        image = "http://stat.homeshop18.com/homeshop18/images/productImages/390/micromax-q409-spark-4g-dual-sim-android-mobile-phone-medium_eee35f2ed387b2d5939bd3f45773b9a2.jpg";
                        break;
                    case 3:
                        image = "https://i.ebayimg.com/images/g/X2AAAOSwWMhaedRR/s-l300.jpg";
                        break;
                    case 4:
                        image = "https://estaticos.serpadres.es/media/cache/400x_thumb/uploads/images/article/593a6e585cafe8fb9c612e94/spinner-juguete-demoda_0.jpg";
                        break;
                    case 5:
                        image = "http://www.1001consejos.com/wp-content/uploads/2012/05/vaca-musical-juguete.jpg";
                        break;
                    case 6:
                        image = "https://definicion.mx/wp-content/uploads/2014/05/juguete.jpg";
                        break;
                    case 7:
                        image = "https://mas-mexico.com.mx/wp-content/uploads/2018/03/trompo.png";
                        break;
                    case 8:
                        image = "https://kiwoko.a.ssl.fastly.net/media/catalog/product/cache/small_image/240x300/beff4985b56e3afdbeabfc89641a4582/f/e/fer_juguete_pelotas_pa_5536_1.jpg";
                        break;
                    case 9:
                        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQT6XQvODKW7G6d2H7ojdRMUoLEYW3j9S_UR9fQVAjEbSQM1jusjQ";
                        break;

                }
                //Se llama al metodo getRegisto en donde se le asignan los valores a los label y txt...
                //El metodo retorna un view
                view = lvAdapter.getRegistro(nombre,precio);

                final String precioF = precio;
                final String nombreF = nombre;
                final String imageF = image;
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent detailProduct = new Intent(MainActivity.this, ProductDetail.class);
                        detailProduct.putExtra("nombre", nombreF);
                        detailProduct.putExtra("precio", precioF);
                        detailProduct.putExtra("imagen", imageF);
                        startActivity(detailProduct);
                    }
                });
                //Agregamos esa vista a nuestro LinearLayout
                llvResultados.addView(view);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
