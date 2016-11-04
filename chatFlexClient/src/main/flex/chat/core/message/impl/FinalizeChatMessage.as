package chat.core.message.impl {
	import chat.core.message.Message;
	import chat.entity.ChatRoom;
	import chat.entity.Usuario;

	public class FinalizeChatMessage extends MessageImpl implements Message {
		
		public var chat:ChatRoom;
		
		public function FinalizeChatMessage(usuario:Usuario, chat:ChatRoom){
			super("chat.core.message.impl.FinalizeChatMessage", usuario);
			this.chat = chat;
		}
	}
}