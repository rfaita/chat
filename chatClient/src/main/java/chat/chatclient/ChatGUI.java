package chat.chatclient;

import chat.core.message.impl.*;
import chat.entity.ChatRoom;
import chat.entity.Usuario;
import chat.util.StringUtil;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author handerson
 */
public class ChatGUI extends JFrame implements GUI {

    private ChatClient cc;
    private static String enderecoChat = "localhost";
    private static int portaChat = 12345;
    public static String SENHA;

    /**
     * Creates new form ChatGUI
     */
    public ChatGUI() throws Exception {
        LoginGUI l = new LoginGUI(this, true);
        l.setVisible(true);
        l.toBack();

        initComponents();
        conectar();
    }

    private void conectar() throws Exception {

        cc = new ChatClient(this);
        cc.connect(enderecoChat, portaChat);
        Thread.sleep(4000);
        cc.sendConnectMessage();

    }

    private void refreshThread() throws Exception {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (!cc.getConnection().isClosed()) {
                    try {
                        cc.sendPingMessage();
                        Thread.sleep(10000);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                serverDown();
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpopMenu = new javax.swing.JPopupMenu();
        jmiConvidarChat = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jpnlChat = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtMsg = new javax.swing.JTextArea();
        jbtnEnviar = new javax.swing.JButton();
        jspnlChat = new javax.swing.JScrollPane();
        jtxtChat = new javax.swing.JTextArea();
        jpnlServidor = new javax.swing.JPanel();
        jspnlMsgServidor = new javax.swing.JScrollPane();
        jtxtMsgServidor = new javax.swing.JTextArea();
        jpnlChats = new javax.swing.JPanel();
        jbtnEntrarChat = new javax.swing.JButton();
        jbtnSairChat = new javax.swing.JButton();
        jbtnFinalizarChat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblChat = new javax.swing.JTable();
        jpnlUserOn = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblUserOnLine = new javax.swing.JTable();
        jpnlSair = new javax.swing.JPanel();
        jtbnSair = new javax.swing.JButton();

        jmiConvidarChat.setText("Convidar para chat...");
        jmiConvidarChat.setEnabled(false);
        jmiConvidarChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConvidarChatActionPerformed(evt);
            }
        });
        jpopMenu.add(jmiConvidarChat);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Chat Logic - Logic Solution Provider");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(480, 350));
        jPanel1.setPreferredSize(new java.awt.Dimension(480, 350));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jpnlChat.setBorder(javax.swing.BorderFactory.createTitledBorder("Atendimento ao Cliente"));
        jpnlChat.setMinimumSize(new java.awt.Dimension(470, 350));
        jpnlChat.setPreferredSize(new java.awt.Dimension(470, 350));
        jpnlChat.setRequestFocusEnabled(false);
        jpnlChat.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(310, 75));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(310, 75));

        jtxtMsg.setColumns(20);
        jtxtMsg.setRows(5);
        jtxtMsg.setEnabled(false);
        jtxtMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtMsgKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtMsgKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtxtMsg);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlChat.add(jScrollPane2, gridBagConstraints);

        jbtnEnviar.setText("Enviar");
        jbtnEnviar.setEnabled(false);
        jbtnEnviar.setMaximumSize(new java.awt.Dimension(200, 200));
        jbtnEnviar.setMinimumSize(new java.awt.Dimension(75, 75));
        jbtnEnviar.setPreferredSize(new java.awt.Dimension(75, 75));
        jbtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEnviarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 4, 4);
        jpnlChat.add(jbtnEnviar, gridBagConstraints);

        jspnlChat.setMinimumSize(new java.awt.Dimension(400, 200));
        jspnlChat.setPreferredSize(new java.awt.Dimension(400, 200));

        jtxtChat.setColumns(20);
        jtxtChat.setRows(5);
        jtxtChat.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxtChat.setEnabled(false);
        jspnlChat.setViewportView(jtxtChat);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 80;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlChat.add(jspnlChat, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jpnlChat, gridBagConstraints);

        jpnlServidor.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensagens do Servidor"));
        jpnlServidor.setMaximumSize(new java.awt.Dimension(2147483647, 75));
        jpnlServidor.setMinimumSize(new java.awt.Dimension(410, 110));
        jpnlServidor.setPreferredSize(new java.awt.Dimension(410, 110));
        jpnlServidor.setLayout(new java.awt.BorderLayout());

        jspnlMsgServidor.setMinimumSize(new java.awt.Dimension(400, 160));
        jspnlMsgServidor.setPreferredSize(new java.awt.Dimension(400, 160));

        jtxtMsgServidor.setColumns(20);
        jtxtMsgServidor.setRows(5);
        jtxtMsgServidor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxtMsgServidor.setDoubleBuffered(true);
        jtxtMsgServidor.setEnabled(false);
        jspnlMsgServidor.setViewportView(jtxtMsgServidor);

        jpnlServidor.add(jspnlMsgServidor, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jpnlServidor, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPanel1, gridBagConstraints);

        jpnlChats.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Chats Abertos"));
        jpnlChats.setMinimumSize(new java.awt.Dimension(480, 350));
        jpnlChats.setPreferredSize(new java.awt.Dimension(480, 350));
        jpnlChats.setLayout(new java.awt.GridBagLayout());

        jbtnEntrarChat.setText("Entrar no Chat");
        jbtnEntrarChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEntrarChatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlChats.add(jbtnEntrarChat, gridBagConstraints);

        jbtnSairChat.setText("Sair do Chat");
        jbtnSairChat.setEnabled(false);
        jbtnSairChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSairChatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlChats.add(jbtnSairChat, gridBagConstraints);

        jbtnFinalizarChat.setText("Finalizar Chat");
        jbtnFinalizarChat.setEnabled(false);
        jbtnFinalizarChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFinalizarChatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlChats.add(jbtnFinalizarChat, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(480, 390));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(480, 390));

        jtblChat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "SAC", "Qtd. OnLine"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblChat.setDoubleBuffered(true);
        jScrollPane1.setViewportView(jtblChat);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 90;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlChats.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlChats, gridBagConstraints);

        jpnlUserOn.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Usuários OnLine")));
        jpnlUserOn.setMinimumSize(new java.awt.Dimension(200, 400));
        jpnlUserOn.setPreferredSize(new java.awt.Dimension(200, 400));
        jpnlUserOn.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(200, 300));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(200, 300));
        jScrollPane4.setRequestFocusEnabled(false);

        jtblUserOnLine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblUserOnLine.setComponentPopupMenu(jpopMenu);
        jtblUserOnLine.setDoubleBuffered(true);
        jScrollPane4.setViewportView(jtblUserOnLine);

        jpnlUserOn.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 95;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlUserOn, gridBagConstraints);

        jpnlSair.setMaximumSize(new java.awt.Dimension(2147483647, 25));
        jpnlSair.setMinimumSize(new java.awt.Dimension(25, 25));
        jpnlSair.setPreferredSize(new java.awt.Dimension(25, 25));
        jpnlSair.setLayout(new java.awt.GridBagLayout());

        jtbnSair.setText("Sair");
        jtbnSair.setMaximumSize(new java.awt.Dimension(200, 25));
        jtbnSair.setMinimumSize(new java.awt.Dimension(200, 25));
        jtbnSair.setPreferredSize(new java.awt.Dimension(100, 25));
        jtbnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnSairActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSair.add(jtbnSair, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlSair, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEntrarChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEntrarChatActionPerformed

        try {
            if (jtblChat.getSelectedRow() > -1) {

                if (cc.getChatRoomAtual() != null) {
                    cc.sendDisconnectChatMessage();
                }

                ChatRoom cr = new ChatRoom();

                cr.setId((Integer) jtblChat.getValueAt(jtblChat.getSelectedRow(), 0));
                cc.sendConnectionChatMessage(cr);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jbtnEntrarChatActionPerformed

    private void jbtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEnviarActionPerformed

        try {
            String mensagem = jtxtMsg.getText();
            cc.sendTalkMessageToChat(mensagem);

            jtxtMsg.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jbtnEnviarActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    private void jtbnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnSairActionPerformed
        try {
            int ret = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "A T E N Ç Ã O", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (ret == JOptionPane.YES_OPTION) {
                if (cc.getChatRoomAtual() != null) {
                    cc.sendDisconnectChatMessage();
                }
                cc.sendDisconnectMessage();
                Thread.sleep(1000);
                cc.disconnect();
                this.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jtbnSairActionPerformed

    private void jbtnSairChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSairChatActionPerformed
        try {

            if (cc.getChatRoomAtual() != null) {
                cc.sendDisconnectChatMessage();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbtnSairChatActionPerformed

    private void jbtnFinalizarChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFinalizarChatActionPerformed
        try {

            if (cc.getChatRoomAtual() != null) {
                cc.sendFinalizeChatMessage();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbtnFinalizarChatActionPerformed

    private void jtxtMsgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtMsgKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbtnEnviarActionPerformed(null);
        }
    }//GEN-LAST:event_jtxtMsgKeyReleased

    private void jtxtMsgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtMsgKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtMsgKeyPressed

    private void jmiConvidarChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConvidarChatActionPerformed
        try {
            if (jtblUserOnLine.getSelectedRow() > -1) {
                int id = (Integer) jtblUserOnLine.getValueAt(jtblUserOnLine.getSelectedRow(), 0);
                Usuario uD = new Usuario();
                uD.setId(id);
                cc.sendInviteChatMessage(uD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jmiConvidarChatActionPerformed

    private void serverDown() {
        //JOptionPane.showMessageDialog(this, "SERVIDOR CAIU", "A T E N Ç Ã O", JOptionPane.ERROR_MESSAGE);
        this.dispose();

    }

    @Override
    public void joinChat() {
        controlCompChats(false);
    }

    @Override
    public void leaveChat() {
        controlCompChats(true);
    }

    private void controlCompChats(boolean flag) {

        if (flag) {
            jtxtChat.setText("");
        }

        jbtnEntrarChat.setEnabled(flag);
        jbtnSairChat.setEnabled(!flag);
        jbtnFinalizarChat.setEnabled(!flag);

        jbtnEnviar.setEnabled(!flag);
        jtxtMsg.setEnabled(!flag);

        jmiConvidarChat.setEnabled(!flag);


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtnEntrarChat;
    private javax.swing.JButton jbtnEnviar;
    private javax.swing.JButton jbtnFinalizarChat;
    private javax.swing.JButton jbtnSairChat;
    private javax.swing.JMenuItem jmiConvidarChat;
    private javax.swing.JPanel jpnlChat;
    private javax.swing.JPanel jpnlChats;
    private javax.swing.JPanel jpnlSair;
    private javax.swing.JPanel jpnlServidor;
    private javax.swing.JPanel jpnlUserOn;
    private javax.swing.JPopupMenu jpopMenu;
    private javax.swing.JScrollPane jspnlChat;
    private javax.swing.JScrollPane jspnlMsgServidor;
    private javax.swing.JTable jtblChat;
    private javax.swing.JTable jtblUserOnLine;
    private javax.swing.JButton jtbnSair;
    private javax.swing.JTextArea jtxtChat;
    private javax.swing.JTextArea jtxtMsg;
    private javax.swing.JTextArea jtxtMsgServidor;
    // End of variables declaration//GEN-END:variables

    public static void main(String args[]) throws Exception {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Metal".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        //</editor-fold>



        if (args.length == 1 || args.length == 2) {
            enderecoChat = args[0];
            if (args.length == 2) {
                portaChat = Integer.parseInt(args[1]);
            }
        }

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new ChatGUI().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.exit(0);
                }
            }
        });
    }

    public JButton getJbtnAtender() {
        return jbtnEntrarChat;
    }

    public JButton getJbtnEnviar() {
        return jbtnEnviar;
    }

    public JButton getJbtnFinalizar() {
        return jbtnSairChat;
    }

    public JTable getJtblChat() {
        return jtblChat;
    }

    public JTable getJtblUserOnLine() {
        return jtblUserOnLine;
    }

    public JTextArea getJtxtChat() {
        return jtxtChat;
    }

    public JTextArea getJtxtMsg() {
        return jtxtMsg;
    }

    public JTextArea getJtxtMsgServidor() {
        return jtxtMsgServidor;
    }

    @Override
    public void addTalkMessageGlobal(TalkMessage m) throws Exception {
        addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] " + m.getUsuario().getNome() + ": " + m.getTalk());
    }

    @Override
    public void addTalkMessageChat(TalkMessage m) throws Exception {
        addMsgChat("[" + StringUtil.formatDateHour(m.getDate()) + "] " + m.getUsuario().getNome() + ": " + m.getTalk());
    }

    @Override
    public void loadChatHistory(ConnectionChatMessage m) throws Exception {
        for (String s : m.getChat().getHistory()) {
            addMsgChat(s);
        }
    }

    @Override
    public void addConnectionMessage(ConnectionMessage m) throws Exception {

        Usuario u = cc.getUsuario();

        if (u == null) {
            cc.setUsuario(m.getUsuario());
            u = cc.getUsuario();
            cc.sendInitiatedChatMessage();
            cc.sendInitiateChatMessage(123123);
            cc.sendConnectedUserMessage();

            refreshThread();
        }

        if (u.equals(m.getUsuario())) {
            addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] BEM VINDO " + m.getUsuario().getNome() + "!");
        } else {
            addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] " + m.getUsuario().getNome() + " ACABOU DE SE CONECTAR.");
            addUser(m.getUsuario());
        }

    }

    @Override
    public void addDisconnectMessage(DisconnectMessage m) throws Exception {

        Usuario u = cc.getUsuario();

        if (u == null) {
            cc.setUsuario(m.getUsuario());
            u = cc.getUsuario();
        }

        if (u.equals(m.getUsuario())) {
            addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] ADEUS " + m.getUsuario().getNome() + "!");
        } else {
            addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] " + m.getUsuario().getNome() + " ACABOU DE SE DESCONECTAR.");
            removeUser(m.getUsuario());
        }


    }

    @Override
    public void addConnectionChatMessage(ConnectionChatMessage m) throws Exception {

        if (cc.getUsuario().equals(m.getUsuario())) {
            cc.setChatRoomAtual(m.getChat());
            loadChatHistory(m);
            joinChat();
            addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] BEM VINDO A SALA " + m.getChat().getNome());
        } else {
            addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] " + m.getUsuario().getNome() + " ACABA DE ENTRAR NA SALA " + m.getChat().getNome());
        }
        refreshChat(m.getChat());

    }

    @Override
    public void addDisconnectChatMessage(DisconnectChatMessage m) throws Exception {

        if (cc.getUsuario().equals(m.getUsuario())) {
            cc.setChatRoomAtual(null);
            leaveChat();
            addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] ADEUS A SALA " + m.getChat().getNome());
        } else {
            addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] " + m.getUsuario().getNome() + " ACABA DE SAIR DA SALA " + m.getChat().getNome());
        }
        refreshChat(m.getChat());

    }

    @Override
    public void addFinalizeChatMessge(FinalizeChatMessage m) throws Exception {

        if (cc.getUsuario().equals(m.getUsuario())) {
            addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] ADEUS A SALA " + m.getChat().getNome());
        } else {
            addMsgServidor("[" + StringUtil.formatDateHour(m.getDate()) + "] " + m.getUsuario().getNome() + " ACABA DE FECHAR A SALA " + m.getChat().getNome());
        }
        removeChat(m.getChat());

        if (cc.getChatRoomAtual() != null && cc.getChatRoomAtual().equals(m.getChat())) {
            leaveChat();
            cc.setChatRoomAtual(null);
        }
    }

    private void addMsgServidor(String s) {
        jtxtMsgServidor.setText(jtxtMsgServidor.getText() + s + "\n");
        jspnlMsgServidor.getVerticalScrollBar().setValue(jspnlMsgServidor.getVerticalScrollBar().getMaximum());
    }

    private void addMsgChat(String s) {
        jtxtChat.setText(jtxtChat.getText() + s + "\n");
        jspnlChat.getVerticalScrollBar().setValue(jspnlChat.getVerticalScrollBar().getMaximum());
    }

    @Override
    public void removeChat(ChatRoom cr) {
        DefaultTableModel model = (DefaultTableModel) jtblChat.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (((Integer) model.getValueAt(i, 0)) == cr.getId()) {
                model.removeRow(i);
            }
        }
    }

    @Override
    public void addChat(ChatRoom cr) {
        DefaultTableModel model = (DefaultTableModel) jtblChat.getModel();

        Object[] chat = new Object[4];

        chat[0] = cr.getId();
        chat[1] = cr.getNome();
        chat[2] = cr.getIdSAC();
        chat[3] = cr.getUsuarios().size();

        model.addRow(chat);
    }

    @Override
    public void refreshChat(ChatRoom cr) {
        DefaultTableModel model = (DefaultTableModel) jtblChat.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (((Integer) model.getValueAt(i, 0)) == cr.getId()) {
                model.setValueAt(cr.getUsuarios().size(), i, 3);
            }
        }
    }

    @Override
    public void removeUser(Usuario u) {
        DefaultTableModel model = (DefaultTableModel) jtblUserOnLine.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (((Integer) model.getValueAt(i, 0)) == u.getId()) {
                model.removeRow(i);
            }
        }
    }

    @Override
    public void addUser(Usuario u) {
        DefaultTableModel model = (DefaultTableModel) jtblUserOnLine.getModel();

        Object[] chat = new Object[3];

        chat[0] = u.getId();
        chat[1] = u.getNome();

        model.addRow(chat);
    }

    @Override
    public void selectUser(int index) {
        ListSelectionModel selectionModel = getJtblUserOnLine().getSelectionModel();
        selectionModel.setSelectionInterval(index, index);

    }

    @Override
    public int getSelectedUser() {
        return getJtblUserOnLine().getSelectedRow();
    }

    @Override
    public boolean acceptInvite(String chat, String usuario) {

        int ret = JOptionPane.showConfirmDialog(this,
                "O usuário " + usuario + " esta te convidando para a sala "
                + chat + ",\nvocê deseja aceitar?", "A T E N Ç Ã O",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        return (ret == JOptionPane.YES_OPTION);
    }
}
