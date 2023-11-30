package com.example.pratice_apache_camel.apacheCamel.moveFile;

import org.apache.camel.builder.RouteBuilder;

public class FileRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/Users/taeil/study/pratice_Apache_Camel/src/main/java/com/example/pratice_apache_camel/apacheCamel/moveFile/input")
                .routeId("fileRoute")
                .to("file:/Users/taeil/study/pratice_Apache_Camel/src/main/java/com/example/pratice_apache_camel/apacheCamel/moveFile/output");
    }
}
