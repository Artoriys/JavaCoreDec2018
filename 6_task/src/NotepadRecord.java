
/**Class "Note in Notepad"
 * @author  Nikita Alemaskin
 * @version 1.0
 *
 */

public class NotepadRecord {
    /** Title of the note */
    private String title;

    /** Text of the note */
    private String record;

    /** Object constructor with defined parameters
     * @param title title of the NotepadRecord
     * @param record record of the NotepadRecord
     */
    NotepadRecord(String title, String record) {
        this.title = title;
        this.record = record;
    }

    /** Setter of the field title
    * @param title title of the NotepadRecord
    */
    public void setTitle(String title) {
        this.title = title;
    }

    /** Getter of th field title
     *
     * @return tittle
     */
    public String getTitle() {
        return this.title;
    }

    /** Setter of the field record
     *
     * @param record record of the NotepadRecord
     */
    public void setRecord(String record) {
        this.record = record;
    }

    /** Getter of the field record
     *
     * @return record
     */
    public String getRecord() {
        return this.record;
    }
}
