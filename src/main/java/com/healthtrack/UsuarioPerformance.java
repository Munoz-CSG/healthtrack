package com.healthtrack;

import org.apache.jmeter.protocol.java.sampler.*;
import org.apache.jmeter.samplers.*;
import org.apache.jmeter.config.*;

public class UsuarioPerformance implements JavaSamplerClient {

    @Override
    public void setupTest(JavaSamplerContext context) {
    }

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        result.sampleStart(); // Inicia la medición del tiempo

        try {
            Usuario u = new Usuario("TestCarga", 80.0);
            for (int i = 0; i < 1000; i++) {
                u.actualizarPeso(80.0 + i);
            }

            result.setSuccessful(true);
            result.setResponseMessage("Prueba de carga completada");
            result.setResponseCodeOK();
        } catch (Exception e) {
            result.setSuccessful(false);
            result.setResponseMessage("Error: " + e.getMessage());
            result.setResponseCode("500");
        }

        result.sampleEnd(); // Finaliza la medición del tiempo
        return result;
    }

    @Override
    public void teardownTest(JavaSamplerContext context) {
    }

    @Override
    public Arguments getDefaultParameters() {
        return new Arguments();
    }
}
