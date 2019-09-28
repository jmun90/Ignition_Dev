package pom.designer;

import com.inductiveautomation.ignition.designer.model.menu.JMenuMerge;
import com.inductiveautomation.ignition.designer.model.menu.MenuBarMerge;
import com.inductiveautomation.ignition.designer.model.menu.WellKnownMenuConstants;
import pom.client.ClientScriptModule;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DesignerHook extends AbstractDesignerModuleHook {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void initializeScriptManager(ScriptManager manager) {
        super.initializeScriptManager(manager);

        manager.addScriptModule(
                "system.vdc",
                new ClientScriptModule(),
                new PropertiesFileDocProvider()
        );
    }

    @Override
    public MenuBarMerge getModuleMenu() {
        Action testAction = new AbstractAction("Import Devices From CSV") {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDevice();
            }
        };

        String menuName = "VDC Tools";
        MenuBarMerge menu = new MenuBarMerge("vantage.tools.vdc-tools");

        JMenuMerge toolsNew = new JMenuMerge(menuName);
        toolsNew.add(testAction);
        menu.add(WellKnownMenuConstants.TOOLS_MENU_LOCATION, toolsNew);

        return menu;
    }

    private void addDevice() {
        System.out.println("This is a test...");
    }

}
