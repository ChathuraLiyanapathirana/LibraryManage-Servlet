/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.impl;

import connection.Connection;
import java.util.prefs.Preferences;

/**
 *
 * @author chathura buddhika
 */
public class PreferencesConnectionImpl implements Connection {

    public Object getConnection() {
        Preferences p = Preferences.userNodeForPackage(this.getClass());
        return p;
    }
}
