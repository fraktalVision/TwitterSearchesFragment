// MainActivity.java
// Manages your favorite Twitter searches for easy
// access and display in the device's web browser
package com.deitel.twittersearches;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends Activity
        implements SearchesFragment.onFilterSelection, SearchesFragment.onItemSelection
{
    private SearchesFragment searchList;

   // called when MainActivity is first created
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

       searchList = new SearchesFragment();

      getFragmentManager().beginTransaction()
              .replace(R.id.fragment_container, searchList)
              .commit();
   } // end method onCreate

    @Override
    public void filterSelection(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.imageRadio:
                if (checked)
                    searchList.setFilter("%20filter:images");
                break;
            case R.id.videoRadio:
                if (checked)
                    searchList.setFilter("%20filter:videos");
                break;
            case R.id.linkRadio:
                if (checked)
                    searchList.setFilter("%20filter:links");
                break;
            default:
                searchList.setFilter("");
                break;
        }
    }

    @Override
    public void itemSelection(String urlString) {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, TwitterWebFragment.newInstance(urlString))
                .addToBackStack(null)
                .commit();
    }

    public void onBackPressed() {
        getFragmentManager().popBackStack();
    }
} // end class MainActivity


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************/