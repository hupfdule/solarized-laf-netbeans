/*
 *
 */
package eu.herrn.netbeans.solarized;

import eu.herrn.solarized.SolarizedLookAndFeel;
import java.util.prefs.Preferences;
import javax.swing.UIManager;
import org.openide.modules.ModuleInstall;
import org.openide.util.NbPreferences;

public class Installer extends ModuleInstall {

    @Override
    public void validate() throws IllegalStateException {
        final Preferences prefs = getPreferences();
        if( !prefs.getBoolean("solarized.theme.installed", false) ) {
            prefs.put( "laf", SolarizedLookAndFeel.class.getName() );
        }
        prefs.putBoolean( "solarized.theme.installed", true );
        UIManager.installLookAndFeel(new UIManager.LookAndFeelInfo( "Solarized", SolarizedLookAndFeel.class.getName()) );
    }


    private Preferences getPreferences() {
        return NbPreferences.root().node( "laf" );
    }
}
