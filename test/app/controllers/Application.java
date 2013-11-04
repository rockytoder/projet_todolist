package controllers;

import java.io.File;
import java.util.List;

import models.Todolist;

import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

import views.html.*;

public class Application extends Controller {

	static Form<Todolist> todoForm = Form.form(Todolist.class);
	
    public static Result index() 
    {
        return ok(index.render());
    }
    
    public static Result listTodo(String username)
    {
    	List<Todolist> todos ;
    	if(username.equals("utilisateur"))
    		todos = Todolist.all();
    	else 
    		todos = Todolist.findByUsername(username);
    	if(request().accepts("text/html"))
    		return ok(views.html.List.render(todos, "bonjour " + username, todoForm));
    	else if(request().accepts("application/json"))
    		return ok(Json.toJson(todos));
    	return badRequest();
    }
 
    public static Result submitTodo()
    {
    	Todolist to = todoForm.bindFromRequest().get();
    	Todolist.create(todo);
    	return redirect(routes.Application.listTodo("utilisateur"));
    }
    
    
}