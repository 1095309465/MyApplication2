package com.example.UtilsTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyOpenHelper extends SQLiteOpenHelper {
	/**
	 * 数据库的名称
	 */
	public static final String DB_NAME = "game.db";
	public static final int DB_VERSION = 2;
	// 操作数据表的
	public SQLiteDatabase db = null;

	/**
	 * 数据库的创建
	 * 
	 * @param context
	 *            上下文环境(存放到/data/data/包名/databases/...db)
	 * @param name
	 *            数据库的文件名称
	 * @param factory
	 *            CusorFactory定义Cursor的返回结果
	 * @param version
	 *            设定数据库的版本编号(更新数据表的时候，可以定义不同的版本编号)
	 */
	public MyOpenHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
		// 肯定可以获取到 SQLiteDataBase
		getDBConn();
	}

	/**
	 * 获取SQLiteDataBase
	 */
	public void getDBConn() {
		// 使用第一个方法比较好
		// 创建或者打开数据库
		// 动态的调用onCreate()/onOpen/onUpgrade方法
		// 1.如果是第一次创建数据库,调用onCreate()+onOpen()方法
		// 2.如果已经创建了数据库,调用onOpen()方法
		// 3.当数据库已经常见，当前的版本号比原来的版本号大，调用onUpgrade()+onOpen()
		// 该方法同样拥有可读写的权限,只是不会产生Error,磁盘空间清理了可以继续操作
		db = getReadableDatabase();
		// 该方法可能会报错(权限问题,磁盘满的时候 ，Error产生以后数据库就不能操作了),产生Error会对数据库加锁，以后就不能操作了
		// db = getWritableDatabase();
	}

	/**
	 * 数据表的创建,该方法第一次创建数据的时候才会执行，以后再也不会执行 可以执行多张表创建的sql语句
	 */
	@Override
	public void onCreate(SQLiteDatabase db) { // 创建数据表(直接通过入参)
		// TODO Auto-generated method stub
		// 五种数据类型
		// int(整型) float(浮点型) text(字符串) blob(byte[]) null(空)
		// 默认没有写就是text类型,text是可以省略不写的
		String sqlCreate = "create table if not exists test"
				+ "(_id integer primary key autoincrement, " + "model text,"
				+ "detail text)";
		db.execSQL(sqlCreate);
	}

	/**
	 * 数据表的更新 newVersion > oldVersion时候该方法会被调用 外部动态的更换版本号，就会执行该方法的逻辑
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// oldVersion老的版本号
		// newVersion新的版本号
		if (newVersion > oldVersion) {
			db.execSQL("drop table student");
			// 重新调用onCreate()
			// onCreate(db);
			String sqlCreate2 = "create table if not exists test"
					+ "(_id integer primary key autoincrement, "
					+ "model text primary key," + "detail text)";
			db.execSQL(sqlCreate2);
		}
	}

	/**
	 * 对表数据进行操作，更为灵活(引入了数据的集合) 添加,删除,修改 比如:insert into student (name,age,score)
	 * values (?,?,?); ?通配符内容要动态替换 比如:delete from student where _id = ? [通过new
	 * Object[]{3}]
	 * 
	 * @param sql
	 *            insert into student (name,age,score) values (?,?,?); //固定的语句
	 * @param obj
	 *            new Object[]{"lisi","20","55"} //动态更改插入的数据
	 * @return true 修改成功
	 */
	public boolean oprateTable(String sql, Object[] obj) {
		Log.i("123", "oprateTable1");
		try {
			// 使用2个参数的执行方法
			if (obj == null) { // 没有?的替换执行1个参数
				db.execSQL(sql);
			} else {
				db.execSQL(sql, obj); // 有?执行2个参数
			}
			Log.i("123", "oprateTable2");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 对表的数据的查询
	 * 
	 * @param sql语句
	 *            select * from student where score>= ? limit ?,?
	 * @param selectionArgs
	 *            匹配?内容(new String[]{60+"",0+"",15+""})
	 * @param cursor
	 */
	public Cursor query(String sql, String[] selectionArgs) {
		return db.rawQuery(sql, selectionArgs);
	}

	public String queryGetString(String sql, String[] selectionArgs) {
		Log.i("123", "queryGetString1");
		Cursor c = db.rawQuery(sql, selectionArgs);
		Log.i("123", "queryGetString2");
		if (c.getCount() == 0) {
			return null;
		}
		Log.i("123", "queryGetString3");
		c.moveToNext();
		Log.i("123", "queryGetString4");
		String[] clounms = c.getColumnNames();
		Log.i("123", "queryGetString5");
		for (int i = 0; i < clounms.length; i++) {
			Log.i("123", "clounms[i]="+clounms[i]);
		}
		Log.i("123", "clounms[1]=" + clounms[0]);
		if (c.getType(1) == Cursor.FIELD_TYPE_STRING) {
			String valueString = c.getString(c.getColumnIndex(clounms[1]));
			Log.i("123", "valueString="+valueString);
			return valueString;
		}
		return null;
	}

	/**
	 * 将Cursor转换成List<Map<String,?>> //或者List<T> 对象
	 * 比如:map[{"_id",1},{"name","zhangsan"}] key就是T的成员变量
	 * Student{_id,name},set_Id(1),setName(zhangsan); Map<String,?>转T,map的灵活性更好
	 * 
	 * 如果实际对象就直接定死了
	 */
	public List<Map<String, Object>> swapCursorToList(Cursor c) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 如果没有数据不能进行moveToNext
		if (c.getCount() == 0) { // 没有数据的时候直接返回没有数据的集合
			return list;
		}
		// 获取所有数据的列名(通过列名可以找到指定要的字段值)
		// 类似于双向链表的结构,移动节点的位置并且获得当前节点下的数据，要注意节点的位置
		while (c.moveToNext()) { // 移动cursor,当c.moveToNext()返回是false表示数据读完了
		// c.moveToPrevious(); 上移
		// c.moveToLast(); 移到最后
		// c.moveToPosition(1); 移到指定位置
			// 获取的是cursor第n条数据所有的列名
			String[] columns = c.getColumnNames();
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < columns.length; i++) {
				// 每个加入List的map是独立的
				String key = columns[i];
				// 通过列名获取实际的值(但是却无法确定数据的类型)
				// 1.先判断该数据的类型
				// _id(int) name(text) ,score(float)
				int type = c.getType(i);
				switch (type) {
				case Cursor.FIELD_TYPE_INTEGER:
					int valueInt = c.getInt(c.getColumnIndex(key));
					map.put(key, valueInt);
					break;
				case Cursor.FIELD_TYPE_STRING:
					String valueString = c.getString(c.getColumnIndex(key));
					map.put(key, valueString);
					break;
				case Cursor.FIELD_TYPE_FLOAT:
					float valueFloat = c.getFloat(c.getColumnIndex(key));
					map.put(key, valueFloat);
				case Cursor.FIELD_TYPE_BLOB:
					byte[] valueByte = c.getBlob(c.getColumnIndex(key));
					map.put(key, valueByte);
				case Cursor.FIELD_TYPE_NULL:
					map.put(key, null); // 没什么意义的
				default:
					break;
				}
			}
			// 循环结束以后添加到List当中
			list.add(map);
		}
		Log.d("123", "list-->" + list);
		return list;
	}

	/**
	 * 对表的数据的查询,返回List<Map<String,?>>
	 * 
	 * @param sql
	 *            语句 select * from student where score>= ? limit ?,?
	 * @param selectionArgs
	 *            匹配?内容(new String[]{60+"",0+"",15+""})
	 * @param List
	 *            <Map<String,Object>>
	 */
	public List<Map<String, Object>> queryList(String sql, String[] args) {
		// 先获取Cursor
		Cursor cursor = db.rawQuery(sql, args);
		// 转换Cursor
		return swapCursorToList(cursor);
	}

	/**
	 * 对表的数据的查询
	 * 
	 * @param sql
	 *            语句
	 * @param selectionArgs
	 *            匹配?
	 * @return 数据的条数
	 */
	public int getCount(String sql, String[] args) {
		Cursor cursor = db.rawQuery(sql, args);
		if (cursor != null) {
			return cursor.getCount();
		}
		return 0;
	}

	/**
	 * 关闭数据库操作db
	 */
	public void closeDB() {
		if (db != null) {
			db.close(); // 关闭操作数据表的SQliteDataBase
		}
		close(); // 关闭当前的数据库
	}

}
