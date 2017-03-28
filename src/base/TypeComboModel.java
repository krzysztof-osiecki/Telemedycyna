package base;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class TypeComboModel extends AbstractListModel implements ComboBoxModel {

  TypPomiaru[] typyPomiaru = TypPomiaru.values();

  TypPomiaru selection = null;

  public Object getElementAt (int index) {
    return typyPomiaru[index];
  }

  public int getSize () {
    return typyPomiaru.length;
  }

  public void setSelectedItem (Object anItem) {
    selection = (TypPomiaru) anItem;
  }

  public Object getSelectedItem () {
    return selection;
  }
}
