package chat.core.message.impl {
	import chat.core.message.Message;
	import chat.entity.ChatRoom;
	import chat.entity.Usuario;

	public class InviteChatMessage extends MessageImpl implements Message {
		
		public var chat:ChatRoom;
		public var usuarioDestino:Usuario;
		
		public function InviteChatMessage(usuario:Usuario, chat:ChatRoom, usuarioDestino:Usuario){
			super("chat.core.message.impl.InviteChatMessage", usuario);
			this.chat = chat;
			this.usuarioDestino = usuarioDestino;
		}
	}
}