package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.List;
import android.util.Log;
import android.content.ContentValues;
import android.database.Cursor;
import java.util.LinkedList;


/**
 * Created by yamin on 2/19/17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    // Database Version. Required for the constructor
    private static final int DATABASE_VERSION = 1;

    // Database Name. Required for the constructor
    private static final String DATABASE_NAME = "RegisteredUserDB";

    // Registered Users table name
    private static final String TABLE_REGISTEREDUSERS = "registered_Users";

    // Registered Users Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ACCOUNT_TYPE = "account_Type";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_LAST_NAME = "last_Name";

    private static final String[] COLUMNS = {KEY_ID, KEY_EMAIL,
            KEY_ACCOUNT_TYPE, KEY_USERNAME, KEY_PASSWORD, KEY_LAST_NAME};

    /**
     * This is the constructor for the Android SQLiteHelper with the required
     * paramters. Null is for the Cursor Factory (Refer to API, if necessary)
     *
     * @param context this is an Android param and is built in to the system
     *                to allow application use.
     */
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * We're creating the table for the first time. This is where the the
     * creation of tables and the initial population should occur.
     *
     * @param db The SQLite Database to create and populate
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create RegisteredUser Table columns.
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_REGISTEREDUSERS +
                " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_EMAIL + " TEXT, "
                + KEY_ACCOUNT_TYPE + " TEXT, "
                + KEY_USERNAME + " TEXT, "
                + KEY_PASSWORD + " TEXT, "
                + KEY_LAST_NAME + " TEXT)";

                // create RegisteredUsers table
        db.execSQL(sql);
    }

    /**
     * This method is called when the database needs to be upgraded. This
     * method will drop tables, add tables, or do anything else it needs to
     * upgrade to the new schema version.
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older Registered table if existed
        db.execSQL("DROP TABLE IF EXISTS RegisteredUsers");

        // create fresh Registered Users table
        this.onCreate(db);
    }

    /**
     * This method will add a Registered User
     */
    public void addRegisteredUserDB(RegisteredUserDB registeredUserDB) {
        //for logging
        Log.d("addRegisterdUser", registeredUserDB.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, registeredUserDB.getEmail());
        values.put(KEY_ACCOUNT_TYPE, registeredUserDB.getAccountType());
        values.put(KEY_USERNAME, registeredUserDB.getUsername());
        values.put(KEY_PASSWORD, registeredUserDB.getPassword());
        values.put(KEY_LAST_NAME, registeredUserDB.getLastName());

        // 3. insert
        db.insert(TABLE_REGISTEREDUSERS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names / values

        // 4. close
        db.close();
    }

    /**
     * This is fetching a specific registered user using the primary key
     *
     * @param id
     * @return the Registered user that corresponds to the primary key.
     */

    public RegisteredUserDB getRegisteredUserDB(int id) {

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_REGISTEREDUSERS, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[]{ String.valueOf(id) }, // d. selections
                        // args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build RegisteredUserDB object
        RegisteredUserDB registeredUserDB = new RegisteredUserDB();
        registeredUserDB.setId(Integer.parseInt(cursor.getString(0)));
        registeredUserDB.setEmail(cursor.getString(1));
        registeredUserDB.setAccountType(cursor.getString(2));
        registeredUserDB.setUserName(cursor.getString(3));
        registeredUserDB.setPassword(cursor.getString(4));
        registeredUserDB.setLastName(cursor.getString(5));

        //log
        Log.d("getRegisterdUserDB("+id+")", registeredUserDB.toString());

        // 5. return RegisteredDB
        return registeredUserDB;
    }

    /**
     * Check to see if we can convert the list to a hashMap
     *
     * @return
     */
    public List<RegisteredUserDB> getAllRegisterdUserDBsList() {
        List<RegisteredUserDB> registeredUserDBsList = new
                LinkedList<RegisteredUserDB>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_REGISTEREDUSERS;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build registeredUser and add it to list
        RegisteredUserDB registeredUserDB = null;
        if (cursor.moveToFirst()) {
            do {
                registeredUserDB = new RegisteredUserDB();
                registeredUserDB.setId(Integer.parseInt(cursor.getString(0)));
                registeredUserDB.setEmail(cursor.getString(1));
                registeredUserDB.setAccountType(cursor.getString(2));
                registeredUserDB.setUserName(cursor.getString(3));
                registeredUserDB.setPassword(cursor.getString(4));
                registeredUserDB.setLastName(cursor.getString(5));

                // Add registered users to the list
                registeredUserDBsList.add(registeredUserDB);
            } while (cursor.moveToNext());
        }

        Log.d("getAllRegisteredUserDBs()", registeredUserDBsList.toString());

        // return the list
        return registeredUserDBsList;
    }

    /**
     * This updates the database with all the attributes of the registered
     * user according to their primary key.
     *
     * @param registeredUserDB
     * @return
     */
    public int updateRegisteredUserDB(RegisteredUserDB registeredUserDB) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("email", registeredUserDB.getEmail());
        values.put("account_Type", registeredUserDB.getAccountType());
        values.put("username", registeredUserDB.getUsername());
        values.put("password", registeredUserDB.getPassword());
        values.put("last_Name", registeredUserDB.getLastName());

        // 3. updating row
        int toBeReturned = db.update(TABLE_REGISTEREDUSERS, values, //
                // column/value
                KEY_ID + " = ?", // selections
                new String[]{String.valueOf(registeredUserDB.getId())});
        //selection args

        // 4. close
        db.close();
        return toBeReturned;
    }

    public void deleteRegisteredUserDB(RegisteredUserDB registeredUserDB) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_REGISTEREDUSERS, //table name
                KEY_ID + " = ?",  // selections
                new String[]{String.valueOf(registeredUserDB.getId())});
        //selections args

        // 3. close
        db.close();

        //log
        Log.d("Delete Registered User", registeredUserDB.toString());
    }
}