package chat.core.message.impl {
	import chat.core.message.Message;
	import chat.entity.ChatRoom;
	import chat.entity.Usuario;

	public class DisconnectChatMessage extends MessageImpl implements Message {
		
		public var chat:ChatRoom;
		
		public function DisconnectChatMessage(usuario:Usuario, chat:ChatRoom){
			super("chat.core.message.impl.DisconnectChatMessage", usuario);
			this.chat = chat;
		}
	}
}