package multimedia.app;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public final class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        drawer = (DrawerLayout) findViewById(R.id.activity_index);
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.open,  R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDawerContent((NavigationView) findViewById(R.id.navView));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /*--------------------------------------------------------------------------------------------*/
    /*Dawer Menu Methods*/

    private void selectItemDawer(MenuItem menu){
        Fragment frg = (Fragment) chooseClass(menu.getItemId());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.index_fragment,frg)
                .commit();
        menu.setChecked(true);
        setTitle(menu.getTitle());
        drawer.closeDrawers();
    }

    private Object chooseClass(int id){
        try {
            switch (id) {
                // Cast needed for new Instance Method
                case R.id.menu_config:
                    return ((Class)Settings.class).newInstance();
                case R.id.menu_files:
                    return((Class)Files.class).newInstance();
                /*case R.id.menu_manual:
                    return((Class)Settings.class).newInstance();
                case R.id.menu_info:
                    return((Class)Settings.class).newInstance();
                 */
                default: return ((Class)Settings.class).newInstance();
            }
        }catch (Exception e){
            Toast.makeText(null,"Unhandled Exception",Toast.LENGTH_LONG);
            return null;
        }
    }

    private void setupDawerContent(NavigationView navView) {
        navView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item){
                    selectItemDawer(item);
                    return true;
                }
            }
        );
    }
    /*--------------------------------------------------------------------------------------------*/
    /*Objects*/

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
}

