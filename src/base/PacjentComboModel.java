package base;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class PacjentComboModel extends AbstractListModel implements ComboBoxModel {

  private final List<Pacjent> pacjenci;

  public PacjentComboModel (List<Pacjent> pacjenci) {
    final Pacjent pacjent = new Pacjent();
    this.pacjenci = new ArrayList<>(pacjenci);
    this.pacjenci.add(0, pacjent);
  }

  Pacjent selection = null;

  public Object getElementAt (int index) {
    return pacjenci.get(index);
  }

  public int getSize () {
    return pacjenci.size();
  }

  public void setSelectedItem (Object anItem) {
    selection = (Pacjent) anItem;
  }

  public Object getSelectedItem () {
    return selection;
  }
}
