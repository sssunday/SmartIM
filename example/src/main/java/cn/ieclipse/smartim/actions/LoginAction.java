package cn.ieclipse.smartim.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import cn.ieclipse.smartim.SmartClient;
import cn.ieclipse.smartim.callback.impl.DefaultLoginCallback;
import cn.ieclipse.smartim.common.LOG;
import cn.ieclipse.smartim.console.MockChatConsole;
import cn.ieclipse.smartim.model.impl.AbstractContact;
import cn.ieclipse.smartim.views.IMPanel;
import icons.SmartIcons;

/**
 * Created by Jamling on 2017/7/12.
 */
public class LoginAction extends JButton implements ActionListener{
    IMPanel panel;

    public LoginAction(IMPanel panel) {
        super(SmartIcons.signin);
        this.panel = panel;
        setToolTipText("登录");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent anActionEvent) {
        final SmartClient client = panel.getClient();
        boolean ok = true;
        if (client.isLogin()) {
            ok = JOptionPane.showConfirmDialog(null,
                    "您已处于登录状态，确定要重新登录吗？") == 0;
        }
        if (ok) {
            client.setLoginCallback(new DefaultLoginCallback() {
                protected void onLoginFinish(boolean success,
                        Exception e) {
                    if (success) {
                        panel.initContacts();
                    }
                    else {
                        LOG.error("登录失败", e);
                    }
                };
            });
            new Thread() {
                @Override
                public void run() {
                    client.login();
                }
            }.start();
        }
        else {
            panel.initContacts();
        }
    }
}
