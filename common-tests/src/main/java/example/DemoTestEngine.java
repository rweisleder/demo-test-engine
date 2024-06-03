package example;

import org.junit.platform.commons.support.ReflectionSupport;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.ExecutionRequest;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestEngine;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.EngineDescriptor;

import java.lang.reflect.Field;
import java.time.LocalTime;
import java.util.List;

public class DemoTestEngine implements TestEngine {

    @Override
    public String getId() {
        return "demo-test-engine";
    }

    @Override
    public TestDescriptor discover(EngineDiscoveryRequest discoveryRequest, UniqueId uniqueId) {
        System.out.println(LocalTime.now() + "\tDemoTestEngine.discover enter");
        printDiscoverySelectors(discoveryRequest);
        System.out.println(LocalTime.now() + "\tDemoTestEngine.discover exit");

        return new EngineDescriptor(uniqueId, "Demo Test Engine");
    }

    @SuppressWarnings({"unchecked", "CallToPrintStackTrace"})
    private static void printDiscoverySelectors(EngineDiscoveryRequest discoveryRequest) {
        try {
            Field selectorsField = discoveryRequest.getClass().getDeclaredField("selectors");
            List<DiscoverySelector> discoverySelectors = (List<DiscoverySelector>) ReflectionSupport.tryToReadFieldValue(selectorsField, discoveryRequest).get();
            for (int i = 0; i < discoverySelectors.size(); i++) {
                System.out.println(LocalTime.now() + "\tdiscoverySelectors[" + i + "] = " + discoverySelectors.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(ExecutionRequest request) {
        // nothing to do
    }
}
