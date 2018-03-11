package multimedia.app;

import android.os.Environment;
import android.widget.Toast;

import java.io.File;

public final class FilesAdmin {

    public FilesAdmin() {
        if (check_SSD_Card())
            init();
        else
            show_SSD_ErrorMsg();
    }

    private boolean check_SSD_Card() {
        return Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)
                && Environment.isExternalStorageRemovable();
    }

    private void init() {
        /*File folder = new File(
                Environment.getExternalStorageDirectory()
                        + File.separator
                        + "MultimediaApp"
        );*/

    }


    /* MESSAGES */
    private void show_SSD_ErrorMsg() {
        Toast.makeText(null, "SSD ERROR", Toast.LENGTH_SHORT);
    }
}