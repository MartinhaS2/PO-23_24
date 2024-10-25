package hva.app.main;

import hva.core.HotelManager;
import hva.core.exception.MissingFileAssociationException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import java.io.IOException;
import javax.sound.midi.Receiver;
import java.io.FileNotFoundException;
// FIXME add more imports if needed

/**
 * Save to file under current name (if unnamed, query for name).
 */
class DoSaveFile extends Command<HotelManager> {
  DoSaveFile(HotelManager receiver) {
    super(Label.SAVE_FILE, receiver, r -> r.getHotel() != null);
  }

  @Override
  protected final void execute() {
    try {
      _receiver.save();
    } 
    catch (MissingFileAssociationException | FileNotFoundException mfe) {
      boolean saved = false;
      while (!saved) {
        try {
          Form form = new Form();
          form.addStringField("filename", Prompt.newSaveAs());
          form.parse();
          String filename = form.stringField("filename");
          saved = true;
          _receiver.saveAs(filename);
        } 
          catch (MissingFileAssociationException | IOException e) {
          // catches this error if the user presses "Enter" without anything written
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    // FIXME implement command and create a local Form
  }
}
