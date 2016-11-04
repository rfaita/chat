package chat.core.action.impl;

import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.TalkMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.ChatRoom;
import chat.entity.Usuario;
import chat.util.StringUtil;

/**
 *
 * @author rafael
 */
public class TalkAction extends Action<TalkMessage> {

    public TalkAction(Connection c, TalkMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        if ((m.getTalk() != null && !m.getTalk().isEmpty())) {
            if (u != null) {
                m.setUsuario(u);
                if (m.getChat() == null) {
                    for (Usuario u2 : Chat.getInstance().getUsuarios()) {
                        if (!u2.equals(u)) {
                            new ThreadBackMessage(u2.getCon(), m).start();
                        }
                    }
                } else {

                    ChatRoom cr = Chat.getInstance().getChatRoom(m.getChat());

                    if (cr != null && cr.isOpen()) {
                        cr.getHistory().add("[" + StringUtil.formatDateHour(m.getDate()) + "] " + m.getUsuario().getNome() + ": " + m.getTalk());

                        ChatRoom crTmp = new ChatRoom();
                        crTmp.setId(cr.getId());
                        crTmp.setNome(cr.getNome());

                        m.setChat(crTmp);
                        for (Usuario u2 : cr.getUsuarios()) {
                            new ThreadBackMessage(u2.getCon(), m).start();
                        }

                    } else {
                        new ThreadBackMessage(u.getCon(), new TalkMessage(u, null, "A SALA " + m.getChat().getId() + " ESTA FECHADA")).start();
                    }

                }
            }
        }

    }
}
