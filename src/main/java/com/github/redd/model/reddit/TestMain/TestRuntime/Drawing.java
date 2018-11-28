package com.github.redd.model.reddit.TestMain.TestRuntime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.gson.typeadapters.RuntimeTypeAdapterFactory

public class Drawing {
    Shape bottomShape;
    Shape topShape;

    public Drawing() {
    }

    public Shape getBottomShape() {
        return bottomShape;
    }

    public void setBottomShape(Shape bottomShape) {
        this.bottomShape = bottomShape;
    }

    public Shape getTopShape() {
        return topShape;
    }

    public void setTopShape(Shape topShape) {
        this.topShape = topShape;
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "      \"bottomShape\": {\n" +
                "        \"type\": \"Diamond\",\n" +
                "        \"width\": 10,\n" +
                "        \"height\": 5,\n" +
                "        \"x\": 0,\n" +
                "        \"y\": 0\n" +
                "      },\n" +
                "      \"topShape\": {\n" +
                "        \"type\": \"Circle\",\n" +
                "        \"radius\": 2,\n" +
                "        \"x\": 4,\n" +
                "        \"y\": 1\n" +
                "      }\n" +
                "    }";

        RuntimeTypeAdapterFactory<Shape> shapeAdapter
                = RuntimeTypeAdapterFactory.of(Shape.class, "type");
        shapeAdapter.registerSubtype(Rectangle.class, "Rectangle");
        shapeAdapter.registerSubtype(Circle.class, "Circle");
        shapeAdapter.registerSubtype(Diamond.class, "Diamond");

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(shapeAdapter)
                .create();
        Drawing drawing = gson.fromJson(json,Drawing.class);
        System.out.println(drawing);
    }

}


