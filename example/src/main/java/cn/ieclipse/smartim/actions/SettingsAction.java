package cn.ieclipse.smartim.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cn.ieclipse.smartim.console.MockChatConsole;
import cn.ieclipse.smartim.dialogs.SettingsDialog;
import cn.ieclipse.smartim.model.impl.AbstractContact;
import cn.ieclipse.smartim.views.IMPanel;
import icons.SmartIcons;

/**
 * Created by Jamling on 2017/7/12.
 */
public class SettingsAction extends JButton implements ActionListener {
    IMPanel panel;
    
    public SettingsAction(IMPanel panel) {
        super(SmartIcons.settings);
        setToolTipText("设置");
        this.panel = panel;
        addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent anActionEvent) {
        SettingsDialog.main(null);
    }
}
