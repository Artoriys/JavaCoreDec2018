
import java.util.LinkedList;

/** Class "Notepad"
 * @author Nikita Alemaskin
 * @version 1.0
 * Manipulates with NotepadRecord objects
 */

public class Notepad {
    /** Massive with NotepadRecord objects*/
    public LinkedList<NotepadRecord> records = new LinkedList<>();

    /**
     * Initialization NotepadRecord object and add it to massive records
     * @param title title of the NotepadRecord
     * @param record record of the NotepadRecord
     */
    public void addRecord(String title, String record) {
        NotepadRecord n = new NotepadRecord(title, record);
        records.add(n);
    }

    /** Remove NotepadRecord from records by index
     * @param index index of the element in massive
     */
    public void removeRecord (int index) {
        records.remove(index);
    }

    /** Change title or record of the object NotepadRecord by index
     * @param index index of the NotepadRecord
     * @param title title of the NotepadRecord
     * @param record record of the NotepadRecord
     */
    public void refacRecord(int index, String title, String record) {
        NotepadRecord n = records.get(index);
        n.setRecord(record);
        n.setTitle(title);
    }

    /** Return records
     * @return records
     */
    public LinkedList<NotepadRecord> showAllRecords() {
        return records;
    }
}
