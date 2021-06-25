package com.myorg;

import software.amazon.awscdk.App;

public final class CdktestApp {
    public static void main(final String[] args) {
        App app = new App();
        

        new CdktestStack(app, "CdktestStack");

        app.synth();
    }
}
