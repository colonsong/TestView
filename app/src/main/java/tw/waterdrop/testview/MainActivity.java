package tw.waterdrop.testview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {

    private static final SampleTest[] samplesArray = new SampleTest[]{
            new SampleTest(R.string.test1,Test1.class),
            new SampleTest(R.string.test2,Test2.class)
    };

    private static class SampleTest{

        final int title;
        final Class targetClass;

        SampleTest(int title,Class targetClass)
        {
            this.title = title;
            this.targetClass = targetClass;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getTitlesList()));

    }
    @Override
    protected void onListItemClick(ListView l,View v, int position, long id)
    {
        if (position >= 0 && position < samplesArray.length)
        {
            startActivity(new Intent(this, samplesArray[position].targetClass));
        }
    }
    private List<String> getTitlesList(){
        List<String> titles = new ArrayList<String>();
        for(SampleTest config: samplesArray)
        {
            titles.add(getString(config.title));
        }
        return titles;
    }


}
