package main;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


public class Launcher {
	
	public static void main(String[] args) {
		staticFiles.location("/public");
		port(5000);
		String path="player.json";
		HashMap<String,Object> polja=new HashMap<>();
		
		
		get("/",(request,response)->{
			polja.put("persons",Data.readFromJson(path));
			ArrayList<String> list=new ArrayList<>();
			for(Player x:Data.readFromJson(path)) {
				if(!list.contains(x.getPosition())) {
					list.add(x.getPosition());
				}
			}
			polja.put("pozicije", list);
			return new ModelAndView(polja,"index.hbs");
		},new HandlebarsTemplateEngine());
		
		get("/forms/add",(request,response)->{
			return new ModelAndView(polja,"addPlayer.hbs");
		},new HandlebarsTemplateEngine());
		
		
		get("/add",(request,response)->{
			ArrayList<Player> tmp=Data.readFromJson("player.json");
			
			int id=tmp.size()+1;
			String firstName=request.queryParams("firstName");
			String lastName=request.queryParams("lastName");
			String position=request.queryParams("position");
			double pointsPerGame=Double.parseDouble(request.queryParams("pointsPerGame"));
			
			tmp.add(new Player(id,firstName,lastName,position,pointsPerGame));
			Data.writeToJSON(tmp, "player.json");
			polja.put("persons", tmp);
			return new ModelAndView(polja,"index.hbs");
		},new HandlebarsTemplateEngine());
		
		
		
		
		post("/api/filtrirajPozicija",(request,response)->{
			response.type("text/text");
			String trazenaPozicija=request.queryParams("position");
			ArrayList<Player> list=new ArrayList<>();
			for(Player x:Data.readFromJson(path)) {
				if(x.getPosition().equals(trazenaPozicija)) {
					list.add(x);
				}
			}
			Gson gson=new Gson();
			return gson.toJson(list);
		});

	}

}