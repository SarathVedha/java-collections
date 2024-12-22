package com.vedha.collections.designpattern;

import java.util.function.Consumer;

class Mailer {

    private String from;

    private String subject;

    private String body;

    private String to;

    private Mailer() {
    }

    public static void send(Consumer<Mailer> block) {

        Mailer mailer = new Mailer();
        block.accept(mailer);
        System.out.println("Sending Mail: " + mailer);
    }

    public Mailer from(String from) {

        this.from = from;
        return this;
    }

    public Mailer subject(String subject) {

        this.subject = subject;
        return this;
    }

    public Mailer body(String body) {

        this.body = body;
        return this;
    }

    public void to(String to) {

        this.to = to;
    }

    @Override
    public String toString() {
        return "Mailer{" +
                "from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}

public class FluentInterface {

    public static void main(String[] args) {

//        Mailer mailer = new Mailer();
//        mailer.from("vedha@gmail.com");
//        mailer.subject("Summa");
//        mailer.body("How Are You??");
//        mailer.to("summa@gmail.com");
//        mailer.send();

        Mailer.send(mailer -> mailer.from("vedha@gmail.com")
                .subject("Summa")
                .body("How Are You?")
                .to("summa@gmail.com"));
    }
}
