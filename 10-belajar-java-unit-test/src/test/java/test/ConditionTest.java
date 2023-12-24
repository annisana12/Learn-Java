package test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

@Tag("integration-test")
public class ConditionTest {
    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows() {

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnWindows() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    public void testEnabledOnJava8() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    public void testDisabledOnJava8() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_19)
    public void testEnabledOnJava8To19() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_19)
    public void testDisabledOnJava8To19() {

    }

    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testEnabledOnJavaVendorOracle() {

    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testDisabledOnJavaVendorOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    public void testEnabledOnProfileDEV() {

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    public void testDisabledOnProfileDev() {

    }
}
