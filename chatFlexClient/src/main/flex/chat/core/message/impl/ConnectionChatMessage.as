package chat.core.message.impl {
	import chat.core.message.Message;
	import chat.entity.ChatRoom;
	import chat.entity.Usuario;

	public class ConnectionChatMessage extends MessageImpl implements Message {
		
		public var chat:ChatRoom;
		
		public function ConnectionChatMessage(usuario:Usuario, chat:ChatRoom){
			super("chat.core.message.impl.ConnectionChatMessage", usuario);
			this.chat = chat;
		}
	}
}