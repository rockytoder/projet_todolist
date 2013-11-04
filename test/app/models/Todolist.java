package models;


import java.util.List;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

public class Todolist extends Model{
	public String todo ;
	public String username;
	 
	
	public static Finder<Long, Todolist> find = new Finder<Long, Todolist>(Long.class, Todolist.class);
	
	public static List<Todolist> all()
	{
		return find.all();
	}
	
	public static List<Todolist> findByUsername(String username)
	{
		return find.where().eq("username", username).findList();
	}
	
	public static Todolist create(Todolist todo) {
        todo.save();
        return todo;
    }

}
