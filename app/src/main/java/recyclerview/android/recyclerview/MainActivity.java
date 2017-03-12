package recyclerview.android.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import recyclerview.android.recyclerview.adapter.GridAdatpter;
import recyclerview.android.recyclerview.adapter.ListAdatpter;
import recyclerview.android.recyclerview.adapter.StaggeredAdatpter;
import recyclerview.android.recyclerview.bean.DataBean;

import static recyclerview.android.recyclerview.bean.DATAS.ICONS;
import static recyclerview.android.recyclerview.bean.StreggeredDatas.PICS;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

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

        recyclerView = (RecyclerView) findViewById(R.id.list_recycleview);

        //默认加载一个布局
        loadListData(false, true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_list_normal) {
            //正常
            loadListData(false, true);
            return true;
        } else if (id == R.id.action_list_vertical_reverse) {
            //竖直反向
            loadListData(true, true);
            return true;
        } else if (id == R.id.action_list_horizontal) {
            //水平
            loadListData(false, false);
            return true;
        } else if (id == R.id.action_list_horizontal_reverse) {
            //水平反向
            loadListData(true, false);
            return true;
        } else if (id == R.id.action_grid_normal) {
            //正常
            loadGridData(false, true);
            return true;
        } else if (id == R.id.action_grid_vertical_reverse) {
            //竖直反向
            loadGridData(true, true);
            return true;
        } else if (id == R.id.action_grid_horizontal) {
            //水平
            loadGridData(false, false);
            return true;
        } else if (id == R.id.action_grid_horizontal_reverse) {
            //水平反向
            loadGridData(true, false);
            return true;
        }else if (id == R.id.action_staggered_normal) {
            //正常
            loadStaggeredData(false, true);
            return true;
        } else if (id == R.id.action_staggered_vertical_reverse) {
            //竖直反向
            loadStaggeredData(true, true);
            return true;
        } else if (id == R.id.action_staggered_horizontal) {
            //水平
            loadStaggeredData(false, false);
            return true;
        } else if (id == R.id.action_staggered_horizontal_reverse) {
            //水平反向
            loadStaggeredData(true, false);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 加载正常的list数据
     */
    private void loadListData(boolean reverse, boolean vertical) {
        List<DataBean> datas = new ArrayList<>();
        //        DataBean bean = new DataBean();
        //        bean.icon = R.mipmap.icon_0;
        //        bean.name  = "图片01";
        //        datas.add(bean);
        for ( int i = 0; i < ICONS.length; i++ ) {
            DataBean bean = new DataBean();
            bean.icon = ICONS[i];
            bean.name = "图片-" + i;
            datas.add(bean);
        }


        //设置布局管理器
        LinearLayoutManager linearlayout = new LinearLayoutManager(this);
        //设置反向
        linearlayout.setReverseLayout(reverse);
        //设置是否水平
        linearlayout.setOrientation(vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearlayout);

        //设置适配器
        recyclerView.setAdapter(new ListAdatpter(this, datas));
    }

    private void loadGridData(boolean reverse, boolean vertical) {
        List<DataBean> datas = new ArrayList<>();
        for ( int i = 0; i < ICONS.length; i++ ) {
            DataBean bean = new DataBean();
            bean.icon = ICONS[i];
            bean.name = "图片-" + i;
            datas.add(bean);
        }

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        //设置反向
        layoutManager.setReverseLayout(reverse);
        //设置是否水平
        layoutManager.setOrientation(vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(new GridAdatpter(this, datas));

    }

    private void loadStaggeredData(boolean reverse, boolean vertical) {
        List<DataBean> datas = new ArrayList<>();
        for ( int i = 0; i < PICS.length; i++ ) {
            DataBean bean = new DataBean();
            bean.icon = PICS[i];
            bean.name = "图片-" + i;
            datas.add(bean);
        }

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,
                vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);

        //设置反向
        layoutManager.setReverseLayout(reverse);
        //设置是否水平
        layoutManager.setOrientation(vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new StaggeredAdatpter(this,datas));


    }


}
