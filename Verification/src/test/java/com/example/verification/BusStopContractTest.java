package com.example.verification;


import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;

@RunWith(PactRunner.class)
@Provider("BusService")
@PactFolder("target/pacts")

public class BusStopContractTest {

    @State("There is a bus with number 613 to Hammersmith bus station")
    public void hammerSmith(){
        System.out.println("There is a bus with number 613 arriving to Hammersmith bus station");
    }

    @TestTarget
    public final Target target = new HttpTarget(8017);
}
