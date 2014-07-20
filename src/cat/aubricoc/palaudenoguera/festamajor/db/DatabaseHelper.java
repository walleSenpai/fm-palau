package cat.aubricoc.palaudenoguera.festamajor.db;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import cat.aubricoc.palaudenoguera.festamajor.model.Tweet;
import cat.aubricoc.palaudenoguera.festamajor.utils.Constants;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, Constants.DATABASE_NAME, null,
				Constants.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i(Constants.PROJECT_NAME, "Create DB...");

		List<String> createTables = DatabaseReflection.getInstance()
				.prepareCreateTables(Tweet.class);

		for (String sql : createTables) {
			db.execSQL(sql);
		}

		Log.i(Constants.PROJECT_NAME, "Create DB...OK");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i(Constants.PROJECT_NAME, "Upgrade DB from " + oldVersion + " to "
				+ newVersion + "...");

		// Add alters on new DB version

		Log.i(Constants.PROJECT_NAME, "Upgrade DB from " + oldVersion + " to "
				+ newVersion + "...OK");
	}
}