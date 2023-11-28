package com.multi.pratice.multipratice.apacheCamel.moveFile;

import org.apache.camel.builder.RouteBuilder;

public class FileRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //from("file:///Users/taeil/plea/study/src/main/java/com/example/study/camel/input?noop=true")
        from("file:/Users/taeil/IdeaProjects/multiPratice/src/main/java/com/multi/pratice/multipratice/apacheCamel/moveFile/input")
                .routeId("fileRoute")
                .to("file:/Users/taeil/IdeaProjects/multiPratice/src/main/java/com/multi/pratice/multipratice/apacheCamel/moveFile/output");
    }
}
