package com.iloveyou;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(/*config*/)
            .get("/", ctx -> ctx.result("Hello World"))
            .start(7070);

        Javalin mock = Javalin.create();
        mock.get("/", ctx -> ctx.json(Mock.entity(1)));
        mock.start(3001);
    }
}
