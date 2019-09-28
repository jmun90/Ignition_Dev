package pom.client;

import com.inductiveautomation.ignition.client.gateway_interface.ModuleRPCFactory;
import pom.AbstractScriptModule;
import pom.MathBlackBox;

public class ClientScriptModule extends AbstractScriptModule {

    private final MathBlackBox rpc;

    public ClientScriptModule() {
        rpc = ModuleRPCFactory.create(
                "com.vantage-dc.ignition.vdc.Vantage-AddOns",
                MathBlackBox.class
        );
    }

    @Override
    protected int multiplyImpl(int arg0, int arg1) {
        return rpc.multiply(arg0, arg1);
    }

}
