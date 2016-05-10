package cs2i.quentin.com.myapp.Activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import cs2i.quentin.com.myapp.Fragments.LatestMovies;
import cs2i.quentin.com.myapp.Fragments.ListePrincipale;
import cs2i.quentin.com.myapp.Fragments.MyBibliotheque;
import cs2i.quentin.com.myapp.Fragments.NowPlayingMovies;
import cs2i.quentin.com.myapp.Fragments.PopularMovies;
import cs2i.quentin.com.myapp.Fragments.TopRatedMovies;
import cs2i.quentin.com.myapp.Fragments.UpCommingMovies;
import cs2i.quentin.com.myapp.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ListePrincipale.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment fragListPrincipale = new ListePrincipale();
        fragmentTransaction.add(R.id.main, fragListPrincipale).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Fragment currentFragment = getFragmentManager().findFragmentById(R.id.main);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (currentFragment instanceof ListePrincipale) {
                super.onBackPressed();
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
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
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment frag = null;
        int id = item.getItemId();

        if (id == R.id.nav_latest) {
            frag = new LatestMovies();
        } else if (id == R.id.nav_now) {
            frag = new NowPlayingMovies();
        } else if (id == R.id.nav_popular) {
            frag = new PopularMovies();
        } else if (id == R.id.nav_top) {
            frag = new TopRatedMovies();
        } else if (id == R.id.nav_upcomming) {
            frag = new UpCommingMovies();
        } else if (id == R.id.nav_myBiblio) {
            frag = new MyBibliotheque();
        } else if (id == R.id.nav_accueil) {
            frag = new ListePrincipale();
        }
        fragmentTransaction.replace(R.id.main, frag).commit();
        //fragmentTransaction.add(R.id.main,frag).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
